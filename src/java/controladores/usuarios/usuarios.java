/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.usuarios;

import controladores.clases.Bdd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author monica
 */
public class usuarios {

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    
    public  Bdd db;
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechanac
     */
    public String getFechanac() {
        return fechanac;
    }

    /**
     * @param fechanac the fechanac to set
     */
    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    /**
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the paginaweb
     */
    public String getPaginaweb() {
        return paginaweb;
    }

    /**
     * @param paginaweb the paginaweb to set
     */
    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    /**
     * @return the facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return the twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the github
     */
    public String getGithub() {
        return github;
    }

    /**
     * @param github the github to set
     */
    public void setGithub(String github) {
        this.github = github;
    }

    /**
     * @return the contrasena1
     */
    public String getContrasena1() {
        return contrasena1;
    }

    /**
     * @param contrasena1 the contrasena1 to set
     */
    public void setContrasena1(String contrasena1) {
        this.contrasena1 = contrasena1;
    }

    /**
     * @return the contrasena2
     */
    public String getContrasena2() {
        return contrasena2;
    }

    /**
     * @param contrasena2 the contrasena2 to set
     */
    public void setContrasena2(String contrasena2) {
        this.contrasena2 = contrasena2;
    }
    
    public void setUser(int u){
            ResultSet usuario; 
       try{
             List<Object> param = new ArrayList<>();
             param.add(u);
             Context initial = new InitialContext();
             db = new Bdd(initial,"jdbc/AWS");
             db.setCallableQuery("{call selectUsers(?)}");
            usuario = db.executeCallRead(param);
            while(usuario.next()){
                nombre=usuario.getString("nombre");
                apellido=usuario.getString("apellido");
                fechanac=usuario.getString("fechaNacimiento");
                presentacion=usuario.getString("presentacion");
                pais=usuario.getString("pais");
                ciudad=usuario.getString("ciudad");
                correo=usuario.getString("correo");
                paginaweb=usuario.getString("paginaweb");
                facebook=usuario.getString("facebook");
                twitter=usuario.getString("twitter");
                github=usuario.getString("github");
            }
            
           db.disconnect();
        }catch(Exception e){
            usuario = null;
        }
             
       
    }
   
     public void updateUser(int u){
            
       try{
             List<Object> param = new ArrayList<>();
             param.add(u);
             param.add(nombre); 
             param.add(apellido); 
             param.add(correo);
             param.add(fechanac);
             param.add(pais); 
             param.add(ciudad); 
             param.add(presentacion); 
             param.add(paginaweb); 
             param.add(facebook); 
             param.add(twitter); 
             param.add(github);
             Context initial = new InitialContext();
             db = new Bdd(initial,"jdbc/AWS");
             db.setCallableQuery("{call Users_Updat(?,?,?,?,?,?,?,?,?,?,?,?)}");
             db.executeCall(param);
              respuesta= "Actualizado con exito"; 
        }catch(Exception e){
           respuesta=e.toString(); 
        }
             
       
    }
    private String nombre; 
    private String apellido; 
    private String fechanac; 
    private String presentacion; 
    private String pais; 
    private String ciudad; 
    private String correo;
    private String paginaweb; 
    private String facebook; 
    private String twitter; 
    private String github; 
    private String contrasena1; 
    private String contrasena2; 
    private String respuesta; 
    
}
