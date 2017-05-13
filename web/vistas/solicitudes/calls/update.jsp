<%-- 
    Document   : update
    Created on : 05-11-2017, 08:50:31 AM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:useBean scope="request" id="sol" class="controladores.solicitudes.solicitudes"></jsp:useBean>
    <jsp:setProperty name="sol" property="*"></jsp:setProperty>
    <jsp:getProperty name="sol" property="update"></jsp:getProperty>
