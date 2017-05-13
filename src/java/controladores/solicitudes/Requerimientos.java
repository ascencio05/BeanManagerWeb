/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.solicitudes;

import controladores.clases.Bdd;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Rodrigo
 */
public class Requerimientos {
    private String idRequerimiento;
    private String idProyecto;
    private String titulo;
    private String des;
    private String date;
    private String mode;
    private String path;

    /**
     * @return the idRequerimiento
     */
    public String getIdRequerimiento() {
        return idRequerimiento;
    }

    /**
     * @param idRequerimiento the idRequerimiento to set
     */
    public void setIdRequerimiento(String idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    /**
     * @return the idProyecto
     */
    public String getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getTable()
    {
        String table = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            int i = 0;
            db.setCallableQuery("{call Requerimientos_select(?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idProyecto);
            
            ResultSet rs = db.executeCallRead(param);
            
            while(rs.next())
            {
                table += "\n" +
"                           <tr id='row" + rs.getString("idRequerimiento") + "'>\n" +
"                              <td id='title" + rs.getString("idRequerimiento") + "'>" + rs.getString("titulo") +"</td>\n" +
"                              <td>" + rs.getString("fecha") + "</td>\n";
                
                if(rs.getString("archivo") == null)
                {
                    table += "<td id='file" + rs.getString("idRequerimiento") + "'>\n" +
"                                                    <div class=\"alert-danger col-xs-offset-4 col-xs-4 text-center h6\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-remove\"></i>\n" +
"                                                    </div>\n" +
"                                                </td>";
                }
                else
                {
                    table += "\n" +
"                                                    <td class='text-center' id='file" + rs.getString("idRequerimiento") + "'><button onclick=\"window.open('http://" + this.path + rs.getString("idRequerimiento") + "/" + rs.getString("archivo") + "')\""
                            + "                         class=\"btn btn-sm btn-success\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-file\"></i>\n" +
"                                                    </button><button class='btn btn-danger btn-sm ace-icon glyphicon glyphicon-remove' onclick=\"ajaxDropFile(" + rs.getString("idRequerimiento") + ")\"</button></td>";
                }
                table += "\n" +
"                                                    <td><button class=\"btn btn-sm btn-primary\" onclick=\"return openDetallesReq(" + rs.getString("idRequerimiento") + ");\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-list\"></i>\n" +
"                                                    </button>" +
"                                                    <button class=\"btn btn-sm btn-danger\" onclick=\"dropReq(" + rs.getString("idRequerimiento") + ",'"+ rs.getString("titulo") + "')\">\n" +
"                                                        <i class=\"ace-icon glyphicon glyphicon-remove\"></i>\n" +
"                                                    </button></td>" +
"                             </tr>";
                i++;
            }
            rs.close();
        } catch (Exception e) {
            table = "error:"+e.getMessage() + " " +this.idProyecto;
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
            int i = 0;
            db.setCallableQuery("{call Requerimientos_select_single(?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idRequerimiento);
            
            ResultSet rs = db.executeCallRead(param);
            
            rs.next();
            response += "titulo:"+rs.getString("titulo")+"&";
            response += "date:"+rs.getString("fecha")+"&";
            response += "des:"+rs.getString("descripcion")+"&";
            response += "id:"+rs.getString("idRequerimiento");
            rs.close();
        } catch (Exception e) {
            response = "error:"+e.getMessage() + " " +this.idProyecto;
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }
    
    public String getModo()
    {
        String result= "";
        switch(Integer.parseInt(this.mode))
        {
            case 0:
                result = Insertar();
                break;
            case 1:
                result = update();
                break;
            case 2:
                result = drop();
                break;
            case 3:
                result = dropFile();
                break;
        }
        return result;
    }
    
    public String drop()
    {
        String result = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Requerimientos_drop(?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idRequerimiento);
            
            db.executeCall(param);
            
            result="done:true&titulo:" + this.titulo + "&id:" + this.idRequerimiento;
        } catch (Exception e) {
            result = "error:"+e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            result = e.getMessage() + "&mode2";
        }
        return result;
    }
    
    public String dropFile()
    {
        String result = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Requerimientos_dropFile(?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idRequerimiento);
            
            db.executeCall(param);
            
            result="done:true&titulo:" + this.titulo + "&id:" + this.idRequerimiento;
        } catch (Exception e) {
            result = "error:"+e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            result = e.getMessage() + "&mode2";
        }
        return result;
    }
    
    public String Insertar()
    {
        String result = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            
            db.setCallableQuery("{call Requerimientos_insert(?,?,?,?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idProyecto);
            param.add(this.titulo);
            param.add(this.des);
            
            db.getCallable().registerOutParameter(4, java.sql.Types.VARCHAR);
            db.executeCall(param,"");
            
            this.idRequerimiento = db.getCallable().getString(4);
            
            result += getInfo();
            
            result +="&done:true";
        } catch (Exception e) {
            result += "error:"+e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            //result = e.getMessage();
        }
        return result;
    }
    
    public String update()
    {
        String result = "";
        Bdd db = new Bdd();
        try {
            Context init = new InitialContext();
            db = new Bdd(init, "jdbc/AWS");
            db.setCallableQuery("{call Requerimientos_update(?,?,?)}");
            List<Object> param = new ArrayList<>();
            param.add(this.idRequerimiento);
            param.add(this.titulo);
            param.add(this.des);
            
            db.executeCall(param);
            
            result="done:true&titulo:" + this.titulo + "&id:" + this.idRequerimiento;
        } catch (Exception e) {
            result = "error:"+e.getMessage();
        }
        try {
            db.disconnect();
        } catch (Exception e) {
            result = e.getMessage() + "&mode2";
        }
        return result;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
}
