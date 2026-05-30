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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PanelEventos extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo = new JLabel("Eventos actuales", JLabel.CENTER);
	private JEditorPane txaInfoEventos = new JEditorPane();
	private JPanel panelBtns = new JPanel();
	
	private JButton btnAtras = new JButton("Atrás");

	private JScrollPane scroll = new JScrollPane(txaInfoEventos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color (138, 153, 173);
	
	public PanelEventos() {
		setLayout(new BorderLayout(10,10));
		setPreferredSize(new Dimension (740, 800));
		lblTitulo.setForeground(colorTitulo);
		lblTitulo.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		txaInfoEventos.setBackground(fondo);
		txaInfoEventos.setContentType("text/html");
		txaInfoEventos.setEditable(false);
		add(scroll, BorderLayout.CENTER);

		btnAtras.setForeground(colorTitulo);
		btnAtras.setBackground(colorBoton);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		
		panelBtns.setBackground(fondo);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
	    panelBtns.add(btnAtras);
	    
	    add(panelBtns, BorderLayout.SOUTH);
		
	}
	
	public JButton getBtnAtras() { return this.btnAtras; }
	
	public JEditorPane getInfoEventos() { return this.txaInfoEventos; }
	
	
	public void limpiarInfo() {
        txaInfoEventos.setText("");
    }
    public void cargarContenidoHtml(String htmlCompleto) {
        txaInfoEventos.setText(htmlCompleto);
        txaInfoEventos.setCaretPosition(0);
    }
	
}
