/*
 * To change this template, choose Tools | Templates
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
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.log4j.Logger;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author waqas.ali2
 */
public class EmailHelper {

    private static final Logger LOGGER = Logger.getLogger(EmailHelper.class);

    private EmailHelper() {
    }

    public static boolean sendEmail(String to, List<Order> orders) {
        boolean response = false;

        try {
            
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(AppConfig.getProperty("USER_NAME"), AppConfig.getProperty("PASSWORD"));
                    }
                });

         
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Dear Customer,"
                    + "\n\n Please find attached summary!");
             
            //now write the PDF content to the output stream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            writePdf(outputStream,orders);
            byte[] bytes = outputStream.toByteArray();
             
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("summary.pdf");
                         
            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
             
            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(AppConfig.getProperty("USER_NAME"));
            InternetAddress iaRecipient = new InternetAddress(to);
             
            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject("Ticket Purchased Summary");
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);
            
            Transport.send(mimeMessage);


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return response;
    }

    public static void writePdf(OutputStream outputStream, List<Order> orders) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
         
        document.open();
         
        document.addTitle("Summary");
        document.addSubject("Tickets Purchased");
        document.addKeywords("iText, email");
        document.addAuthor("Waqas Ali");
        document.addCreator("Waqas Ali");
         
        document.add(new Paragraph("Ticket Purchase Summary"));
         
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
         
        document.add(table);
         
        document.close();
    }
}
