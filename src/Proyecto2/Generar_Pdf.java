package Proyecto2;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Marco Antonio Lares Tohom
 */
public class Generar_Pdf {

    public static final String DEST = "C:/workplac/Programacion1/Programacion1/Reporte Demanda con Font.pdf";

    public static void main(String[] args) {
        new Generar_Pdf().crearPDF(DEST);
    }

    public static void crearPDF(String destino) {

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
            doc.add(new Paragraph("Numero de expediente:").setFont(font));
            doc.add(new Paragraph("Nombre demandante:").setFont(font));
            doc.add(new Paragraph("Nombre demandado:").setFont(font));
            doc.add(new Paragraph("Numero de colegiado de juez:").setFont(font));
            doc.add(new Paragraph("Resolucion:").setFont(font));
            doc.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Ha ocurrido un error al localizar la base de datos.");
            System.out.println("Ha ocurrido un error al localizar la base de datos.");
        } catch (NullPointerException npe) {
            System.err.print("La dirección a la que se ha intentado acceder e serrónea");
            System.out.println("La dirección a la que se ha intentado acceder e serrónea");
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un fallo en la escritura/lectura.");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.err.println("Ha ocurrido un fallo en la escritura/lectura.");
            }
        }

    }
}
