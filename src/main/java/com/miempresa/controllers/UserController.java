package com.miempresa.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.miempresa.persistence.HibernateSessionAlumno;
import com.miempresa.persistence.HibernateSessionProfesor;
import com.miempresa.persistence.HibernateSessionsUser;
import com.miempresa.proyectoAGD.Alumno;
import com.miempresa.proyectoAGD.Amonestacion;
import com.miempresa.proyectoAGD.Aplazo;
import com.miempresa.proyectoAGD.Asistencia;
import com.miempresa.proyectoAGD.Curso;
import com.miempresa.proyectoAGD.Nota;
import com.miempresa.proyectoAGD.Profesor;
import com.miempresa.proyectoAGD.TipoUsuario;
import com.miempresa.proyectoAGD.User;

public class UserController {
	HibernateSessionsUser sessionUser = new HibernateSessionsUser();
	public boolean existeUserControl(String id ) {
		User user= sessionUser.getUser(Integer.parseInt(id));
		return user!=null;
	}
	//BUSCAR EL USUARIO Y TRAERLO CON LOS ATRIBUTOS DEL TIPO QUE SON SI ES PROFESOR QUE TRAIGA LOS DATOS DEL PROFESOR  Y LOS CURSOS QUE LE PERTENECEN
	//COMO LOS DOS OBJETOS, PROFESOR Y ALUMNO HEREDAN DE USER EL OBJETO QUE RETORNARA ES DE TIPO USER
	//Integer idDNI, String nombre, String apellido, Byte password, TipoUsuario tipoUsuario,
	//LinkedList<Curso> cursos
	public void crearUsuarioTipo(Integer dni, String nombre,String apellido,Byte password,TipoUsuario tipo) {
		
		if (tipo.equals(TipoUsuario.PROFESOR))
		{	LinkedList<Curso> cursos = new LinkedList<>();
			HibernateSessionProfesor sessionProfesor = new HibernateSessionProfesor();
			Profesor prof = new Profesor(dni,nombre,apellido,password,tipo,cursos);
			sessionProfesor.addProfesor(prof);
		}
		else
		{//Integer idDNI, String nombre, String apellido, Byte password, TipoUsuario tipoUsuario, List<Asistencia> asistencias, List<Nota> notas, List<Amonestacion> amonestaciones,
			//Double[] cuatrimestres, Double[] trimestres, List<Aplazo> aplazos
			HibernateSessionAlumno sessionAlumno =  new HibernateSessionAlumno();
			 List<Asistencia> asistencias = new ArrayList<>();
			 List<Nota> notas =  new ArrayList<>();
			 List<Amonestacion> amonestaciones =  new ArrayList<>();
			 Double[] cuatrimestres = {};
			 Double[] trimestres = {};
			 List<Aplazo> aplazos = new ArrayList<>();
			Alumno alum = new Alumno(dni,nombre,apellido,password,tipo,asistencias,notas,amonestaciones,cuatrimestres,trimestres,aplazos);
			sessionAlumno.addAlumno(alum);
		}
	}
	
	public void darBajaUsuario(String id) {
		
	}
}
