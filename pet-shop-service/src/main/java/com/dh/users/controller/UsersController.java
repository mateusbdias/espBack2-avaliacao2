package com.dh.users.controller;

import com.dh.users.dto.BillDTO;
import com.dh.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/bills/{idBill}")
    public ResponseEntity<BillDTO> findByIdBill(@PathVariable String idBill) {
        return ResponseEntity.ok(service.findByIdBill(idBill));
    }

}
