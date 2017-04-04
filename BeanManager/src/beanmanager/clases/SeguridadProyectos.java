/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;
import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ascencio
 */
public class SeguridadProyectos {
   public Usuario session;

    public SeguridadProyectos(int idModulo,Usuario session,Component[] Agregar,Component[] Modificar,Component[] Eliminar)
    {
        try
        {
            for(int i =0;i<session.permisos.size();i++)
              if(Integer.parseInt(session.permisos.get(i).idModulo)==idModulo)
              {
                   if(Agregar!=null&&!session.permisos.get(i).agregar)
                        bloquear(Agregar);
                   if(Modificar!=null&&!session.permisos.get(i).modificar)
                        bloquear(Modificar);
                   if(Eliminar!=null&&!session.permisos.get(i).borrar)
                        bloquear(Eliminar);
              }
           
        }
        catch(Exception e)
         {
            if(Agregar!=null)
                bloquear(Agregar);
            if(Modificar!=null)
                bloquear(Modificar);
            if(Eliminar!=null)
                bloquear(Eliminar);
             
         }
    }
    
        public SeguridadProyectos(int[] idModulo,Usuario session,Component[] Ingresar)
    {
        try
        {
            
            for(int i =0;i<idModulo.length;i++)
            {
                for(int j =0;j<session.permisos.size();j++)
                    if(Integer.parseInt(session.permisos.get(j).idModulo)==idModulo[i])
                    {
                         if(Ingresar!=null&&session.permisos.get(j).ingresar)
                              bloquear(Ingresar);
                    }
            }
        }
        catch(Exception e)
         {
            if(Ingresar!=null)
                bloquear(Ingresar);   
         }
    }
    
    private void bloquear(Component[] Com)
    {
        for(int i=0;i<Com.length;i++)
             Com[i].setVisible(false);
    }
    
}
