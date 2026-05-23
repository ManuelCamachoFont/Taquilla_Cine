package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOTicket {

	private Connection connect;

	public DAOTicket(Connection connect) {
		this.connect = connect;
	}


	public List<Ticket> obtenerTicketPelicula(Pelicula pelicula) {
		List<Ticket> listaTickets = new ArrayList<>();
		String sqlQuery = "SELECT idTicket, tipoTicket, precioTicket FROM tickets WHERE idPeliculaFK = ?";
		try (PreparedStatement ps = connect.prepareStatement(sqlQuery)) {

			ps.setInt(1, pelicula.getId());

			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					int id = (rs.getInt("idticket"));
					String tipo = (rs.getString("tipoTicket"));
					float precio = (rs.getFloat("precioTicket"));
					Ticket t = new Ticket(id, tipo, precio, pelicula);
					listaTickets.add(t);
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error al leer: " + sqle.getMessage());
		}
		return listaTickets;
	}

}
