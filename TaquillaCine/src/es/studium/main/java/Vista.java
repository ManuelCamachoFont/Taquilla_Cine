package es.studium.main.java;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase principal de la Vista que actúa como contenedor de la interfaz gráfica.
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 */
public class Vista {

    private JFrame ventana = new JFrame("CineLema");
    private CardLayout paneles = new CardLayout();
    private JPanel panelPrincipal = new JPanel(paneles);
    
    private PanelHome panelHome = new PanelHome();
    private PanelEventos panelEventos = new PanelEventos();
    private PanelCompra panelCompra = new PanelCompra();
    private PanelConfirm panelConfirm = new PanelConfirm();
    private PanelFin panelFin = new PanelFin();
 
    private Image icono = new ImageIcon(Vista.class.getResource("/es/studium/main/resources/ico/icononeon.png")).getImage();
    
    private Color fondo = new Color(11,15, 25);
    

    public Vista(){
        ventana.setSize(1182,665);
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(icono);

        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        ventana.setResizable(false);
        panelHome.setBackground(fondo);
        panelPrincipal.add(panelHome,"HOME");
        panelCompra.setBackground(fondo);
        panelPrincipal.add(panelCompra,"COMPRA");
        panelConfirm.setBackground(fondo);
        panelPrincipal.add(panelConfirm, "RESUMEN");
        panelEventos.setBackground(fondo);
        panelPrincipal.add(panelEventos,"INFO");
        panelFin.setBackground(fondo);
        panelPrincipal.add(panelFin, "FIN");
        
        ventana.add(panelPrincipal);
        
        mostrarPanel("HOME");
        
        ventana.setVisible(true);
       
    }
    
    /**
     * Cambia de panel en el CardLayout y muestra el panel seleccionado
     * @param nombre Nombre del panel al que se quiere cambiar
     */
    public void mostrarPanel(String nombre) {
    	paneles.show(panelPrincipal, nombre);
    }
    
    
    // Getters de paneles
    
    public PanelHome getPanelHome() { return panelHome; }
    
    public PanelEventos getPanelEventos() { return panelEventos; }
    
    public PanelCompra getPanelCompra() { return panelCompra; }
    
    public PanelConfirm getPanelConfirm() {	return panelConfirm; }
    
    public PanelFin getPanelFin() { return panelFin; }
    
    public JFrame getVentana() { return ventana; }    
    
    
    /**
     * Muestra y redimensiona PanelHome
     */
    public void cargarPanelHome() {
        mostrarPanel("HOME");
        getVentana().setSize(1182, 665);
        getVentana().setLocationRelativeTo(null);
    }
    
    /**
     * Muestra y redimensiona PanelEventos
     */
    public void cargarPanelEventos() {
        getVentana().setVisible(false);
        mostrarPanel("INFO");
        getVentana().setSize(740, 800);
        getVentana().setLocationRelativeTo(null);
        getPanelEventos().getInfoEventos().setCaretPosition(0);
        getVentana().setVisible(true);
    }
    
    /**
     * Muestra y redimensiona PanelCompra
     */
    public void cargarPanelCompra() {
        mostrarPanel("COMPRA");
        getVentana().setSize(500, 300);
        getVentana().setLocationRelativeTo(null);
    }
    
    /**
     * Muestra y redimensiona PanelConfirm
     */
    public void cargarPanelConfirmar() {
        mostrarPanel("RESUMEN");
        getVentana().setSize(600, 600);
        getVentana().setLocationRelativeTo(null);
    }
    
    /**
     * Muestra y redimensiona PanelFin
     */
    public void cargarPanelFin() {
        mostrarPanel("FIN");
        getVentana().setSize(500, 300);
        getVentana().setLocationRelativeTo(null);
    }
    
 
}

