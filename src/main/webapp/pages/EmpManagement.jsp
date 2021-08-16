<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<script type="text/javascript" src="../commons/layer_gp.js"></script>
   <style type="text/css">
	   .modal-dialog {
		   position: absolute;
		   top: 0;
		   bottom: 0;
		   left: 0;
		   right: 0;
	   }

	   .modal-content {
		   /*overflow-y: scroll; */
		   position: absolute;
		   top: 0;
		   bottom: 0;
		   width: 100%;
	   }

	   .modal-body {
		   overflow-y: scroll;
		   position: absolute;
		   top: 55px;
		   bottom: 65px;
		   width: 100%;
	   }

	   .modal-header .close {margin-right: 15px;}

	   .modal-footer {
		   position: absolute;
		   width: 100%;
		   bottom: 0;
	   }
   </style>

<body class="hold-transition skin-blue sidebar-mini">

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
				员工管理 <small>全部员工</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="#">员工管理</a></li>

				<li class="active">全部员工</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

				<!-- 正文区域 -->
				<section class="content"> <!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">列表</h3>
					</div>

					<div class="box-body">

						<!-- 数据表格 -->
						<div class="table-box">

							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<a  class="btn btn-success add"  href="javascript:;" onclick="layer_show('添加员工','${pageContext.request.contextPath}/pages/addEmp.jsp',600,600)">
											<i class="fa fa-file-o"></i> 新建
										</a>
										<a  class="btn btn-success " href="javascript:location.reload()">
											<i class="fa fa-refresh"></i> 刷新
										</a>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input type="text" class="form-control input-sm"
										placeholder="搜索"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</div>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="myTable"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">用户名</th>
										<th class="sorting_desc">姓名</th>
										<th class="sorting">性别</th>
										<th class="sorting">年龄</th>
										<th class="sorting">职位</th>
										<th class="sorting">联系电话</th>
										<th class="sorting">家庭住址</th>
										<th class="sorting">角色信息</th>
										<th class="sorting">寝室楼栋</th>
										<th class="sorting">备注</th>
										<th class="sorting">操作</th>
									</tr>
								</thead>
								<tbody>
                                  <c:forEach items="${employees}" var="one">

									  <tr>
											<td><input name="ids" type="checkbox"></td>
											<td>${one.empUsername}</td>
											<td>${one.empName}</td>
											<td>${one.empSex}</td>
											<td>${one.empAge}</td>
											<td>${one.empJob}</td>
											<td>${one.empPhone}</td>
											<td>${one.empAddress}</td>
											<td>
												<c:if test="${one.roleId==1}">管理员</c:if>
												<c:if test="${one.roleId==2}">宿管</c:if>
											</td><td>${one.buildId}</td>

											<td>${one.empDes}</td>
											<td class="text-center">
												<span style="display: none">${one.empId}</span>
												<a href="javascript:;" class="btn bg-olive btn-xs eUpdate"
												   onclick="layer_show('修改员工信息','${pageContext.request.contextPath}/pages/updateEmp.jsp?empId='+${one.empId},600,600)">修改</a>
												<a href="javascript:;" class="btn bg-red btn-xs eDelete" >删除</a>
											</td>
										</tr>
								  </c:forEach>
								</tbody>

							</table>
							<!--数据列表/-->

						</div>
						<!-- 数据表格 /-->

					</div>
					<!-- /.box-body -->

				</div>

				</section>
				<!-- 正文区域 /-->
			</div>
			<!-- @@close -->
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

			$(document)
					.ready(
							function() {

								// 激活导航位置
								setSidebarActive("admin-datalist");

								// 列表按钮 
								$("#dataList td input[type='checkbox']")
										.iCheck(
												{
													checkboxClass : 'icheckbox_square-blue',
													increaseArea : '20%'
												});
								// 全选操作 
								$("#selall")
										.click(
												function() {
													var clicks = $(this).is(
															':checked');
													if (!clicks) {
														$(
																"#dataList td input[type='checkbox']")
																.iCheck(
																		"uncheck");
													} else {
														$(
																"#dataList td input[type='checkbox']")
																.iCheck("check");
													}
													$(this).data("clicks",
															!clicks);
												});

							});

		</script>

	<script>


		$(function () {
			//删除按钮的
			//询问框
			$(".eDelete").click(function () {
				var empId=$(this).parent().find("span").text();
				layer.confirm("你确定要删除[" + $(this).parent().parent().find("td:eq(1)").text() + "]吗？", {
					btn: ['确定', '取消'] //按钮
				}, function () {
					$.ajax({
						url:"${pageContext.request.contextPath}/admin/deleteEmp",
						type: "post",
						data:{
							id:empId,
						},
						success:function (data) {
							layer.msg('删除成功', {icon: 1});
							location.reload();
						},
						error:function (data) {
							layer.msg('删除失败', {icon: 2});
						}
					});
				}, function () {
					layer.msg('好的咱不删', {icon: 2});
				});
			});
		});

		// //使用DataTables来实现表格的一些功能(比如按价格升降序)
		// var table=  $('#myTable').dataTable( {
		// 	"ordering": true,
		// 	"columnDefs": [
		// 		{ "orderable": false, "targets": 0 },
		// 		{ "orderable": true, "targets": 1 },
		// 		{ "orderable": false, "targets": 2 },
		// 		{ "orderable": false, "targets": 3 },
		// 		{ "orderable": true, "targets": 4 },
		// 	]
		// } );
		// table.order().draw();
	</script>

</body>

</html>