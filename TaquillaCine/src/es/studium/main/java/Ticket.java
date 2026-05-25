package es.studium.main.java;

public class Ticket {

	private int id;
	private String tipo;
	private float precio;
	private Pelicula pelicula;
	
	public Ticket(int id, String tipo, float precio, Pelicula pelicula) {
		this.id = id;
		this.tipo = tipo;
		this.precio= precio;
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	@Override
    public String toString() {
        return this.tipo + " (" + this.precio + "€)";
    }
}
