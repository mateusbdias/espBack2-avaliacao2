package com.dh.bill.service.impl;

import com.dh.bill.dto.BillDTO;
import com.dh.bill.model.Bill;
import com.dh.bill.repository.BillRepository;
import com.dh.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repository;

    @Override
    public BillDTO save(BillDTO dto) {
        Bill entity = new Bill();
        entity.setCustomerBill(dto.getCustomerBill());
        entity.setProductBill(dto.getProductBill());
        entity.setTotalPrice(dto.getTotalPrice());
        return entityToDTO(repository.save(entity));
    }

    @Override
    public BillDTO findByIdBill(String idBill) {
        return entityToDTO(repository.findByIdBill(idBill));
    }

    public BillDTO entityToDTO(Bill bill) {
        return BillDTO.builder()
                .idBill(bill.getIdBill())
                .customerBill(bill.getCustomerBill())
                .productBill(bill.getProductBill())
                .totalPrice(bill.getTotalPrice())
                .build();
    }

}
