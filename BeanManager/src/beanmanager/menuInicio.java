/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager;

import beanmanager.proyectos.*;
import beanmanager.controles.*;
import beanmanager.ajustes.*;
import beanmanager.clases.Usuario;
import beanmanager.solicitudes.*;
import beanmanager.usuarios.MenuUsuarios;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    public Usuario session;
    private menuInicio autoreference;
    
   
    public menuInicio() {
        setSize(475,525);// Tamaño pantalla
        setTitle("Bean Manager - Menu Principal");//titulo
        //setUndecorated(true);// Quita borde
        setResizable(false); //Quitar Resize
        setLocationRelativeTo(null);//Centra pantalla
        setLayout(null); // Libre seleccion de tamaño
        initComponents();
        autoreference = this;
    }
    
    private void initComponents()
    {
        //Solicitudes
        imgSolicitudes = new ImageIcon(getClass().getResource(imgPath+"solicitudes.png")); 
        etiquetaSolicitudes = new JLabel(imgSolicitudes);
        etiquetaSolicitudes.setOpaque(true);
        etiquetaSolicitudes.setBackground(Color.decode("#FFFFFF"));
        etiquetaSolicitudes.setSize(200, 200);
        etiquetaSolicitudes.setLocation(25, 25);
        etiquetaSolicitudes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //Proyectos
        imgProyectos = new ImageIcon(getClass().getResource(imgPath+"proyectos.png")); 
        etiquetaProyectos = new JLabel(imgProyectos);
        etiquetaProyectos.setOpaque(true);
        etiquetaProyectos.setBackground(Color.decode("#FFFFFF"));
        etiquetaProyectos.setSize(200, 200);
        etiquetaProyectos.setLocation(25, 250);
        etiquetaProyectos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Usuarios       
        imgUsuarios = new ImageIcon(getClass().getResource(imgPath+"usuarios.png")); 
        etiquetaUsuarios = new JLabel(imgUsuarios);
        etiquetaUsuarios.setOpaque(true);
        etiquetaUsuarios.setBackground(Color.decode("#FFFFFF"));
        etiquetaUsuarios.setSize(200, 200);
        etiquetaUsuarios.setLocation(250, 25);
        etiquetaUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Ajustes
        imgAjustes = new ImageIcon(getClass().getResource(imgPath+"ajustes.png")); 
        etiquetaAjustes = new JLabel(imgAjustes);
        etiquetaAjustes.setOpaque(true);
        etiquetaAjustes.setBackground(Color.decode("#FFFFFF"));
        etiquetaAjustes.setSize(200, 200);
        etiquetaAjustes.setLocation(250, 250);
        etiquetaAjustes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //Texto
      
        texto=new JLabel();
        Font fuente=new Font("Monospaced", Font.BOLD, 25);
        texto.setFont(fuente);
        texto.setText("");
        texto.setSize(425,25);
        texto.setLocation(25, 470);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        //Agregarlos
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        getContentPane().add(etiquetaSolicitudes);
        getContentPane().add(etiquetaProyectos);
        getContentPane().add(etiquetaUsuarios);
        getContentPane().add(etiquetaAjustes);
        getContentPane().add(texto);
        
        
        etiquetaSolicitudes.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent e)
            {
                etiquetaSolicitudes.setBackground(Color.decode("#87B87E"));
                texto.setText("Solicitudes");
            }
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
               Load l=new Load(1);
               l.session = session;
               l.padre = autoreference;
               l.setVisible(true); 
                cerrar();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaSolicitudes.setBackground(Color.decode("#FFFFFF"));
                texto.setText("");
            }
        
        });
        
        
        etiquetaAjustes.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent e)
            {
                etiquetaAjustes.setBackground(Color.decode("#B74635"));
                texto.setText("Controles");
            }
            @Override
            public void mouseClicked(MouseEvent e) { }
                
            @Override
            public void mousePressed(MouseEvent e) {
                Load l=new Load(2);
               l.session = session;
               l.padre = autoreference;
               l.setVisible(true); 
                cerrar();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaAjustes.setBackground(Color.decode("#FFFFFF"));
                texto.setText("");
            }
        
        });
        
        etiquetaUsuarios.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent e)
            {
                etiquetaUsuarios.setBackground(Color.decode("#FFB752"));
                texto.setText("Usuarios");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              Load l=new Load(3);
               l.setVisible(true);
               cerrar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaUsuarios.setBackground(Color.decode("#FFFFFF"));
                texto.setText("");
            }
        
        });
        
        
        etiquetaProyectos.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent e)
            {
                etiquetaProyectos.setBackground(Color.decode("#99D5E2"));
                texto.setText("Proyectos");
            }
            @Override
            public void mouseClicked(MouseEvent e) {  
               Load l=new Load(4);
               l.session = session;
               l.setVisible(true);
               cerrar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaProyectos.setBackground(Color.decode("#FFFFFF"));
                texto.setText("");
            }
        
        });
    }

    private void cerrar()
    {
        this.setVisible(false);
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
