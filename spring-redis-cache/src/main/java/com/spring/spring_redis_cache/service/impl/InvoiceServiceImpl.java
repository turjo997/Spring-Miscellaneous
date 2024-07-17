package com.spring.spring_redis_cache.service.impl;

import com.spring.spring_redis_cache.entity.Invoice;
import com.spring.spring_redis_cache.exception.InvoiceNotFoundException;
import com.spring.spring_redis_cache.repository.InvoiceRepository;
import com.spring.spring_redis_cache.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice inv) {
        return invoiceRepository.save(inv);
    }

    @Override
    @CachePut(value = "Invoice" , key = "#invId")
    public Invoice updateInvoice(Invoice inv, Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(()-> new InvoiceNotFoundException("Invoice not found"));

        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());

        invoiceRepository.save(invoice);

        return invoice;
    }

    @Override
    @CacheEvict(value="Invoice" , key="#invId")
    public void deleteInvoice(Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepository.delete(invoice);
    }

    @Override
    @Cacheable(value = "Invoice" , key = "#invId")
    public Invoice getOneInvoice(Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(()-> new InvoiceNotFoundException("Invoice not found"));

        return invoice;
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
