<%-- 
    Document   : insertSol
    Created on : 05-12-2017, 10:27:03 PM
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean scope="request" id="sol" class="controladores.solicitudes.solicitudes"></jsp:useBean>
    

    <html>
        <head>
            <link href="../../../recursos/css/Loading.css" rel="stylesheet" type="text/css"/>
            <link href="../../../recursos/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
            <script src="../../../recursos/plantilla/js/jquery-2.1.4.min.js" type="text/javascript"></script>
            <script src="../../../recursos/js/loading/dialog.js" type="text/javascript"></script>
            <script src="../../../recursos/plantilla/js/jquery-ui.min.js" type="text/javascript"></script>
        </head>
        <body>
        <% String id = (String) session.getAttribute("id"); %>
             <img src="../../../recursos/img/cargando-3.gif" alt=""/>
            <jsp:setProperty name="sol" property="*"></jsp:setProperty>   
            <jsp:setProperty name="sol" property="idUsuario" value="<%= id %>"></jsp:setProperty>   
            <jsp:getProperty name="sol" property="insert"></jsp:getProperty>
            <%
                if(sol.isEstado())
                {
                %>
                <script>
                        location.href = "../solicitudes.jsp?i=true";
                </script>
                <%
                    }
               else
                    {
                %>
                <script>
                    location.href = "../solicitudes.jsp?i=false";
                </script>
                <% } %>
    
        </body>
    </html>