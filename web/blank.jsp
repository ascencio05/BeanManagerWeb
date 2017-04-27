<%-- 
    Document   : agenda
    Created on : 04-27-2017, 09:59:19 AM
    Author     : ascencio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../partes/head.jsp" />
        <title>BeanManager-</title>
    </head>
    
    <body class="no-skin">
        <jsp:include page="../partes/header.jsp" />

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../partes/sideBar.jsp" />
					
			<div class="main-content">
                            <jsp:include page="../partes/menu.jsp" />
                            <div class="page-content">
                                <div class="row">
                                    <div class="col-xs-12">
                                        
                                        //CONTENIDO
                                        
                                    </div>                                    
                                </div>
                            </div>
                        </div>
                </div>
                 <jsp:include page="../partes/javaScript.jsp" />           
    </body>
</html>

								
						