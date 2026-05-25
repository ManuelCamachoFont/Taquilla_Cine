package es.studium.main.java;

public class Modelo {

	DB conexion = new DB();
	
	private DAOPelicula daoP;
	private DAOTicket daoT;
	private DAOVenta daoV;


	DAOPelicula daoPelicula = new DAOPelicula();
	//DAOTicket daoTicket = new DAOTicket();
	//DAOVenta daoVenta = new DAOVenta();

	public Modelo() {
		this.daoP = daoPelicula;
		//this.daoT = daoTicket;
		//this.daoV = daoVenta;
		System.out.println(conexion);
		System.out.println(daoPelicula.obtenerPeliculas());
	}
}
