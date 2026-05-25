package es.studium.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controlador extends WindowAdapter implements ActionListener {

	private Modelo m;
	private Vista v;
	private DAOPelicula daoP;
	private DAOTicket daoT;
	private DAOVenta daoV;
	
	public Controlador(Modelo modelo, Vista vista, DAOPelicula daoPelicula, DAOTicket daoTicket, DAOVenta daoVenta) {
		this.m = modelo;
		this.v = vista;
		this.daoP = daoPelicula;
		this.daoT = daoTicket;
		this.daoV = daoVenta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		
	}

}
