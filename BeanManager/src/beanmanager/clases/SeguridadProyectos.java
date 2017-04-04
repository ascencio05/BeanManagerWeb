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
            String a ="SELECT A.agregar,A.borrar,A.modificar FROM Permisos A INNER JOIN TiposUsuario B ON(A.idTipo=B.idTipo) INNER JOIN Usuarios C ON(B.idTipo=C.idTipo) WHERE C.idUsuario="+idUsuario+" AND A.idModulo="+idModulo+" AND A.eliminado=0 AND C.eliminado=0" ;
            if(!rs.getBoolean("A.agregar"))
                bloquear(Agregar);
            if(!rs.getBoolean("A.modificar"))
                bloquear(Modificar);
            if(!rs.getBoolean("A.borrar"))
                bloquear(Eliminar);
        }
        catch(Exception e)
         {
             //JOptionPane.showMessageDialog(null, "Error en BDD: "+e.toString());
         }
    }
    
    private void bloquear(Component[] Com)
    {
        for(int i=0;i<Com.length;i++)
             Com[i].setVisible(false);
    }
    
}
