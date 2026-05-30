package es.studium.main.java;

/**
 * Clase Principal que ejecuta el programa en modelo - vista - controlador
 * 
 * @author Manuel Camacho Font
 * @author José Leopoldo Ruiz Moreno
 * @version 1.0
 */
public class Principal {

	public static void main(String[] args) {
			Modelo modelo = new Modelo();
			Vista vista = new Vista();
			new Controlador(modelo, vista);
	}
}
