package com.miempresa.proyectoAGD;

import java.util.Date;

public class Asistencia {
	private Date fecha;
	private EnumAsistencia descripcionAsistencia;
	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asistencia(Date fecha, EnumAsistencia descripcionAsistencia) {
		super();
		this.fecha = fecha;
		this.descripcionAsistencia = descripcionAsistencia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EnumAsistencia getDescripcionAsistencia() {
		return descripcionAsistencia;
	}
	public void setDescripcionAsistencia(EnumAsistencia descripcionAsistencia) {
		this.descripcionAsistencia = descripcionAsistencia;
	}
	
	
}
