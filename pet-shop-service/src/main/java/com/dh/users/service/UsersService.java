package com.dh.users.service;

import com.dh.users.dto.BillDTO;

public interface UsersService {

    BillDTO findByIdBill(String idBill);

}
