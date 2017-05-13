<%-- 
    Document   : agenda
    Created on : 04-27-2017, 09:59:19 AM
    Author     : ascencio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="controladores.clases.Bdd"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../../recursos/partes/head.jsp" />
        <title>BeanManager-</title>
    </head>
    
    <body class="no-skin">
        <%
       try{
        Context initial = new InitialContext();
        Bdd db = new Bdd(initial,"jdbc/AWS");
       }
       catch(Exception e)
       {
            out.println(e.toString());
        }
        
        %>
        <jsp:include page="../../recursos/partes/header.jsp" />

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container');}catch(e){}
			</script>
                        <jsp:include page="../../recursos/partes/sideBar.jsp" />
					
			<div class="main-content">
                            <jsp:include page="../../recursos/partes/menu.jsp" />
					<div class="page-content">



						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-sm-10">
										<div class="space"></div>

										<div id="calendar"></div>
									</div>

									<div class="col-sm-2">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h4>Tipo de Actividad</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="external-events">
														<div class="external-event label-grey" data-class="label-grey">
															<i class="ace-icon fa fa-arrows"></i>
															Codigo
														</div>

														<div class="external-event label-success" data-class="label-success">
															<i class="ace-icon fa fa-arrows"></i>
															Exposicion
														</div>

														<div class="external-event label-danger" data-class="label-danger">
															<i class="ace-icon fa fa-arrows"></i>
															Emergencia
														</div>

														<div class="external-event label-purple" data-class="label-purple">
															<i class="ace-icon fa fa-arrows"></i>
															Salida
														</div>

														<div class="external-event label-yellow" data-class="label-yellow">
															<i class="ace-icon fa fa-arrows"></i>
															Reunion
														</div>

														<div class="external-event label-pink" data-class="label-pink">
															<i class="ace-icon fa fa-arrows"></i>
															Analisis
														</div>

														<div class="external-event label-info" data-class="label-info">
															<i class="ace-icon fa fa-arrows"></i>
															Otro
														</div>
													</div>
												</div>
											</div>
                                                                                    <div class="widget-header">
												<h4>Descripción Actividad: </h4>
                                                                                    </div>
                                                                                    <blockquote>
                                                                                        <p id="descripcion"></p>
                                                                                    </blockquote>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
                        </div>
                    <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                 
                 <jsp:include page="../../recursos/partes/javaScript.jsp" />    
                 <script type="text/javascript">
                         var a=0;
                         var idAc;
                                 var fechaI;
        var fechaF;

			jQuery(function($) {

/* initialize the external events
	-----------------------------------------------------------------*/

	$('#external-events div.external-event').each(function() {

		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
		// it doesn't need to have a start or end
		var eventObject = {
			title: $.trim($(this).text()) // use the element's text as the event title
		};

		// store the Event Object in the DOM element so we can get to it later
		$(this).data('eventObject', eventObject);

		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});

	});




	/* initialize the calendar
	-----------------------------------------------------------------*/

	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();

	var calendar = $('#calendar').fullCalendar({

		buttonHtml: {
			prev: '<i class="ace-icon fa fa-chevron-left"></i>',
			next: '<i class="ace-icon fa fa-chevron-right"></i>'
		},

		header: {
			left: 'prev,next today',
			center: 'title',
			right: ''
		},
		events: [
                    
                        <%
                        try{
                            Context initial = new InitialContext();
                            Bdd db = new Bdd(initial,"jdbc/AWS");
                            String datos="";
                            db.setCallableQuery("{call allActividades(?)}");
                            List<Object> param = new ArrayList<>();
                            int id=Integer.parseInt(session.getAttribute("id").toString());
                            param.add(id);
                            ResultSet rs = db.executeCallRead(param);
                            while(rs.next())
                            {
                                if(rs.getDate("fechaInicio").equals(rs.getDate("fechaFinal")))
                                    datos+="{id:'"+rs.getInt("idActividad")+"',title:'"+rs.getString("titulo")+"',start:'"+rs.getDate("fechaInicio")+"',allDay:true"+",className: '"+rs.getString("descripcion")+"',description:'"+rs.getString("descAct")+"'},";
                                else
                                {
                                    String [] parts = rs.getDate("fechaFinal").toString().split("-");
                                    int diaF=Integer.parseInt(parts[2])+1;
                                    datos+="{id:'"+rs.getInt("idActividad")+"',title:'"+rs.getString("titulo")+"',start:'"+rs.getDate("fechaInicio")+"',end:'"+parts[0]+"-"+parts[1]+"-"+diaF+"',className: '"+rs.getString("descripcion")+"',description:'"+rs.getString("descAct")+"'},";
                                }
                            }
                                out.println(datos);
                                
                           }
                           catch(Exception e)
                           {
                                out.println(e.toString());
                            }
                        
                        
                        %>
		]

                ,
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
                    //display a modal
			var modal2 =
			'<div  class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				 <div class="modal-body">\
				   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
				   <form id="agregarAct" class="no-margin">\
                                   <h3>Agregar Nueva Actividad</h3><br>\
					  <label>Titulo de Actividad &nbsp; </label>\
					  <input required type="text" id="newTitle" class="middle" autocomplete="off"  value=" " />\
                                          <label>Tipo de Actividad: &nbsp; </label>\
                                          <select id="tipoAct">';
                        var modal2=modal2+<%
                         try{
                                Bdd bd = new Bdd();
                                ResultSet rs =null;
                                bd.setCallableQuery("{call tiposActividades()}");
                                List<Object> param = new ArrayList<>();        
                                rs = bd.executeCallRead(param);
                                out.print('"');
                                while(rs.next())
                                {
                                    out.print("<option value='");
                                    out.print(rs.getInt("idTipo"));
                                    out.print("' name='");
                                    out.print(rs.getString("descripcion"));
                                    out.print("'>");
                                    out.print(rs.getString("tipo"));
                                    out.print("</option>");
                                }
                                out.print('"');
                            }
                            catch(Exception e)
                            {
                                out.println("Error al agregar : "+e.toString());
                            }
                        %> ;                
                        modal2= modal2+'</select><br><br>\
                        <label>Fecha Inicio: &nbsp; </label>\
                        <input value="'+start._d.getFullYear()+"-"+(start._d.getMonth()+1)+"-"+start.date()+'" id="newFechaInicial" type="text" pattern="[0-9]{4}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1}" placeholder="YYYY-mm-dd"/>\
                        <label>Fecha Final: &nbsp; </label>\
                        <input value="'+end._d.getFullYear()+"-"+(end._d.getMonth()+1)+"-"+(end.date()-1)+'" id="newFechaFinal" type="text" pattern="[0-9]{4}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1}" placeholder="YYYY-mm-dd"/><br><br>\
                        <div class="col-md-12">\
                        <div class="col-md-6">\
                        <label>Descripción: &nbsp; </label><br>\
                        <textarea type="text" id="newDescripcion"></textarea><br><br>\
                        </div>\
                        <div class="col-md-6"><br>\
                        <button type="submit" class="btn btn-block btn-success"><i class="ace-icon fa fa-check"></i> Crear</button>\
                        </div>\
                        </div>\
                        </form>\
			</div><br><br><br><br>\
			</div>\
			</div>\
			</div>';

                        //ACTUALIZAR TITULO
			var modal2 = $(modal2).appendTo('body');
			modal2.modal('show').on('hidden.bs.modal', function(){
				modal2.remove();
			});
                        
                        modal2.find('form').on('submit', function(ev){
                            ev.preventDefault();
                                var classAct=$('#tipoAct').find(":selected").attr("name");
				var title = $(this).find("#newTitle").val();
                                var tipoA=$('#tipoAct').find(":selected").val();
                                fechaI=$('#newFechaInicial').val();
                                fechaF=$('#newFechaFinal').val();
                                var diaI=parseInt(fechaI.slice(fechaI.lastIndexOf("-")+1,fechaI.length))+1;
                                var diaF=parseInt(fechaF.slice(fechaF.lastIndexOf("-")+1,fechaF.length))+1;
                                var des=$('#newDescripcion').val();
                                var id =Integer.parseInt(session.getAttribute("id").toString());
                                $.post('agregarActividad.jsp', {
                                        idUsuario:id,
                                        titulo: title,
                                        fechaFinal:fechaF,
                                        fechaInicial:fechaI,
                                        tipoActividad:tipoA,
                                        descripcion:des
                                        
                                        }, function(responseText) {
                                     
                                      calendar.fullCalendar('renderEvent',
                                         {
                                            id:responseText.trim(),
                                            title: title,
                                            start: fechaI.slice(0,fechaI.lastIndexOf("-")+1)+diaI,
                                            end: fechaF.slice(0,fechaF.lastIndexOf("-")+1)+diaF,
                                            className: classAct,
                                            description:des,
                                            allDay:true
                                            
                                          },
                                        true // make the event "stick"
                                  );
                                  });  
				modal2.modal("hide");
                                
                                
			});
			calendar.fullCalendar('unselect');
                        
		}
		,
		eventClick: function(calEvent, jsEvent, view) {
                    
                        var fInicial;
                        var fFinal;
                        if(calEvent._end==null)
                            fInicial=fFinal=calEvent._start._i;
                        else
                        {
                            fInicial=calEvent._start._i;
                            fFinal=calEvent._end._i;
                        }
 
			var modal =
			'<div  class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				 <div class="modal-body">\
				   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
				   <form id="agregarAct" class="no-margin">\
                                   <h3>Modificar Actividad</h3><br>\
					  <label>Titulo de Actividad &nbsp; </label>\
					  <input required type="text" id="newTitle" class="middle" autocomplete="off"  value="'+calEvent.title+'" />\
                                          <label>Tipo de Actividad: &nbsp; </label>\
                                          <select id="tipoActividad">';
                        var modal=modal+<%
                         try{
                                Bdd bd = new Bdd();
                                ResultSet rs =null;
                                bd.setCallableQuery("{call tiposActividades()}");
                                List<Object> param = new ArrayList<>();        
                                rs = bd.executeCallRead(param);
                                out.print('"');
                                while(rs.next())
                                {
                                    out.print("<option value='");
                                    out.print(rs.getInt("idTipo"));
                                    out.print("' name='");
                                    out.print(rs.getString("descripcion"));
                                    out.print("'>");
                                    out.print(rs.getString("tipo"));
                                    out.print("</option>");
                                }
                                out.print('"');
                            }
                            catch(Exception e)
                            {
                                out.println("Error al agregar : "+e.toString());
                            }
                        %> ;                
                        modal= modal+'</select><br><br>\
                        <label>Fecha Inicio: &nbsp; </label>\
                        <input value="'+fInicial+'" id="newFechaInicial" type="text" pattern="[0-9]{4}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1}" placeholder="YYYY-mm-dd"/>\
                        <label>Fecha Final: &nbsp; </label>\
                        <input value="'+fFinal+'" id="newFechaFinal" type="text" pattern="[0-9]{4}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1}" placeholder="YYYY-mm-dd"/><br><br>\
                        <div class="col-md-12">\
                        <div class="col-md-6">\
                        <label>Descripción: &nbsp; </label><br>\
                        <textarea type="text" id="newDescripcion">'+calEvent.description+'</textarea><br><br>\
                        </div>\
                        <div class="col-md-6"><br>\
                        <button type="submit" class="btn btn-sm btn-block btn-info"><i class="ace-icon fa fa-floppy-o"></i> Guardar</button>\
                        <button type="button" class="btn btn-sm btn-block btn-warning" data-action="complete"><i class="ace-icon fa fa-check"></i> Finalizar Actividad</button>\
                        <button type="button" class="btn btn-sm btn-block btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> Eliminar Actividad</button>\
                        </div>\
                        </div>\
                        </form>\
			</div><br><br><br><br><br><br><br>\
			</div>\
			</div>\
			</div>';
                          

                       
			var modal = $(modal).appendTo('body');
                        
                        
                        modal.find('form').on('submit', function(ev){
                            
                                ev.preventDefault();
                                
				var title = $(this).find("#newTitle").val();
                                var tipoA=$('#tipoActividad').find(":selected").val();
                                var tipoB=$('#tipoActividad').find(":selected").attr("name");
                                fechaI=$('#newFechaInicial').val();
                                fechaF=$('#newFechaFinal').val();
                                var diaI=parseInt(fechaI.slice(fechaI.lastIndexOf("-")+1,fechaI.length))+1;
                                var diaF=parseInt(fechaF.slice(fechaF.lastIndexOf("-")+1,fechaF.length))+1;
                                var des=$('#newDescripcion').val();
                                $.post('modificarActividad.jsp', {
                                        id:calEvent._id,
                                        titulo: title,
                                        fechaFinal:fechaF,
                                        fechaInicial:fechaI,
                                        tipoActividad:tipoA,
                                        descripcion:des
                                        
                                        }, function(responseText) {
                                         if(fechaF==fechaI)
                                             calEvent.end=null;
                                         else
                                         {
                                             calEvent.start=fechaI;
                                             calEvent.end=fechaF;
                                         }
                                         calEvent.title=title;
                                         calEvent.description=des;
                                         calEvent.className=tipoB;
                                          $('#calendar').fullCalendar('updateEvent', calEvent);
                                  });  
                                    
				modal.modal("hide");
                                
                                
			});
			calendar.fullCalendar('unselect');
                        
                        //////////////////////
                        //ELIMINA EVENTO
			modal.find('button[data-action=delete]').on('click', function() {

                                $.post('eliminarActividad.jsp', {
                                        idActividad: calEvent._id
                                }, function(responseText) {
                                      
                                });
                                
				calendar.fullCalendar('removeEvents' , function(ev){
					return (ev._id == calEvent._id);
				})
				modal.modal("hide");
                                
			});
                        
                        
                        //////////////////////
                        //Completo EVENTO
			modal.find('button[data-action=complete]').on('click', function() {

                                $.post('completarActividad.jsp', {
                                        idActividad: calEvent._id
                                }, function(responseText) {
                                      
                                });
                                
				calendar.fullCalendar('removeEvents' , function(ev){
					return (ev._id == calEvent._id);
				})
				modal.modal("hide");
                                
			});
                        //////////////////////////////////////
                        
			modal.modal('show').on('hidden.bs.modal', function(){
				modal.remove();
			});
		},
         
         eventMouseover:function( event, jsEvent, view ) { 
             document.getElementById("descripcion").innerHTML=event.description;
            }

	});


});
		</script>
    </body>
</html>

								
						