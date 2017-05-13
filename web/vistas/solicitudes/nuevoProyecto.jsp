<%-- 
    Document   : nuevoProyecto
    Created on : 05-03-2017, 10:48:06 AM
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
        <title>BeanManager-</title>
    </head>
    
    <body class="no-skin">
        <jsp:include page="../../recursos/partes/header.jsp" />

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../../recursos/partes/sideBar.jsp" />
					
			<div class="main-content">
                            <jsp:include page="../../recursos/partes/menu.jsp" />
                            <div class="page-content">
                                <div class="page-header">
                                    <div class="text-center">
                                        <h2>Ingrese los siguientes datos</h2>
                                    </div>                                    
                                </div>
                                <div class="col-xs-offset-1 col-xs-10">
                                    <form class="form-horizontal">
                                        <div class="col-sm-offset-2 col-sm-8">
                                            <input type="text" class="form-control" placeholder="T&iacute;tulo del poryecto"/>
                                            
                                            <div class="col-sm-6 no-padding-left">
                                                <label class="control-label">Fecha de Inicio</label>
                                                <div class="input-group">
                                                    <input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" placeholder="YYYY-MM-DD">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-calendar bigger-110"></i>
                                                        </span>
                                                </div>
                                                <br>
                                            </div>
                                            
                                            <div class="col-sm-6 no-padding-right">
                                                <label class="control-label">Fecha Final</label>
                                                <div class="input-group">
                                                    <input class="form-control date-picker" id="id-date-picker-2" type="text" data-date-format="yyyy-mm-dd" placeholder="YYYY-MM-DD">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-calendar bigger-110"></i>
                                                        </span>
                                                </div>
                                            <br>
                                            </div>
                                            
                                            <textarea class="form-control" rows="8" cols="80" placeholder=" Descripción Corta del Proyecto ..."></textarea>
                                            <br>
                                            <div class="text-center">
                                                <button class="btn btn-success">
                                                    <i class="ace-icon fa fa-check"></i>Aceptar
                                                </button>
                                                <button class="btn btn-danger">
                                                    <i class="ace-icon glyphicon glyphicon-repeat"></i>Borrar
                                                </button>
                                            </div>
                                       </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                 <jsp:include page="../../recursos/partes/javaScript.jsp" />
                 <script src="../../recursos/plantilla/js/bootstrap-datepicker.min.js"></script>
                 <script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../../recursos/plantilla/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function(){
				$(this).prev().focus();
			});

			$('#id-input-file-3').ace_file_input({
	style: 'well',
	btn_choose: 'Drop files here or click to choose',
	btn_change: null,
	no_icon: 'ace-icon fa fa-cloud-upload',
	droppable: true,
	thumbnail: 'small'//large | fit
	//,icon_remove:null//set null, to hide remove/reset button
	/**,before_change:function(files, dropped) {
		//Check an example below
		//or examples/file-upload.html
		return true;
	}*/
	/**,before_remove : function() {
		return true;
	}*/
	,
	preview_error : function(filename, error_code) {
		//name of the file that failed
		//error_code values
		//1 = 'FILE_LOAD_FAILED',
		//2 = 'IMAGE_LOAD_FAILED',
		//3 = 'THUMBNAIL_FAILED'
		//alert(error_code);
	}

}).on('change', function(){
	//console.log($(this).data('ace_input_files'));
	//console.log($(this).data('ace_input_method'));
});

		$(".knob").knob();
		</script>
    </body>
</html>	
