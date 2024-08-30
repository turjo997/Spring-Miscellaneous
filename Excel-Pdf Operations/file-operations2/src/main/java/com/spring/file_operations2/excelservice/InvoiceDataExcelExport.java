package com.spring.file_operations2.excelservice;

import com.spring.file_operations2.entity.Invoice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.util.List;
import java.util.Map;


public class InvoiceDataExcelExport extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment;fileName=InvoiceData.xls");

        @SuppressWarnings("unchecked")
        List<Invoice> list = (List<Invoice>) model.get("list");


        Sheet sheet = workbook.createSheet("Invoice");

        Row row0 = sheet.createRow(0);

        row0.createCell(0).setCellValue("ID");
        row0.createCell(1).setCellValue("NAME");
        row0.createCell(2).setCellValue("LOCATION");
        row0.createCell(3).setCellValue("AMOUNT");

        int rowNum = 1;

        for (Invoice spec : list){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(spec.getId());
            row.createCell(1).setCellValue(spec.getName());
            row.createCell(2).setCellValue(spec.getLocation());
            row.createCell(3).setCellValue(spec.getAmount());
        }

    }

}
