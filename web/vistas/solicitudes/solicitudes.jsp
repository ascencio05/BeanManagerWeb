<%-- 
    Document   : requerimientos
    Created on : 05-03-2017, 01:07:45 PM
    Author     : Rodrigo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../../recursos/partes/head.jsp" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-datepicker3.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-timepicker.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/daterangepicker.min.css" />
	<link rel="stylesheet" href="../../recursos/plantilla/css/bootstrap-datetimepicker.min.css" />
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <style>
            .dataTable {
                vertical-align: text-top;
             }
        </style>
        <title>BeanManager-</title>
    </head>
    
    <body class="no-skin">
        <jsp:include page="../../recursos/partes/header.jsp" />

		<div class="main-container ace-save-state hbox" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../../recursos/partes/sideBar.jsp" />
					
			<div class="main-content">
                            <jsp:include page="../../recursos/partes/menu.jsp" />
                            <div class="page-content">
                                <div class="page-header">
                                    <div class="text-center">
                                        <h2>Solicitudes pendientes</h2>
                                    </div>                                    
                                </div>
                                <div class="row col-sm-12" id="table" style="display: none">
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover table-responsive">
                                        <thead>
                                                <th>Id</th>
                                                <th>T&iacute;tulo</th>
                                                <th>Estado</th>
                                                <th></th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>titulo 1</td>
                                                <td>fecha 1</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol();">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>titulo 2</td>
                                                <td>fecha 2</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>titulo 3</td>
                                                <td>fecha 3</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>titulo 4</td>
                                                <td>fecha 4</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>titulo 5</td>
                                                <td>fecha 5</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>titulo 6</td>
                                                <td>fecha 6</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>7</td>
                                                <td>titulo 7</td>
                                                <td>fecha 7</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>8</td>
                                                <td>titulo 8</td>
                                                <td>fecha 8</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>9</td>
                                                <td>titulo 9</td>
                                                <td>fecha 9</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>10</td>
                                                <td>titulo 10</td>
                                                <td>fecha 10</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>11</td>
                                                <td>titulo 11</td>
                                                <td>fecha 11</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>12</td>
                                                <td>titulo 12</td>
                                                <td>fecha 12</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>13</td>
                                                <td>titulo 13</td>
                                                <td>fecha 13</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>14</td>
                                                <td>titulo 14</td>
                                                <td>fecha 14</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>15</td>
                                                <td>titulo 15</td>
                                                <td>fecha 15</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary" onclick="return openDetallesSol()">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger">
                                                        <i class="ace-icon glyphicon glyphicon-file"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>	
                                  </div>
                            </div>
                        </div>
                        <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                
                <!-- ********************** dialogos ************************** -->
                
                <div style="display: none">
                    <div id="frmDetSol" class="scrollable"> 
                        <form>
                            <div class="row form-group form-inline">
                                <div class="col-sm-3">
                                    <label>T&iacute;tulo:</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group form-inline">
                                <div class="col-sm-3">
                                    <label>Fecha Inicio:</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group form-inline">
                                <div class="col-sm-3">
                                    <label>Fecha Final:</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <label>Descripci&oacute;n:</label>
                                <textarea class="form-control" style="resize: none"></textarea>
                            </div>
                        </form>
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
		<script src="../../recursos/plantilla/js/dataTables.select.min.js"></script>
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
