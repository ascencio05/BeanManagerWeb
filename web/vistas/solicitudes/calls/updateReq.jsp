<%-- 
    Document   : updateReq
    Created on : 05-11-2017, 09:00:56 PM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:useBean scope="request" id="req" class="controladores.solicitudes.Requerimientos"></jsp:useBean>
    <jsp:setProperty name="req" property="*"></jsp:setProperty>    
    <jsp:getProperty name="req" property="modo"></jsp:getProperty>