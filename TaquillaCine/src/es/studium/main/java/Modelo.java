package es.studium.main.java;

import java.sql.Connection;

public class Modelo
{

	private Connection conexion;

	private DAOPelicula daoPelicula;
	private DAOTicket daoTicket;
	private DAOVenta daoVenta;

	public Modelo()
	{
		this.conexion = DB.DBConnect();
		if (this.conexion != null) {
			this.daoPelicula = new DAOPelicula(this.conexion);
			this.daoTicket = new DAOTicket(this.conexion);
			this.daoVenta = new DAOVenta(this.conexion);
			System.out.println("Conexiones a tablas establecidas");
		} else {
			System.err.println("Fallo de conexión");
		}
	}
	
	public DAOPelicula getDaoPelicula() {
		return daoPelicula;
	}
	public DAOTicket getDaoTicket() {
		return daoTicket;
	}
	public DAOVenta getDaoVenta() {
		return daoVenta;
	}
}
