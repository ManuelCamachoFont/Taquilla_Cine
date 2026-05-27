package es.studium.main.java;

public class Ticket {

	private int id;
	private String tipo;
	private float precio;
	
	public Ticket(int id, String tipo, float precio) {
		this.id = id;
		this.tipo = tipo;
		this.precio= precio;
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
	
	@Override
    public String toString() {
        return this.tipo + " (" + this.precio + "€)";
    }
}
