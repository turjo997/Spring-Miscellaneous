package com.spring.apache.pdf.controller;

import com.spring.apache.pdf.model.Invoice;
import com.spring.apache.pdf.repo.InvoiceRepository;
import com.spring.apache.pdf.service.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Controller
public class InvoiceController {


    private final InvoiceRepository invoiceRepository;
    private final PdfService pdfService;

    public InvoiceController(InvoiceRepository invoiceRepository, PdfService pdfService) {
        this.invoiceRepository = invoiceRepository;
        this.pdfService = pdfService;
    }

    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        List<Invoice> invoices = invoiceRepository.findAll();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/invoices/pdf")
    public ResponseEntity<byte[]> downloadPdf() throws IOException {
        List<Invoice> invoices = invoiceRepository.findAll();
        byte[] pdf = pdfService.generateInvoicePdf(invoices);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoices.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }


    @GetMapping("/invoices/{id}/receipt")
    public ResponseEntity<byte[]> downloadReceipt(@PathVariable Long id) throws IOException {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        byte[] pdf = pdfService.generateReceipt(invoice, "RCP-" + invoice.getId(), "Credit Card", "MyCompany Inc.");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=receipt-" + invoice.getId() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
