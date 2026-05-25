package es.studium.main.java;

import javax.swing.*;
import java.awt.*;

public class Vista {

    JFrame ventana = new JFrame("Kiosko de cine");
    JPanel panelPrincipal = new JPanel();
    JPanel panelEventos = new JPanel();
    JPanel panelCompra = new JPanel();
    JPanel panelSeleccion = new JPanel();

    public Vista(){
        ventana.setSize(500,300);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana. setVisible(true);
    }
}
