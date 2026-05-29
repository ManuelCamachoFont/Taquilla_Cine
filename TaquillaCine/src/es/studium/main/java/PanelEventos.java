package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelEventos extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo = new JLabel("Todos los eventos", JLabel.CENTER);
	private JEditorPane txaInfoEventos = new JEditorPane();
	private JPanel panelBtns = new JPanel();
	
	private JButton btnAtras = new JButton("Atrás");

	private JScrollPane scroll = new JScrollPane(txaInfoEventos);
	
	public PanelEventos() {
		setLayout(new BorderLayout(10,10));
		
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		txaInfoEventos.setContentType("text/html");
		txaInfoEventos.setEditable(false);
		add(scroll, BorderLayout.CENTER);

		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
	    panelBtns.add(btnAtras);
	    
	    add(panelBtns, BorderLayout.SOUTH);
		
	}
	
	public JButton getBtnAtras() {
		return this.btnAtras;
	}
	public JEditorPane getInfoEventos() {
		return this.txaInfoEventos;
	}
}
