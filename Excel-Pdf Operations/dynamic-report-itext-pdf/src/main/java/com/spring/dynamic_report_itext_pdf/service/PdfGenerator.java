package com.spring.dynamic_report_itext_pdf.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.dynamic_report_itext_pdf.entity.Employee;
import com.spring.dynamic_report_itext_pdf.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfGenerator {

    @Value("${pdf.dir}")
    private String pdfDir;

    @Value("${pdf.report.file-name}")
    private String reportFileName;

    @Value("${pdf.report.file-name-date-format}")
    private String reportFileNameDateFormat;

    @Value("${pdf.local-date-format}")
    private String localDateFormat;

    @Value("${pdf.logo.img-path}")
    private String logoImgPath;

    @Value("${pdf.logo.img-scale}")
    private Float[] logoImgScale;

    @Value("${pdf.currency-symbol}")
    private String currencySymbol;

    @Value("${pdf.table.no-of-columns}")
    private int tableNoOfColumns;

    @Value("${pdf.table.column-names}")
    private List<String> tableColumnNames;

    @Autowired
    EmployeeRepo eRepo;

    private static Font COURIER = new Font(Font.FontFamily.COURIER , 20 , Font.BOLD);
    private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);


    public void generatePdfReport() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document , new FileOutputStream(getPdfNameWithDate()));
            document.open();
            addLogo(document);
            addDocTitle(document);
            createTable(document , tableNoOfColumns);
            addFooter(document);
            document.close();
            System.out.println("------------------Your PDF Report is ready!-------------------------");
        }catch (FileNotFoundException | DocumentException e){
            e.printStackTrace();
        }
    }

    public void addLogo(Document document){
        try{
            Image image = Image.getInstance(logoImgPath);
            image.scalePercent(logoImgScale[0] , logoImgScale[1]);
            image.setAlignment(Element.ALIGN_RIGHT);
            document.add(image);
        }catch (DocumentException | IOException e){
            e.printStackTrace();

        }
    }

    private void addDocTitle(Document document) throws DocumentException {
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));

        Paragraph p1 = new Paragraph();
        leaveEmptyLine(p1 , 1);
        p1.add(new Paragraph(reportFileName , COURIER));
        p1.setAlignment(Element.ALIGN_CENTER);
        leaveEmptyLine(p1 , 1);
        p1.add(new Paragraph("Report Generated on "+localDateString , COURIER_SMALL));
        document.add(p1);
    }

    private void createTable(Document document, int tableNoOfColumns) throws DocumentException {
         Paragraph paragraph = new Paragraph();
         leaveEmptyLine(paragraph , 3);
         document.add(paragraph);

        PdfPTable table = new PdfPTable(tableNoOfColumns);

        for (int i = 0 ; i < tableNoOfColumns ; ++i){
            PdfPCell cell = new PdfPCell(new Phrase(tableColumnNames.get(i)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(cell);
        }

        table.setHeaderRows(1);
        getDbData(table);
        document.add(table);
    }

    private void getDbData(PdfPTable table) {
        List<Employee> allEmployeeList = eRepo.getAllEmployeeData();

        for (Employee e : allEmployeeList){
            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(e.getEmpId().toString());
            table.addCell(e.getEmpName());
            table.addCell(e.getEmpDept());
            table.addCell(currencySymbol + e.getEmpSal().toString());

            System.out.println(e.getEmpName());
        }
    }

    private void addFooter(Document document) throws DocumentException {
        Paragraph p2 = new Paragraph();
        leaveEmptyLine(p2 , 3);
        p2.setAlignment(Element.ALIGN_MIDDLE);
        p2.add(new Paragraph(	"------------------------End Of " +reportFileName+"------------------------",
                COURIER_SMALL_FOOTER));
        document.add(p2);
    }


    private void leaveEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0 ; i < number ; ++i){
             paragraph.add(new Paragraph(" "));
        }
    }

    private String getPdfNameWithDate() {
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(reportFileNameDateFormat));
        return pdfDir+reportFileName+"-"+localDateString+".pdf";
    }
}
