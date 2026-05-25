package es.studium.main.java;

import java.time.LocalDate;

public class Venta {

	private int id;
	private LocalDate fecha;
	private int cantidad;
	private float total;
	private Ticket ticket;
	
	public Venta(int id, LocalDate fecha, int cantidad, float total, Ticket ticket) {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
