package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Data Access Object para gestionar el objeto Ticket de la base de datos.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class DAOTicket
{

	private Connection conexion;

	public DAOTicket(Connection connect)
	{
		this.conexion = connect;
	}

	/**
	 * Función para obtener el listado de los tickets de la base de datos.
	 * 
	 * @return Devuelve un listado con todos los tickets disponibles y los guarda en un array con sus valores.
	 */
	public List<Ticket> obtenerTicket()
	{
		List<Ticket> listaTickets = new ArrayList<>();
		String sqlQuery = "SELECT * FROM tickets;";
		try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = (rs.getInt("idticket"));
				String tipo = (rs.getString("tipoTicket"));
				float precio = (rs.getFloat("precioTicket"));
				Ticket t = new Ticket(id, tipo, precio);
				listaTickets.add(t);
			}
		} catch (SQLException sqle) {
			System.out.println("Error al leer: " + sqle.getMessage());
		}
		return listaTickets;
	}

}
