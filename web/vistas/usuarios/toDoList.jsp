<%-- 
    Document   : toDoList
    Created on : 12-may-2017, 14:20:12
    Author     : Monica Escrich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<jsp:useBean id="todo" scope="page" class="controladores.usuarios.toDo"/>
<%
String actividad = request.getParameter("addToList");
if(actividad!=null){
    todo.insertActividad(10, actividad);
}
%>
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
								<!-- PAGE CONTENT BEGINS -->



					<div class="page-content">
                                            <div class="row">
                                                
                                                <form name="addToListForm" method="post">
                                                    <div class="col-md-3">
                                                    <input type="text" name="addToList" placeholder="Add Item..."/>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input class="btn btn-info" type="submit" value="Agregar">
                                                    </div>
                                                </form>
                                                
                                            </div>
                                            </br></br>
						<div class="row">
                                                    
							<div class="col-xs-12">
                                                            <div id="timeline-1">
									<div class="row">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1">
											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-primary arrowed-in-right label-lg">
														<b>To Do List</b>
													</span>
												</div>
                                                                                            <% 
                                                                                                try{
                                                                                                ResultSet r= todo.getToDo(10);
                                                                                                
    while (r.next()) {
                                                                                            %>
												<div class="timeline-items">
													
                                                                                                    <div class="timeline-item clearfix" id="<%=r.getInt("idActividad")%>">
														<div class="timeline-info">
															<i class="timeline-indicator ace-icon  btn btn-warning no-hover green"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
                                                                                                                            <h5 class="widget-title smaller"><%=r.getString("actividad")%></h5>
                                                                                                                                    <span class="widget-toolbar">
																	<a href="#" data-action="collapse">
																		<i class="ace-icon fa fa-check"></i>
																	</a>
																</span>
								
															</div>

					
														</div>
                                                                                                    </div>
                                                                                                </div><!-- /.timeline-items -->
                                                                                            <% }
                                                                                            } catch (Exception e) {
                                                                                            %><%=e.toString()%> <%
                                                                                                    }%>
                                                                                        </div><!-- /.timeline-container -->

											
																			</div><!-- /.timeline-items -->
											

										
									</div>
                                        </div>
</div>
			</div><!-- /.main-content -->
</div>
<div class="footer">
	<div class="footer-inner">
		<div class="footer-content">
			<span class="bigger-120">
				<span class="blue bolder">CodeLab Sivar</span> <img src="img/el-salvador.png" style="width:25px;" />
				Bean Manager &copy; 2017
			</span>

			&nbsp; &nbsp;
			<span class="action-buttons">
				<a href="#">
					<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
				</a>

				<a href="#">
					<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
				</a>

				<a href="#">
					<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
				</a>
			</span>
		</div>
	</div>
</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="../../recursos/plantilla/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="../../recursos/plantilla/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../../recursos/plantilla/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../../recursos/plantilla/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->
		<script src="../../recursos/plantilla/js/ace-elements.min.js"></script>
		<script src="../../recursos/plantilla/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('[data-toggle="buttons"] .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					$('[id*="timeline-"]').addClass('hide');
					$('#timeline-'+which).removeClass('hide');
				});
			});
		</script>
	</body>
</html>
