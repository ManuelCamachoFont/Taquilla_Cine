package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCompra extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	String[] eventos = {"Selecciona una opción..."};
	String[] tipoAsiento = {"Tipo de asiento..."};
	private JLabel lblTitulo = new JLabel("Selección de entradas", JLabel.CENTER);
	private JLabel lblEvento = new JLabel("Película");
	private JComboBox<String> choEventos = new JComboBox<>(eventos);
	private JLabel lblNombre = new JLabel("Nombre");
	private JTextField txtNombre = new JTextField(20);
	private JLabel lblApellido = new JLabel("Apellido");
	private JTextField txtApellido = new JTextField(20);
	private JLabel lblEmail = new JLabel ("Email");
	private JTextField txtEmail = new JTextField(20);
	private JComboBox<String>choTipoAsiento = new JComboBox<String>(tipoAsiento);
	private JLabel lblAsientos = new JLabel ("Cantidad");
	private JTextField txtAsientos = new JTextField(4);
	private JButton btnAceptar = new JButton("Comprar");
	private JButton btnAtras = new JButton("Atrás");
	private JButton btnLimpiar = new JButton("Limpiar");
	
	private JPanel panelTxtFields = new JPanel();
	private JPanel panelBtns = new JPanel();
	
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color (138, 153, 173);
	
	
	public PanelCompra() {
		setLayout(new BorderLayout(10, 10));
		
		lblTitulo.setForeground(colorTitulo);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		add(lblTitulo, BorderLayout.NORTH);
		
		panelTxtFields.setBackground(fondo);
		panelTxtFields.setLayout(gridbag);
		gbc.insets = new Insets (5, 5, 5,5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		lblEvento.setForeground(colorTxt);
		panelTxtFields.add(lblEvento, gbc);
		
		gbc.gridx = 1;
		
		panelTxtFields.add(choEventos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lblNombre.setForeground(colorTxt);
		panelTxtFields.add(lblNombre, gbc);
		gbc.gridx = 1;
		panelTxtFields.add(txtNombre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lblApellido.setForeground(colorTxt);
		panelTxtFields.add(lblApellido, gbc);
		gbc.gridx = 1;
		panelTxtFields.add(txtApellido, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 3;
		lblEmail.setForeground(colorTxt);
		panelTxtFields.add(lblEmail, gbc);
		gbc.gridx = 1;
		panelTxtFields.add(txtEmail, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets.set(10, 30, 10, 10);;
		panelTxtFields.add(choTipoAsiento, gbc);
		
		gbc.gridx = 1;
		gbc.insets.set(10, 0, 10, 100);
		lblAsientos.setForeground(colorTxt);
		panelTxtFields.add(lblAsientos, gbc);
		gbc.insets.set(10, 20, 10, 10);
		panelTxtFields.add(txtAsientos, gbc);
		
		panelBtns.setBackground(fondo);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		btnAtras.setForeground(colorTitulo);
		btnAtras.setBackground(colorBoton);
	    panelBtns.add(btnAtras);
	    btnAceptar.setForeground(colorTitulo);
		btnAceptar.setBackground(colorBoton);
	    panelBtns.add(btnAceptar);
	    btnLimpiar.setForeground(colorTitulo);
		btnLimpiar.setBackground(colorBoton);
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
