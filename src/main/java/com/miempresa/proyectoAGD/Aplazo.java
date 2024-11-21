package com.miempresa.proyectoAGD;

import java.util.Date;

public class Aplazo {
	private boolean tieneCursar;
	private Date fecha;
	private double notaNumerica;
	public Aplazo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aplazo(boolean tieneCursar, Date fecha, double notaNumerica) {
		super();
		this.tieneCursar = tieneCursar;
		this.fecha = fecha;
		this.notaNumerica = notaNumerica;
	}
	public boolean isTieneCursar() {
		return tieneCursar;
	}
	public void setTieneCursar(boolean tieneCursar) {
		this.tieneCursar = tieneCursar;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getNotaNumerica() {
		return notaNumerica;
	}
	public void setNotaNumerica(double notaNumerica) {
		this.notaNumerica = notaNumerica;
	}

	
}
