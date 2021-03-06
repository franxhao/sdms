<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
<%--					获取当前登录的用户名--%>
                  	    <shiro:principal />
				</p>
				<a><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
				<span>系统管理</span> <span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<%--<li><a
						href="${pageContext.request.contextPath}/pages/user-list.jsp">
						<i class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/pages/role-list.jsp">
						<i	class="fa fa-circle-o"></i> 角色管理
					</a></li>--%>
					<li><a
						href="${pageContext.request.contextPath}/stuManagement/findAll"> <i
							class="fa fa-circle-o"></i> 学生信息管理
					</a></li>
                    <shiro:hasRole name="管理员">
                    <li><a
                            href="${pageContext.request.contextPath}/admin/page">
                        <i class="fa fa-circle-o"></i> 管理员管理
                    </a></li>
					</shiro:hasRole>
                    <shiro:hasRole name="管理员">
					<li><a
							href="${pageContext.request.contextPath}/admin/listEmp">
						<i class="fa fa-circle-o"></i> 员工管理
					</a></li>
					</shiro:hasRole>
                    <shiro:hasRole name="管理员">
					<li><a
							href="${pageContext.request.contextPath}/building/queryAllBuild">
						<i class="fa fa-circle-o"></i> 楼房管理
					</a></li>
					</shiro:hasRole>
                    <shiro:hasRole name="管理员">
					<li><a
							href="${pageContext.request.contextPath}/dorm/queryAllDorm">
						<i class="fa fa-circle-o"></i> 寝室管理
					</a></li>
                     </shiro:hasRole>


				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>宿舍管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<%--<li><a
						href="#">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li><a
						href="#">
							<i class="fa fa-circle-o"></i> 订单管理
					</a></li>--%>

<%--					<li><a href="${pageContext.request.contextPath}/pages/syslog-list.jsp">--%>
<%--						<i class="fa fa-circle-o"></i> 访问日志--%>
<%--					</a></li>--%>

					<li><a
							href="${pageContext.request.contextPath}/goods/getAll"> <i
							class="fa fa-circle-o"></i> 存储物品
					</a></li>

					<li><a
							href="${pageContext.request.contextPath}/outsider/getAll"> <i
							class="fa fa-circle-o"></i> 来访人员登记
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
