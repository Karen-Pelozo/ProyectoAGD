package com.miempresa.proyectoAGD;

import java.util.Date;

public class Nota {
	private double notaNum;
	private Date fecha;
	private String descripcion;
	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nota(double notaNum, Date fecha, String descripcion) {
		super();
		this.notaNum = notaNum;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	public double getNotaNum() {
		return notaNum;
	}
	public void setNotaNum(double notaNum) {
		this.notaNum = notaNum;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
