package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOVenta
{

	private Connection conexion;

	public DAOVenta(Connection connect)
	{
		this.conexion = connect;
	}

	public int registrarVenta(Venta venta)
	{
		String sqlUpdate = "INSERT INTO ventas (fechaVenta, cantidadVenta, totalVenta, idTicketFK, idPeliculaFK) VALUES (?, ?, ?, ?, ?)";
		int id = -1;
		try (PreparedStatement ps = conexion.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS)) {

			ps.setObject(1, venta.getFecha());
			ps.setFloat(2, venta.getCantidad());
			ps.setDouble(3, venta.getTotal());
			ps.setInt(4, venta.getTicket().getId());
			ps.setInt(5, venta.getPelicula().getId());

			int insert = ps.executeUpdate();

			if (insert > 0) {
				try (ResultSet rsPK = ps.getGeneratedKeys()) {
					if (rsPK.next()) {
						id = rsPK.getInt(1);
					}
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error al leer: " + sqle.getMessage());
		}
		return id;
	}
}
