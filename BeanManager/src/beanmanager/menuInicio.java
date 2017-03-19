/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author ascencio
 */
public class menuInicio  extends javax.swing.JFrame{
    private final String imgPath="recursos/imagenes/";
    private ImageIcon imgSolicitudes ;
    private ImageIcon imgProyectos ;
    private ImageIcon imgUsuarios ;
    private ImageIcon imgAjustes ;
    private JLabel etiquetaSolicitudes;
    private JLabel etiquetaProyectos;
    private JLabel etiquetaUsuarios ;
    private JLabel etiquetaAjustes ;
    private JLabel texto ;
    
   
    public menuInicio() {
        setSize(475,525);// Tamaño pantalla
        setTitle("Bean Manager - Menu Principal");//titulo
        //setUndecorated(true);// Quita borde
        setResizable(false); //Quitar Resize
        setLocationRelativeTo(null);//Centra pantalla
        setLayout(null); // Libre seleccion de tamaño
        initComponents();
    }
    
    private void initComponents()
    {
        //Solicitudes
        imgSolicitudes = new ImageIcon(getClass().getResource(imgPath+"solicitudes.png")); 
        etiquetaSolicitudes = new JLabel(imgSolicitudes);
        etiquetaSolicitudes.setOpaque(true);
        etiquetaSolicitudes.setBackground(Color.decode("#87B87E"));
        etiquetaSolicitudes.setSize(200, 200);
        etiquetaSolicitudes.setLocation(25, 25);
        
        //Proyectos
        imgProyectos = new ImageIcon(getClass().getResource(imgPath+"proyectos.png")); 
        etiquetaProyectos = new JLabel(imgProyectos);
        etiquetaProyectos.setOpaque(true);
        etiquetaProyectos.setBackground(Color.decode("#99D5E2"));
        etiquetaProyectos.setSize(200, 200);
        etiquetaProyectos.setLocation(25, 250);
        //Usuarios       
        imgUsuarios = new ImageIcon(getClass().getResource(imgPath+"usuarios.png")); 
        etiquetaUsuarios = new JLabel(imgUsuarios);
        etiquetaUsuarios.setOpaque(true);
        etiquetaUsuarios.setBackground(Color.decode("#FFB752"));
        etiquetaUsuarios.setSize(200, 200);
        etiquetaUsuarios.setLocation(250, 25);
        //Ajustes
        imgAjustes = new ImageIcon(getClass().getResource(imgPath+"ajustes.png")); 
        etiquetaAjustes = new JLabel(imgAjustes);
        etiquetaAjustes.setOpaque(true);
        etiquetaAjustes.setBackground(Color.decode("#B74635"));
        etiquetaAjustes.setSize(200, 200);
        etiquetaAjustes.setLocation(250, 250);
        
        //Texto
      
        texto=new JLabel();
        Font fuente=new Font("Monospaced", Font.BOLD, 25);
        texto.setFont(fuente);
        texto.setText("Texto de las Opciones");
        texto.setSize(425,25);
        texto.setLocation(25, 470);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        //Agregarlos
        getContentPane().add(etiquetaSolicitudes);
        getContentPane().add(etiquetaProyectos);
        getContentPane().add(etiquetaUsuarios);
        getContentPane().add(etiquetaAjustes);
        getContentPane().add(texto);
    }

    

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        }catch(Exception e)
        {
            System.out.println("No se puede establecer el aspecto deseado: "+e);
        }
         new menuInicio().setVisible(true);
      
    }
}
