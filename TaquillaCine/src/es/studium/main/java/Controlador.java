package es.studium.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controlador implements ActionListener
{

	private Modelo m;
	private Vista v;
	private List<Pelicula> cartelera;
	private List<Ticket> asientos;

	private Venta ventaPreparada;

	public Controlador(Modelo modelo, Vista vista)
	{
		this.m = modelo;
		this.v = vista;
		registrarActivaciones();

	}

	private void registrarActivaciones() {
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
		Object evento = e.getSource();

		// Panel Home
		if (evento.equals(v.getPanelHome().getBtnInfoEventos())) {
			procesarEventos();

		} else if (evento.equals(v.getPanelHome().getBtnSacarEntrada())) {
			procesarCompra();
		} 
		// Panel Evento
		else if (evento.equals(v.getPanelEventos().getBtnAtras())) {
			v.cargarPanelHome();

		}
		// Panel Compra
		else if (evento.equals(v.getPanelCompra().getBtnAceptar())) {
			procesarValidarCompra();
		} 
		else if (evento.equals(v.getPanelCompra().getBtnAtras()))
		{	
			v.cargarPanelHome();
		} else if (evento.equals(v.getPanelCompra().getBtnLimpiar())) {
			v.getPanelCompra().limpiarCampos();

		} 
		// Panel Confirmacion
		else if (evento.equals(v.getPanelConfirm().getBtnAceptar())) {
			procesarGuardarVenta();
		} else if (evento.equals(v.getPanelConfirm().getBtnAtras())) {
			v.cargarPanelCompra();
		}

		//	Panel Fin
		else if (evento.equals(v.getPanelFin().getBtnVolverMenu())) {
			v.getPanelCompra().limpiarCampos();
			v.cargarPanelHome();
		} else if (evento.equals(v.getPanelFin().getBtnSeguirComprando())) {
			v.getPanelCompra().limpiarCampos();
			v.cargarPanelCompra();
		} else if (evento.equals(v.getPanelFin().getBtnImprimirEntrada())) {
			imprimirEntrada();
		}

	}

	private void procesarEventos() {
		if (cartelera == null) cartelera = m.consultarCartelera();

		v.getPanelEventos().limpiarInfo();
		String htmlCartelera = GeneradorHtml.generarCartelera(cartelera);
		v.getPanelEventos().cargarContenidoHtml(htmlCartelera);
		v.cargarPanelEventos();
	}

	private void procesarCompra() {
		if (cartelera == null) cartelera = m.consultarCartelera();
		if (asientos == null) asientos = m.consultarTickets();

		v.getPanelCompra().reinicioVisualCampos();
		v.getPanelCompra().poblarPeliculas(cartelera);
		v.getPanelCompra().poblarAsientos(asientos);

		v.cargarPanelCompra();
	}

	private void procesarValidarCompra() {
		PanelCompra panelCompra = v.getPanelCompra();

		if (!panelCompra.validarCampos()) {
			return; 
		}

		String evento = panelCompra.getPelicula();
		String tipoAsiento = panelCompra.getAsiento();
		int cantidad = panelCompra.getCantidad();
		String nombreCompleto = panelCompra.getNombreCompleto();
		String email = panelCompra.getEmail();

		prepararVenta(evento, tipoAsiento, cantidad);

		String htmlResumen = GeneradorHtml.generarResumenVenta(this.ventaPreparada, nombreCompleto, email);
		v.getPanelConfirm().setResumen(htmlResumen);

		v.cargarPanelConfirmar();
	}



	private void procesarGuardarVenta()
	{
		int idVentaGenerado = m.procesarVenta(this.ventaPreparada);

		if (idVentaGenerado != -1) {
			v.cargarPanelFin();
		} else {
			ControlErrores.mostrarError(v.getPanelConfirm(), "Error en el procesamiento de la venta", "Error", 0);
		}
	}

	public void prepararVenta(String tituloPelicula, String tipoAsiento, int cantidad) {

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


		double precioTotal = 0.0;
		if (ticketSeleccionado != null) {
			precioTotal = ticketSeleccionado.getPrecio() * cantidad;
		}

		this.ventaPreparada = new Venta(0, java.time.LocalDate.now(), cantidad, precioTotal, ticketSeleccionado, peliculaSeleccionada );
	}

	public void imprimirEntrada() {
		if (this.ventaPreparada != null) {

			String titulo = this.ventaPreparada.getPelicula().getTitulo();
			String nombreCompleto = v.getPanelCompra().getNombreCompleto();
			String tipoAsiento = this.ventaPreparada.getTicket().getTipo();
			int cantidad = this.ventaPreparada.getCantidad();
			double total = this.ventaPreparada.getTotal();
			Impresora.imprimirEntrada(titulo, nombreCompleto, tipoAsiento, cantidad, total);

		} else {
			ControlErrores.mostrarError(v.getPanelFin(), "Error en la impresión", "Error", 0);
		}
	}


}
