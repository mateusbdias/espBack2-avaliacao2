package com.dh.bill.service;

import com.dh.bill.dto.BillDTO;

public interface BillService {

    BillDTO save(BillDTO dto);

    BillDTO findByIdBill(String idBill);

}
