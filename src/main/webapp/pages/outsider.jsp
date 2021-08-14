<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                人员来访管理 <small>全部信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/sysLog/findAll.do">人员来访管理</a></li>

                <li class="active">全部信息</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">详细信息</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary" title="刷新"
                                            onclick="window.location.reload();">
                                        <i class="fa fa-refresh"></i> 刷新(添加信息)
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
                                <th class="" style="padding-right: 0px"><input id="selall"
                                                                               type="checkbox"
                                                                               class="icheckbox_square-blue"></th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting">姓名</th>
                                <th class="sorting">性别</th>
                                <th class="sorting">年龄</th>
                                <th class="sorting">来访时间</th>
                                <th class="sorting">离开时间</th>
                                <th class="sorting">电话号码</th>
                                <th class="sorting">备注</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageData.list}" var="one">
                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${one.outId}</td>
                                    <td>${one.outName}</td>
                                    <td>${one.outSex}</td>
                                    <td>${one.outAge}</td>
                                    <td>${one.recordIn}</td>
                                    <td>${one.recordOut}</td>
                                    <td>${one.outPhone}</td>
                                    <td>${one.outDes}</td>
                                    <td>
                                        <button type="button" class="btn btn-success">修改</button>
                                        <button type="button" class="btn btn-danger">删除</button>
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

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <span>当前第${pageData.currentPage}页，共${pageData.totalSize}条数据</span>
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
                <!-- /.box-footer-->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="/commons/foot.jsp"/>
    <!-- 底部导航 /-->

</div>

<%--	导入外部的js代码--%>
<jsp:include page="/commons/js.jsp"/>

<script>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
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

    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>

<script>
    var pageNumber = ${pageData.currentPage};
    var pageSize = ${pageData.pageSize};
    var totalPage = ${pageData.totalPage};

    function goto() {
        window.location.href =
            "${pageContext.request.contextPath}/outsider/getAll?pageNumber=" + pageNumber + "&pageSize=" + pageSize;
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
</body>

</html>