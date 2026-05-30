package es.studium.main.java;

/**
 * Clase objeto Película para gestionar las películas en la aplicación.
 * 
 * @author Manuel Camacho Font
 * @author José Luis Ruiz Moreno
 * @version 1.0
 */
public class Pelicula
{

	private int id;
	private String titulo;
	private int duracion;
	private String sinopsis;
	private String imagen;

	public Pelicula(int id, String titulo, int duracion, String sinopsis, String imagen)
	{
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuracion(int duracion)
	{
		this.duracion = duracion;
	}

	public String getSinopsis()
	{
		return sinopsis;
	}
	
	public void setRutaImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getRutaImagen() {
		return imagen;
	}

	public void setSinopsis(String sinopsis)
	{
		this.sinopsis = sinopsis;
	}

	
	/**
	 * Simplifica un objeto Película en su Título para el manejo y la visualización del objeto.
	 */
	@Override
	public String toString()
	{
		return this.titulo;
	}
}
