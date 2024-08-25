package com.spring.excel_poiji_api.service;

import com.spring.excel_poiji_api.repo.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExcelDataUploadRunner implements CommandLineRunner {

    @Autowired
    InvoiceRepo invoiceRepo;

    @Autowired
    ExcelPoijiService excelPoijiService;

    @Override
    public void run(String... args) throws Exception {
        invoiceRepo.saveAll(excelPoijiService.getListfromExcelData());
    }
}
