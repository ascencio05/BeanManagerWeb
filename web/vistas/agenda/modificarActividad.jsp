<%-- 
    Document   : modificarActividad
    Created on : 05-11-2017, 05:32:52 PM
    Author     : ascencio
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="controladores.clases.Bdd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            Context initial = new InitialContext();
            Bdd bd = new Bdd(initial,"jdbc/AWS");;
            ResultSet rs =null; 
            String id = request.getParameter("id");           
            String titulo = request.getParameter("titulo");
            String fechaInicial=request.getParameter("fechaInicial");
            String fechaFinal=request.getParameter("fechaFinal");
            String tipoAct=request.getParameter("tipoActividad");
            String descripcion=request.getParameter("descripcion");
            try{
                bd.setCallableQuery("{call modificarActividad(?,?,?,?,?,?)}");
                List<Object> param = new ArrayList<>();
                param.add(id);
                param.add(titulo);
                param.add(fechaInicial);
                param.add(fechaFinal);
                param.add(tipoAct);
                param.add(descripcion);
                bd.executeCall(param);
            }
            catch(Exception e)
            { out.println("Error al modificar: "+e.toString());}
            
%>