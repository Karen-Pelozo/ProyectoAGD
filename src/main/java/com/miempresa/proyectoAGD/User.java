package com.miempresa.proyectoAGD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private Integer idDNI=0;
	@Column
	private	String nombre;
	@Column
	private String apellido;
	@Column
	private Byte password;
	@Column
	private TipoUsuario tipoUsuario;
		
	public User(Integer idDNI, String nombre, String apellido, Byte password, TipoUsuario tipoUsuario) {
		super();
		this.idDNI = idDNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.tipoUsuario = tipoUsuario;

	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdDNI() {
		return idDNI;
	}
	public void setIdDNI(Integer idDNI) {
		this.idDNI = idDNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Byte getPassword() {
		return password;
	}
	public void setPassword(Byte password) {
		this.password = password;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
