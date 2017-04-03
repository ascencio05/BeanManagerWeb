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
public class Permiso {
    String idPermiso;
    String idTipo;
    String idModulo;
    boolean agregar;
    boolean borrar;
    boolean ingresar;
    boolean modificar;
    
    public Permiso(String idPermiso, String idTipo, String idModulo, String agregar, String borrar, String modificar, String ingresar)
    {
        this.idPermiso = idPermiso;
        this.idTipo = idTipo;
        this.idModulo = idModulo;
        this.agregar = agregar.equals("1");
        this.borrar = borrar.equals("1");
        this.ingresar = ingresar.equals("1");
        this.modificar = modificar.equals("1");
    }
}
