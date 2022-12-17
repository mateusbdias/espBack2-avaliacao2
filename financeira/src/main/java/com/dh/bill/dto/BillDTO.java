package com.dh.bill.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillDTO {

    private String idBill;

    private String customerBill;

    private String productBill;

    private Double totalPrice;

}
