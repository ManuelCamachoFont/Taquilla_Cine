package es.studium.main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel principal de la interfaz gráfica que contiene una pantalla de bienvenida con dos botones, uno para consultar información y otro para la compra de entradas.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class PanelHome extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo = new JLabel("¡Bienvenido a CineLema!", JLabel.CENTER);
	private JButton btnSacarEntrada = new JButton("Sacar entradas");
	private JButton btnInfoEvento = new JButton("Información de Eventos");
	private JLabel lblDerechos = new JLabel("© 2026 CineLema. Leo Ruiz & Manuel Camacho. Todos los derechos reservados.", JLabel.CENTER);
	
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color(138, 153, 173);
	
	private Image fondo;
	
	public PanelHome() {
		
		URL urlFondo = PanelHome.class.getResource("/es/studium/main/resources/img/fondo.png");
		if (urlFondo != null) {
			fondo = new ImageIcon(urlFondo).getImage();
		}
		
		setLayout(null);
		setPreferredSize(new Dimension (1182,665));
		
		lblTitulo.setForeground(colorTitulo);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitulo.setBounds(291, 100, 600, 50);
		add(lblTitulo);
		
		btnInfoEvento.setForeground(colorTitulo);
		btnInfoEvento.setBackground(colorBoton);
		btnInfoEvento.setFont(new Font("Arial", Font.BOLD, 14));
        btnInfoEvento.setBounds( 441, 280, 300, 50);
       

        add(btnInfoEvento);

        btnSacarEntrada.setForeground(colorTitulo);
        btnSacarEntrada.setBackground(colorBoton);
        btnSacarEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		btnSacarEntrada.setBounds(441, 360, 300, 50);
        add(btnSacarEntrada);
        
        lblDerechos.setForeground(colorTxt);
		lblDerechos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDerechos.setBounds(341, 580, 500, 30); 
		add(lblDerechos);
	}
	
	/**
	 * Método para establecer la imagen de fondo, y en caso de error cambiar el color de fondo a uno de la misma paleta utilizada en la aplicación.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (fondo != null) {
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		} else {
			setBackground(new Color(11, 15, 25));
		}
	}
	
	public JButton getBtnInfoEventos() {
		return this.btnInfoEvento;
	}
	public JButton getBtnSacarEntrada() {
		return this.btnSacarEntrada;
	}
}
