package com.spring.file_operations.service;

import com.spring.file_operations.entity.Invoice;
import com.spring.file_operations.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataService {

    private final InvoiceRepository invoiceRepository;

    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;

    public ExcelDataService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    public List<Invoice> getExcelDataAsList(){
        List<String> list = new ArrayList<>();
        Workbook workbook = null;

         // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println(EXCEL_FILE_PATH);

        // Create the Workbook
        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        }catch (EncryptedDocumentException | IOException e){
            e.printStackTrace();
        }

        // Retrieving the number of sheets in the Workbook
        System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");


        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Getting number of columns in the Sheet
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

        // Using for-each loop to iterate over the rows and columns

        for (Row row : sheet){
            for (Cell cell : row){
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }

        // filling excel data and creating list as List<Invoice>
        List<Invoice> invList = createList(list , noOfColumns);

        // Closing the workbook
        try {
            workbook.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return invList;
    }

    private List<Invoice> createList(List<String> excelData, int noOfColumns) {

        ArrayList<Invoice> invList = new ArrayList<Invoice>();

        int i = noOfColumns;

        do {

            Invoice inv = new Invoice();

            inv.setName(excelData.get(i));
            inv.setAmount(Double.valueOf(excelData.get(i + 1)));
            inv.setNumber(excelData.get(i + 2));
            inv.setReceivedDate(excelData.get(i + 3));

            invList.add(inv);
            i = i + (noOfColumns);

        }while (i < excelData.size());

        return invList;

    }


    public int saveExcelData(List<Invoice> invoices) {

        List<Invoice> list = new ArrayList<>();

        for (Invoice invoice : invoices) {

            Invoice inv = invoiceRepository.saveAllInvoices(
                    invoice.getAmount(), invoice.getName() ,
                    invoice.getNumber(),
                    invoice.getReceivedDate());

            list.add(inv);
        }


        //invoices = invoiceRepository.saveAllInvoices(invoices);
        return list.size();
    }
}
