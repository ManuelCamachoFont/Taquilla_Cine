package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPelicula {

	private Connection connect;
	
	public DAOPelicula(Connection connect) {
		this.connect = connect;
	}
	
	public boolean insertarPelicula(Pelicula pelicula) {
		String sqlUpdate = "INSERT INTO peliculas(tituloPelicula, duracion, sinopsis) VALUES = (?, ?, ?)";
		try (PreparedStatement ps = connect.prepareStatement(sqlUpdate)){
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getDuracion());
			ps.setString(3, pelicula.getSinopsis());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException sqle) {
			return false;
		}
	}
	
	public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        String sqlQuery = "SELECT * FROM peliculas";
        try (PreparedStatement ps = connect.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = (rs.getInt("idPelicula"));
                String titulo = (rs.getString("tituloPelicula"));
                int duracion = (rs.getInt("duracionPelicula"));
                String sinopsis = (rs.getString("sinopsisPelicula"));
                Pelicula p = new Pelicula(id, titulo, duracion, sinopsis);
                listaPeliculas.add(p);
            }
        } catch (SQLException sqle) {
            System.out.println("Error al leer: " + sqle.getMessage());
        }
        return listaPeliculas;
    }
	
    public Pelicula obtenerPelicula(int idBusqueda) {
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, idBusqueda);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	int id = (rs.getInt("idPelicula"));
                    String titulo = (rs.getString("tituloPelicula"));
                    int duracion = (rs.getInt("duracionPelicula"));
                    String sinopsis = (rs.getString("sinopsisPelicula"));
                    Pelicula p = new Pelicula(id, titulo, duracion, sinopsis);
                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        }
        return null;
    }

    
}
