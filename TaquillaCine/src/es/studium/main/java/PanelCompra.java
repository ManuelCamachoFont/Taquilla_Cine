package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel de compra en el que el usuario puede seleccionar diferentes opciones e introducir sus datos para realizar la compra de una entrada a el evento.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class PanelCompra extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitulo = new JLabel("Selección de entradas", JLabel.CENTER);
	private JLabel lblEvento = new JLabel("Película");
	private JComboBox<String> choEventos = new JComboBox<>();
	private JLabel lblNombre = new JLabel("Nombre");
	private JTextField txtNombre = new JTextField(20);
	private JLabel lblApellido = new JLabel("Apellido");
	private JTextField txtApellido = new JTextField(20);
	private JLabel lblEmail = new JLabel ("Email");
	private JTextField txtEmail = new JTextField(20);
	private JComboBox<String>choTipoAsiento = new JComboBox<String>();
	private JLabel lblAsientos = new JLabel ("Cantidad");
	private JTextField txtAsientos = new JTextField(4);
	private JButton btnAceptar = new JButton("Comprar");
	private JButton btnAtras = new JButton("Atrás");
	private JButton btnLimpiar = new JButton("Limpiar");
	
	private JPanel panelTxtFields = new JPanel();
	private JPanel panelBtns = new JPanel();
	
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private Color fondo = new Color(11,15, 25);
	private Color colorBoton = new Color(22, 27, 38);
	private Color colorTitulo = new Color(0, 229, 255);
	private Color colorTxt = new Color (138, 153, 173);
	private Color blanco = Color.WHITE;
	private Color colorError = new Color(255, 230, 230);
	
	
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
	
	/**
	 * Actualiza el JComboBox con la cartelera actual.
	 * 
	 * @param cartelera Listado con todas las películas disponibles.
	 */
	public void poblarPeliculas(List<Pelicula> cartelera) {
	    choEventos.removeAllItems();
	    choEventos.addItem("Selecciona una película...");
	    for (Pelicula p : cartelera) {
	        choEventos.addItem(p.getTitulo());
	    }
	}
	
	/**
	 * Actualiza el JComboBox con los asientos existentes.
	 * 
	 * @param asientos Listado con todos los tipos de asiento disponibles.
	 */
	public void poblarAsientos(List<Ticket> asientos) {
	    choTipoAsiento.removeAllItems();
	    choTipoAsiento.addItem("Tipo de asiento..."); 
	    for (Ticket t : asientos) {
	        choTipoAsiento.addItem(t.getTipo());
	    }
	}

	
	// Getters Elementos
	
	public JComboBox<String> getChoEventos() { return this.choEventos; }
	
	public JComboBox<String> getChoTipoAsiento() { return this.choTipoAsiento; }
	
	public JTextField getTxtNombre() {	return this.txtNombre;}
	
	public JTextField getTxtApellido() {return this.txtApellido;}
	
	public JTextField getTxtEmail() {return this.txtEmail; }
	
	public JTextField getTxtAsiento() {	return this.txtAsientos; }	
	
	public JButton getBtnAceptar() { return this.btnAceptar; }
	
	public JButton getBtnAtras() {return this.btnAtras;	}
	
	public JButton getBtnLimpiar() {return this.btnLimpiar;	}
	
	
	// Getters Valores
	
	public String getNombreCompleto() { return txtNombre.getText().trim() + " " + txtApellido.getText().trim(); }
	
	public String getEmail() { return txtEmail.getText().trim(); }
	
	public String getPelicula() { return (String) choEventos.getSelectedItem(); }
	
	public String getAsiento() { return (String) choTipoAsiento.getSelectedItem(); }
	
	public int getCantidad() { return Integer.parseInt(txtAsientos.getText().trim()); }
	
	
	
	/**
	 * Reinicia todos los campos dejando los JTextField en blanco y los JComboBox en la opción predeterminada.
	 */
	public void limpiarCampos() {
	    choEventos.setSelectedIndex(0);
	    txtNombre.setText("");
	    txtApellido.setText("");
	    txtEmail.setText("");
	    txtAsientos.setText("");
	    choTipoAsiento.setSelectedIndex(0);
	}

	/**
	 * Reinicia el color de fondo de todos los campos.
	 */
	public void reinicioVisualCampos() {
	    choEventos.setBackground(blanco);
	    txtNombre.setBackground(blanco);
	    txtApellido.setBackground(blanco);
	    txtEmail.setBackground(blanco);
	    txtAsientos.setBackground(blanco);
	    choTipoAsiento.setBackground(blanco);
	}

	/**
	 * Procedimiento para verificar que la información y selección de todos los campos cumplen con los requerimientos de la aplicación. Que no estén vacíos y admitan el dato correspondiente.
	 * 
	 * @return Devuelve un booleano, true si pasa la validación, o false si no.
	 */
	public boolean validarCampos() {
	    reinicioVisualCampos();

	    if (choEventos.getSelectedIndex() == 0) {
	        marcarErrorCampo(choEventos, "Seleccione una película por favor", "Película - Inválido");
	        return false;
	    }
	    if (txtNombre.getText().trim().isEmpty()) {
	        marcarErrorCampo(txtNombre, "Rellene todos los campos por favor", "Nombre - Inválido");
	        return false;
	    }
	    // Patron Regex para nombres
	    if (!txtNombre.getText().matches("^[\\p{L} .'-]+$")) {
	        marcarErrorCampo(txtNombre, "Introduzca caracteres válidos para el nombre", "Nombre - Inválido");
	        return false;
	    }
	    if (txtApellido.getText().trim().isEmpty()) {
	        marcarErrorCampo(txtApellido, "Rellene todos los campos por favor", "Apellido - Inválido");
	        return false;
	    }
	    if (!txtApellido.getText().matches("^[\\p{L} .'-]+$")) {
	        marcarErrorCampo(txtApellido, "Introduzca caracteres válidos para el apellido", "Apellido - Inválido");
	        return false;
	    }
	    if (txtEmail.getText().trim().isEmpty()) {
	        marcarErrorCampo(txtEmail, "Rellene todos los campos por favor", "Email - Inválido");
	        return false;
	    }
	    // Patron Regex para email
	    if (!txtEmail.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
	        marcarErrorCampo(txtEmail, "El correo debe tener un formato válido, por ejemplo: usuario@dominio.com", "Email - Inválido");
	        return false;
	    }
	    
	    try {
	        int cantidad = Integer.parseInt(txtAsientos.getText().trim());
	        if (cantidad <= 0) {
	        	marcarErrorCampo(txtAsientos, "Debe comprar al menos 1 entrada", "Cantidad - Inválido");
		        return false;
	        }
	        if (cantidad > 10) {
	        	marcarErrorCampo(txtAsientos, "No se permite adquirir más de 10 tickets por compra", "Cantidad - Inválido");
		        return false;
	        }
	    } catch (NumberFormatException e) {
	        marcarErrorCampo(txtAsientos, "Introduce un valor numérico, por ejemplo: 2", "Cantidad - Inválido");
	        return false;
	    }
	   

	    if (choTipoAsiento.getSelectedIndex() == 0) {
	        marcarErrorCampo(choTipoAsiento, "Seleccione una butaca por favor", "Butaca - Inválido");
	        return false;
	    }

	    return true;
	}

	/**
	 * Procedimiento que muestra que campo no ha cumplido la verificación llamando al diálogo de la clase ControlErrores.java
	 * 
	 * @param elemento Componente en el cuál se ha producido el error
	 * @param mensajeError Mensaje personalizado que recibe para especificar el error
	 * @param tituloDialogo Título que va a mostrar en el diálogo para el error
	 */
	private void marcarErrorCampo(JComponent elemento, String mensajeError, String tituloDialogo) {
	    elemento.setBackground(colorError);
	    elemento.requestFocus();
	    ControlErrores.mostrarError(this, mensajeError, tituloDialogo, 2);
	}

	
	
}
