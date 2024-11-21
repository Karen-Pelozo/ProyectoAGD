package com.miempresa.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

//import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import view.WindowDefault;

public class PanelVistaProfesor extends JPanel{

	private static final long serialVersionUID = 1L;
	//CREA EL APARTADO DE LOS DATOS DEL PERFIL
	private JPanel panelDatos = new JPanel();
	private JLabel lblProfesor= new JLabel("Profesor");
	private JLabel lblNombre = new JLabel("ACA VA EL NOMBRE");
	private JLabel lblPerfil =new JLabel("Perfil");
	private JLabel lblImgPerfil=new JLabel();
	//CREA EL APARTADO DE EL MENU CURSOS /TAREAS / AMONESTACIONES
//	private JPanel panelMenu = new JPanel();
	
	//CREA EL APARTADO DE LA VENTANA INTERNA DEL PROFESOR
	//private JPanel panelVentInter = new JPanel();
	
	
	
	PanelVistaProfesor(WindowDefault frame){
		this.setSize(frame.getSize());
		agregarComponentes(frame);
	}
	public void agregarComponentes(WindowDefault frame) {
		//AGREGAR UN LAYOUT PARA SETEAR LOS COMPONENTES
		GridBagLayout grLayout = new GridBagLayout();
		this.setLayout(grLayout);
		GridBagConstraints constraints = new GridBagConstraints(); 
		constraints.gridx = 0;
		constraints.gridy=0;
		panelDatos.setSize(new Dimension(50,50));
		panelDatos.add(lblProfesor);
		panelDatos.add(lblNombre);
		panelDatos.add(lblPerfil);
		lblImgPerfil.setIcon(new ImageIcon(getClass().getResource("/com/miempresa/images/usuarioFemale64.png")));
		panelDatos.add(lblImgPerfil);
		this.add(panelDatos,constraints);
		
	}
}
