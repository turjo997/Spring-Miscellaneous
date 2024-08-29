package com.spring.file_operations2.service.impl;

import com.spring.file_operations2.entity.Invoice;
import com.spring.file_operations2.exception.InvoiceNotFoundException;
import com.spring.file_operations2.repo.InvoiceRepository;
import com.spring.file_operations2.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IInvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> invoice =  invoiceRepository.findById(id);

        if(invoice.isPresent()){
            return invoice.get();
        }else{
            throw new InvoiceNotFoundException("Invoice with Id : "+id+" Not Found");
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
       invoiceRepository.delete(getInvoiceById(id));
    }

    @Override
    public void updateInvoice(Invoice invoice) {
          invoiceRepository.save(invoice);
    }
}
