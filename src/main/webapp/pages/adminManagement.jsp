<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

        .modal-header .close {
            margin-right: 15px;
        }

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
                超级管理员管理 <small>全部管理员</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="#">管理员管理</a></li>

                <li class="active">全部管理员</li>
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
                                    <a class="btn btn-success add" href="javascript:;">
                                        <i class="fa fa-file-o"></i> 新建
                                    </a>
                                    <a class="btn btn-success " href="javascript:location.reload()">
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
                        <table id="dataList"
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
                                <th class="sorting">备注</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageData.list}" var="one">

                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${one.adUsername}</td>
                                    <td>${one.adName}</td>
                                    <td>${one.adSex}</td>
                                    <td>${one.adAge}</td>
                                    <td>${one.adJob}</td>
                                    <td>${one.adPhone}</td>
                                    <td>${one.adAddress}</td>
                                    <td>
                                        <c:if test="${one.roleId==1}">管理员</c:if>
                                        <c:if test="${one.roleId==2}">宿管</c:if>
                                    </td>
                                    <td>${one.adDes}</td>
                                    <td class="text-center">
                                        <span style="display: none">${one.adId}</span>
                                        <a href="javascript:;" class="btn bg-olive btn-xs aUpdate">修改</a>
                                        <a href="javascript:;" class="btn bg-red  btn-xs aDelete">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                        <!--数据列表/-->
                        <!--分页-->
                        <div class="box-footer">
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <span class="">当前第<strong>${pageData.currentPage}</strong>页，共<strong>${pageData.totalSize}</strong>条数据</span>
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
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

            </div>

        </section>
        <!-- 正文区域 /-->

        <!--添加用的模态框 -->
        <div class="modal fade" id="addModal" style="top:20px" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title">添加用户</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" onsubmit="return false;">
                            <div class="form-group">
                                <label>用户名</label>
                                <input id="adUserName" type="text" name="adUserName" value="阳桑"
                                       class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>用户密码</label>
                                <input id="adPassword" type="text" name="adPassword" value="123456"
                                       class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>姓名</label>
                                <input id="adName" type="text" name="adName" value="阳东林" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <input id="adSex" type="text" name="adSex" value="男" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>年龄</label>
                                <input id="adAge" type="text" name="adAge" value="22" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>职位</label>
                                <input id="adJob" type="text" name="adJob" value="管理员" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>联系电话</label>
                                <input id="adPhone" type="text" name="adPhone" value="13456897531" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>家庭住址</label>
                                <input id="adAddress" type="text" name="adAddress" value="金牛区九里提"
                                       class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>角色</label> <br/>
                                <input id="roleId" type="radio" name="roleId" value="1" checked>管理员<br/>
                            </div>
                            <div class="form-group">
                                <label>备注</label>
                                <input id="adDes" type="text" name="adDes" value="啥也没有" class="form-control"><br/>
                            </div>
                            <%--                      <input class="btn btn-success" type="submit" value="提交">--%>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary btn1" data-dismiss="modal">取消</button>
                        <button id="addAjax" type="button" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </div>
        </div>

        <!--修改用的模态框 -->
        <div class="modal fade" id="updateModal" style="top:20px" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title">修改用户</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" onsubmit="return false;">
                            <div class="form-group">
                                <label>用户名</label>
                                <input id="adUserName1" type="text" name="adUserName" value="${admin.adUsername}"
                                       class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>用户密码</label>
                                <input id="adPassword1" type="text" name="adPassword" value="${admin.adPassword}"
                                       class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>姓名</label>
                                <input id="adName1" type="text" name="adName" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <input id="adSex1" type="text" name="adSex" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>年龄</label>
                                <input id="adAge1" type="text" name="adAge" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>职位</label>
                                <input id="adJob1" type="text" name="adJob" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>联系电话</label>
                                <input id="adPhone1" type="text" name="adPhone" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>家庭住址</label>
                                <input id="adAddress1" type="text" name="adAddress" class="form-control"><br/>
                            </div>
                            <div class="form-group">
                                <label>角色</label> <br/>
                                <input id="roleId1" type="radio" name="roleId" checked>管理员<br/>
                            </div>
                            <div class="form-group">
                                <label>备注</label>
                                <input id="adDes1" type="text" name="adDes" class="form-control"><br/>
                            </div>
                            <%--                      <input class="btn btn-success" type="submit" value="提交">--%>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary btn1" data-dismiss="modal">取消</button>
                        <button id="updateAjax" type="button" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </div>
        </div>

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

    $(document)
        .ready(
            function () {

                // 激活导航位置
                setSidebarActive("admin-datalist");

                // 列表按钮
                $("#dataList td input[type='checkbox']")
                    .iCheck(
                        {
                            checkboxClass: 'icheckbox_square-blue',
                            increaseArea: '20%'
                        });
                // 全选操作
                $("#selall")
                    .click(
                        function () {
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
        //给添加功能绑定单击事件
        $(".add").click(function () {
            $("#addModal").modal("show");
            //给添加(Ajax)管理员按钮绑定单击事件
            $("#addAjax").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/addAdmin",
                    type: "post",
                    data: {
                        adUsername: $("#adUserName").val(),
                        adPassword: $("#adPassword").val(),
                        adName: $("#adName").val(),
                        adSex: $("#adSex").val(),
                        adAge: $("#adAge").val(),
                        adJob: $("#adJob").val(),
                        adPhone: $("#adPhone").val(),
                        roleId: $("#roleId").val(),
                        adAddress: $("#adAddress").val(),
                        adDes: $("#adDes").val(),
                    },
                    success: function (data) {
                        alert("添加成功");
                        location.reload();
                    },
                    error: function (data) {
                        console.log("通信错误");
                        alert("通信失败");
                    }
                });
            });


        });

        //删除按钮的
        //询问框
        $(".aDelete").click(function () {
            var adId = $(this).parent().find("span").text();
            layer.confirm("你确定要删除[" + $(this).parent().parent().find("td:eq(1)").text() + "]吗？", {
                btn: ['确定', '取消'] //按钮
            }, function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/deleteAdmin",
                    type: "post",
                    data: {
                        id: adId,
                    },
                    success: function (data) {
                        layer.msg('删除成功', {icon: 1});
                        location.reload();
                    },
                    error: function (data) {
                        layer.msg('删除失败', {icon: 2});
                    }
                });
            }, function () {
                layer.msg('好的咱不删', {icon: 2});
            });
        });

        //修改管理员操作
        $(".aUpdate").click(function () {
            //获取到该id对应的用户信息填充到修改模态框中
            var adId = $(this).parent().find("span").text();
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/queryAdminById",
                type: "post",
                dataType: "json",
                data: {
                    id: adId,
                },
                success: function (data) {
                    console.log("数据获取成功");
                    $("#adUserName1").val(data.adUsername);
                    // $("#adPassword1").val(data.adPassword);
                    $("#adName1").val(data.adName);
                    $("#adSex1").val(data.adSex);
                    $("#adAge1").val(data.adAge);
                    $("#adJob1").val(data.adJob);
                    $("#adPhone1").val(data.adPhone);
                    $("#adAddress1").val(data.adAddress);
                    $("#roleId1").val(data.roleId);
                    $("#adDes1").val(data.adDes);
                }
            });
            $("#updateModal").modal("show");

            //提交修改的操作
            $("#updateAjax").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/updateAdmin",
                    type: "post",
                    data: {
                        adId: adId,
                        adUsername: $("#adUserName1").val(),
                        adPassword: $("#adPassword1").val(),
                        adName: $("#adName1").val(),
                        adSex: $("#adSex1").val(),
                        adAge: $("#adAge1").val(),
                        adJob: $("#adJob1").val(),
                        adPhone: $("#adPhone1").val(),
                        roleId: $("#roleId1").val(),
                        adAddress: $("#adAddress1").val(),
                        adDes: $("#adDes1").val(),
                    },
                    success: function (data) {
                        alert("修改成功");
                        location.reload();
                    },
                    error: function (data) {
                        console.log("通信错误");
                        alert("通信失败");
                    }
                });

            });


        });
    })
</script>

<%--分页--%>
<script>
    var pageNumber = ${pageData.currentPage};
    var pageSize = ${pageData.pageSize};
    var totalPage = ${pageData.totalPage};

    function goto() {
        window.location.href =
            "${pageContext.request.contextPath}/admin/page?pageNumber=" + pageNumber + "&pageSize=" + pageSize;
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