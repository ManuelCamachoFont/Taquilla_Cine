package es.studium.main.java;

/**
 * Clase objeto Ticket para gestionar los Tickets en la aplicación.
 * 
 * @author Manuel Camacho Font
 * @author José Luis Ruiz Moreno
 * @version 1.0
 */
public class Ticket
{

	private int id;
	private String tipo;
	private float precio;

	public Ticket(int id, String tipo, float precio)
	{
		this.id = id;
		this.tipo = tipo;
		this.precio = precio;
	}

	public int getId()
	{
		return id;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public float getPrecio()
	{
		return precio;
	}

	public void setPrecio(float precio)
	{
		this.precio = precio;
	}

	/**
	 * Simplifica un objeto Ticket en su tipo y precio para el manejo y la visualización del objeto.
	 */
	@Override
	public String toString()
	{
		return this.tipo + " (" + this.precio + "€)";
	}
}
