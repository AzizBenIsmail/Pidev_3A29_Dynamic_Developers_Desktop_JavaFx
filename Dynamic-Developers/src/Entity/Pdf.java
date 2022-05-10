package Entity;

import Entity.voyage;
import Service.ServiceVoyage;
import com.itextpdf.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author AZAYEZ BINSA
 */
public class Pdf {

    public void GeneratePdf(String filename, voyage p, int id) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException {

        Document document = new Document() {
        };
        PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
        document.open();

        ServiceVoyage us = new ServiceVoyage();
        document.add(new Paragraph("            Date  :"+LocalDateTime.now()));
        document.add(new Paragraph("            le voyage :"+p.getNom_voyage()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------"));

        document.add(new Paragraph("destination :" + p.getDestination()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("nom_voyage :" + p.getNom_voyage()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("duree_voyage:" + p.getDuree_voyage()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("valabilite :" + p.getValabilite()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("date :" + p.getDate()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("prix :" + p.getPrix()));
        document.add(new Paragraph("                      "));
        document.add(new Paragraph("image :" + p.getImage()));
        document.add(new Paragraph("                      "));
       

        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        document.add(new Paragraph("                              Dynamic Devellopres                     "));
        document.close();
        Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filename + ".pdf");
    }

}