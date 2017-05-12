<%-- 
    Document   : sideBar
    Created on : 04-27-2017, 10:39:55 AM
    Author     : ascencio
--%>
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
								<li class="active">
									<a href="">
										<i class="menu-icon fa fa-calendar"></i>

										<span class="menu-text">
											Mi Calendario
										</span>
									</a>
									<b class="arrow"></b>
								</li>
								<li class="">
									<a href="">
										<i class="menu-icon fa fa-cubes"></i>

										<span class="menu-text">
											Mis Proyectos
										</span>
									</a>
									<b class="arrow"></b>
								</li>
								<li class="">
									<a href="../../vistas/usuarios/toDoList.jsp">
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
