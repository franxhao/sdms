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
				用户管理 <small>用户表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>
				<li class="active">用户表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form action="${pageContext.request.contextPath}/user/save.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">用户信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">用户名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="username"
								placeholder="用户名称" value="">
						</div>
						<div class="col-md-2 title">密码</div>
						<div class="col-md-4 data">
							<input type="password" class="form-control" name="password"
								placeholder="密码" value="">
						</div>
						<div class="col-md-2 title">邮箱</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="email"
								placeholder="邮箱" value="">
						</div>
						<div class="col-md-2 title">联系电话</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="phoneNum"
								placeholder="联系电话" value="">
						</div>
						<div class="col-md-2 title">用户角色</div>
						<div class="col-md-10 data">
							<input class="" type="checkbox" name="roleId" value="1">院长
							<input type="checkbox" name="roleId" value="2">课程研究员
							<input type="checkbox" name="roleId" value="3">讲师
							<input type="checkbox" name="roleId" value="4">助教
							<input type="checkbox" name="roleId" value="5">就业指导
							<input type="checkbox" name="roleId" value="6">班主任
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
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