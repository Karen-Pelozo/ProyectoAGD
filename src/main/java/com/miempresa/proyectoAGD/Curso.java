package com.miempresa.proyectoAGD;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Curso {
	@Id
	private Integer idCurso;
	@Column
	private String nomenclatura;
	@Column
	private String materiaCurso;
	@Column
	private List<EnumDias> diasHabiles;
	private List<String> tareasCurso;
	@Column
	@Temporal(TemporalType.TIME)
	private LocalTime horario;
	@OneToMany
	@JoinColumn
	private LinkedList<Alumno> alumnos;
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Curso(Integer idCurso, String nomenclatura, String materiaCurso, List<EnumDias> diasHabiles,
			List<String> tareasCurso, LocalTime horario, LinkedList<Alumno> alumnos) {
		super();
		this.idCurso = idCurso;
		this.nomenclatura = nomenclatura;
		this.materiaCurso = materiaCurso;
		this.diasHabiles = diasHabiles;
		this.tareasCurso = tareasCurso;
		this.horario = horario;
		this.alumnos = alumnos;
	}

	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idClase) {
		this.idCurso = idClase;
	}
	public String getNomenclatura() {
		return nomenclatura;
	}
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
	public String getMateriaCurso() {
		return materiaCurso;
	}
	public void setMateriaCurso(String materiaCurso) {
		this.materiaCurso = materiaCurso;
	}
	public List<EnumDias> getDiasHabiles() {
		return diasHabiles;
	}
	public void setDiasHabiles(List<EnumDias> diasHabiles) {
		this.diasHabiles = diasHabiles;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public LinkedList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(LinkedList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<String> getTareasCurso() {
		return tareasCurso;
	}

	public void setTareasCurso(List<String> tareasCurso) {
		this.tareasCurso = tareasCurso;
	}
	
}
