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
				用户管理 <small>全部用户</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>

				<li class="active">全部用户</li>
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
										<button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/user-add.jsp'">
											<i class="fa fa-file-o"></i> 新建
										</button>
										
										<button type="button" class="btn btn-default" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>
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
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">用户名</th>
										<th class="sorting_asc sorting_asc_disabled">邮箱</th>
										<th class="sorting_desc sorting_desc_disabled">联系电话</th>
										<th class="sorting">具有角色</th>
										<th class="sorting">操作</th>
									</tr>
								</thead>
								<tbody>

										<tr>
											<td><input name="ids" type="checkbox"></td>
											<td>1</td>
											<td>张三</td>
											<td>zhangsan@itcast.cn</td>
											<td>13888888888</td>
											<td class="text-center">
												课程研究员&nbsp;讲师&nbsp;
											</td>
											<td class="text-center">
												<a href="javascript:void(0);" class="btn bg-olive btn-xs">删除</a>
											</td>
										</tr>

                                        <tr>
                                            <td><input name="ids" type="checkbox"></td>
                                            <td>2</td>
                                            <td>李四</td>
                                            <td>lisi@itcast.cn</td>
                                            <td>13999999999</td>
                                            <td class="text-center">
                                                讲师&nbsp;
                                            </td>
                                        </tr>

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
</body>

</html>