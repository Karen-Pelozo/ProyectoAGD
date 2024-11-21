package com.miempresa.persistence;

import java.util.LinkedList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.miempresa.proyectoAGD.Alumno;

public class HibernateSessionAlumno {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory() ;
		//AGREGAR ALUMNO
		public void addAlumno(Alumno alumno) {
			Session session = sessionFactory.openSession();
			try{
				session.beginTransaction();
				session.persist(alumno);
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
		//LISTAR TODOS LOS ALUMNOS
		public LinkedList<Alumno> getAllAlumnos() {
			Session session = sessionFactory.openSession();
			LinkedList<Alumno> alumnos ;
			try {
				session.beginTransaction();
				alumnos = (LinkedList<Alumno>) session.createQuery("SELECT * FROM Alumno",Alumno.class).list();
				 return alumnos;
				
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
		//ELIMINAR UN ALUMNO
		public void deleteAlumno(Integer id) {
			Session session = sessionFactory.openSession();
			Alumno alumno;
			try {
				session.beginTransaction();
				alumno = session.get(Alumno.class, id);
				session.remove(alumno);
				
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
		//MODIFICAR UN ALUMNO
		@SuppressWarnings("deprecation")
		public void updateAlumno(Alumno alumno) {
			Session session = sessionFactory.openSession();
			try {
				session.beginTransaction();
				session.saveOrUpdate(alumno);
								
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
		//BUSCAR UN ALUMNO Y RETORNARLO
		public Alumno getAlumno(Integer id) {
			Session session = sessionFactory.openSession();
			Alumno alumno= new Alumno();
			try {
				session.beginTransaction();
				alumno = session.get(Alumno.class, id);
				 				
			}catch(Exception a) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw a;
			}finally {
				session.close();
				sessionFactory.close();
			}
			return alumno;
		}
}
