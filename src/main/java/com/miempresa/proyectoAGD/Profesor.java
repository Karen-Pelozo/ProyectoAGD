package com.miempresa.proyectoAGD;

import java.util.LinkedList;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Profesor extends User{ 
	@OneToMany
	@JoinColumn
	private LinkedList<Curso> cursos;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profesor(Integer idDNI, String nombre, String apellido, Byte password, TipoUsuario tipoUsuario,
			LinkedList<Curso> cursos) {
		super(idDNI, nombre, apellido, password, tipoUsuario);
		this.cursos= cursos;
	}

	public LinkedList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(LinkedList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
