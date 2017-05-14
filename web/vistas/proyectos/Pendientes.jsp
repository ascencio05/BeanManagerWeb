<%-- 
    Document   : Pendientes
    Created on : 05-12-2017, 09:19:46 PM
    Author     : jacky
--%>
<jsp:useBean id="proyecto" scope="page" class="controladores.proyectos.proyectos"/>
<jsp:setProperty name="proyecto" property="idUsuario"/>
<jsp:setProperty name="proyecto" property="idProyecto"/>
<jsp:setProperty name="proyecto" property="estado"/>
<jsp:getProperty name="proyecto" property="resultado"/>
	