package com.dh.users.service.impl;

import com.dh.users.dto.BillDTO;
import com.dh.users.service.BillFeign;
import com.dh.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private BillFeign billFeign;

    @Override
    public BillDTO findByIdBill(String idBill) {
        return billFeign.findByIdBill(idBill).getBody();
    }

}
