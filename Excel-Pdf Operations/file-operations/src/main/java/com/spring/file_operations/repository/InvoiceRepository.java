package com.spring.file_operations.repository;


import com.spring.file_operations.entity.Invoice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository {

   // List<Invoice> saveAll(List<Invoice> invoices);


    @Query(value = "INSERT INTO invoice (amount, name , number, received_date) VALUES (:amount, :name , :number, :receivedDate)", nativeQuery = true)
    Invoice saveAllInvoices(@Param("amount") Double amount, @Param("name") String name,
                         @Param("number") String number,
                         @Param("receivedDate") String receivedDate);
}
