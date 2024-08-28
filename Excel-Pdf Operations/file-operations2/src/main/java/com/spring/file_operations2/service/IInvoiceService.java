package com.spring.file_operations2.service;

import com.spring.file_operations2.entity.Invoice;

import java.util.List;

public interface IInvoiceService {

     Invoice saveInvoice(Invoice invoice);
     List<Invoice> getAllInvoices();
     Invoice getInvoiceById(Long id);
     void deleteInvoiceById(Long id);
     void updateInvoice(Invoice invoice);
}
