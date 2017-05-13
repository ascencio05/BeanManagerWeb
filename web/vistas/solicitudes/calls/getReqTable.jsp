<%-- 
    Document   : getReqTable
    Created on : 05-12-2017, 08:50:14 PM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setContentType("application/json"); %>
    <jsp:useBean scope="request" id="req" class="controladores.solicitudes.Requerimientos"></jsp:useBean>
    <jsp:setProperty name="req" property="idProyecto" param="id"></jsp:setProperty>
    <jsp:getProperty name="req" property="table"></jsp:getProperty>