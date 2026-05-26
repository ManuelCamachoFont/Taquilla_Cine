package es.studium.main.java;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista {

    private JFrame ventana = new JFrame("Kiosko de cine");
    private CardLayout paneles = new CardLayout();
    private JPanel panelPrincipal = new JPanel(paneles);
    
    private PanelHome panelHome = new PanelHome();
    private PanelEventos panelEventos = new PanelEventos();
    private PanelCompra panelCompra = new PanelCompra();
    private PanelConfirm panelConfirm = new PanelConfirm();
    private PanelFin panelFin = new PanelFin();
    

    public Vista(){
        ventana.setSize(500,300);
        ventana.setLocationRelativeTo(null);
        //Fuck AWT... con esto se cierra la ventana... WHAT!
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ventana.setResizable(false);
        //me cago en la leche, hay que tener mil ojos con el add <-- está pasando por parámetro el nombre del panel. 
        panelPrincipal.add(panelHome,"HOME");
        panelPrincipal.add(panelCompra,"COMPRA");
        panelPrincipal.add(panelConfirm, "RESUMEN");
        panelPrincipal.add(panelEventos,"INFO");
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
}

