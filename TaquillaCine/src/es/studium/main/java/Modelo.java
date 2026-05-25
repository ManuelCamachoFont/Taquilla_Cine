package es.studium.main.java;

import java.sql.Connection;

public class Modelo {

	private DAOPelicula daoP;
	private DAOTicket daoT;
	private DAOVenta daoV;

	Connection conexion = DBConnect.getInstance().getDBConnection();

	DAOPelicula daoPelicula = new DAOPelicula(conexion);
	DAOTicket daoTicket = new DAOTicket(conexion);
	DAOVenta daoVenta = new DAOVenta(conexion);

	public Modelo() {
		this.daoP = daoPelicula;
		this.daoT = daoTicket;
		this.daoV = daoVenta;
		System.out.println(conexion);
	}
}
