package com.spring.apache.pdf.service;

import com.spring.apache.pdf.model.Invoice;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfService {

    public byte[] generateInvoicePdf(List<Invoice> invoices) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream cs = new PDPageContentStream(document, page)) {
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 16);
                cs.newLineAtOffset(50, 750);
                cs.showText("Invoice Report");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(50, 700);

                for (Invoice inv : invoices) {
                    String line = inv.getId() + ". " + inv.getCustomerName() +
                            " - " + inv.getDescription() +
                            " ($" + inv.getAmount() + ")";
                    cs.showText(line);
                    cs.newLineAtOffset(0, -20);
                }
                cs.endText();
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            return baos.toByteArray();
        }
    }

    public byte[] generateReceipt(Invoice invoice, String receiptNumber, String paymentMethod, String companyName) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream cs = new PDPageContentStream(document, page)) {

                // ===== HEADER =====
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 20);
                cs.newLineAtOffset(180, 750);
                cs.showText("Payment Receipt Format");
                cs.endText();

                // Receipt number and date
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(50, 700);
                cs.showText("Receipt No: " + receiptNumber);
                cs.newLineAtOffset(0, -20);
                cs.showText("Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
                cs.endText();

                // ===== TABLE (Details / Information) =====
                float startY = 640;
                float leftX = 50;
                float rightX = 250;

                drawRow(cs, "Received From", invoice.getCustomerName(), leftX, startY);
                drawRow(cs, "Amount Paid", "$" + invoice.getAmount(), leftX, startY - 30);
                drawRow(cs, "Payment Method", paymentMethod, leftX, startY - 60);
                drawRow(cs, "Description of Goods", invoice.getDescription(), leftX, startY - 90);

                // ===== FOOTER =====
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
                cs.newLineAtOffset(50, 200);
                cs.showText("Issued by: " + companyName);
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_OBLIQUE, 11);
                cs.newLineAtOffset(50, 180);
                cs.showText("Thank you for your payment!");
                cs.endText();
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            return baos.toByteArray();
        }
    }

    private void drawRow(PDPageContentStream cs, String detail, String info, float leftX, float y) throws IOException {
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
        cs.newLineAtOffset(leftX, y);
        cs.showText(detail + ": ");
        cs.endText();

        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA, 12);
        cs.newLineAtOffset(leftX + 150, y);
        cs.showText(info);
        cs.endText();
    }
}
