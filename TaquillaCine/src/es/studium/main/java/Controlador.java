package es.studium.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Clase Controlador para gestionar los eventos de la interfaz, comunicación con la base de datos y el flujo de la compra de entradas.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
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
		salidaSegura();

	}

	/**
	 * Registra los listeners de todos los botones.
	 */
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
	
	/**
	 * Cierra la conexión antes de cerrar la aplicación.
	 */
	private void salidaSegura() {
		this.v.getVentana().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando la conexión con la base de datos...");
                DB.closeConnection(); 
                v.getVentana().dispose(); 
                System.exit(0); 
            }
        });
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

	/**
	 * Actualiza la información del PanelEventos y carga el panel.
	 */
	private void procesarEventos() {
		if (cartelera == null) cartelera = m.consultarCartelera();

		v.getPanelEventos().limpiarInfo();
		String htmlCartelera = GeneradorHtml.generarCartelera(cartelera);
		v.getPanelEventos().cargarContenidoHtml(htmlCartelera);
		v.cargarPanelEventos();
	}

	/**
	 * Carga las películas y asientos disponibles y muestra el panel con el formulario de compra.
	 */
	private void procesarCompra() {
		if (cartelera == null) cartelera = m.consultarCartelera();
		if (asientos == null) asientos = m.consultarTickets();

		v.getPanelCompra().reinicioVisualCampos();
		v.getPanelCompra().poblarPeliculas(cartelera);
		v.getPanelCompra().poblarAsientos(asientos);

		v.cargarPanelCompra();
	}

	/**
	 * Valida la información de todos los campos del formulario, y si cumplen los requisitos carga el PanelConfirm.
	 */
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
	
	/**
	 * Guarda la venta en memoria despues de completar el formulario para mostrar un resumen y darle opción al usuario de confirmar la operación o cancelarla.
	 * 
	 * @param tituloPelicula Película seleccionada por el usuario en el formulario.
	 * @param tipoAsiento Asiento seleccionado por el usuario en el formulario.
	 * @param cantidad Cantidad de entradas seleccionadas por el usuario en el formulario.
	 */
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


	/**
	 * Desde el PanelConfirm ejecuta la venta y la registra en la base de datos y lleva al usuario al PanelFin.
	 */
	private void procesarGuardarVenta()
	{
		int idVentaGenerado = m.procesarVenta(this.ventaPreparada);

		if (idVentaGenerado != -1) {
			v.cargarPanelFin();
		} else {
			ControlErrores.mostrarError(v.getPanelConfirm(), "Error en el procesamiento de la venta", "Error", 0);
		}
	}

	/**
	 * Crea un archivo PDF con los datos del usuario obtenidos en el formulario, de la aplicación y la fecha en la que se ha realizado.
	 */
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
