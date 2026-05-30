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

/**
 * Panel en el que se muestra la información de todos los eventos, la cartelera con las películas disponibles
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class PanelEventos extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo = new JLabel("Eventos actuales", JLabel.CENTER);
	private JEditorPane txaInfoEventos = new JEditorPane();
	private JPanel panelBtns = new JPanel();
	
	private JButton btnAtras = new JButton("Atrás");

	private JScrollPane scroll = new JScrollPane(txaInfoEventos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	
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
	
	/**
	 * Reinicia la información de los eventos
	 */
	public void limpiarInfo() {
        txaInfoEventos.setText("");
    }
	
	/**
	 * Procedimiento para rellenar el panel con la información de los eventos y establecer el scroll en la parte superior
	 * 
	 * @param htmlCompleto HTML creado en la clase GeneradorHTML que recibe para aplicarlo a la vista y mostrar la cartelera
	 */
    public void cargarContenidoHtml(String htmlCompleto) {
        txaInfoEventos.setText(htmlCompleto);
        txaInfoEventos.setCaretPosition(0);
    }
	
}
