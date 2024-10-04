package com.spring.dynamic_report_itext_pdf.controller;

import com.spring.dynamic_report_itext_pdf.service.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

    @Autowired
    PdfGenerator pdfGeneratorService;

    @GetMapping("/get")
    public void generateReport(){
        pdfGeneratorService.generatePdfReport();
    }
}
