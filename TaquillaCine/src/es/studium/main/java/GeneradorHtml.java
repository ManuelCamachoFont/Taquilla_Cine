package es.studium.main.java;

import java.util.List;

public class GeneradorHtml {

	public static String generarCartelera(List<Pelicula> cartelera) {
		StringBuilder html = new StringBuilder("""
				<html>
				<head>
				    <style>
				        body { background-color: #1e1e1e; color: #ffffff; font-family: sans-serif; }
				        .pelicula-card { width: 260px; background-color: #2a2a2a; padding: 10px; vertical-align: top; }
				        .pelicula-titulo { font-size: 14px; color: #ffcc00; padding: 10px; font-weight: bold; text-align: center; }
				        .pelicula-duracion { font-size: 11px; color: #aaaaaa; padding: 8px }
				        .pelicula-sinopsis { font-size: 12px; color: #dddddd; padding: 10px }
				        img { padding: 10px; }
				    </style>
				</head>
				<body>
				    <div style="width: 550px;">
				        <table width="100%" cellspacing="10" cellpadding="0">
				""");

		int i = 0;
		for (Pelicula p : cartelera) {
			String titulo = p.getTitulo();
			int duracion = p.getDuracion();
			String sinopsis = p.getSinopsis();
			String rutaImagen = p.getRutaImagen();

			if (rutaImagen == null || rutaImagen.trim().isEmpty()) {
				rutaImagen = "/es/studium/main/resources/img/placeholder.jpg";
			} 

			java.net.URL urlImagen = Controlador.class.getResource(rutaImagen);
			String 	rutaImagenHtml = urlImagen.toExternalForm();

			if (i % 2 == 0) {
				html.append("<tr>");
			}
			html.append("""
					    <td class="pelicula-card">
					        <p class="pelicula-titulo">%s</p>
					        <center><img src="%s" width="260" height="160"></center>
					        <p class="pelicula-duracion">Duración: %d min</p>
					        <p class="pelicula-sinopsis">%s</p>
					    </td>
					""".formatted(titulo, rutaImagenHtml, duracion, sinopsis));

			if (i % 2 != 0 || i == cartelera.size() - 1) {
				html.append("</tr>");
			}
			i++;
		}
		html.append("""
				        </table>
				    </div>
				</body>
				</html>
				""");
		return html.toString();
	}
	
	public static String generarResumenVenta(Venta venta, String nombreCompleto, String email) {
		StringBuilder html = new StringBuilder("""
				<html>
				<head>
				    <style>
				        body { background-color: #0B0F19; color: #8A99AD; font-family: sans-serif; font-size: 13px; }
				        .tabla-resumen { width: 100%%; border-collapse: collapse; background-color: #161B26; margin-top: 10px; }
				        .tabla-resumen th { background-color: #161B26; color: #00E5FF; padding: 12px; font-size: 15px; border-bottom: 2px solid #00E5FF; text-align: left; }
				        .tabla-resumen td { padding: 14px 12px; border-bottom: 1px solid #222726; }
				        .concepto { color: #00E5FF; font-weight: bold; width: 35%%; }
				        .valor { color: #FFFFFF; }
				        .total-row { font-size: 16px; font-weight: bold; background-color: #1A2333; }
				        .total-row td { color: #00E5FF; border-top: 2px solid #00E5FF; }
				    </style>
				</head>
				<body>
				    <table class="tabla-resumen">
				        <tr>
				            <th colspan="2">DETALLES DE LA COMPRA</th>
				        </tr>
				        <tr>
				            <td class="concepto">Película:</td>
				            <td class="valor">%s <i style="color:#8A99AD;">(%d min)</i></td>
				        </tr>
				        <tr>
				            <td class="concepto">Espectador:</td>
				            <td class="valor">%s</td>
				        </tr>
				        <tr>
				            <td class="concepto">Contacto:</td>
				            <td class="valor">%s</td>
				        </tr>
				        <tr>
				            <td class="concepto">Butaca:</td>
				            <td class="valor">%s <i style="color:#8A99AD;">(x%d)</i></td>
				        </tr>
				        <tr>
				            <td class="concepto">Precio/ud:</td>
				            <td class="valor">%.2f €</td>
				        </tr>
				        <tr class="total-row">
				            <td>TOTAL:</td>
				            <td style="text-align: right; padding-right: 20px;">%.2f €</td>
				        </tr>
				    </table>
				</body>
				</html>
			""".formatted(venta.getPelicula().getTitulo(), venta.getPelicula().getDuracion(), nombreCompleto, email, venta.getTicket().getTipo(), venta.getCantidad(), venta.getTicket().getPrecio(), venta.getTotal()));
		return html.toString();
	}
}
