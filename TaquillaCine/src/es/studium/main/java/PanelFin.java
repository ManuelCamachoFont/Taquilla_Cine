package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PanelFin extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea txaGracias = new JTextArea(10, 10);

	private JPanel panelBtns = new JPanel();
	
	private JButton btnVolverMenu = new JButton("Volver al menú");
	private JButton btnSeguirComprando = new JButton("Seguir comprando");
	private JButton btnImprimirEntrada = new JButton("Imprimir entrada");
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color (138, 153, 173);
	
	public PanelFin() {
		setLayout(new BorderLayout(10, 10));
		txaGracias.setEditable(false);
		txaGracias.setBorder(new EmptyBorder(50, 50, 50, 50));
		txaGracias.setForeground(colorTxt);
		txaGracias.setBackground(fondo);
		txaGracias.setLineWrap(true);
		txaGracias.setWrapStyleWord(true);
		txaGracias.setFont(new Font("Segoe UI", 3, 20));
		txaGracias.setText("Gracias por la compra, esperamos que disfrute de la película. El equipo de CineLema le desea una magnífica experiencia.");
		add(txaGracias, BorderLayout.CENTER);
		
		
		panelBtns.setBackground(fondo);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		btnVolverMenu.setForeground(colorTitulo);
		btnVolverMenu.setBackground(colorBoton);
	    panelBtns.add(btnVolverMenu);
	    btnSeguirComprando.setForeground(colorTitulo);
	    btnSeguirComprando.setBackground(colorBoton);
	    panelBtns.add(btnSeguirComprando);
	    btnImprimirEntrada.setForeground(colorTitulo);
	    btnImprimirEntrada.setBackground(colorBoton);
	    panelBtns.add(btnImprimirEntrada);
	    
	    add(panelBtns, BorderLayout.SOUTH);
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
