/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.usuarios;

import controladores.clases.Bdd;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Monica Escrich
 */
public class toDo {

    /**
     * @return the idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * @return the done
     */
    public int getDone() {
        return done;
    }

    /**
     * @param done the done to set
     */
    public void setDone(int done) {
        this.done = done;
    }

    /**
     * @return the actividad
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    private int idActividad; 
    private int done; 
    private String actividad; 
    Bdd db;
    String respuesta; 
    
    public ResultSet getToDo(int u){
            ResultSet usuario; 
       try{
             List<Object> param = new ArrayList<>();
             param.add(u);
             Context initial = new InitialContext();
             db = new Bdd(initial,"jdbc/AWS");
             db.setCallableQuery("{call toDoSelect(?)}");
            usuario = db.executeCallRead(param);
            
            return usuario;
                       
        }catch(Exception e){
             return usuario = null;
        }
    }
    
     public void insertActividad(int u, String acti ){
            
       try{
             List<Object> param = new ArrayList<>();
             param.add(u);
             param.add(acti); 
             Context initial = new InitialContext();
             db = new Bdd(initial,"jdbc/AWS");
             db.setCallableQuery("{call insertActividad(?,?)}");
             db.executeCall(param);
             respuesta= "Actualizado con exito"; 
        }catch(Exception e){
           respuesta=e.toString(); 
        }
             
       
    }
     
     public void updateActividad(int u, int eliminar){
            
       try{
             List<Object> param = new ArrayList<>();
             param.add(eliminar);
             Context initial = new InitialContext();
             db = new Bdd(initial,"jdbc/AWS");
             db.setCallableQuery("{call updateTodo(?)}");
             db.executeCall(param);
              respuesta= "Actualizado con exito"; 
        }catch(Exception e){
           respuesta=e.toString(); 
        }
             
       
    }
    
    public void disconnect(){
        try {
            db.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(toDo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
