package es.studium.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static final String URL = "jdbc:mysql://localhost:3306/taquilla_cine" ;
	private static final String USER = "clienteCine" ;
	private static final String PWD = "studium";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static DBConnect instance = null;

	private Connection connect = null;

	private DBConnect() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		connect = DriverManager.getConnection(URL, USER, PWD);

	}

	public static DBConnect getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null || instance.connect == null || instance.connect.isClosed()) {
			instance = new DBConnect();
		}

		return instance;
	}

	public Connection getDBConnection(){
		return this.connect;
	}

	public void closeConnection() {
		try {
			if (connect!=null && !connect.isClosed()) {
				connect.close();
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
