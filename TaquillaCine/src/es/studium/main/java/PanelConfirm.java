package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelConfirm extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo = new JLabel("Confirmar compra", JLabel.CENTER);
	
	private JEditorPane txaResumen = new JEditorPane();
	
	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnAtras = new JButton("Atras");
	
	private JPanel panelBtns = new JPanel();
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color (138, 153, 173);
	
	public PanelConfirm() {
		setLayout(new BorderLayout(10,10));
		setPreferredSize(new Dimension (600, 600));
		lblTitulo.setBorder(new EmptyBorder (10, 10, 10, 10));
		lblTitulo.setForeground(colorTitulo);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		txaResumen.setBorder(new EmptyBorder(10,30, 10, 30));
		txaResumen.setContentType("text/html");
		txaResumen.setEditable(false);
		txaResumen.setBackground(fondo);
		
		panelBtns.setBackground(fondo);
		btnAtras.setForeground(colorTitulo);
		btnAtras.setBackground(colorBoton);
		panelBtns.add(btnAtras);
		btnAceptar.setForeground(colorTitulo);
		btnAceptar.setBackground(colorBoton);
		panelBtns.add(btnAceptar);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20,5));
		
		add(txaResumen, BorderLayout.CENTER);
		add(panelBtns, BorderLayout.SOUTH);
	}
	
	public JEditorPane getResumen() {
		return this.txaResumen;
	}
	
	public JButton getBtnAtras() {
		return this.btnAtras;
	}
	public JButton getBtnAceptar() {
		return this.btnAceptar;
	}
}
