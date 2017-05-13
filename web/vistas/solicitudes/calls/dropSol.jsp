<%-- 
    Document   : drop
    Created on : 05-11-2017, 11:38:03 AM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:useBean scope="request" id="sol" class="controladores.solicitudes.solicitudes"></jsp:useBean>
    <jsp:setProperty name="sol" property="idProyecto" param="id"></jsp:setProperty>
    <jsp:getProperty name="sol" property="drop"></jsp:getProperty>
