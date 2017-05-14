/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.proyectos;
import controladores.clases.Bdd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
/**
 *
 * @author Jacquelin
 */
public class proyectos {
    
     private int idUsuario;
     private ResultSet proyectos = null;
     private ResultSet Actividades = null;
     private int idProyecto;
     private int estado;
     private String resultado;
     public  Bdd db;
     
      /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
     /**
     * @return the idProyecto
     */
    public int getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public ResultSet consultar(int u)
    {
        try{
             List<Object> param = new ArrayList<>();
             param.add(u);
             Context initial = new InitialContext();
               db = new Bdd(initial,"jdbc/AWS");
                db.setCallableQuery("{call SelectProyecto(?)}");
            proyectos = db.executeCallRead(param);
           
        }catch(Exception e){
            proyectos = null;
        }
        return proyectos;
    }
    
    public String getResultado()
    {
        try{
            List<Object> param = new ArrayList<>();
            param.add(idUsuario);
            param.add(idProyecto);
            param.add(estado);
            Context initial = new InitialContext();
            db = new Bdd(initial,"jdbc/AWS");
            db.setCallableQuery("{call SelectActividad(?,?,?)}");
            Actividades = db.executeCallRead(param);
            int i=1;
            resultado="";
            while(Actividades.next())
            {
                resultado += "<tr>";
                resultado += "<td>"+i+"</td>";
                resultado += "<td>"+Actividades.getString("titulo")+"</td>";
                resultado += "<td>"+Actividades.getString("descripcion")+"</td>";
                resultado += "<td>"+Actividades.getString("fechaInicio")+"</td>";
                resultado += "</tr>";
                i++;
            }
            if(resultado.equals(""))
            {
                if(estado == 0){
                    resultado="0";
                }
                else
                {
                    resultado="1";
                }
            }
           db.disconnect();
        }catch(Exception e){
            resultado = "Error: "+e;
        }
        return resultado;
    }
    
     public ResultSet getActividad()
    {
    try{
             List<Object> param = new ArrayList<>();
             param.add(idUsuario);
             param.add(idProyecto);
             param.add(estado);
             Context initial = new InitialContext();
               db = new Bdd(initial,"jdbc/AWS");
                db.setCallableQuery("{call SelectActividad(?,?,?)}");
            Actividades = db.executeCallRead(param);
           
        }catch(Exception e){
            Actividades = null;
        }
        return Actividades;
    }
    public void Desc()
    {
        try{
        db.disconnect();}
        catch(Exception e){
           System.out.println(e);
        }
    }
    
   
    
}
