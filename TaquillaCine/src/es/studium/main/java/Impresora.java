package es.studium.main.java;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Impresora
{
	private static final String DEST = "entradas/entrada_"+System.currentTimeMillis()+".pdf";

	public static void imprimirEntrada(String tituloPelicula, String nombreCompleto, String tipoAsiento, int cantidadAsientos, double precioTotal)
	{
		new File("entradas").mkdirs();
		String recibo = """
				*******************************************

				%s

				*******************************************

				Datos del comprador:
				%s

				Tipo de asiento adquirido:
				%s

				Cantidad:
				%d

				Total pagado:
				%.2f

				===========================================
				""".formatted(tituloPelicula, nombreCompleto, tipoAsiento, cantidadAsientos, precioTotal);
		try {
			PdfWriter writer = new PdfWriter(DEST);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf, PageSize.A4);
			document.setMargins(20, 20, 20, 20);
			document.add(new Paragraph(recibo));
			
			document.close();
			pdf.close();
			writer.close();
			Desktop.getDesktop().open(new File(DEST));
		} catch (IOException ioe) {
			System.err.println("Error al generar el PDF: " + ioe.getMessage());
		}
	}
}
