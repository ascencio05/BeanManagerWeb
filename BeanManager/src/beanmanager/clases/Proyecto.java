/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;

import java.util.ArrayList;
import java.util.List;
import beanmanager.controles.Bdd;
import java.sql.ResultSet;

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
    public List<Requerimiento> requerimientos;
    
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
    
    public void getRequerimientos(Bdd db) throws Exception
    {
        requerimientos = new ArrayList<>();
        String cmd = "Select * from Requerimientos where idProyecto = ?";
        db.setPreparedQuery(cmd);
        List<Object> parametros = new ArrayList<>();
        parametros.add(this.idProyecto);
        ResultSet rs = db.executeReader(parametros);
        while(rs.next())
        {
            String id = rs.getString("idRequerimiento");
            String titulo = rs.getString("titulo");
            String des = rs.getString("descripcion");
            String date = rs.getString("fecha");
            
            Requerimiento aux = new Requerimiento(id, titulo, des, date);
            requerimientos.add(aux);
        }
    }
    
    public void aceptarSolicitud(Bdd db, Usuario session) throws Exception
    {
        String cmd = "Update Proyecto set aceptado = 1 where idProyecto = ?";
        db.setPreparedQuery(cmd);
        List<Object> parametros = new ArrayList<>();
        parametros.add(this.idProyecto);
        db.executeQuery(parametros);
        
        cmd = "Insert into Integrantes values(null,1,?,?,0)";
        db.setPreparedQuery(cmd);
        parametros = new ArrayList<>();
        parametros.add(session.idUsuario);
        parametros.add(this.idProyecto);
        db.executeQuery(parametros);
    }
}
