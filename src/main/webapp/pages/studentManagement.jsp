<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<style>
		.downlist{
			position: absolute;
			top: 47px;
			right: 210px !important;
		}
		.fileDown{
			position: absolute;
			top: 53px;
			left: 170px !important;
		}

		.box-tools button:hover {
			background-color: #d4d0c8;
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
				学生信息 <small>学生信息管理</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/role/findAll.do">学生信息管理</a></li>

				<li class="active">学生信息</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 添加学生信息模态框 -->
			<div id="addModal" class="modal fade" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">添加学生信息</h4>
						</div>
						<div class="modal-body">
							<%-- 模态框中间部分 --%>
							<form id="addForm" method="post" onclick="return false">
								<div class="panel panel-default">
									<div class="panel-heading">学生信息</div>
									<div class="row data-type">

										<div class="col-md-2 title">学号</div>
										<div class="col-md-4 data">
											<input id="stuKey" type="text" class="form-control" name="stuKey"
												   placeholder="请填写学生学号">
										</div>
										<div class="col-md-2 title">姓名</div>
										<div class="col-md-4 data">
											<input id="stuName" type="text" class="form-control" name="stuName"
												   placeholder="请填写学生姓名">
										</div>
										<div class="col-md-2 title">性别</div>
										<div class="col-md-4 data">
											<input id="stuSex" type="text" class="form-control" name="stuSex"
												   placeholder="请填写学生性别">
										</div>
										<div class="col-md-2 title">入学日期</div>
										<div class="col-md-4 data">
											<input id="stuEnr" type="text" class="form-control" name="stuEnr"
												   placeholder="如：2000-01-01">
										</div>
										<div class="col-md-2 title">出生日期</div>
										<div class="col-md-4 data">
											<input id="stuBirth" type="text" class="form-control" name="stuBirth"
												   placeholder="如：2000-01-01">
										</div>
										<div class="col-md-2 title">学院</div>
										<div class="col-md-4 data">
											<input id="stuCollege" type="text" class="form-control" name="stuCollege"
												   placeholder="请填写学生所在学院">
										</div>
										<div class="col-md-2 title">专业</div>
										<div class="col-md-4 data">
											<input id="stuMajor" type="text" class="form-control" name="stuMajor"
												   placeholder="请填写学生专业">
										</div>
										<div class="col-md-2 title">班级</div>
										<div class="col-md-4 data">
											<input id="stuClass" type="text" class="form-control" name="stuClass"
												   placeholder="请填写学生所在班级">
										</div>
										<div class="col-md-2 title">家庭住址</div>
										<div class="col-md-4 data">
											<input id="stuAddress" type="text" class="form-control" name="stuAddress"
												   placeholder="请填写学生的家庭住址">
										</div>
										<div class="col-md-2 title">联系方式</div>
										<div class="col-md-4 data">
											<input id="stuTel" type="text" class="form-control" name="stuTel"
												   placeholder="请填写学生的联系方式">
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="add_do()">添加</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->

			<!-- 修改学生信息模态框 -->
			<div id="editModal" class="modal fade" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">修改学生信息</h4>
						</div>
						<div class="modal-body">
							<%-- 模态框中间部分 --%>
							<form id="addForm" method="post" onclick="return false">
								<div class="panel panel-default">
									<div class="panel-heading">学生信息</div>
									<div class="row data-type">

										<div class="col-md-2 title">学号</div>
										<div class="col-md-4 data">
											<input id="stuKey2" type="text" class="form-control" name="stuKey2"
												   placeholder="请填写学生学号" readonly>
										</div>
										<div class="col-md-2 title">姓名</div>
										<div class="col-md-4 data">
											<input id="stuName2" type="text" class="form-control" name="stuName2"
												   placeholder="请填写学生姓名" readonly>
										</div>
										<div class="col-md-2 title">性别</div>
										<div class="col-md-4 data">
											<input id="stuSex2" type="text" class="form-control" name="stuSex2"
												   placeholder="请填写学生性别">
										</div>
										<div class="col-md-2 title">入学日期</div>
										<div class="col-md-4 data">
											<input id="stuEnr2" type="text" class="form-control" name="stuEnr2"
												   placeholder="如：2000-01-01">
										</div>
										<div class="col-md-2 title">出生日期</div>
										<div class="col-md-4 data">
											<input id="stuBirth2" type="text" class="form-control" name="stuBirth2"
												   placeholder="如：2000-01-01">
										</div>
										<div class="col-md-2 title">学院</div>
										<div class="col-md-4 data">
											<input id="stuCollege2" type="text" class="form-control" name="stuCollege2"
												   placeholder="请填写学生所在学院">
										</div>
										<div class="col-md-2 title">专业</div>
										<div class="col-md-4 data">
											<input id="stuMajor2" type="text" class="form-control" name="stuMajor2"
												   placeholder="请填写学生专业">
										</div>
										<div class="col-md-2 title">班级</div>
										<div class="col-md-4 data">
											<input id="stuClass2" type="text" class="form-control" name="stuClass2"
												   placeholder="请填写学生所在班级">
										</div>
										<div class="col-md-2 title">家庭住址</div>
										<div class="col-md-4 data">
											<input id="stuAddress2" type="text" class="form-control" name="stuAddress2"
												   placeholder="请填写学生的家庭住址">
										</div>
										<div class="col-md-2 title">联系方式</div>
										<div class="col-md-4 data">
											<input id="stuTel2" type="text" class="form-control" name="stuTel2"
												   placeholder="请填写学生的联系方式">
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="edit_do()">修改</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->

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
										<button type="button" class="btn btn-default" title="添加" onclick="add()">
											<i class="fa fa-file-o"></i> 添加
										</button>
										
										<button type="button" class="btn btn-default" onclick="location.reload()" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>


									</div>
								</div>
							</div>
							<!-- 文件上传 -->
							<form id="uploadForm" class="fileDown" name="uploadForm" action="${pageContext.request.contextPath}/stuManagement/upload" method="post" enctype="multipart/form-data">
									<input type="file" name="excelFile" onchange="doUpload()"><br/>
							</form>

							<select id="sel" class="selectpicker downlist" multiple title="-- 请选择查询方式 --">
								<option value="sel1">按寝室查询</option>
								<option value="sel2">按学号查询</option>
								<option value="sel3">按姓名查询</option>
								<option value="sel4">按班级查询</option>
								<option value="sel5">按住宿情况查询</option>
							</select>

							<%-- 搜索功能 --%>
							<div class="box-tools pull-right" style="width: 200px">
								<div class="has-feedback" style="width: 150px; vertical-align: top; display:inline-block">
									<input id="search" type="text" style="padding-right: 0" class="form-control input-sm" placeholder="搜索">
<%--									<a class="glyphicon glyphicon-search form-control-feedback" type="button" style="margin-left: 10px"></a>--%>
<%--									<span class="glyphicon glyphicon-search form-control-feedback"></span>--%>
								</div>
								<div style="display: inline-block ">
									<button id="searchbtn" onclick="search_do()" class="glyphicon glyphicon-search" type="button" style="width: 30px;height: 30px; margin-left: -3px; color: skyblue; border: 1px solid #d2d6de;"></button>
								</div>
							</div>

							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">学生学号</th>
										<th class="sorting_asc">姓名</th>
										<th class="sorting_desc">性别</th>
										<th class="sorting">寝室</th>
										<th class="sorting">班级</th>
										<th class="sorting">住宿状态</th>
										<th class="sorting">联系方式</th>
										<th class="sorting">操作</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${STUDENTS.list}" var="one">
									<tr>
										<td><input name="ids" type="checkbox"></td>
										<td>${one.stuKey}</td>
										<td>${one.stuName}</td>
										<td>${one.stuSex}</td>
										<td>${one.room}</td>
										<td>${one.stuClass}</td>
										<td>${one.stuState}</td>
										<td>${one.stuTel}</td>
										<td class="text-center">
											<a href="javascript:" onclick="edit1('${one.stuKey}','${one.stuName}')" class="btn bg-olive btn-xs ">修改</a>
											<a href="#" class="btn bg-red btn-xs" onclick="delete_do('${one.stuKey}','${one.stuName}')">删除</a>
										</td>
									</tr>
									</c:forEach>
								</tbody>

							</table>
							<!--数据列表/-->

						</div>
						<!-- 数据表格 /-->

						<!--分页-->
						<div class="box-footer">
							<div class="pull-left">
								<div class="form-group form-inline">
									<span class="">当前第<strong>${STUDENTS.currentPage}</strong>页，共<strong>${STUDENTS.totalSize}</strong>条数据</span>
								</div>
							</div>

							<div class="box-tools pull-right">
								<ul class="pagination">
									<li>
										<button type="button" class="btn bg-primary" onclick="firstPage()">首页</button>
									</li>
									<li>
										<button type="button" class="btn bg-primary" onclick="previousPage()">上一页</button>
									</li>
									<li>
										<button type="button" class="btn bg-primary" onclick="nextPage()">下一页</button>
									</li>
									<li>
										<button type="button" class="btn bg-primary" onclick="lastPage()">尾页</button>
									</li>
								</ul>
							</div>

						</div>
						<!--分页-->

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
		function doUpload()
		{
			document.getElementById("uploadForm").submit()
		}
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

		$(document).ready(
			function() {

				// 激活导航位置
				setSidebarActive("admin-datalist");

				// 列表按钮
				$("#dataList td input[type='checkbox']").iCheck({
					checkboxClass : 'icheckbox_square-blue',
					increaseArea : '20%'
				});
				// 全选操作
				$("#selall").click(
					function() {
						var clicks = $(this).is(':checked');
						if (!clicks) {
							$("#dataList td input[type='checkbox']").iCheck("uncheck");
						} else {
							$("#dataList td input[type='checkbox']").iCheck("check");
						}
						$(this).data("clicks",!clicks);
				});
		});
	</script>

	<%--分页--%>
	<script>
		var pageNumber = ${STUDENTS.currentPage};
		var pageSize = ${STUDENTS.pageSize};
		var totalPage = ${STUDENTS.totalPage};

		function goto() {
			window.location.href =
					"${pageContext.request.contextPath}/stuManagement/findAll?pageNumber=" + pageNumber + "&pageSize=" + pageSize;
		}

		//首页
		function firstPage() {
			if (pageNumber > 1) {
				pageNumber = 1;
				//跳转页面
				goto();
			}
		}

		//上一页
		function previousPage() {
			if (pageNumber > 1) {
				pageNumber--;
				goto();
			}
		}

		//下一页
		function nextPage() {
			if (pageNumber < totalPage) {
				pageNumber++;
				goto();
			}
		}

		//尾页
		function lastPage() {
			if (pageNumber < totalPage) {
				pageNumber = totalPage;
				goto();
			}
		}
	</script>

	<!-- 引入编写的js文件 -->
	<script src="../js/stuManagement.js"></script>

	<script>
		function search_do() {
			if ($("#sel").val().length > 0){
				$.ajax({
					url:"",
					method:"post",
					contentType:"application/json;charset=utf-8",
					dataType:"text",
					data:JSON.stringify({
						sel:$("#sel").val(),
						search_val:$("#search").val()
					}),
					success:function (data) {

					},
					error:function (err) {
						console.log("search_do err: " + err);
					}
				})
			} else {
				layer.msg("请选择查询条件");
			}
		}
	</script>
</body>

</html>