/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.usuarios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Monica Escrich
 */
public class usuarios extends javax.swing.JFrame {
    
    //Declaracion de componentes
    private final String imgPath="../recursos/imagenes/";
    private ImageIcon imgUsuarios;
    private ImageIcon imgConfiguracion;
    private JLabel etiquetaImagen; 
    private JLabel etiquetaNombres;
    private JLabel etiquetaApellidos;
    private JLabel etiquetaCorreo;
    private JLabel etiquetaFechaNac;
    private JLabel etiquetaRol;
    private JLabel etiquetaPassword;
    private JLabel etiquetaColor;
    private JLabel etiquetaActivo;
    private JTextField jtfNombres; 
    private JTextField jtfApellidos;
    private JTextField jtfCorreo;
    private JComboBox jcbRol; 
    private JPasswordField jpfPassword;
    private JButton jbtnColor; 
    private JCheckBox jcbActivo; 
    private Graphics gLinea; 
    
   
    public usuarios() {
       
        setSize(600,600);// Tamaño pantalla
        setTitle("Bean Manager - Usuarios");//titulo
       // setUndecorated(true);// Quita borde
        setResizable(false); //Quitar Resize
        setLocationRelativeTo(null);//Centra pantalla
        setLayout(null); // Libre seleccion de tamaño
        initComponents();
        setVisible(true);
    }
    
   
    
    private void initComponents()
    {
       //Imagen Usuarios
        imgUsuarios = new ImageIcon(getClass().getResource(imgPath+"usuarios.png")); 
        etiquetaImagen = new JLabel(imgUsuarios);
        etiquetaImagen.setOpaque(true);
        etiquetaImagen.setBackground(Color.decode("#EAED3B"));
        etiquetaImagen.setSize(200, 200);
        etiquetaImagen.setLocation(25, 25);
        
        //Etiqueta Nombre 
        etiquetaNombres = new JLabel("Nombres: ");
        etiquetaNombres.setOpaque(true);
        etiquetaNombres.setBounds(250,25,300,14);
        
        //TextField Nombres
        jtfNombres= new JTextField(); 
        jtfNombres.setOpaque(true); 
        jtfNombres.setBounds(250,50,300,25);
        
        //Etiqueta Apellidos 
        etiquetaApellidos = new JLabel("Apellidos: ");
        etiquetaApellidos.setOpaque(true);
        etiquetaApellidos.setBounds(250,80,300,14);
        
        //TextField Apellidos
        jtfApellidos= new JTextField(); 
        jtfApellidos.setOpaque(true); 
        jtfApellidos.setBounds(250,105,300,25);
        
        //Etiqueta Correo 
        etiquetaCorreo = new JLabel("Correo Electronico: ");
        etiquetaCorreo.setOpaque(true);
        etiquetaCorreo.setBounds(250,135,300,14);
        
        //TextField Correo
        jtfCorreo= new JTextField(); 
        jtfCorreo.setOpaque(true); 
        jtfCorreo.setBounds(250,160,300,25);
        
        //Etiqueta Fecha Nac 
        etiquetaFechaNac = new JLabel("Fecha de Nacimiento: ");
        etiquetaFechaNac.setOpaque(true);
        etiquetaFechaNac.setBounds(250,200,150,14);
        
        //JDateField fechaNac
        
       
        
        
        
        //Agregar al contenedor 
        getContentPane().add(etiquetaImagen);
        getContentPane().add(etiquetaNombres);
        getContentPane().add(jtfNombres);
        getContentPane().add(etiquetaApellidos);
        getContentPane().add(jtfApellidos);
        getContentPane().add(etiquetaCorreo); 
        getContentPane().add(jtfCorreo); 
        getContentPane().add(etiquetaFechaNac);
    }
    
    private void exitForm(WindowEvent evt)
    {
        System.exit(0);
    }
    private void formWindowOpened(WindowEvent evt){
       
    }
    
     public static void main(String[] args) {
        try{
          // UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
        }catch(Exception e)
        {
            System.out.println("No se puede establecer el aspecto deseado: "+e);
        }
         new usuarios().setVisible(true);
      
    }
}
