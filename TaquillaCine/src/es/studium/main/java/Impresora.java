package es.studium.main.java;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
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
		LocalDateTime ahora = LocalDateTime.now();

		LocalDate fecha = ahora.toLocalDate();
		LocalTime hora = ahora.toLocalTime();

		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

		String fechaFormateada = fecha.format(formatoFecha);
		String horaFormateada = hora.format(formatoHora);
	    
		new File("entradas").mkdirs();
		String recibo = """
				*******************************************
				
								CINELEMA
				
					Calle Hola Mundo, 13
					
				*******************************************
				
				Fecha: %s\t\t\tHora: %s
				
				EVENTO: %s

				Datos del comprador:
				%s

				Tipo de asiento:\t\t\tCantidad:
				%s\t\t\t\t   %d\t
										-------------------
											Total pagado:
												%.2f €

				===========================================
				""".formatted(fechaFormateada, horaFormateada, tituloPelicula, nombreCompleto, tipoAsiento, cantidadAsientos, precioTotal);
		try {
			PdfWriter writer = new PdfWriter(DEST);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf, PageSize.A4);
			document.setMargins(20, 20, 20, 20);
			document.add(new Paragraph(recibo.replace("\t", "    ")).setFont(PdfFontFactory.createFont(StandardFonts.COURIER)));
			
			document.close();
			pdf.close();
			writer.close();
			Desktop.getDesktop().open(new File(DEST));
		} catch (IOException ioe) {
			System.err.println("Error al generar el PDF: " + ioe.getMessage());
		}
	}
}
