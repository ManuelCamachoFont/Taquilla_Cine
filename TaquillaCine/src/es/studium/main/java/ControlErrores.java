package es.studium.main.java;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControlErrores {


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
