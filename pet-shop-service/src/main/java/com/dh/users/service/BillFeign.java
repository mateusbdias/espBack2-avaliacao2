package com.dh.users.service;

import com.dh.users.configuration.openfeign.KeycloakInterceptorConfiguration;
import com.dh.users.dto.BillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bills", url = "http://localhost:8081", configuration = KeycloakInterceptorConfiguration.class)
public interface BillFeign {

    @GetMapping("/bills/{idBill}")
    ResponseEntity<BillDTO> findByIdBill(@PathVariable String idBill);

}
