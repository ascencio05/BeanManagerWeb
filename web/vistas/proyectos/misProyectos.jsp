<%-- 
    Document   : misProyectos
    Created on : 05-11-2017, 08:01:48 AM
    Author     : jacky
--%>
<jsp:useBean id="proyecto" scope="page" class="controladores.proyectos.proyectos"/>

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../../recursos/partes/head.jsp" />
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
                                <div class="row">
                                    <div class="col-xs-12">
                                       
                                      <%
                                          try{
                                                ResultSet r = proyecto.consultar(Integer.parseInt(session.getAttribute("id").toString()));
                                                int i = 0;
                                                while(r.next())
                                                {
                                                    
                                                    if(r.getInt("tusActividades")!=0){
                                                     %>
                                            <div class="col-sm-5 infobox-container" style="margin-left: 5%; margin-top: 15px;border-style: solid; border-width: 0.5px; border-color: silver; border-radius: 5px;">
                                        <h2 class="widget-title lighter">
                                                <i class="ace-icon fa fa-star orange"></i>
                                                <%= r.getString("titulo") %>
                                                <br><br>
                                        </h2>
                                      <div class="infobox infobox-red">
                                        <div class="infobox-icon">
                                            <i class="ace-icon fa fa-list-alt"></i>
                                        </div>

                                        <div class="infobox-data">
                                                <span class="infobox-data-number"><%= r.getInt("tusPendientes") %></span>
                                                <div class="infobox-content">
                                                    <%out.print("<a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"javascript:actividades("+Integer.parseInt(session.getAttribute("id").toString())+","+r.getString("idProyecto")+",0)\">Tareas pendientes</a>");%>
                                                </div>    
                                        </div>
                                      </div>

                                        <div class="infobox infobox-green">
                                            <div class="infobox-icon">
                                               <i class="ace-icon fa fa-check"></i>
                                            </div>

                                            <div class="infobox-data">
                                                <span class="infobox-data-number"><%= r.getString("tusTerminadas") %></span>
                                                <div class="infobox-content"><% out.print("<a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"javascript:actividades("+Integer.parseInt(session.getAttribute("id").toString())+","+r.getString("idProyecto")+",1)\">Tareas finalizadas</a>");%></div>
                                            </div>
                                        </div>
                                         <div class="infobox infobox-blue">
                                            <div class="infobox-icon">
                                                    <i class="ace-icon fa fa-calendar"></i>
                                            </div>

                                            <div class="infobox-data">
                                                    <span class="infobox-data-number"><%= r.getString("fechaInicio") %></span>
                                                    <div class="infobox-content">Inicio</div>
                                            </div>
                                        </div>
                                        <div class="infobox infobox-blue2">
                                            <div class="infobox-icon">
                                                    <i class="ace-icon fa fa-calendar-check-o"></i>
                                            </div>

                                            <div class="infobox-data">
                                                    <span class="infobox-data-number"><%= r.getString("fechaFinal") %></span>
                                                    <div class="infobox-content">Fin</div>
                                            </div>
                                        </div>

                                       <div class="space-6"></div> 
                                        <h4>Tu Progreso: <small>
                                       <%
                                            i++;
                                           int tusAc = r.getInt("tusActividades"),
                                              tusterminadas = r.getInt("tusTerminadas");
                                           double Progreso=0;
                                          if(tusAc!=0){
                                                Progreso = (tusterminadas*100)/tusAc;
                                                out.print(Progreso+"%");
                                          }
                                          else
                                          {
                                               out.print(Progreso+"%");
                                          }
                                       %>
                                       </small></h4> 
                                       <div class="col-sm-10 col-md-offset-1" >
                                         <div class="progress progress-striped active">
                                             <div class="progress-bar progress-small progress-bar-<%
                                                    if(Progreso<40)
                                                    {
                                                        out.print("danger");
                                                    }
                                                    else if(Progreso>=40 && Progreso<60)
                                                    {
                                                        out.print("warning");
                                                    }
                                                    else
                                                    {
                                                        out.print("success");
                                                    }
                                                  %>" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(Progreso+"%");%>;">
                                             </div>
                                         </div>
                                       </div>
                                       <div class="space-6"></div> 
                                       <h4>Progreso Total: <small>
                                       <%
                                          int total = r.getInt("Total"),
                                              terminadas = r.getInt("Tterminadas");
                                           double porcentaje=0;
                                          if(total!=0){
                                                porcentaje = (terminadas*100)/total;
                                                out.print(porcentaje+"%");
                                          }
                                          else
                                          {
                                               out.print(porcentaje+"%");
                                          }
                                       %>
                                       </small></h4> 
                                       <div class="col-sm-10 col-md-offset-1" >
                                         <div class="progress progress-striped active">
                                             <div class="progress-bar progress-bar-<%
                                                    if(porcentaje<40)
                                                    {
                                                        out.print("danger");
                                                    }
                                                    else if(porcentaje>=40 && porcentaje<60)
                                                    {
                                                        out.print("warning");
                                                    }
                                                    else
                                                    {
                                                        out.print("success");
                                                    }
                                                  %>" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(porcentaje+"%");%>;">
                                             </div>
                                         </div>
                                       </div>
                                       
                                        <div class="space-6"></div>
                                    </div>
                                        <%
                                            }
                                                }
                                                proyecto.Desc();
                                            }
                                          catch(Exception ex)
                                          {
                                            ex.printStackTrace();
                                          }
                                      %>
                                        
                                         <br/>
                                         <form method="post" action="Actividades.jsp" target="_blank">
                                             <input type="text" name="idProyecto" id="idProy" required="" hidden=""/>
                                             <input type="text" name="estado" id="e" required="" hidden=""/>
                                             <input type="submit" id="boton" value="probando" hidden=""/>
                                         </form>
                                         <!-- Modal-->    
                                         
                                          <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                          <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content">
                                              <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel"></h4>
                                              </div>
                                              <div class="modal-body" id="c">
                                                <table class="table table-hover">
                                                    <thead>
                                                      <tr style="font-weight: bold;">
                                                          <td>N°</td>
                                                          <td>Acividad</td>
                                                          <TD>Descripción</TD>
                                                          <td>fecha Inicio</td>
                                                      </tr> 
                                                      </thead>
                                                      <tbody id="contenedor2">
                                                      </tbody>
                                                </table>
                                             </div>
                                              <div class="modal-footer">
                                                  <button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:limpiar()">Cancelar</button>
                                             </div>
                                            </div>
                                          </div>
                                       </div> 
                                         <!--Fin modal Modal-->
                                         
                                    </div>                                    
                                </div>
                            </div>
                        </div>
                            <jsp:include page="../../recursos/partes/footer.jsp" /> 
                </div>
                 <jsp:include page="../../recursos/partes/javaScript.jsp" />
                 <script type="text/javascript">
                     function actividades(u,n,es)
                     {
                         //alert(document.getElementById("idproyecto"+n).value);
                         //document.getElementById("idProy").value = document.getElementById("idpro"+n).value;
                         //document.getElementById("e").value = es;
                         //document.getElementById("boton").click();
                         if(es==0)
                         {
                             document.getElementById("myModalLabel").innerHTML = "Actividades Pendientes";
                         }
                         else
                         {
                             document.getElementById("myModalLabel").innerHTML = "Actividades Terminadas";
                         }
                         $.post(
                                 "Pendientes.jsp",
                                 {idUsuario: u, idProyecto: n, estado: es},
                                 function(result){
                                     if(result == 0)
                                     {
                                        document.getElementById("contenedor2").innerHTML = "<td colspan=\"4\">\n\
                                        <div class=\" alert alert-success\" style=\"width:100%;\"><strong><i class=\"glyphicon glyphicon-thumbs-up\"></i> \n\
                                        ¡Genial!</strong> No tienes Actividades Pendientes</div></td>"; 
                                     }
                                     else if(result == 1)
                                     {
                                         document.getElementById("contenedor2").innerHTML = "<td colspan=\"4\">\n\
                                        <div class=\" alert alert-warning\" style=\"width:100%;\"><strong><i class=\"glyphicon glyphicon-eye-open\"></i> \n\
                                        <i class=\"glyphicon glyphicon-eye-open\"></i> ¡OJO!</strong> No has terminado ninguna de tus Actividades</div></td>";
                                     }
                                     else{
                                     document.getElementById("contenedor2").innerHTML = result;}
                                     
                                 } 
                                 );
                         
                     }
                     function limpiar()
                     {
                         document.getElementById("contenedor2").innerHTML = "";
                     }
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: ace.vars['old_ie'] ? false : 1000,
						size: size
					});
				})

				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html',
									 {
										tagValuesAttribute:'data-values',
										type: 'bar',
										barColor: barColor ,
										chartRangeMin:$(this).data('min') || 0
									 });
				});


			  //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			  //but sometimes it brings up errors with normal resize event handlers
			  $.resize.throttleWindow = false;

			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "Guadalupe Caballero",  data: 25, color: "#2091CF"},
				{ label: "Monica Escrich",  data: 25, color: "#68BC31"},
				{ label: "Carlos Ascencio",  data: 25, color: "#AF4E96"},
				{ label: "Rodrigo Villacorta",  data: 25, color: "#DA5430"},
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne",
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);

			 var placeholder2 = $('#piechart-placeholder2').css({'width':'90%' , 'min-height':'150px'});
			 var data2 = [
			 { label: "Guadalupe Caballero",  data: 25, color: "#2091CF"},
			 { label: "Monica Escrich",  data: 30, color: "#68BC31"},
			 { label: "Carlos Ascencio",  data: 20, color: "#AF4E96"},
			 { label: "Rodrigo Villacorta",  data: 20, color: "#DA5430"},
			 ]
			 function drawPieChart(placeholder2, data2, position) {
				 $.plot(placeholder2, data2, {
				 series: {
					 pie: {
						 show: true,
						 tilt:0.8,
						 highlight: {
							 opacity: 0.25
						 },
						 stroke: {
							 color: '#fff',
							 width: 2
						 },
						 startAngle: 2
					 }
				 },
				 legend: {
					 show: true,
					 position: position || "ne",
					 labelBoxBorderColor: null,
					 margin:[-30,15]
				 }
				 ,
				 grid: {
					 hoverable: true,
					 clickable: true
				 }
				})
			}
			drawPieChart(placeholder2, data2);

			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);


			  //pie chart tooltip example
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;

			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			 });

				/////////////////////////////////////
				$(document).one('ajaxloadstart.page', function(e) {
					$tooltip.remove();
				});




				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}

				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}

				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}


				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});


				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();

					var off2 = $source.offset();
					//var w2 = $source.width();

					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}


				$('.dialogs,.comments').ace_scroll({
					size: 300
			    });


				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if(ace.vars['touch'] && ace.vars['android']) {
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				  });
				}

				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {
						//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});


				//show the dropdowns on top or bottom depending on window height and menu position
				$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
					var offset = $(this).offset();

					var $w = $(window)
					if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
						$(this).addClass('dropup');
					else $(this).removeClass('dropup');
				});

			})
		</script>
    </body>
</html>								
	