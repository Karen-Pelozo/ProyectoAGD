package com.miempresa.persistence;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.miempresa.proyectoAGD.User;

public class HibernateSessionsUser {
	SessionFactory sessionfactory= new Configuration().configure().buildSessionFactory();
	
	//NECESITAMOS AGREGAR UN USUARIO
	public void addUser(User user) {
			//ABRO UNA SESION
			Session session = sessionfactory.openSession();
			try{
				session.beginTransaction();
				session.persist(user);
				session.getTransaction().commit();
			
			}catch(Exception e) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw e;
			}finally {
				session.close();
				sessionfactory.close();
			}
			
		}
	//NECESITAMOS ELIMINAR UN USUARIO
	public void deleteUser(Integer id) {
			Session session = sessionfactory.openSession();
			try {
				session.beginTransaction();
				User user = session.get(User.class, id);
				session.remove(user);
				
			}catch(Exception a) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw a;
			}finally {
				session.close();
				sessionfactory.close();
			}
		}
	//NECESITAMOS MODIFICAR UN USUARIO
		@SuppressWarnings("deprecation")
	public void updateUser(User user) {
			Session session = sessionfactory.openSession();
			try {
				session.beginTransaction();
				session.saveOrUpdate(user);
								
			}catch(Exception a) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw a;
			}finally {
				session.close();
				sessionfactory.close();
			}
		}
	//NECESITAMOS TRAER TODOS LOS USUARIOS PARA UNA COMPARACION
	public LinkedList<User> getAllUsers() {
			Session session = sessionfactory.openSession();
			LinkedList<User> users ;
			try {
				session.beginTransaction();
				 users = (LinkedList<User>) session.createQuery("SELECT * FROM User",User.class).list();
				 return users;
				
			}catch(Exception a) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw a;
			}finally {
				session.close();
				sessionfactory.close();
			}
		}
	//NECESITAMOS TRAER UN USUARIO DE LA BASE DE DATOS
	public User getUser(Integer id) {
			Session session = sessionfactory.openSession();
			User user= new User();
			try {
				session.beginTransaction();
				 user = session.get(User.class, id);
				 				
			}catch(Exception a) {
				if(session.getTransaction()!=null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				throw a;
			}finally {
				session.close();
				sessionfactory.close();
			}
			return user;
		}
	
}
