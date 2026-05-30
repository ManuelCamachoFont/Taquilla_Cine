package es.studium.main.java;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Clase creada para el manejo de errores en la aplicación de forma visual para el usuario.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class ControlErrores {

	/**
	 * Este procedimiento muestra un diálogo con un mensaje personalizado que se ejecutará en caso de error para que el usuario pueda comprender que ha fallado.
	 * 
	 * @param elementoPadre Componente sobre el que se mostrará el diálogo.
	 * @param mensajeError	Mensaje personalizado para cada error.
	 * @param tituloDialogo Título para el diálogo destacando el error.
	 * @param tipoMensaje	Tipo de error que acompañara al diálogo con un icono de advertencia, error,...
	 */
	public static void mostrarError(JComponent elementoPadre, String mensajeError, String tituloDialogo, int tipoMensaje) {
		
		Color fondo = new Color(11,15, 25);
		Color colorTexto = new Color(255, 255, 255); 
		Color colorBoton = new Color(0, 229, 255);

		JLabel lblError = new JLabel();

		lblError.setForeground(colorTexto);
		lblError.setFont(new Font("Segoe UI", 2, 14));
		lblError.setText(mensajeError);

		UIManager.put("OptionPane.background", fondo);
		UIManager.put("Panel.background", fondo);

		UIManager.put("Button.background", fondo);
		UIManager.put("Button.foreground", colorBoton);
		UIManager.put("Button.font", new Font("Segoe UI", 1, 12));

		JOptionPane.showMessageDialog(elementoPadre, lblError, tituloDialogo, tipoMensaje);
		
	}
}
