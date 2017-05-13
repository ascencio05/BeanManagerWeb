/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.session;

/**
 *
 * @author Rodrigo
 */
public class Permiso {
    public String idPermiso;
    public String idModulo;
    public boolean agregar;
    public boolean borrar;
    public boolean ingresar;
    public boolean modificar;
    
    public Permiso(String idPermiso, String idModulo, String agregar, String borrar, String modificar, String ingresar)
    {
        this.idPermiso = idPermiso;
        this.idModulo = idModulo;
        this.agregar = agregar.equals("1");
        this.borrar = borrar.equals("1");
        this.ingresar = ingresar.equals("1");
        this.modificar = modificar.equals("1");
    }
    
    public Permiso()
    {
        
    }
}
