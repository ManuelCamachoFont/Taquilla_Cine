package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCompra extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//String[] opcionesDePrueba = {"Selecciona una opción...", "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5", };
	//String[] TestingTipoAsiento = {"Selecciona el tipo de asiento...","Butaca - 7,50€", "Butaca Premium - 10,50€", "Palco - 15,50€"};
	private JLabel lblTitulo = new JLabel("Selección de entradas", JLabel.CENTER);
	private JComboBox<String> choEventos = new JComboBox<>();
	private JTextField txtNombre = new JTextField(30);
	private JTextField txtApellido = new JTextField(30);
	private JTextField txtEmail = new JTextField(30);
	private JTextField txtAsientos = new JTextField(15);
	private JComboBox<String>choTipoAsiento = new JComboBox<String>();
	private JButton btnAceptar = new JButton("Comprar");
	private JButton btnAtras = new JButton("Atrás");
	private JButton btnLimpiar = new JButton("Limpiar");
	
	private JPanel panelTxtFields = new JPanel();
	private JPanel panelBtns = new JPanel();
	
	
	
	public PanelCompra() {
		setLayout(new BorderLayout(10, 10));
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.NORTH);
		
		panelTxtFields.setLayout(new FlowLayout(FlowLayout.CENTER, 20,5));
		panelTxtFields.add(choEventos);
		panelTxtFields.add(txtNombre);
		panelTxtFields.add(txtApellido);
		panelTxtFields.add(txtEmail);
		panelTxtFields.add(txtAsientos);
		panelTxtFields.add(choTipoAsiento);
		
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
	    panelBtns.add(btnAtras);
	    panelBtns.add(btnAceptar);
	    panelBtns.add(btnLimpiar);
	    
	    add(panelTxtFields, BorderLayout.CENTER);
	    add(panelBtns, BorderLayout.SOUTH);
	    
	    
	}

	public JComboBox<String> getChoEventos() {
		return this.choEventos;
	}
	public JTextField getTxtNombre() {
		return this.txtNombre;
	}
	public JTextField getTxtApellido() {
		return this.txtApellido;
	}
	public JTextField getTxtEmail() {
		return this.txtEmail;
	}
	public JTextField getTxtAsiento() {
		return this.txtAsientos;
	}
	public JComboBox<String> getChoTipoAsiento() {
		return this.choTipoAsiento;
	}
	public JButton getBtnAceptar() {
		return this.btnAceptar;
	}
	public JButton getBtnAtras() {
		return this.btnAtras;
	}
	public JButton getBtnLimpiar() {
		return this.btnLimpiar;
	}
}
