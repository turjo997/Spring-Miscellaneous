package com.spring.file_operations.repository;


import com.spring.file_operations.entity.Invoice;

import java.util.List;

public interface InvoiceRepository {

    List<Invoice> saveAll(List<Invoice> invoices);

}
