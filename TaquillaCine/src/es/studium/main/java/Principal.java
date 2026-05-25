package es.studium.main.java;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			Modelo modelo = new Modelo();
			Vista vista = new Vista();
			conexion = DBConnect.getInstance().getDBConnection();
			DAOPelicula daoPelicula = new DAOPelicula(conexion);
			DAOTicket daoTicket = new DAOTicket(conexion);
			DAOVenta daoVenta = new DAOVenta(conexion);
			Controlador controlador = new Controlador(modelo, vista, daoPelicula, daoTicket, daoVenta);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, 
					"No se ha podido conectar con la base de datos.\nVerifica que MySQL esté encendido.", 
					"Error de Conexión", 
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

	}
}
