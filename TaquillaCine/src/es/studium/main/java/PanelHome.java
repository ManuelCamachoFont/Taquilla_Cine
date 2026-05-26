package es.studium.main.java;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHome extends JPanel
{
	private JLabel lblTitulo = new JLabel("Bienvenido", JLabel.CENTER);
	private JButton btnSacarEntrada = new JButton("Sacar entradas");
	private JButton btnInfoEvento = new JButton("Información de Eventos");
	
	public PanelHome() {
		setLayout(new GridLayout(3,1,10,20));
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblTitulo);
		
		btnInfoEvento.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnInfoEvento);

        btnSacarEntrada.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnSacarEntrada);
	}
	
	public JButton getBtnInfoEventos() {
		return this.btnInfoEvento;
	}
	public JButton getBtnSacarEntrada() {
		return this.btnSacarEntrada;
	}
}
