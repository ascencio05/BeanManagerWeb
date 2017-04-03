/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;

/**
 *
 * @author Rodrigo
 */
public class Requerimiento {
    public String idRequerimiento;
    public String titulo;
    public String descripcion;
    public String fecha;
    
    public Requerimiento()
    {
        idRequerimiento = "";
        titulo = "";
        descripcion = "";
        fecha = "";
    }
    
    public Requerimiento(String id, String title, String des, String date)
    {
        idRequerimiento = id;
        titulo = title;
        descripcion = des;
        fecha = date;
    }
}
