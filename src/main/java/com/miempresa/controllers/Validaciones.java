package com.miempresa.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.miempresa.proyectoAGD.TipoUsuario;

public class Validaciones {
	private UserController userController = new UserController();
	public Validaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void validacionLogin(String dniUser,char[] password) {
		String p= String.copyValueOf(password);
		if(!this.dniValido(dniUser))
			JOptionPane.showMessageDialog(null, "El USUARIO NO ES VALIDO\n *El dni debe estar sin puntuacion");	
		if(!this.passwordValido(p)) {
		JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO ES VALIDA"
				+ "\n *Contraseña de 4-20 caracteres "
				+ "\n *con al menos un dígito"
				+ "\n *al menos uno letra minúscula"
				+ "\n *al menos una letra mayúscula,"
				+ "\n *al menos una caracter especial '@#$%^&+='"
				+ "\n *y sin espacios en blanco");
		System.out.print(p);
		if(!this.existeUsuario(dniUser)) {
			JOptionPane.showMessageDialog(null, "El USUARIO NO EXISTE\n *Debe registrarse");
			}else {
				//AGREGAR LA BUSQUEDA DE EL USUARIO Y ABRIR EL PANEL DE USUARIO
				
				//TRAER USUARIO
			}
		}	
	}
	public void validacionRegistro(String dni,String passwor,String nombreUser,String apellidoUser,String tipoUser, JFrame ventna) {
		if(!this.dniValido(dni))
			JOptionPane.showMessageDialog(null, "El USUARIO NO ES VALIDO\n *El dni debe estar sin puntuacion");	
		else if(existeUsuario(dni)) {
			JOptionPane.showMessageDialog(null, "El USUARIO EXISTE\n *Debe iniciar sesion");
		}else if(!this.passwordValido(passwor)) {
			JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO ES VALIDA"
					+ "\n *Contraseña de 4-20 caracteres "
					+ "\n *con al menos un dígito"
					+ "\n *al menos uno letra minúscula"
					+ "\n *al menos una letra mayúscula,"
					+ "\n *al menos una caracter especial '@#$%^&+='"
					+ "\n *y sin espacios en blanco");
			System.out.print(passwor);
			}else {
				Byte pass = Byte.parseByte(passwor);
				UserController userController= new UserController();
				userController.crearUsuarioTipo(Integer.parseInt(dni), nombreUser, apellidoUser,pass ,deStringATipoUser(tipoUser));
			}
	}
//VALIDACIONES DEL PASSWORD
	/*No puede contener signos de interrogación, dos puntos ni espacios. No puede incluir solo números, ni dejarse en blanco.*/
	public boolean passwordValido(String pssword) {
		Pattern formatoPass = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,20}$");
		Matcher matcher = formatoPass.matcher(pssword); 
		boolean esValido = matcher.matches();
		return esValido;
	}
//VALIDACIONES DEL DNI
	public  boolean dniValido(String string) {
		//el dni deben ser todos numeros y igual a 8
		return this.esNumero(string) && this.tamanioOcho(string);
	}
	public boolean esNumero(String numero) {
		boolean esNum=false;
		try {
			Integer.parseInt(numero);
			esNum=true;
		}catch(Exception e){
			esNum =false;
		}
		return esNum;
	}
	public boolean tamanioOcho(String numero) {
		if(this.esNumero(numero)) {
			return numero.length() ==8;
		}
		return false;
	}
	//DEBE DE SER DE TIPO BOOLEAN 
	public boolean existeUsuario(String dni) {
		return userController.existeUserControl(dni);
	}
	public TipoUsuario deStringATipoUser(String tipo) {
		return TipoUsuario.PROFESOR.toString()== tipo ? TipoUsuario.PROFESOR : TipoUsuario.ALUMNO;
	}
	 
}
