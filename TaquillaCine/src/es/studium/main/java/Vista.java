package es.studium.main.java;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista {

    private JFrame ventana = new JFrame("CineLema");
    private CardLayout paneles = new CardLayout();
    private JPanel panelPrincipal = new JPanel(paneles);
    
    private PanelHome panelHome = new PanelHome();
    private PanelEventos panelEventos = new PanelEventos();
    private PanelCompra panelCompra = new PanelCompra();
    private PanelConfirm panelConfirm = new PanelConfirm();
    private PanelFin panelFin = new PanelFin();
 
    private Image icono = new javax.swing.ImageIcon(Vista.class.getResource("/es/studium/main/resources/ico/icononeon.png")).getImage();
    
    private Color fondo = new Color(11,15, 25);
    

    public Vista(){
        ventana.setSize(1182,665);
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(icono);
        //Fuck AWT... con esto se cierra la ventana... WHAT!
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
    public void mostrarPanel(String nombre) {
    	paneles.show(panelPrincipal, nombre);
    }
    public void panelAnterior() {
    	paneles.previous(panelPrincipal);
    }
    public PanelHome getPanelHome() {
        return panelHome;
    }
    public PanelEventos getPanelEventos() {
    	return panelEventos;
    }
    public PanelCompra getPanelCompra() {
    	return panelCompra;
    }
    public PanelConfirm getPanelConfirm() {
    	return panelConfirm;
    }
    public PanelFin getPanelFin() {
    	return panelFin;
    }
    
    public JFrame getVentana() {
    	return ventana;
    }
}

