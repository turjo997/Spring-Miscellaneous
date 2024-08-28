package com.spring.file_operations2.service.impl;

import com.spring.file_operations2.entity.Invoice;
import com.spring.file_operations2.service.IInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IInvoiceServiceImpl implements IInvoiceService {
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return List.of();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return null;
    }

    @Override
    public void deleteInvoiceById(Long id) {

    }

    @Override
    public void updateInvoice(Invoice invoice) {

    }
}
