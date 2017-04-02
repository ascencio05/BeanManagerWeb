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
public class Proyecto {
    public String idProyecto;
    public String idUsuario;
    public String titulo;
    public String descripcion;
    public String fechaInicio;
    public String fechaFinal;
    public String fechaCreacion;
    public boolean aceptado;
    public boolean estado;
    
    public Proyecto()
    {
        idProyecto = "";
        idUsuario = "";
        titulo = "";
        descripcion = "";
        fechaFinal = "";
        fechaInicio = "";
        fechaCreacion ="";
        aceptado = false;
        estado = false;
    }
    
    public Proyecto(String idP, String idUs, String title, String des, String fI, String fF, String fC, String accepted, String state)
    {
        idProyecto = idP;
        idUsuario = idUs;
        titulo = title;
        descripcion = des;
        fechaInicio = fI;
        fechaFinal = fF;
        fechaCreacion = fC;
        aceptado = accepted.equals("1");
        estado = state.equals("1");
    }
}
