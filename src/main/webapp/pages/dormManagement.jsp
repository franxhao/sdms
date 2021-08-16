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
                宿舍管理 <small>全部宿舍</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/dorm/findAll.do">宿舍管理</a></li>

                <li class="active">全部宿舍</li>
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
<%--                                <th class="sorting_asc">楼房编号</th>--%>
                                <th class="sorting_asc">寝室编号</th>
                                <th class="sorting_asc">住宿性别</th>
                                <th class="sorting_desc">应住人数</th>
                                <th class="sorting">实住人数</th>
                                <th class="sorting">住宿费用</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageData.list}" var="one">

                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${one.dorId}</td>
                                    <td>${one.dorSex}</td>
                                    <td>${one.dorNum}</td>
                                    <td>${one.dorFact}</td>
                                    <td>${one.dorPrice}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn btn-success" onclick="edit(${one.dorId})">
                                            修改
                                        </button>
                                        <button type="button" class="btn btn-danger" onclick="deleteOne(${one.dorId})">
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
                <!-- /.box-body -->
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
<%--                            <div class="form-group">--%>
<%--                                <label>楼房编号</label>--%>
<%--                                <input id="buildId" type="text" name="buildId"--%>
<%--                                       class="form-control" placeholder="请输入楼房编号"><br/>--%>
<%--                            </div>--%>
                            <div class="form-group">
                                <label>居住性别</label>
                                <input id="dorSex" type="text" name="dorSex"
                                       class="form-control" placeholder="请输入居住性别"><br/>
                            </div>
                            <div class="form-group">
                                <label>应住人数</label>
                                <input id="dorNum" type="text" name="dorNum"
                                       class="form-control" placeholder="请输入应住人数"><br/>
                            </div>
                            <div class="form-group">
                                <label>实住人数</label>
                                <input id="dorFact" type="text" name="dorFact"
                                       class="form-control" placeholder="请输入实住人数"><br/>
                            </div>
                            <div class="form-group">
                                <label>住宿费用</label>
                                <input id="dorPrice" type="text" name="dorPrice"
                                       class="form-control" placeholder="请输入住宿费用"><br/>
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
                        <h3 class="modal-title">修改宿舍信息</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" onsubmit="return false;">
                            <div class="form-group">
                                <div class="form-group">
<%--                                    <label>楼房编号</label>--%>
<%--                                    <input id="buildId1" type="text" name="buildId"--%>
<%--                                           class="form-control" placeholder="请输入楼房编号"><br/>--%>
<%--                                </div>--%>
                                <div class="form-group">
                                    <label>居住性别</label>
                                    <input id="dorId1" type="text" name="dorId1"
                                         class="form-control" readonly="readonly"><br/>
                                </div>
                                <div class="form-group">
                                    <label>居住性别</label>
                                    <input id="dorSex1" type="text" name="dorSex1"
                                           class="form-control" placeholder="请输入居住性别"><br/>
                                </div>
                                <div class="form-group">
                                    <label>应住人数</label>
                                    <input id="dorNum1" type="text" name="dorNum1"
                                           class="form-control" placeholder="请输入应住人数"><br/>
                                </div>
                                <div class="form-group">
                                    <label>实住人数</label>
                                    <input id="dorFact1" type="text" name="dorFact1"
                                           class="form-control" placeholder="请输入实住人数"><br/>
                                </div>
                                <div class="form-group">
                                    <label>住宿费用</label>
                                    <input id="dorPrice1" type="text" name="dorPrice1"
                                           class="form-control" placeholder="请输入住宿费用"><br/>
                                </div>
                            <%--                      <input class="btn btn-success" type="submit" value="提交">--%>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary btn1" data-dismiss="modal">取消</button>
                        <button id="updateAjax" type="button" class="btn btn-primary" onclick="edit_do()">提交</button>
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
<%--分页--%>
<script>
    var pageNumber = ${pageData.currentPage};
    var pageSize = ${pageData.pageSize};
    var totalPage = ${pageData.totalPage};

    function goto() {
        window.location.href =
            "${pageContext.request.contextPath}/dorm/queryAllDorm?pageNumber=" + pageNumber + "&pageSize=" + pageSize;
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
                var dorm = {
                    // buildId: $("#buildId").val(),
                    dorSex: $("#dorSex").val(),
                    dorNum: $("#dorNum").val(),
                    dorFact: $("#dorFact").val(),
                    dorPrice:$("#dorPrice").val(),
                }
                $.ajax({
                    url: "${pageContext.request.contextPath}/dorm/addDorm",
                    type: "post",
                    contentType: "application/json",
                    data: JSON.stringify(dorm),
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
        var dorm = {dorId: id}
        $.ajax({
            url: "${pageContext.request.contextPath}/dorm/updateDorm",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(dorm),
            dataType: "json",
            success: function (result) {
                // $("#buildId1").val(result["dorm"].buildId)
                $("#dorId1").val(result["dorm"].dorId);
                $("#dorSex1").val(result["dorm"].dorSex);
                $("#dorNum1").val(result["dorm"].dorNum);
                $("#dorFact1").val(result["dorm"].dorFact);
                $("#dorPrice1").val(result["dorm"].dorPrice);
            }
        })
    }

    //提交修改信息
    function edit_do() {
        var dorm = {
            // buildId: $("#buildId1").val(),
            dorId: $("#dorId1").val(),
            dorSex: $("#dorSex1").val(),
            dorNum: $("#dorNum1").val(),
            dorFact: $("#dorFact1").val(),
            dorPrice: $("#dorPrice1").val(),
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/dorm/updateDormDo",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(dorm),
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
            var dorm = {dorId: id}
            $.ajax({
                url: "${pageContext.request.contextPath}/dorm/deleteDorm",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(dorm),
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