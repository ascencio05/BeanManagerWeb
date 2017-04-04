/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.ajustes;
import beanmanager.controles.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author jacky
 */
public class AgregarPermisosRol {
    private String rol,descripcion;
    private List<String> id;
    public AgregarPermisosRol(String r, String d)
    {
        rol = r;
        descripcion = d;
    }
    
    public void PermisosRol(){
        try{
            String idRol="";
            Bdd conexion = new Bdd();
            String consulta="SELECT `idModulo` as 'id' FROM `Modulos`";
            Statement stmt = conexion.con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            id= new ArrayList<String>();
            while(resultado.next())
            {
                id.add(resultado.getString("id"));
                
            }
            consulta = "SELECT `idRol` as 'id' FROM `rolesProyecto` WHERE `rol`='"+rol+"' and `descripcion`='"+descripcion+"'";
            resultado = stmt.executeQuery(consulta);
            if(resultado.next())
            {
                 idRol = resultado.getString("id");
            }
            int n = id.size();
            for(String modulo: id)
            {
                consulta = "INSERT INTO `PermisosRoles`(`idRol`, `idModulo`, "
                       + "`modificar`, `agregar`, `borrar`, `ingresar`, `eliminado`) "
                       + "VALUES ("+idRol+","+modulo+",0,0,0,0,0)";
               stmt.executeUpdate(consulta);
            }
               
            
            conexion.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
