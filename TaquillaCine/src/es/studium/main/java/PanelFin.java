package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFin extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitulo = new JLabel("Gracias por tu compra", JLabel.CENTER);

	private JButton btnVolverMenu = new JButton("Volver al menú");
	private JButton btnSeguirComprando = new JButton("Seguir comprando");
	private JButton btnImprimirEntrada = new JButton("Imprimir entrada");
	
	public PanelFin() {
		setLayout(new FlowLayout(20));

		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		add(btnVolverMenu, FlowLayout.LEFT);
		add(btnSeguirComprando, FlowLayout.CENTER);
		add(btnImprimirEntrada, FlowLayout.RIGHT);
	}
	
	public JButton getBtnVolverMenu() {
		return this.btnVolverMenu;
	}
	public JButton getBtnSeguirComprando() {
		return this.btnSeguirComprando;
	}
	public JButton getBtnImprimirEntrada() {
		return this.btnImprimirEntrada;
	}
}
