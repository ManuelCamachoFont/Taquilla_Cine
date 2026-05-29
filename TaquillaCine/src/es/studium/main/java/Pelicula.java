package es.studium.main.java;

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

	@Override
	public String toString()
	{
		return this.titulo;
	}
}
