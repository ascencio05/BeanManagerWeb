<%-- 
    Document   : sideBar
    Created on : 04-27-2017, 10:39:55 AM
    Author     : ascencio
--%>

<%@page import="controladores.solicitudes.solicitudes"%>
<%@page import="controladores.session.Permiso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%
    Permiso solicitudesSideBar = new Permiso();
    if(session.getAttribute("autenticado") != null && (boolean)session.getAttribute("autenticado"))
                {
                    List<Permiso> permisos = (List<Permiso>) session.getAttribute("permisos");
                    
                    for(Permiso per : permisos)
                    {
                        if(per.idModulo.equals("3"))
                        {
                            solicitudesSideBar = per;
                        }
                    }
                }%>
            <div id="sidebar" class="sidebar responsive ace-save-state">
							<script type="text/javascript">
								try{ace.settings.loadState('sidebar')}catch(e){}
							</script>

							<div class="sidebar-shortcuts" id="sidebar-shortcuts">
    
                                                                <img id ="Mascota" class="img-responsive"/>
                                                            	
								<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
									<button class="btn btn-success">
										<i class="ace-icon fa fa-signal"></i>
									</button>

									<button class="btn btn-info">
										<i class="ace-icon fa fa-pencil"></i>
									</button>

									<button class="btn btn-warning">
										<i class="ace-icon fa fa-users"></i>
									</button>

									<button class="btn btn-danger">
										<i class="ace-icon fa fa-cogs"></i>
									</button>
								</div>

								<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
									<span class="btn btn-success"></span>

									<span class="btn btn-info"></span>

									<span class="btn btn-warning"></span>

									<span class="btn btn-danger"></span>
								</div>
							</div><!-- /.sidebar-shortcuts -->

							<ul class="nav nav-list">
								<li class="">
									<a href="">
										<i class="menu-icon fa  fa-child"></i>
										<span class="menu-text"> Mi Perfil </span>
									</a>
									<b class="arrow"></b>
								</li>
								<li>
									<a href="">
										<i class="menu-icon fa fa-calendar"></i>

										<span class="menu-text">
											Mi Calendario
										</span>
									</a>
									<b class="arrow"></b>
								</li>
                                                                
                                                                <% 
                                                                    if(solicitudesSideBar.ingresar)
                                                                    {
                                                                %>
								<li id="liMP" class="">
									<a href="" class="dropdown-toggle">
										<i class="menu-icon fa fa-desktop"></i>

										<span class="menu-text">
											Mis Proyectos
										</span>
									</a>
									<b class="arrow"></b>
                                                                        <ul class="submenu">
                                                                            <li id="1" class="">
                                                                                    <a href="solicitudes.jsp">
                                                                                            <i class="menu-icon fa fa-folder-open"></i>
                                                                                            Ver Proyectos
                                                                                    </a>
                                                                                    <b class="arrow"></b>
                                                                            </li>
                                                                            <% if(solicitudesSideBar.modificar)
                                                                            { %>
                                                                            <li id="2" class="">
                                                                                    <a href="nuevoProyecto.jsp">
                                                                                            <i class="menu-icon fa fa-cloud-upload"></i>
                                                                                            Nuevo Proyecto
                                                                                    </a>
                                                                                    <b class="arrow"></b>
                                                                            </li>
                                                                            <% } %>
                                                                        </ul>
								</li>
                                                                <% } %>
								<li class="">
									<a href="">
										<i class="menu-icon fa fa-pencil-square-o"></i>
										<span class="menu-text"> To do list </span>
									</a>
									<b class="arrow"></b>
								</li>


							</ul><!-- /.nav-list -->

							<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
								<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
							</div>
						</div>
