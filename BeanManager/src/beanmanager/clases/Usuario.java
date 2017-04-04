/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;

import beanmanager.controles.Bdd;
import java.awt.image.ColorModel;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Usuario {
    public String idUsuario;
    public String idTipo;
    public String correo;
    public String nombre;
    public Date nacimiento;
    public String color;
    public boolean validado;
    public List<Permiso> permisos;
    
    public Usuario(String id, String idT, String correo, String nombre,String apellid, String nacimiento, String color)
    {
        idUsuario = id;
        this.correo = correo;
        this.nombre = nombre + apellid;
        this.nacimiento = Date.valueOf(nacimiento);
        idTipo = idT;
        this.color = color;
    }
    
    public Usuario(String correo)
    {
        this.correo = correo;
    }
    
    public boolean authenticate(String pass, Bdd db) throws Exception
    {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(pass.getBytes(),0,pass.length());
        String md5Pass = new BigInteger(1,m.digest()).toString(16);
        
        String cmd = "select * from Usuarios where correo = ? and contrasena = ?";
        
        db.setPreparedQuery(cmd);
        List<Object> parametrosList = new ArrayList<>();
        parametrosList.add(this.correo);
        parametrosList.add(md5Pass);
        ResultSet rs = db.executeReader(parametrosList);
        
        int i = 0;
        
        while(rs.next())
        {
            i++;
            idUsuario = rs.getString("idUsuario");
            idTipo = rs.getString("idTipo");
            nombre = rs.getString("nombre") + rs.getString("apellido");
            nacimiento = Date.valueOf(rs.getString("fechaNacimiento"));
            color = rs.getString("colorGUI");
        }
        
        return (i > 0);
    }
    
    public void getListedPermisos(Bdd db) throws Exception
    {
        permisos = new ArrayList<>();
        String cmd = "select * from Permisos where idTipo = ?";
        List<Object> parametros = new ArrayList<>();
        parametros.add(idTipo);
        db.setPreparedQuery(cmd);
        ResultSet rs = db.executeReader(parametros);
        while(rs.next())
        {
            String idPermiso = rs.getString("idPermiso");
            String idModulo = rs.getString("idModulo");
            String agregar = rs.getString("agregar");
            String borrar = rs.getString("borrar");
            String ingresar = rs.getString("ingresar");
            String modificar = rs.getString("modificar");
            permisos.add(new Permiso(idPermiso, idModulo, agregar, borrar, modificar, ingresar));
        }
    }
    
    public Permiso getPermiso(String idModulo)
    {
        for (Permiso permiso : permisos) {
            if(permiso.idModulo.equals(idModulo))
                return permiso;
        }
        return null;
    }
}
