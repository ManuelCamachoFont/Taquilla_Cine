package es.studium.main.java;

import java.sql.Connection;
import java.util.List;

/**
 * Clase Modelo en la que se gestiona la lógica de los datos que utilizará el controlador. Hace uso de las clases Data Access Object.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
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

	/**
	 *  Accede a la clase DAOPelicula para obtener su información. Hace de puente con el controlador.
	 *  
	 * @return Devuelve un listado con todas las películas disponibles y las guarda en un array con sus valores.
	 */
	public List<Pelicula> consultarCartelera()
	{
		return this.daoPelicula.obtenerPeliculas();
	}

	/**
	 * Accede a la clase DAOTicket para obtener su información. Hace de puente con el controlador.
	 * 
	 * @return Devuelve un listado con todos los tickets disponibles y los guarda en un array con sus valores.
	 */
	public List<Ticket> consultarTickets()
	{
		return this.daoTicket.obtenerTicket();
	}
	
	/**
	 * Accede a la clase DAOVenta para obtener su información. Hace de puente con el controlador.
	 * 
	 * @param venta Objeto Venta que obtenemos de la clase Venta.java
	 * @return Devuelve el id de la venta, si devuelve -1 nos indica que ha surgido algún error, en caso contrario que nos devuelva otro número será el id de la venta generada.
	 */
	public int procesarVenta(Venta venta)
	{
		return this.daoVenta.registrarVenta(venta);
	}
}
