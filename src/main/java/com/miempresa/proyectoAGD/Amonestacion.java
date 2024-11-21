package com.miempresa.proyectoAGD;

public class Amonestacion {
	
	private Integer idAmonestacion;
	private String fecha;
	private String descripcion;
	private int contador;
	public Amonestacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Amonestacion(Integer idAmonestacion, String fecha, String descripcion, int contador) {
		super();
		this.idAmonestacion = idAmonestacion;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.contador = contador;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}

	public Integer getIdAmonestacion() {
		return idAmonestacion;
	}

	public void setIdAmonestacion(Integer idAmonestacion) {
		this.idAmonestacion = idAmonestacion;
	}
	
	
}
