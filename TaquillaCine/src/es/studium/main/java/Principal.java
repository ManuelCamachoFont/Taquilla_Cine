package es.studium.main.java;

public class Principal {

	public static void main(String[] args) {
			Modelo modelo = new Modelo();
			Vista vista = new Vista();
			new Controlador(modelo, vista);
		//System.out.println("Resultado de pelis: " + new Modelo().getDaoPelicula().obtenerPeliculas());
	}
}
