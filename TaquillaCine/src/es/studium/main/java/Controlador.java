package es.studium.main.java;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Controlador implements ActionListener
{

	private Modelo m;
	private Vista v;
	private List<Pelicula> cartelera;
	private List<Ticket> asientos;

	private Venta ventaPreparada;
	// Object boton1 = v.getPanelHome().getBtnInfoEventos();

	private void cargarPeliculas()
	{
		cartelera = m.consultarCartelera();
	}

	private void cargarTickets()
	{
		asientos = m.consultarTickets();
	}

	public Controlador(Modelo modelo, Vista vista)
	{
		this.m = modelo;
		this.v = vista;

		this.v.getPanelHome().getBtnInfoEventos().addActionListener(this);
		this.v.getPanelHome().getBtnSacarEntrada().addActionListener(this);

		this.v.getPanelEventos().getBtnAtras().addActionListener(this);

		this.v.getPanelCompra().getBtnAceptar().addActionListener(this);
		this.v.getPanelCompra().getBtnAtras().addActionListener(this);
		this.v.getPanelCompra().getBtnLimpiar().addActionListener(this);

		this.v.getPanelConfirm().getBtnAceptar().addActionListener(this);
		this.v.getPanelConfirm().getBtnAtras().addActionListener(this);

		this.v.getPanelFin().getBtnVolverMenu().addActionListener(this);
		this.v.getPanelFin().getBtnSeguirComprando().addActionListener(this);
		this.v.getPanelFin().getBtnImprimirEntrada().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == v.getPanelHome().getBtnInfoEventos()) {
			v.getPanelEventos().getInfoEventos().setText("");
			// Pausa para que cargue todo
			v.getVentana().setVisible(false);
			v.mostrarPanel("INFO");
			redimensionEventos();
			listarPeliculas();
			// Para que comienze el scroll arriba del todo
			v.getPanelEventos().getInfoEventos().setCaretPosition(0);
			v.getVentana().setVisible(true);

		} else if (e.getSource() == v.getPanelEventos().getBtnAtras()) {
			v.getPanelEventos().getInfoEventos().setText("");
			v.mostrarPanel("HOME");
			redimensionHome();
		} else if (e.getSource() == v.getPanelHome().getBtnSacarEntrada()) {
			reiniciarColorCampos();
			poblarComboCompraPeliculas();
			poblarComboSeleccionAsiento();
			v.mostrarPanel("COMPRA");
			redimensionCompra();
		} else if (e.getSource() == v.getPanelCompra().getBtnAceptar()) {
			verificarCampos();

			// v.mostrarPanel("RESUMEN");
		} else if (e.getSource() == v.getPanelCompra().getBtnAtras())
		{	
			v.panelAnterior();
			redimensionHome();
		} else if (e.getSource() == v.getPanelCompra().getBtnLimpiar()) {
			limpiarCampos();
		} else if (e.getSource() == v.getPanelConfirm().getBtnAtras()) {
			v.panelAnterior();
			redimensionCompra();
		} else if (e.getSource() == v.getPanelConfirm().getBtnAceptar()) {
			guardarVenta();
		} else if (e.getSource() == v.getPanelFin().getBtnVolverMenu()) {
			limpiarCampos();
			v.mostrarPanel("HOME");
			redimensionHome();
		} else if (e.getSource() == v.getPanelFin().getBtnSeguirComprando()) {
			limpiarCampos();
			v.mostrarPanel("COMPRA");
			redimensionCompra();
		} else if (e.getSource() == v.getPanelFin().getBtnImprimirEntrada()) {
			imprimirEntrada();
		}

	}

	private void guardarVenta()
	{
		int idVentaGenerado = m.procesarVenta(this.ventaPreparada);

		if (idVentaGenerado != -1) {
			v.mostrarPanel("FIN");
			redimensionCompra();
		} else {
			System.err.println("Error en el registro de la venta");
		}
	}

	private void limpiarCampos()
	{
		v.getPanelCompra().getChoEventos().setSelectedIndex(0);
		v.getPanelCompra().getTxtNombre().setText("");
		v.getPanelCompra().getTxtApellido().setText("");
		v.getPanelCompra().getTxtEmail().setText("");
		v.getPanelCompra().getTxtAsiento().setText("");
		v.getPanelCompra().getChoTipoAsiento().setSelectedIndex(0);
	}

	private void verificarCampos()
	{
		JComboBox<String> choEvento = v.getPanelCompra().getChoEventos();
		JTextField txtNombre = v.getPanelCompra().getTxtNombre();
		JTextField txtApellido = v.getPanelCompra().getTxtApellido();
		JTextField txtEmail = v.getPanelCompra().getTxtEmail();
		JTextField txtAsiento = v.getPanelCompra().getTxtAsiento();
		JComboBox<String> choTipoAsiento = v.getPanelCompra().getChoTipoAsiento();

		reiniciarColorCampos();

		if (choEvento.getSelectedIndex() == 0) {
			choEvento.setBackground(new Color(255, 230, 230));
			choEvento.requestFocus();
			mostrarError("Seleccione una película por favor", "Película - Inválido", 2);
			return;
		}

		if (txtNombre.getText().trim().isEmpty()) {
			txtNombre.setBackground(new Color(255, 230, 230));
			txtNombre.requestFocus();
			mostrarError("Rellene todos los campos por favor", "Nombre - Inválido", 2);
			return;
		}
		
		if (!txtNombre.getText().matches("^[\\p{L} .'-]+$")){
			txtNombre.setBackground(new Color(255, 230, 230));
			txtNombre.requestFocus();
			mostrarError("Introduzca carácteres válidos para un nombre", "Nombre - Inválido", 2);
			return;
		}

		if (txtApellido.getText().trim().isEmpty()) {
			txtApellido.setBackground(new Color(255, 230, 230));
			txtApellido.requestFocus();
			mostrarError("Rellene todos los campos por favor", "Apellido - Inválido", 2);
			return;
		}
		
		if (!txtApellido.getText().matches("^[\\p{L} .'-]+$")){
			txtApellido.setBackground(new Color(255, 230, 230));
			txtApellido.requestFocus();
			mostrarError("Introduzca carácteres válidos para un apellido", "Apellido - Inválido", 2);
			return;
		}

		if (txtEmail.getText().trim().isEmpty()) {
			txtEmail.setBackground(new Color(255, 230, 230));
			txtEmail.requestFocus();
			mostrarError("Rellene todos los campos por favor", "Email - Inválido", 2);
			return;
		}
		
		String email = txtEmail.getText().trim();
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

		if (!email.matches(regexEmail)) {
		    txtEmail.setBackground(new Color(255, 230, 230));
		    txtEmail.requestFocus();
		    mostrarError("El correo debe tener un formato válido, por ejemplo: usuario@dominio.com", "Email - Inválido", 2);
		    return;
		}
		
		try {
			int cantidad = Integer.parseInt(txtAsiento.getText().trim());
			
			if (cantidad <= 0) {
				txtAsiento.setBackground(new Color(255, 230, 230));
				txtAsiento.requestFocus();
				mostrarError("Debe comprar al menos 1 entrada", "Cantidad - Inválido", 2);
				return;
			}
		} catch (NumberFormatException nfe) {
			txtAsiento.setBackground(new Color(255, 230, 230));
			txtAsiento.requestFocus();
			mostrarError("Introduce un valor numérico, por ejemplo: 2", "Cantidad - Inválido", 2);
			return;
		}

		if (txtAsiento.getText().trim().isEmpty()) {
			txtAsiento.setBackground(new Color(255, 230, 230));
			txtAsiento.requestFocus();
			mostrarError("Rellene todos los campos por favor", "Cantidad - Inválido", 2);
			return;
		}

		if (choTipoAsiento.getSelectedIndex() == 0) {
			choTipoAsiento.setBackground(new Color(255, 230, 230));
			choTipoAsiento.requestFocus();
			mostrarError("Seleccione una butaca por favor", "Butaca - Inválido", 2);
			return;
		}
		mostrarResumen();

	}
	
	private void mostrarError(String mensaje, String titulo, int tipoMensaje) {
		
		Color fondo = new Color(22, 27, 38);  
		Color colorTexto = new Color(255, 255, 255); 
		Color colorBoton = new Color(0, 229, 255);
		
		javax.swing.JLabel lblMensaje = new javax.swing.JLabel(mensaje);
		lblMensaje.setForeground(colorTexto);
		lblMensaje.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
		
		javax.swing.UIManager.put("OptionPane.background", fondo);
		javax.swing.UIManager.put("Panel.background", fondo);
		
		javax.swing.UIManager.put("Button.background", fondo);
		javax.swing.UIManager.put("Button.foreground", colorBoton);
		javax.swing.UIManager.put("Button.font", new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));


		javax.swing.JOptionPane.showMessageDialog(v.getVentana(), lblMensaje, titulo, tipoMensaje);
	}

	private void mostrarResumen()
	{
		PanelCompra pCompra = v.getPanelCompra();
		PanelConfirm pConfirm = v.getPanelConfirm();

		String evento = (String) pCompra.getChoEventos().getSelectedItem();
		String nombre = pCompra.getTxtNombre().getText();
		String apellido = pCompra.getTxtApellido().getText();
		String email = pCompra.getTxtEmail().getText();
		int cantidad = Integer.parseInt(pCompra.getTxtAsiento().getText());
		String tipoAsiento = (String) pCompra.getChoTipoAsiento().getSelectedItem();
		double precioTotal = calcularPrecio();

		prepararVenta(evento, tipoAsiento, cantidad);
		int duracion = this.ventaPreparada.getPelicula().getDuracion();
		float precioUnitario = this.ventaPreparada.getTicket().getPrecio();

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
					            <td class="valor">%s %s</td>
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
				""".formatted(
						evento, duracion, 
						nombre, apellido, 
						email, 
						tipoAsiento, cantidad, 
						precioUnitario, 
						precioTotal
						));

		pConfirm.getResumen().setText(html.toString());

		v.mostrarPanel("RESUMEN");
		redimensionConfirmar();

	}

	private void poblarComboCompraPeliculas()
	{
		if (cartelera == null) {
			cargarPeliculas();
		}
		JComboBox<String> combo = v.getPanelCompra().getChoEventos();
		combo.removeAllItems();
		combo.addItem("Seleciona una película...");
		for (Pelicula p : cartelera) {
			combo.addItem(p.getTitulo());
		}
	}

	private void poblarComboSeleccionAsiento()
	{
		if (asientos == null) {
			cargarTickets();
		}
		JComboBox<String> combo = v.getPanelCompra().getChoTipoAsiento();
		combo.removeAllItems();
		combo.addItem("Selecciona el tipo de butaca");
		for (Ticket t : asientos) {
			combo.addItem(t.getTipo());
		}

	}

	private double calcularPrecio()
	{
		String tipoAsiento = (String) v.getPanelCompra().getChoTipoAsiento().getSelectedItem();
		int cantidad = Integer.parseInt(v.getPanelCompra().getTxtAsiento().getText());
		double precioAsiento = 0.0;
		for (Ticket t : asientos) {
			if (t.getTipo().equals(tipoAsiento)) {
				precioAsiento = t.getPrecio();
				break;
			}
		}

		return cantidad * precioAsiento;
	}

	//	public void listarPeliculas()
	//	{
	//		if (cartelera == null) {
	//			cargarPeliculas();
	//		}
	//		for (Pelicula p : cartelera) {
	//			String titulo = p.getTitulo();
	//			int duracion = p.getDuracion();
	//			String sinopsis = p.getSinopsis();
	//
	//			String bloquePelicula = """
	//					===============================
	//					%s
	//
	//					Duración: %d minutos.
	//					Sinopsis: %s
	//
	//
	//					""".formatted(titulo, duracion, sinopsis);
	//			v.getPanelEventos().getInfoEventos().append(bloquePelicula);
	//		}
	//	}



	private void listarPeliculas()
	{

		if (cartelera == null) {
			cargarPeliculas();
		}
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
		v.getPanelEventos().getInfoEventos().setText(html.toString());
	}




	public void prepararVenta(String tituloPelicula, String tipoAsiento, int cantidad)
	{
		Pelicula peliculaSeleccionada = null;
		for (Pelicula p : cartelera) {
			if (p.getTitulo().equals(tituloPelicula)) {
				peliculaSeleccionada = p;
				break;
			}
		}

		Ticket ticketSeleccionado = null;
		for (Ticket t : asientos) {
			if (t.getTipo().equals(tipoAsiento)) {
				ticketSeleccionado = t;
				break;
			}
		}
		double precioTotal = calcularPrecio();

		this.ventaPreparada = new Venta(0, java.time.LocalDate.now(), cantidad, precioTotal, ticketSeleccionado,
				peliculaSeleccionada);
	}

	public void imprimirEntrada() {
		if (this.ventaPreparada != null) {

			String titulo = this.ventaPreparada.getPelicula().getTitulo();
			String nombreCompleto = v.getPanelCompra().getTxtNombre().getText() + " " + v.getPanelCompra().getTxtApellido().getText();
			String tipoAsiento = this.ventaPreparada.getTicket().getTipo();
			int cantidad = this.ventaPreparada.getCantidad();
			double total = this.ventaPreparada.getTotal();

			System.out.println("nombre: "+nombreCompleto);
			Impresora.imprimirEntrada(titulo, nombreCompleto, tipoAsiento, cantidad, total);

		} else {
			System.err.println("Error en la impresión");
		}
	}

	public void reiniciarColorCampos() {

		JComboBox<String> choEvento = v.getPanelCompra().getChoEventos();
		JTextField txtNombre = v.getPanelCompra().getTxtNombre();
		JTextField txtApellido = v.getPanelCompra().getTxtApellido();
		JTextField txtEmail = v.getPanelCompra().getTxtEmail();
		JTextField txtAsiento = v.getPanelCompra().getTxtAsiento();
		JComboBox<String> choTipoAsiento = v.getPanelCompra().getChoTipoAsiento();

		choEvento.setBackground(Color.WHITE);
		txtNombre.setBackground(Color.WHITE);
		txtApellido.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtAsiento.setBackground(Color.WHITE);
		choTipoAsiento.setBackground(Color.WHITE);
	}
	
	public void redimensionHome() {
		v.getVentana().setSize(1182,665);
		v.getVentana().setLocationRelativeTo(null);
	}
	
	public void redimensionCompra() {
		v.getVentana().setSize(500, 300);
		v.getVentana().setLocationRelativeTo(null);
	}
	
	public void redimensionEventos() {
		v.getVentana().setSize(740, 800);
		v.getVentana().setLocationRelativeTo(null);
	}
	
	public void redimensionConfirmar() {
		v.getVentana().setSize(600, 600);
		v.getVentana().setLocationRelativeTo(null);
	}
}
