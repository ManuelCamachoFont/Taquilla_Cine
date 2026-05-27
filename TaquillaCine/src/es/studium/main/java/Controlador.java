package es.studium.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

	private Modelo m;
	private Vista v;
	
	//Object boton1 = v.getPanelHome().getBtnInfoEventos();
	
	public Controlador(Modelo modelo, Vista vista) {
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == v.getPanelHome().getBtnInfoEventos()){
			v.mostrarPanel("INFO");
		} else if (e.getSource() == v.getPanelEventos().getBtnAtras()) {
			v.mostrarPanel("HOME");
		} else if (e.getSource() == v.getPanelHome().getBtnSacarEntrada()) {
			v.mostrarPanel("COMPRA");
		} else if (e.getSource() == v.getPanelCompra().getBtnAceptar()) {
			v.mostrarPanel("RESUMEN");
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
			v.mostrarPanel("COMPRA");
		} else if (e.getSource() == v.getPanelFin().getBtnImprimirEntrada()) {
			System.out.println("IMPRIMIR ENTRADA");
		}
		
	}
	
	public void limpiarCampos() {
		v.getPanelCompra().getTxtNombre().setText(" ");
		v.getPanelCompra().getTxtApellido().setText(" ");
		v.getPanelCompra().getTxtEmail().setText(" ");
		v.getPanelCompra().getTxtAsiento().setText(" ");
	}
	
	

}
