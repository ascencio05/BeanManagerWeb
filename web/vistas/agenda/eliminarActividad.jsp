<%-- 
    Document   : eliminarActividad
    Created on : 05-11-2017, 03:04:46 PM
    Author     : ascencio
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controladores.clases.Bdd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            Context initial = new InitialContext();
            Bdd bd = new Bdd(initial,"jdbc/AWS");;
            try{
                bd.setCallableQuery("{call eliminarActividad(?)}");
                List<Object> param = new ArrayList<>();
                String id = request.getParameter("idActividad");
                param.add(id);
                bd.executeCall(param);
                out.println("Eliminado con exito");
            }
            catch(Exception e)
            {
                out.println("Error al eliminar : "+e.toString());
            }
%>
