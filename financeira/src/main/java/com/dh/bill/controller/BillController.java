package com.dh.bill.controller;

import com.dh.bill.dto.BillDTO;
import com.dh.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping
    public ResponseEntity<BillDTO> save(@RequestBody BillDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{idBill}")
    @PreAuthorize("hasRole('PROVIDERS')")
    public ResponseEntity<BillDTO> findByIdBill(@PathVariable String idBill) {
        return ResponseEntity.ok(service.findByIdBill(idBill));
    }

}
