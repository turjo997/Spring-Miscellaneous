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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExcelDataService {

    private final InvoiceRepository invoiceRepository;

    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;


    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public ExcelDataService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    public List<Invoice> getExcelDataAsList(){
        List<Invoice> allInvList = new ArrayList<>();
        Workbook workbook = null;


        File folder = new File(uploadDir);
        File[] files = folder.listFiles(((dir, name) -> name.endsWith(".xlsx")));

        DataFormatter dataFormatter = new DataFormatter();

        if (files != null && files.length  > 0){

            for (File file : files){
                System.out.println("Processing file: " + file.getAbsolutePath());

                try {
                    workbook = WorkbookFactory.create(file);
                }catch (EncryptedDocumentException | IOException e){
                    e.printStackTrace();
                }

                // Getting the Sheet at index zero
                Sheet sheet = workbook.getSheetAt(0);

                // Getting number of columns in the Sheet
                int noOfColumns = sheet.getRow(0).getLastCellNum();
                System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

                List<String> list = new ArrayList<>();

                // Using for-each loop to iterate over the rows and columns

                for (Row row : sheet){
                    for (Cell cell : row){
                        String cellValue = dataFormatter.formatCellValue(cell).trim();
                        if (!cellValue.isEmpty()) {
                            list.add(cellValue);
                        }
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

                allInvList.addAll(invList);
            }

            return allInvList;

        }else {
            System.out.println("No .xlsx files found in the directory.");
            return Collections.emptyList();
        }
    }

    private List<Invoice> createList(List<String> excelData, int noOfColumns) {

        System.out.println(excelData);
        System.out.println(excelData.size());
        System.out.println(noOfColumns);

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

            //Invoice inv = invoiceRepository.save(invoice); //i can use this onw also

            list.add(inv);
        }


        //invoices = invoiceRepository.saveAllInvoices(invoices);
        return list.size();
    }
}
