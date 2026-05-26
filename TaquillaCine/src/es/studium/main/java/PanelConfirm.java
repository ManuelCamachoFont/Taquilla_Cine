package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConfirm extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo = new JLabel("Resumen de compra", JLabel.CENTER);
	
	private JLabel lblInfoEvento = new JLabel();
	private JLabel lblNombreCompleto = new JLabel();
	private JLabel lblInfoAsiento = new JLabel();
	private JLabel lblPrecioTotal = new JLabel();
	
	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnAtras = new JButton("Atras");
	
	private JPanel panelInfo = new JPanel();
	private JPanel panelBtns = new JPanel();
	
	public PanelConfirm() {
		setLayout(new BorderLayout(10,10));
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		/*SET TEXTS DE EJEMPLO*/
		
		lblInfoEvento.setText("Información completa del evento");
		lblNombreCompleto.setText("Información completa del comprador");
		lblInfoAsiento.setText("Información completa del asiento");
		lblPrecioTotal.setText("Información de todo el precio... caro, es muy caro");
		
		panelInfo.add(lblInfoEvento);
		panelInfo.add(lblNombreCompleto);
		panelInfo.add(lblInfoAsiento);
		panelInfo.add(lblPrecioTotal);
		panelInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 20,5));
		
		panelBtns.add(btnAtras);
		panelBtns.add(btnAceptar);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20,5));
		
		add(panelInfo, BorderLayout.CENTER);
		add(panelBtns, BorderLayout.SOUTH);
	}
	
	public JLabel getInfoEvento() {
		return this.lblInfoEvento;
	}
	public JLabel getNombreCompleto() {
		return this.lblNombreCompleto;
	}
	public JLabel getInfoAsiento() {
		return this.lblInfoAsiento;
	}
	public JLabel getPrecioTotal() {
		return this.lblPrecioTotal;
	}
	public JButton getBtnAtras() {
		return this.btnAtras;
	}
	public JButton getBtnAceptar() {
		return this.btnAceptar;
	}
}
