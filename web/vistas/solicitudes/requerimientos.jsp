<%-- 
    Document   : requerimientos
    Created on : 05-03-2017, 01:07:45 PM
    Author     : Rodrigo
--%>
<%@page import="java.util.List"%>
<%@page import="controladores.session.Permiso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../../recursos/partes/head.jsp" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-datepicker3.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-timepicker.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/daterangepicker.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-datetimepicker.min.css" />
        <link href="../../recursos/css/Loading.css" rel="stylesheet" type="text/css"/>
        <link href="../../recursos/css/Messages.css" rel="stylesheet" type="text/css"/>
        <style>
            .dataTable {
                vertical-align: text-top;
             }
        </style>
        <title>BeanManager-</title>
    </head>
    
    <%
            Permiso solicitudes = new Permiso();
            if( session != null && session.getAttribute("autenticado") != null && (boolean)session.getAttribute("autenticado"))
                        {
                            List<Permiso> permisos = (List<Permiso>) session.getAttribute("permisos");

                            for(Permiso per : permisos)
                            {
                                if(per.idModulo.equals("3"))
                                {
                                    solicitudes = per;
                                }
                            }
                        }
            else
            {
                response.sendRedirect("../../login.html?failed=true");
            }
            %>
    
    <body class="no-skin">
        <jsp:include page="../../recursos/partes/header.jsp" />

		<div class="main-container ace-save-state hbox" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../../recursos/partes/sideBar.jsp" />
                        <jsp:useBean id="reqTable" class="controladores.solicitudes.Requerimientos" scope="page"></jsp:useBean>
                        <jsp:setProperty name="reqTable" property="*"></jsp:setProperty>
					
			<div class="main-content">
                            <jsp:include page="../../recursos/partes/menu.jsp" />
                            <div class="page-content">
                                <% if(solicitudes.agregar)
                                { %>
                                <div class="page-header">
                                    <div class="text-warning col-sm-12 messages msg errorMsg text-center" id="errorMsg">
                                    </div>
                                    <div class="text-success col-sm-12 messages msg successMsg text-center" id="successMsg">
                                    </div>
                                    <% String app = request.getServerName() + ":" + request.getServerPort() + "/Uploads/Requerimientos/";
                                        if(request.getParameter("titulo") != null) { %>
                                    <div class="text-center">
                                        <h2>Requerimientos del Proyecto:<br> <%=request.getParameter("titulo")%></h2>
                                    </div> 
                                    <div class="text-center">
                                        <button class="btn btn-success" onclick="return openNewr();">Nuevo Requerimiento</button>
                                    </div>   
                                    <% } else { %>
                                    <div class="text-center">
                                        <h2>No se ha seleccionado un proyecto</h2>
                                    </div> 
                                    <% } %>                                    
                                </div>
                                <div class="row col-sm-12" id="table" style="display: none">
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover table-responsive">
                                        <thead>
                                                <th>T&iacute;tulo</th>
                                                <th>Fecha</th>
                                                <th>Archivo</th>
                                                <th></th>
                                        </thead>
                                        <tbody id="bodyTable">
                                            <jsp:setProperty name="reqTable" property="path" value="<%= app %>"></jsp:setProperty>
                                            <jsp:getProperty name="reqTable" property="table"></jsp:getProperty>
                                        </tbody>
                                    </table>	
                                  </div> <%} else { %>
                                <h1>No tiene suficientes permisos </h1> <% } %>
                            </div>
                        </div>
                        <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                
                <!-- ********************** dialogos ************************** -->
                
                <div style="display: none">
                    <div id="frmDetReq" class="scrollable"> 
                        <form>
                            <input type="hidden" name="mode" id="hidMode">
                            <div class="row form-group form-inline">
                                <div class="col-sm-3">
                                    <label>T&iacute;tulo:</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control" id="title"/>
                                </div>
                                <div class="text-warning col-sm-12 msg text-center">
                                </div>
                            </div>
                            <div class="row form-group form-inline">
                                <div class="col-sm-3">
                                    <label>Fecha:</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control" type="date" readonly id="date"/>
                                </div>
                                <div class="text-warning col-sm-12 msg text-center">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div>
                                    <label>Descripci&oacute;n:</label>
                                    <textarea class="form-control" style="resize: none" id="des"></textarea>
                                </div>
                                <div class="text-warning col-sm-12 msg text-center">
                                </div>
                            </div>
                        </form>
                        <form id="frmFile">                          
                            <div class="row form-group">
                                <label>Nuevo Archivo: </label>
                                <input type="file" id="file" name="file">
                                <input type="hidden" id="fileId" name="id">
                            </div>
                        </form>
                    </div>
                </div>
                
                <div style="display: none">
                    <input type="hidden" id="hidId">
                    <input type="hidden" id="hidTitle">
                    <input type="hidden" id="hidDes">
                    <input type="hidden" id="hidMod">
                    <input type="hidden" id="hidIdP" value="<%=request.getParameter("idProyecto") %>">
                </div>
                
                <div style="display: none">
                    <div id="loading">
                        <img src="../../recursos/img/cargando-3.gif" alt="" class="img-responsive"/>
                    </div>
                    <div class="h5 text-center" id="loadingFile" style="display: none">
                        cargando archivo...
                    </div>
                    <form id="reload" action="requerimientos.jsp" method="get">
                        <input type="hidden" name="idProyecto" value="<%= request.getParameter("idProyecto") %>">
                        <input type="hidden" name="titulo" value="<%= request.getParameter("titulo") %>">
                        <input type="hidden" name="msg" id="msg" value="<%= request.getParameter("msg") %>">
                        <input type="hidden" name="msgm" id="msgm" value="<%= request.getParameter("msgm") %>">
                    </form>
                </div>
                
                 <jsp:include page="../../recursos/partes/javaScript.jsp" />
		<script src="../../recursos/plantilla/js/jquery.dataTables.min.js"></script>
		<script src="../../recursos/plantilla/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="../../recursos/plantilla/js/dataTables.buttons.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.flash.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.html5.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.print.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.colVis.min.js"></script>
		<script src="../../recursos/plantilla/js/dataTables.select.min.js"></script>
                <script src="../../recursos/plantilla/js/jquery-ui.min.js" type="text/javascript"></script>
                <script src="../../recursos/js/solicitudes/dialogs.js" type="text/javascript"></script>
                <script src="../../recursos/js/solicitudes/ajax.js" type="text/javascript"></script>
                <script src="../../recursos/js/loading/dialog.js" type="text/javascript"></script>
                <script src="../../recursos/js/Messages.js" type="text/javascript"></script>
                <script src="../../recursos/js/solicitudes/validate.js" type="text/javascript"></script>
                <script type="text/javascript">
                    $(document).ready( function(){
				$('#dynamic-table').DataTable( {
					bAutoWidth: false,
					"aoColumns": [null, null,null,{ "bSortable": false }],
                                        "language":{
                                            "infoEmpty": "No hay información",
                                            "info": "Mostrando página _PAGE_ de _PAGES_",
                                            "emptyTable": "No hay información",
                                            "search": "Buscar: ",
                                            "lengthMenu": "Mostrando _MENU_",
                                            "infoFiltered": "(Filtrado de _MAX_ entradas)",
                                            paginate: {
                                                first: 'Primero',
                                                previous: 'Anterior',
                                                next: 'Siguiente',
                                                last: 'Último'
                                            }
                                        }
			    } );
                            $("#table").show();
			});
		</script>
                
    </body>
</html>	
