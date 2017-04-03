/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;

import java.awt.image.ColorModel;
import java.sql.Date;

/**
 *
 * @author Rodrigo
 */
public class Usuario {
    String idUsuario;
    String correo;
    String nombre;
    Date nacimiento;
    String color;
    
    public Usuario(String id, String correo, String nombre,String apellid, String nacimiento, String color)
    {
        idUsuario = id;
        this.correo = correo;
        this.nombre = nombre + apellid;
        this.nacimiento = Date.valueOf(nacimiento);
        this.color = color;
    }
}
