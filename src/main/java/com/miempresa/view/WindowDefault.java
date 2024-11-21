package com.miempresa.view;

import java.awt.*;
import javax.swing.*;

public class WindowDefault extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	private PanelLogin panelLogin = new PanelLogin(this);
	private PanelRegistro panelRegistro = new PanelRegistro(this);
	private PanelVistaProfesor panelProf = new PanelVistaProfesor(this);
	//************prueba
//	Image iconAGD =Toolkit.getDefaultToolkit().getImage(WindowLogin.class.getResource("/images/bookIcon.png"));
	public WindowDefault(){
		this.setSize(screenSize);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("AGENDA DOCENTE");
		this.setVisible(true);
		this.initComponent();
	
	}
	
	public  void initComponent() {
		cambioPanel(0);
		pack();
	}
	
	public void cambioPanel(int i) {
		JPanel [] paneles= {
			panelLogin,
			panelRegistro, 
			panelProf
		};
		this.setContentPane(paneles[i]);
	}

}
