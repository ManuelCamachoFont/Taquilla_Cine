package es.studium.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB
{
	private static final String URL = "jdbc:mysql://localhost:3306/taquilla_cine";
	private static final String USER = "clienteCine";
	private static final String PWD = "studium";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Connection connect = null;

	public static Connection DBConnect()
	{
		try {
			if (connect != null && !connect.isClosed()) {
				return connect;
			}
			Class.forName(DRIVER);
			connect = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Driver cargado: " + DRIVER);
			System.out.println("Conexión establecida: " + connect);
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Error de driver: " + e.getMessage());
			connect = null;
		}

		return connect;
	}

	public void closeConnection()
	{
		try {
			if (connect != null && !connect.isClosed()) {
				connect.close();
				System.out.println("Conexión cerrada correctamente.");
			}
		} catch (SQLException sqle) {
			System.err.println("Error al cerrar la base de datos: " + sqle.getMessage());
		}
	}
}
