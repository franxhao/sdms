<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>学生宿舍管理系统</title>
<meta name="description" content="学生宿舍管理系统">
<meta name="keywords" content="学生宿舍管理系统">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


	<!--导入外部的css样式文件-->
	<jsp:include page="/commons/css.jsp"/>

	<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				添加学生 <small>学生信息管理</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/role/findAll.do">学生信息管理</a></li>
				<li class="active">添加学生</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form action="${pageContext.request.contextPath}/role/save.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">学生信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">学号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								placeholder="学号" value="">
						</div>
						<div class="col-md-2 title">姓名</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="姓名" value="">
						</div>
						<div class="col-md-2 title">性别</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="性别" value="">
						</div>
						<div class="col-md-2 title">入学日期</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="入学日期" value="">
						</div>
						<div class="col-md-2 title">出生日期</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="出生日期" value="">
						</div>
						<div class="col-md-2 title">学院</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="学院" value="">
						</div>
						<div class="col-md-2 title">专业</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="专业" value="">
						</div>
						<div class="col-md-2 title">班级</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="班级" value="">
						</div>
						<div class="col-md-2 title">家庭住址</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="家庭住址" value="">
						</div>
						<div class="col-md-2 title">联系方式</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="联系方式" value="">
						</div>
						<div class="col-md-2 title">住宿状态</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="住宿状态" value="">
						</div>
						<div class="col-md-2 title">寝室</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleDesc"
								placeholder="寝室" value="">
						</div>


					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">添加</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
         <jsp:include page="/commons/foot.jsp"/>
		<!-- 底部导航 /-->

	</div>


	<%--	导入外部的js代码--%>
	<jsp:include page="/commons/js.jsp"/>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

	</script>
	

</body>

</html>