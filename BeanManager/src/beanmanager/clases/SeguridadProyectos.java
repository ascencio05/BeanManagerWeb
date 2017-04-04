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
    Statement st;
    ResultSet rs;

    public SeguridadProyectos(int idModulo,int idUsuario,Connection con,Component[] Agregar,Component[] Modificar,Component[] Eliminar)
    {
        try
        {
            st = con.createStatement();
            rs=st.executeQuery("SELECT A.agregar,A.borrar,A.modificar FROM Permisos A INNER JOIN TiposUsuario B ON(A.idTipo=B.idTipo) INNER JOIN Usuarios C ON(B.idTipo=C.idTipo) WHERE C.idUsuario="+idUsuario+" AND A.idModulo="+idModulo+" AND A.eliminado=0 AND C.eliminado=0" );
            rs.next();
            if(Agregar!=null&&!rs.getBoolean("A.agregar"))
                bloquear(Agregar);
            if(Modificar!=null&&!rs.getBoolean("A.modificar"))
                bloquear(Modificar);
            if(Eliminar!=null&&!rs.getBoolean("A.borrar"))
                bloquear(Eliminar);
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
    
        public SeguridadProyectos(int[] idModulo,int idUsuario,Connection con,Component[] Ingresar)
    {
        try
        {
            st = con.createStatement();
            for(int i =0;i<idModulo.length;i++)
            {
                rs=st.executeQuery("SELECT A.agregar,A.borrar,A.modificar FROM Permisos A INNER JOIN TiposUsuario B ON(A.idTipo=B.idTipo) INNER JOIN Usuarios C ON(B.idTipo=C.idTipo) WHERE C.idUsuario="+idUsuario+" AND A.idModulo="+idModulo[i]+" AND A.eliminado=0 AND C.eliminado=0" );
                rs.next();
                if(Ingresar!=null&&!rs.getBoolean("A.ingresar"))
                    bloquear(Ingresar);
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
