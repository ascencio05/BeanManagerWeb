/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.solicitudes;

import controladores.clases.Bdd;
import controladores.session.Permiso;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author villacorta
 */
public class solicitudes {
    private String idProyecto;
    private String idUsuario;
    private String titulo;
    private String des;
    private String fI;
    private String fF;
    private String fC;
    private boolean aceptado;
    private boolean estado;

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    private Permiso permiso;

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return the fI
     */
    public String getfI() {
        return fI;
    }

    /**
     * @param fI the fI to set
     */
    public void setfI(String fI) {
        this.fI = fI;
    }

    /**
     * @return the fF
     */
    public String getfF() {
        return fF;
    }

    /**
     * @param fF the fF to set
     */
    public void setfF(String fF) {
        this.fF = fF;
    }

    /**
     * @return the fC
     */
    public String getfC() {
        return fC;
    }

    /**
     * @param fC the fC to set
     */
    public void setfC(String fC) {
        this.fC = fC;
    }

    /**
     * @return the aceptado
     */
    public boolean isAceptado() {
        return aceptado;
    }

    /**
     * @param aceptado the aceptado to set
     */
    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getTable()
    {
        
        String table = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            int i = 0;
            db.setCallableQuery("{call Solicitudes_select(?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idUsuario);
            
            ResultSet rs = db.executeCallRead(param);
            
            while(rs.next())
            {
                table += "\n"+
"                           <tr id='row" + rs.getString("idProyecto") + "'>\n" +
"                              <td id='title" + rs.getString("idProyecto") + "'>" + rs.getString("titulo") +"</td>\n" +
"                              <td>" + rs.getString("fechaCreacion") + "</td>\n";
                
                if(rs.getInt("aceptado") == 1)
                {
                    table += "<td>\n" +
"                                                    <div class=\"alert-success col-xs-offset-4 col-xs-4 text-center h6\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-ok\"></i>\n" +
"                                                    </div>\n" +
"                                                </td>";
                }
                else
                {
                    table += "<td>\n" +
"                                                    <div class=\"alert-danger col-xs-offset-4 col-xs-4 text-center h6\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-remove\"></i>\n" +
"                                                    </div>\n" +
"                                                </td>";
                }
                
                if(rs.getInt("estado") == 1)
                {
                    table += "<td>\n" +
"                                                    <div class=\"alert-success col-xs-offset-4 col-xs-4 text-center h6\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-ok\"></i>\n" +
"                                                    </div>\n" +
"                                                </td>";
                }
                else
                {
                    table += "<td>\n" +
"                                                    <div class=\"alert-danger col-xs-offset-4 col-xs-4 text-center h6\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-remove\"></i>\n" +
"                                                    </div>\n" +
"                                                </td>";
                }
                table+=        "<td>\n" +
"                                 <button class=\"btn btn-sm btn-primary\" onclick=\"return openDetallesSol(" + rs.getString("idProyecto") + ");\">\n" +
"                                   <i class=\"ace-icon fa fa-pencil-square-o\"></i>\n" +
"                                 </button>\n" +
                                 "<button class=\"btn btn-sm btn-success\"onclick=\"return openReq(" + rs.getString("idProyecto") + ",'" + rs.getString("titulo") + "');\">\n" +
"                                   <i class=\"ace-icon glyphicon glyphicon-list\"></i>\n" +
"                                 </button>\n";
                if(rs.getInt("aceptado") == 0 && permiso.borrar)
                {
                    table += "<button class=\"btn btn-sm btn-danger\"onclick=\"return dropSol(" + rs.getString("idProyecto") + ");\">\n" +
"                                   <i class=\"ace-icon glyphicon glyphicon-remove\"></i>\n" +
"                                 </button>\n";
                }
                table += "</td>\n" +
"                             </tr>";
                i++;
            }
            rs.close();
        } catch (Exception e) {
            table = e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            table = e.getMessage();
        }
        return table;
    }
    
    public String getInfo()
    {
        String response = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Solicitudes_info(?)}");
            
            List<Object> param = new ArrayList<>();
            param.add(this.idProyecto);
            
            ResultSet rs = db.executeCallRead(param);
            
            rs.next();
            response += "titulo:"+rs.getString("titulo")+"&";
            response += "fI:"+rs.getString("fechaInicio")+"&";
            response += "fF:"+rs.getString("fechaFinal")+"&";
            response += "des:"+rs.getString("descripcion")+"&";
            response += "id:"+rs.getString("idProyecto")+"&";
            rs.close();
        } catch (Exception e) {
            response = "error: " + e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }
    
    public String getUpdate()
    {
        String response = "";
        Bdd db = new Bdd();
        
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Solicitudes_update(?,?,?,?,?)}");
            
            List<Object> param = new ArrayList<>();
            param.add(this.idProyecto);
            param.add(this.titulo);
            param.add(this.des);
            param.add(this.fF);
            param.add(this.fI);
            
            db.executeCall(param);
            response="titulo:"+this.titulo+"&id:" + this.idProyecto + "&done:true";
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        return response;
    }
    
    public String getDrop()
    {
        String response = "";
        Bdd db = new Bdd();
        
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Solicitudes_drop(?)}");
            
            List<Object> param = new ArrayList<>();
            param.add(this.idProyecto);
            
            db.executeCall(param);
            response= "id:" + this.idProyecto + "&done:true";
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        return response;
    }
    
    
    public String getInsert()
    {
        String response = "";
        Bdd db = new Bdd();
        
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Solicitudes_insert(?,?,?,?,?)}");
            
            List<Object> param = new ArrayList<>();
            param.add("1");
            param.add(this.titulo);
            param.add(this.des);
            param.add(this.fI);
            param.add(this.fF);
            
            db.executeCall(param);
            
            estado = true;
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        try {
            
            estado = true;
            db.disconnect();
        } catch (Exception e) {
            response = "error: " + e.getMessage() + "&done:flase";
        }
        return response;
    }
}
