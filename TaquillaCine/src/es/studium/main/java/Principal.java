package es.studium.main.java;

public class Principal {

	public static void main(String[] args) {
		//try {
			Modelo modelo = new Modelo();
			Vista vista = new Vista();
			new Controlador(modelo, vista);
		//}catch (Exception e){
		//	JOptionPane.showMessageDialog(null,
		//			"No se ha podido conectar con la base de datos.\nVerifica que MySQL esté encendido.",
		//			"Error de Conexión",
		//			JOptionPane.ERROR_MESSAGE);
		//	System.exit(1);

	}
}
