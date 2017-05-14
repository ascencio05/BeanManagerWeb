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
        <%
            session = request.getSession();
            String id = (String) session.getAttribute("id");
            %>
    </head>
    
    <body class="no-skin">
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
        <jsp:include page="../../recursos/partes/head.jsp" />
        <jsp:useBean id="solTable" class="controladores.solicitudes.solicitudes" scope="page"></jsp:useBean>
        <jsp:setProperty name="solTable" property="idUsuario" value="<%= id %>"></jsp:setProperty>
        <jsp:setProperty name="solTable" property="permiso" value="<%= solicitudes %>"></jsp:setProperty>
		<div class="main-container ace-save-state hbox" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../../recursos/partes/sideBar.jsp" />
					
			<div class="main-content">
                            <jsp:include page="../../recursos/partes/menu.jsp" />
                            <div class="page-content">
                                <div class="page-header">
                                    
                                    <% if(request.getParameter("i") != null)
                                    { 
                                        if(String.valueOf(request.getParameter("i")).equals("true"))
                                        { %>
                                    <div class="text-success col-sm-12 messages msg successMsg text-center" style="display: block">
                                        Solicitud Agregada
                                    </div>
                                     <% }
                                        else if(String.valueOf(request.getParameter("i")).equals("false"))
                                        { %>
                                    <div class="text-warning col-sm-12 messages msg errorMsg text-center" style="display: block">
                                        Solicitud no agregada
                                    </div>
                                    <% } } %>
                                    <div class="text-warning col-sm-12 messages msg errorMsg text-center" id="errorMsg">
                                    </div>
                                    <div class="text-success col-sm-12 messages msg successMsg text-center" id="successMsg">
                                    </div>
                                    <div class="text-center">
                                        <h2>Solicitudes pendientes</h2>
                                    </div>                                    
                                </div>
                                <div class="row col-sm-12" id="table" style="display: none">
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover table-responsive">
                                        <thead>
                                                <th>T&iacute;tulo</th>
                                                <th>Fecha de Creación</th>
                                                <th>Aceptado</th>
                                                <th>Estado</th>
                                                <th></th>
                                        </thead>
                                        <tbody>
                                            <jsp:getProperty name="solTable" property="table"></jsp:getProperty>
                                        </tbody>
                                    </table>	
                                  </div>
                            </div>
                        </div>
                        <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                
                <!-- ********************** dialogos ************************** -->
                
                <div style="display: none">
                    <form>
                        <input type="hidden" id="hidTitle">
                        <input type="hidden" id="hidFi">
                        <input type="hidden" id="hidFf">
                        <input type="hidden" id="hidDes">
                        <input type="hidden" id="hidId">
                    </form>
                    
                    <form action="requerimientos.jsp" method="post" id="frmShowReq">
                        <input type="hidden" name="idProyecto" id="hidIDP">
                        <input type="hidden" name="titulo" id="hidTP">
                    </form>
                    
                    <div id="frmDetSol" class="scrollable"> 
                            <div class=" form-group form-inline col-xs-12">
                                <div class="col-sm-3">
                                    <label>T&iacute;tulo:</label>
                                </div>
                                <div class="col-sm-9">
                                    <input class="form-control" id="dTitle"/>
                                </div>
                            </div>
                            <div class=" form-group form-inline col-xs-12">
                                <div class="col-sm-3">
                                    <label>Fecha Inicio:</label>
                                </div>
                                <div class="col-sm-9">
                                    <input class="form-control" id="dialogFi"/>
                                </div>
                            </div>
                            <div class="form-group form-inline col-xs-12">
                                <div class="col-sm-3">
                                    <label>Fecha Final:</label>
                                </div>
                                <div class="col-sm-9">
                                    <input class="form-control" id="dialogFf"/>
                                </div>
                            </div>
                            <div class="form-group col-xs-12">
                                <label>Descripci&oacute;n:</label>
                                <textarea class="form-control" style="resize: none" id="dialogDes"></textarea>
                            </div>
                    </div>
                </div>
                
                <div style="display: none">
                    <div id="loading">
                        <img src="../../recursos/img/cargando-3.gif" alt="" class="img-responsive"/>
                    </div>
                </div>
                
                 <jsp:include page="../../recursos/partes/javaScript.jsp" />
		<script src="../../recursos/plantilla/js/jquery.dataTables.min.js"></script>
		<script src="../../recursos/plantilla/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="../../recursos/plantilla/js/dataTables.buttons.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.flash.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.html5.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.print.min.js"></script>
		<script src="../../recursos/plantilla/js/buttons.colVis.min.js"></script>
                <script src="../../recursos/plantilla/js/jquery-ui.min.js" type="text/javascript"></script>
                <script src="../../recursos/js/solicitudes/dialogs.js" type="text/javascript"></script>
                <script src="../../recursos/js/solicitudes/ajax.js" type="text/javascript"></script>
		<script src="../../recursos/plantilla/js/dataTables.select.min.js"></script>
                <script src="../../recursos/js/loading/dialog.js" type="text/javascript"></script>
                <script src="../../recursos/js/Messages.js" type="text/javascript"></script>
                <script type="text/javascript">
                    $(document).ready( function(){
				$('#dynamic-table').DataTable( {
					bAutoWidth: false,
					"aoColumns": [null, null,null,null,{ "bSortable": false }],
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
