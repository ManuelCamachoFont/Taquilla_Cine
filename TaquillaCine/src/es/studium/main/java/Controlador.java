package es.studium.main.java;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Controlador implements ActionListener
{

	private Modelo m;
	private Vista v;

	// Object boton1 = v.getPanelHome().getBtnInfoEventos();

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
			v.mostrarPanel("INFO");
		} else if (e.getSource() == v.getPanelEventos().getBtnAtras()) {
			v.mostrarPanel("HOME");
		} else if (e.getSource() == v.getPanelHome().getBtnSacarEntrada()) {
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
			v.mostrarPanel("FIN");
		} else if (e.getSource() == v.getPanelFin().getBtnVolverMenu()) {
			v.mostrarPanel("HOME");
		} else if (e.getSource() == v.getPanelFin().getBtnSeguirComprando()) {
			limpiarCampos();
			v.mostrarPanel("COMPRA");
		} else if (e.getSource() == v.getPanelFin().getBtnImprimirEntrada()) {
			System.out.println("IMPRIMIR ENTRADA");
		}

	}

	public void limpiarCampos()
	{
		v.getPanelCompra().getTxtNombre().setText(" ");
		v.getPanelCompra().getTxtApellido().setText(" ");
		v.getPanelCompra().getTxtEmail().setText(" ");
		v.getPanelCompra().getTxtAsiento().setText(" ");
	}

	public void verificarCampos()
	{
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

	public void mostrarResumen()
	{
		PanelCompra pCompra = v.getPanelCompra();
		PanelConfirm pConfirm = v.getPanelConfirm();

		String evento = (String) pCompra.getChoEventos().getSelectedItem();
		String nombre = pCompra.getTxtNombre().getText();
		String apellido = pCompra.getTxtApellido().getText();
		String email = pCompra.getTxtEmail().getText();
		String asiento = pCompra.getTxtAsiento().getText();
		String tipoAsiento = (String) pCompra.getChoTipoAsiento().getSelectedItem();

		// Hay que mirar cómo pasarlo a número si no lo devuelve ya. que el índice no
		// venga como 0, poruqe peta todo
		float precioTotal = Integer.parseInt(asiento) * calcularPrecio(pCompra.getChoTipoAsiento());

		pConfirm.getInfoEvento().setText("Película seleccionada: " + evento);

		pConfirm.getNombreCompleto().setText(
				"Datos del comprador:\n" + "Nombre completo: " + nombre + " " + apellido + "\n" + "Email: " + email);

		pConfirm.getInfoAsiento().setText("Tipo de asiento: " + tipoAsiento);
		pConfirm.getPrecioTotal().setText("Precio total: " + precioTotal + "€");

		v.mostrarPanel("RESUMEN");
	}

	public float calcularPrecio(JComboBox<String> choEvento)
	{
		// float precioTotal
		String seleccion = choEvento.getSelectedItem().toString();
		float precio = 0.0f;
		switch (seleccion) {
		case "Butaca - 7,50€":
			precio = 7.5f;
			break;
		case "Butaca Premium - 10,50€":
			precio = 10.50f;
			break;
		case "Palco - 15,50€":
			precio = 15.50f;
			break;
		default:
		}
		System.out.println(seleccion);
		System.out.println(precio);
		return precio;
	}

}
