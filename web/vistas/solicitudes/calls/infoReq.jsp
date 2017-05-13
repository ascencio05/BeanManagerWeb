<%-- 
    Document   : infoReq
    Created on : 05-11-2017, 10:30:47 PM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:useBean scope="request" id="req" class="controladores.solicitudes.Requerimientos"></jsp:useBean>
    <jsp:setProperty name="req" property="idRequerimiento" param="id"></jsp:setProperty>    
    <jsp:getProperty name="req" property="info"></jsp:getProperty>
