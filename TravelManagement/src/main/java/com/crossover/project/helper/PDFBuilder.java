/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.helper;

import com.crossover.project.entities.Order;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author waqas.ali2
 */
public class PDFBuilder extends AbstractITextPdfView  {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Order> orders = (List<Order>) model.get("orders");
         
        doc.add(new Paragraph("Ticket Purchase Summary"));
        doc.addTitle("Summary");
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        cell.setPhrase(new Phrase("From", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("To", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Tickets", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Total Price", font));
        table.addCell(cell);
         
        for (Order order : orders) {
            table.addCell(order.getFrom());
            table.addCell(order.getTo());
            table.addCell(String.valueOf(order.getTickets()));
            table.addCell(String.valueOf(order.getTotalPrice()));
        }
         
        doc.add(table);
         
    }
 
}
