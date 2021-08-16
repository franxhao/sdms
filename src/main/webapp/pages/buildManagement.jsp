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
                楼栋管理 <small>全部楼栋</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/build/findAll.do">楼栋管理</a></li>

                <li class="active">全部楼栋</li>
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
                                    <a class="btn btn-primary add" href="javascript:;">
                                        <i class="fa fa-address-book-o"></i><u>添加</u>
                                    </a>
                                    <button type="button" class="btn btn-primary" title="刷新"
                                            onclick="window.location.reload();">
                                        <i class="fa fa-refresh"></i><u>刷新</u>
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
                                <th class="sorting_asc">楼房编号</th>
                                <th class="sorting_asc">楼房名称</th>
                                <th class="sorting_asc">楼房房间数</th>
                                <th class="sorting_desc">楼房层数</th>
                                <th class="sorting">楼房应住人数</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageData.list}" var="one">

                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${one.buildId}</td>
                                    <td>${one.buildName}</td>
                                    <td>${one.romAmount}</td>
                                    <td>${one.floorAmount}</td>
                                    <td>${one.personAmount}</td>
                                    <td class="text-center">
                                        <span style="display: none">${one.buildId}</span>
<%--                                        <a href="javascript:;" class="btn bg-olive btn-xs eUpdate"--%>
<%--                                           onclick="layer_show('修改楼房信息','${pageContext.request.contextPath}/pages/updateBuild.jsp?buildId='+${one.buildId},600,600)">修改</a>--%>
                                        <button type="button" class="btn btn-success" onclick="edit(${one.buildId})">
                                            修改
                                        </button>
                                        <button type="button" class="btn btn-danger" onclick="deleteOne(${one.buildId})">
                                            删除
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                            <!--数据列表/-->

                        </div>
                        <!-- 数据表格 /-->

                    </div>

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
        </section>
        <!-- 正文区域 /-->
    </div>

</section>
<!-- 正文区域 /-->

<!--添加用的模态框 -->
<div class="modal fade" id="addModal" style="top:20px" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">添加楼房</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" onsubmit="return false;">
                    <div class="form-group">
                        <label>楼房名称</label>
                        <input id="buildName" type="text" name="buildName"
                               class="form-control" placeholder="请输入楼房名称"><br/>
                    </div>
                    <div class="form-group">
                        <label>房间数</label>
                        <input id="romAmount" type="text" name="romAmount"
                               class="form-control" placeholder="请输入房间数"><br/>
                    </div>
                    <div class="form-group">
                        <label>楼层数</label>
                        <input id="floorAmount" type="text" name="floorAmount"
                               class="form-control" placeholder="请输入楼层数"><br/>
                    </div>
                    <div class="form-group">
                        <label>应住人数</label>
                        <input id="personAmount" type="text" name="personAmount"
                               class="form-control" placeholder="应住人数"><br/>
                    </div>
                    <%-- <input class="btn btn-success" type="submit" value="提交">--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn1" data-dismiss="modal">取消</button>
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
                <h3 class="modal-title">修改登记信息</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" onsubmit="return false;">
                    <div class="form-group">
                        <div class="form-group">
                            <label>ID</label>
                            <input id="buildId1" type="text" name="buildId1"
                                   class="form-control" readonly><br/>
                        </div>
                        <label>楼房名称</label>
                        <input id="buildName1" type="text" name="buildName1"
                               class="form-control" placeholder="请输入楼房名称"><br/>
                    </div>
                    <div class="form-group">
                        <label>房间数</label>
                        <input id="romAmount1" type="text" name="romAmount1"
                               class="form-control" placeholder="请输入房间数"><br/>
                    </div>
                    <div class="form-group">
                        <label>楼层数</label>
                        <input id="floorAmount1" type="text" name="floorAmount1"
                               class="form-control" placeholder="请输入楼层数"><br/>
                    </div>
                    <div class="form-group">
                        <label>应住人数</label>
                        <input id="personAmount1" type="text" name="personAmount1"
                               class="form-control" placeholder="应住人数"><br/>
                    </div>
                    <%--                      <input class="btn btn-success" type="submit" value="提交">--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary btn1" data-dismiss="modal">取消</button>
                <button id="updateAjax" type="button" class="btn btn-primary" onclick="edit_do(id)">提交</button>
            </div>
        </div>
    </div>
</div>

</div>

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
                setSidebarActive("build-datalist");

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

    <%--分页--%>
    <script>
    var pageNumber = ${pageData.currentPage};
    var pageSize = ${pageData.pageSize};
    var totalPage = ${pageData.totalPage};

    function goto() {
        window.location.href =
            "${pageContext.request.contextPath}/building/queryAllBuild?pageNumber=" + pageNumber + "&pageSize=" + pageSize;
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

<%--模态框点击事件--%>
<script>
    $(function () {
        $(".add").click(function () {
            $("#addModal").modal("show");
            $("#addAjax").click(function () {
                var build = {
                    buildName: $("#buildName").val(),
                    romAmount: $("#romAmount").val(),
                    floorAmount: $("#floorAmount").val(),
                    personAmount: $("#personAmount").val(),
                }
                $.ajax({
                    url: "${pageContext.request.contextPath}/building/addBuild",
                    type: "post",
                    contentType: "application/json",
                    data: JSON.stringify(build),
                    dataType: "json",
                    success: function (result) {
                        alert("添加成功");
                        location.reload();
                    },
                    error: function (result) {
                        alert("添加失败");
                    }
                });
            });
        });
    })
    //修改模态框添加值
    function edit(id) {
        $("#updateModal").modal("show")
        var build = {buildId: id}
        $.ajax({
            url: "${pageContext.request.contextPath}/building/updateBuild",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(build),
            dataType: "json",
            success: function (result) {
                $("#buildId1").val(result["build"].buildId)
                $("#buildName1").val(result["build"].buildName)
                $("#romAmount1").val(result["build"].romAmount)
                $("#floorAmount1").val(result["build"].floorAmount)
                $("#personAmount1").val(result["build"].personAmount)
            }
        })
    }

    //提交修改信息
    function edit_do() {
        var build = {
            buildId: $("#buildId1").val(),
            buildName: $("#buildName1").val(),
            romAmount: $("#romAmount1").val(),
            floorAmount: $("#floorAmount1").val(),
            personAmount: $("#personAmount1").val(),
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/building/updateBuildDo",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(build),
            dataType: "json",
            success: function (result) {
                alert(result["message"]);
                location.reload();
            },
            error: function (result) {
                alert("添加失败");
            }
        });
    }


    //删除信息
    function deleteOne(id) {
        if (confirm("确定删除这条数据吗？")) {
            var build = {buildId: id}
            $.ajax({
                url: "${pageContext.request.contextPath}/building/deleteBuild",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(build),
                dataType: "json",
                success: function (result) {
                    alert(result["message"])
                    location.reload();
                },
                error: function (result) {
                    alert("错误")
                    console.log(result)
                },
            })
        }

    }
</script>

</body>

</html>