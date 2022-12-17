package com.dh.users.configuration.openfeign;

import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Slf4j
@Configuration
@AllArgsConstructor
public class KeycloakInterceptorConfiguration {
    private static final String CLIENT_REGISTRATION_ID = "users-service-registration";

    private final OAuth2AuthorizedClientService clientService;
    private final ClientRegistrationRepository repository;

    @Bean
    public RequestInterceptor requestInterceptor() {
        final ClientRegistration client = repository.findByRegistrationId(CLIENT_REGISTRATION_ID);
        final OAuth2AuthorizedClientManager authorizedClientManager = getAuthorizedClientManager();
        OAuthClientCredentialsFeignManager clientCredentialsFeignManager = new OAuthClientCredentialsFeignManager(authorizedClientManager, client);
        String token = clientCredentialsFeignManager.getAccessToken();
        log.info("Token na camada de request interceptor é " + token);
        return requestInterceptor -> requestInterceptor
                .header("Authorization", "Bearer " + token);
    }

    private OAuth2AuthorizedClientManager getAuthorizedClientManager() {
        OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(repository, clientService);
        authorizedClientManager.setAuthorizedClientProvider(provider);
        return authorizedClientManager;
    }

}