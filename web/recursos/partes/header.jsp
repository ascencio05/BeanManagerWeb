<%-- 
    Document   : header
    Created on : 04-27-2017, 10:38:09 AM
    Author     : ascencio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="controladores.clases.Bdd"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>

	<% String gui = session.getAttribute("gui").toString();%>
        
<div id="navbar" class="navbar navbar-default" style="background-color: #<%= gui %>">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar" style="background-color: #555555">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left col-xs-6">
					<a href="index.html" class="navbar-brand">
						<small>
                                                    <div class="col-md-1 col-xs-2">
                                                          <img src="../../recursos/img/FrijolLinealBlanco.png" class="img-responsive"/>
                                                    </div>

                                                    <b>Bean Manager</b>
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span class="badge badge-important">0</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-check"></i>
									4 Tasks to complete
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Software Update</span>
													<span class="pull-right">65%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:65%" class="progress-bar"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Hardware Upgrade</span>
													<span class="pull-right">35%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:35%" class="progress-bar progress-bar-danger"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Unit Testing</span>
													<span class="pull-right">15%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:15%" class="progress-bar progress-bar-warning"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Bug Fixes</span>
													<span class="pull-right">90%</span>
												</div>

												<div class="progress progress-mini progress-striped active">
													<div style="width:90%" class="progress-bar progress-bar-success"></div>
												</div>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="#">
										See tasks with details
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="grey dropdown-modal">
							<%
                                                        int Contador=0;
                                                        String Datos="";
                                                        try{
                                                        Context initial = new InitialContext();
                                                        Bdd db = new Bdd(initial,"jdbc/AWS");
                                                        out.println("");
                                                        db.setCallableQuery("{call fechaActividades(?,?)}");
                                                        List<Object> param = new ArrayList<>();
                                                        Calendar c1 = Calendar.getInstance();
               
                                                        String dia = Integer.toString(c1.get(Calendar.DATE));
                                                        String mes = Integer.toString(c1.get(Calendar.MONTH)+1);
                                                        String annio = Integer.toString(c1.get(Calendar.YEAR));

                                                        String fecha=annio+"-"+mes+"-"+dia;
                                                        int id=Integer.parseInt(session.getAttribute("id").toString());
                                                        param.add(id);
                                                        param.add(fecha);
                                                        ResultSet rs = db.executeCallRead(param);
                                                        
                                                        while(rs.next())
                                                        {
                                                            Contador++;
                                                            String Pivote="";
                                                            switch(rs.getInt("idTipo"))
                                                            {
                                                                case 1:
                                                                     Pivote="fa fa-code";
                                                                  break;
                                                                case 2:
                                                                     Pivote="fa fa-paint-brush";
                                                                   break;
                                                                case 4:
                                                                     Pivote="fa fa-exclamation-triangle";
                                                                   break;    
                                                                case 5:
                                                                     Pivote="fa fa-sign-out";
                                                                   break;
                                                                case 6:
                                                                     Pivote="fa fa-users";
                                                                   break;
                                                                case 7:
                                                                     Pivote="fa fa-line-chart";
                                                                   break;
                                                                case 8:
                                                                     Pivote="fa fa-bug";
                                                                   break;
                                                                default:
                                                                     Pivote="fa fa-user";
                                                                    break;
                                                            }
                                                           Datos+="<li><a href='#'><i class='btn btn-xs "+Pivote+" "+rs.getString("descripcion")+"'></i> "+rs.getString("titulo")+"</a></li>";
                                                        }

                                                       }
                                                       catch(Exception e)
                                                       {
                                                            out.println(e.toString());
                                                        }

                                                    %>
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important"><%out.println(Contador);%></span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-blue dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-exclamation-triangle"></i>
									<%out.println(Contador);%> Actividades
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar navbar-pink">
										<%
                                                                                out.println(Datos);
                                                                                %>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="../agenda/agenda.jsp">
										Mirar Todas las Actividades
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="grey dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
		
								<span class="user-info">
									<small>Bienvenido,</small>
                                                                        <%
                                                                            out.println(session.getAttribute("nombre").toString()+","+session.getAttribute("apellido").toString());  
                                                                        %>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Perfil  
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="../../LogOut">
										<i class="ace-icon fa fa-power-off"></i>
										Cerrar Sesion
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
                                                                