package com.spring.file_operations2.excelservice;

import com.spring.file_operations2.entity.Invoice;
import com.spring.file_operations2.repo.InvoiceRepository;
import com.spring.file_operations2.service.IInvoiceService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private IInvoiceService invoiceService;


    public ByteArrayInputStream exportInvoice() throws IOException{

        List<Invoice> list = invoiceService.getAllInvoices();


        try(Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Invoice");

            Row row0 = sheet.createRow(0);

            row0.createCell(0).setCellValue("ID");
            row0.createCell(1).setCellValue("NAME");
            row0.createCell(2).setCellValue("LOCATION");
            row0.createCell(3).setCellValue("AMOUNT");

            int rowNum = 1;

            for (Invoice spec : list) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(spec.getId());
                row.createCell(1).setCellValue(spec.getName());
                row.createCell(2).setCellValue(spec.getLocation());
                row.createCell(3).setCellValue(spec.getAmount());
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());
        }
    }


}
