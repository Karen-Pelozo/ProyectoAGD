package com.miempresa.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import com.miempresa.controllers.Validaciones;


public class PanelRegistro extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel panelRegistro = new JPanel();
	private JTextField campoNombre = new JTextField("Nombre", 20);
	private JTextField campoDNI= new JTextField("D.N.I", 20);
	private JTextField campoApellido= new JTextField("Apellido", 20);
	private JTextField campoPassword= new JTextField("password", 20);
	private JTextField campoPasswordValid= new JTextField("copiar password", 20);
	private JLabel lbNombre= new JLabel("Nombre");
	private JLabel lbDNI= new JLabel("D.N.I");
	private JLabel lbApellido= new JLabel("Apellido");
	private JLabel lbPassword= new JLabel("Contraseña");
	private JLabel lbPasswordValid= new JLabel("Copiar Contraseña");
	private JLabel lbTipoUser= new JLabel("Tipo de usuario");	
	private String[] opcionesComboBX= {"Seleccion...","PROFESOR","ALUMNO"};
	private JComboBox<String> tipoUsercboBx = new JComboBox<>(opcionesComboBX);
	private JButton btnfinRegistro= new JButton("Finalizar >>");
	private JButton btnAtrasRegistro= new JButton("<< Atras");
	//private JFrame frameAux;
	PanelRegistro(WindowDefault frame){
		//this.frameAux = frame;
		this.setSize(frame.getSize());
		FlowLayout flwLayout = new FlowLayout(FlowLayout.CENTER,50,100); 
		this.setLayout(flwLayout);
		this.setOpaque(true);
		crearPanelRegistro(frame);
		
	};
	PanelRegistro(){
		super();
	};
	public void crearPanelRegistro(WindowDefault frame) {
		Font font = new Font("Arial",0, 15);
		campoNombre.setFont(font);
		campoApellido.setFont(font);
		campoPassword.setFont(font);
		campoDNI.setFont(font);
		campoPasswordValid.setFont(font);
		
		campoNombre.setForeground(Color.gray);
		campoApellido.setForeground(Color.gray);
		campoPassword.setForeground(Color.gray);
		campoPasswordValid.setForeground(Color.gray);
		campoDNI.setForeground(Color.gray);
		
		lbNombre.setForeground(Color.black);
		lbDNI.setForeground(Color.black);
		lbApellido.setForeground(Color.black);
		lbPassword.setForeground(Color.black);
		lbPasswordValid.setForeground(Color.black);
		lbTipoUser.setForeground(Color.black);
		
		BoxLayout bxLayoutRegi = new BoxLayout(panelRegistro,BoxLayout.PAGE_AXIS);	
		panelRegistro.setLayout(bxLayoutRegi);
		
		lbNombre.setHorizontalAlignment(SwingConstants.RIGHT); 
	    lbDNI.setHorizontalAlignment(SwingConstants.RIGHT); 
	    lbApellido.setHorizontalAlignment(SwingConstants.RIGHT);
	    lbPassword.setHorizontalAlignment(SwingConstants.RIGHT); 
	    lbTipoUser.setHorizontalAlignment(SwingConstants.RIGHT);
	    JPanel panelBotones = new JPanel();
	    btnfinRegistro.setAlignmentY(Box.RIGHT_ALIGNMENT);
		btnAtrasRegistro.setAlignmentX(Box.RIGHT_ALIGNMENT);
		
		panelRegistro.add(lbDNI);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(campoDNI);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(lbNombre);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(campoNombre);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(lbApellido);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(campoApellido);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(lbPassword);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(campoPassword);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(lbPasswordValid);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(campoPasswordValid);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(lbTipoUser);
		panelRegistro.add(Box.createRigidArea(new Dimension(0,5)));
		panelRegistro.add(tipoUsercboBx);
		panelBotones.add(btnAtrasRegistro);
		panelBotones.add(btnfinRegistro);
		panelRegistro.add(panelBotones);
		
		this.accionDelClickJTextField(campoDNI);
		this.accionDelClickJTextField(campoNombre);
		this.accionDelClickJTextField(campoApellido);
		this.accionDelClickJTextField(campoPassword);
		this.accionDelClickJTextField(campoPassword);
		this.accionDelClickJTextField(campoPasswordValid);
		this.accionClickBotonAtras(btnAtrasRegistro, frame);
		this.add(panelRegistro);
		
	};
	
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
	public void accionClickBotonAtras(JButton btn , WindowDefault frame) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cambiarPanel(frame);
			}
		} );
	}
	public void accionClickBotonFinalizar(JButton btn , WindowDefault frame) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				cambiarPanel(frame);
			}
		});
	}
	public void cambiarPanel(WindowDefault frame) {
		frame.remove(PanelRegistro.this);
		frame.revalidate();
		frame.cambioPanel(0);
		frame.revalidate();
		frame.repaint();
	}
	public void obtenerDatosUsuario(WindowDefault frame) {
		
		Validaciones validacion = new Validaciones();
		if(compararPassword(campoPassword.toString(),campoPasswordValid.toString())) {
			validacion.validacionRegistro(campoDNI.getText(),
					campoPassword.toString(),
					campoNombre.getText(),
					campoApellido.getText(),
					tipoUsercboBx.getSelectedItem().toString(),
					frame);
		}
	/*	boolean esValido = validarCampos(campoDNI.getText(),campoNombre.getText(),
					campoApellido.getText(),campoPassword.getText(),
					campoPasswordValid.getText(),
					tipoUsercboBx.getSelectedItem().toString());
		if(esValido) {
			user.setIdDNI(Integer.parseInt(campoDNI.getText()));
			user.setNombre(campoNombre.getText());
			user.setApellido(campoApellido.getText());
			Byte pass =Byte.parseByte(campoPassword.toString());
			user.setPassword(pass);
		}else {
			//MOSTRAR UN MENSAJE QUE DIGA QUE EL REGISTRO NO ES VALIDO
		}*/
	}
	public boolean compararPassword(String pass1, String pass2) {
		return pass1.equals(pass2) ? true: false;
	}
	/*public boolean validarCampos(String dni,String nombre,String apellido,String password,String password2,String tipoUsuario) {
		Validaciones validacion = new Validaciones();
		validacion.validacionRegistro(dni, password2, null);
		return false;
	}*/
}
