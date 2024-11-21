package com.miempresa.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

import com.miempresa.controllers.Validaciones;



public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;

//	private JFrame frameAux;
	private JPanel panelLogin = new JPanel();
	private JLabel lblUser= new JLabel();
	private JLabel lblPassword= new JLabel();
	private JLabel lblRegister= new JLabel();
	private JTextField txtfUser= new JTextField("DNI AQUI...",20);
	private JPasswordField passwordField = new JPasswordField("Password aqui...",20);
	private JButton btnInicio = new JButton();
	private JCheckBox jchbxShow = new JCheckBox();
	
	PanelLogin(WindowDefault frame){
		//this.frameAux = frame;
		this.setPreferredSize(frame.getSize());
		crearPanelLogin(frame);
	};
	public void crearPanelLogin(WindowDefault frame) {
		FlowLayout flwLayout = new FlowLayout(FlowLayout.CENTER,150,250);
		this.setLayout(flwLayout);
		Font font = new Font("Arial",0, 15);
		panelLogin.setOpaque(false);
		lblUser.setText("Usuario");
		lblUser.setFont(font);
		lblUser.setForeground(Color.ORANGE);
		lblPassword.setText("Password");
		lblPassword.setFont(font);
		lblPassword.setForeground(Color.ORANGE);
		lblRegister.setText(" Registrar");
		lblRegister.setForeground(Color.ORANGE);
		txtfUser.setForeground(Color.GRAY);
		passwordField.setForeground(Color.GRAY);
		btnInicio.setText("Inicio");
		btnInicio.setBackground(Color.LIGHT_GRAY);
		btnInicio.setForeground(Color.darkGray);
		jchbxShow.setText("Show");
		jchbxShow.setFont(font);
		jchbxShow.setForeground(Color.black);
		jchbxShow.setOpaque(false);
		jchbxShow.setIcon(new ImageIcon(this.getClass().getResource("/com/miempresa/images/not-visible.png")));
		BoxLayout bxLayout = new BoxLayout(panelLogin,BoxLayout.Y_AXIS);	
		panelLogin.setLayout(bxLayout);
		
		lblUser.setAlignmentY(CENTER_ALIGNMENT);
		txtfUser.setAlignmentY(RIGHT_ALIGNMENT);
		lblPassword.setAlignmentY(CENTER_ALIGNMENT);
		passwordField.setAlignmentY(RIGHT_ALIGNMENT);
		jchbxShow.setAlignmentY(LEFT_ALIGNMENT);
		btnInicio.setAlignmentY(CENTER_ALIGNMENT);
		lblRegister.setAlignmentY(LEFT_ALIGNMENT);
		
		panelLogin.add(lblUser);
		panelLogin.add(txtfUser);
		panelLogin.add(lblPassword);
		panelLogin.add(passwordField);
		panelLogin.add(jchbxShow);
		panelLogin.add(btnInicio);
		panelLogin.add(lblRegister);
		
		this.visibilizarPassword(jchbxShow); 
		this.accionDelClickJTextField(txtfUser);
		this.accionDelClickJTextField(passwordField);
		this.accionDelClickRegistrar(lblRegister,frame);
		this.accionDelBotonInicio(btnInicio);
		this.add(panelLogin);
		
	

		
	}
	public void visibilizarPassword(JCheckBox jchbx) {
		jchbx.addActionListener(e ->{ 
			JCheckBox chBxAU = (JCheckBox) e.getSource();
				passwordField.setEchoChar(chBxAU.isSelected() ? '\u0000': (Character) UIManager.get("PasswordField.echoChar"));
		});
		
	}
	public void accionDelClickJTextField(JTextComponent comp) {
		comp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(comp.getText()!="") {
					comp.setText("");
					comp.setForeground(Color.black);
					
				}	
			}
		});
	}
	public void accionDelClickRegistrar(JLabel lblRegistrar,WindowDefault frame) {
		lblRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				frame.remove(PanelLogin.this);
				frame.revalidate();
				frame.cambioPanel(1);
				frame.revalidate();
				frame.repaint();
				
				
			}
			public void mouseEntered(MouseEvent e) {
				lblRegistrar.setForeground(Color.BLUE);
			}
			public void mouseExited(MouseEvent e) {
				lblRegistrar.setForeground(Color.ORANGE);
			}
		});
	}
	public void accionDelBotonInicio(JButton btnInicio) {
		btnInicio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				 new Validaciones().validacionLogin(txtfUser.getText(), passwordField.getPassword());
			}
		});
	}
}
