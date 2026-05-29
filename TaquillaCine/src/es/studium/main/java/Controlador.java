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
			listarPeliculas();
			v.mostrarPanel("INFO");
		} else if (e.getSource() == v.getPanelEventos().getBtnAtras()) {
			v.mostrarPanel("HOME");
		} else if (e.getSource() == v.getPanelHome().getBtnSacarEntrada()) {
			reiniciarColorCampos();
			poblarComboCompraPeliculas();
			poblarComboSeleccionAsiento();
			v.mostrarPanel("COMPRA");
		} else if (e.getSource() == v.getPanelCompra().getBtnAceptar()) {
			verificarCampos();
			// v.mostrarPanel("RESUMEN");
		} else if (e.getSource() == v.getPanelCompra().getBtnAtras()) {
			v.panelAnterior();
		} else if (e.getSource() == v.getPanelCompra().getBtnLimpiar()) {
			limpiarCampos();
		} else if (e.getSource() == v.getPanelConfirm().getBtnAtras()) {
			v.panelAnterior();
		} else if (e.getSource() == v.getPanelConfirm().getBtnAceptar()) {
			guardarVenta();
		} else if (e.getSource() == v.getPanelFin().getBtnVolverMenu()) {
			limpiarCampos();
			v.mostrarPanel("HOME");
		} else if (e.getSource() == v.getPanelFin().getBtnSeguirComprando()) {
			limpiarCampos();
			v.mostrarPanel("COMPRA");
		} else if (e.getSource() == v.getPanelFin().getBtnImprimirEntrada()) {
			imprimirEntrada();
		}

	}

	private void guardarVenta()
	{
		int idVentaGenerado = m.procesarVenta(this.ventaPreparada);

		if (idVentaGenerado != -1) {
			v.mostrarPanel("FIN");
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
			return;
		}

		if (txtNombre.getText().trim().isEmpty()) {
			txtNombre.setBackground(new Color(255, 230, 230));
			txtNombre.requestFocus();
			return;
		}

		if (txtApellido.getText().trim().isEmpty()) {
			txtApellido.setBackground(new Color(255, 230, 230));
			txtApellido.requestFocus();
			return;
		}

		if (txtEmail.getText().trim().isEmpty()) {
			txtEmail.setBackground(new Color(255, 230, 230));
			txtEmail.requestFocus();
			return;
		}

		if (txtAsiento.getText().trim().isEmpty()) {
			txtAsiento.setBackground(new Color(255, 230, 230));
			txtAsiento.requestFocus();
			return;
		}

		if (choTipoAsiento.getSelectedIndex() == 0) {
			choTipoAsiento.setBackground(new Color(255, 230, 230));
			choTipoAsiento.requestFocus();
			return;
		}
		mostrarResumen();

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

		pConfirm.getInfoEvento().setText("Película seleccionada: " + evento +" (Duración: "+ duracion+" minutos");
		pConfirm.getNombreCompleto().setText(
				"Datos del comprador - Nombre completo: " + nombre + " " + apellido + "||" + "Email: " + email);
		pConfirm.getInfoAsiento().setText("Tipo de asiento: " + tipoAsiento + "Cantidad: " + cantidad);
		pConfirm.getPrecioTotal().setText("Precio por butaca: "+ precioUnitario + "€. Precio total: " + precioTotal + "€");

		v.mostrarPanel("RESUMEN");
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

	private void listarPeliculas()
	{
		if (cartelera == null) {
			cargarPeliculas();
		}
		for (Pelicula p : cartelera) {
			String titulo = p.getTitulo();
			int duracion = p.getDuracion();
			String sinopsis = p.getSinopsis();

			String bloquePelicula = """
					===============================
					%s

					Duración: %d minutos.
					Sinopsis: %s


					""".formatted(titulo, duracion, sinopsis);
			v.getPanelEventos().getInfoEventos().append(bloquePelicula);
		}
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
}
