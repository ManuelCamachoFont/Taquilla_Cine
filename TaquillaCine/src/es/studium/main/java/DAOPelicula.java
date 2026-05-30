package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Data Access Object para gestionar el objeto Película de la base de datos.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class DAOPelicula
{

	private Connection conexion;

	public DAOPelicula(Connection connect)
	{
		this.conexion = connect;
	}

	/**
	 * Función para obtener el listado de las películas de la base de datos.
	 * 
	 * @return Devuelve un listado con todas las películas disponibles y las guarda en un array con sus valores.
	 */
	public List<Pelicula> obtenerPeliculas()
	{
		List<Pelicula> listaPeliculas = new ArrayList<>();
		String sqlQuery = "SELECT * FROM peliculas";
		try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = (rs.getInt("idPelicula"));
				String titulo = (rs.getString("tituloPelicula"));
				int duracion = (rs.getInt("duracionPelicula"));
				String sinopsis = (rs.getString("sinopsisPelicula"));
				String imagen = (rs.getString("imgPelicula"));
				Pelicula p = new Pelicula(id, titulo, duracion, sinopsis, imagen);
				listaPeliculas.add(p);
			}
		} catch (SQLException sqle) {
			System.err.println("Error al leer: " + sqle.getMessage());
		}
		return listaPeliculas;
	}

}
