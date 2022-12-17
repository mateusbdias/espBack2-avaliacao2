package com.dh.bill.repository;

import com.dh.bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {

    Bill findByIdBill(String idBill);

}
