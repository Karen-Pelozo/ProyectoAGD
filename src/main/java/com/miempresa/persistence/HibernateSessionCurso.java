package com.miempresa.persistence;

import java.util.LinkedList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.miempresa.proyectoAGD.Curso;

public class HibernateSessionCurso {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	//AGREGAR CURSO
	public void addCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			session.persist(curso);
			session.getTransaction().commit();
		
		}catch(Exception e) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw e;
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//LISTAR TODOS LOS CURSOS
	public LinkedList<Curso> getAllCurso() {
		Session session = sessionFactory.openSession();
		LinkedList<Curso> cursos ;
		try {
			session.beginTransaction();
			cursos = (LinkedList<Curso>) session.createQuery("SELECT * FROM Curso",Curso.class).list();
			 return cursos;
			
		}catch(Exception a) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw a;
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//ELIMINAR UN CURSO
	public void deleteCurso(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Curso curso = session.get(Curso.class, id);
			session.remove(curso);
			
		}catch(Exception a) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw a;
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//MODIFICAR UN CURSO
	@SuppressWarnings("deprecation")
	public void updateCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(curso);
							
		}catch(Exception a) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw a;
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//BUSCAR UN CURSO Y RETORNARLO
	public Curso getCurso(Integer id) {
		Session session = sessionFactory.openSession();
		Curso curso= new Curso();
		try {
			session.beginTransaction();
			 curso = session.get(Curso.class, id);
			 				
		}catch(Exception a) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw a;
		}finally {
			session.close();
			sessionFactory.close();
		}
		return curso;
	}
}
