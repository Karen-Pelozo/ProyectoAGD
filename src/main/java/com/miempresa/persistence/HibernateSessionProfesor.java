package com.miempresa.persistence;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.miempresa.proyectoAGD.Profesor;
import com.miempresa.proyectoAGD.User;

public class HibernateSessionProfesor {
	SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();

	//LISTAR TODOS LOS PROFESORES
	public void addProfesor(Profesor profesor) {
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			session.persist(profesor);
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
	//ELIMINAR UN PROFESOR
	public void deleteProfesor(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = session.get(Profesor.class, id);
			session.remove(user);
			
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
	//MODIFICAR UN PROFESOR
	@SuppressWarnings("deprecation")
	public void updateProfesor(Profesor profesor) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(profesor);
							
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
	//BUSCAR UN PROFESOR Y RETORNARLO
	public Profesor getProfesor(Integer id) {
		Session session = sessionFactory.openSession();
		Profesor profesor= new Profesor();
		try {
			session.beginTransaction();
			 profesor = session.get(Profesor.class, id);
			 				
		}catch(Exception a) {
			if(session.getTransaction()!=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw a;
		}finally {
			session.close();
			sessionFactory.close();
		}
		return profesor;
	}
	//AGREGAR PROFESOR
	public LinkedList<Profesor> getAllProfesores() {
		Session session = sessionFactory.openSession();
		LinkedList<Profesor> profesores ;
		try {
			session.beginTransaction();
			profesores = (LinkedList<Profesor>) session.createQuery("SELECT * FROM Profesor",Profesor.class).list();
			 return profesores;
			
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
}
