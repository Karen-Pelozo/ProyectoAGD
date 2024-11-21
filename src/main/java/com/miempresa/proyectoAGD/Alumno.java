package com.miempresa.proyectoAGD;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class Alumno extends User{
	@Column
	private List<Asistencia> asistencias;
	@Column
	private List<Nota> notas;
	@Column
	private List<Amonestacion> amonestaciones;
	@Column
	private Double [] cuatrimestres;
	@Column
	private Double [] trimestres;
	@Column	
	private List<Aplazo> aplazos;
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumno(Integer idDNI, String nombre, String apellido, Byte password, TipoUsuario tipoUsuario, List<Asistencia> asistencias, List<Nota> notas, List<Amonestacion> amonestaciones,
			Double[] cuatrimestres, Double[] trimestres, List<Aplazo> aplazos) {
		super(idDNI, nombre, apellido, password, tipoUsuario);
		this.asistencias = asistencias;
		this.notas = notas;
		this.amonestaciones = amonestaciones;
		this.cuatrimestres = cuatrimestres;
		this.trimestres = trimestres;
		this.aplazos = aplazos;
	}
	public List<Asistencia> getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public List<Amonestacion> getAmonestaciones() {
		return amonestaciones;
	}
	public void setAmonestaciones(List<Amonestacion> amonestaciones) {
		this.amonestaciones = amonestaciones;
	}
	public Double[] getCuatrimestres() {
		return cuatrimestres;
	}
	public void setCuatrimestres(Double[] cuatrimestres) {
		this.cuatrimestres = cuatrimestres;
	}
	public Double[] getTrimestres() {
		return trimestres;
	}
	public void setTrimestres(Double[] trimestres) {
		this.trimestres = trimestres;
	}
	public List<Aplazo> getAplazos() {
		return aplazos;
	}
	public void setAplazos(List<Aplazo> aplazos) {
		this.aplazos = aplazos;
	}
	
		
}
