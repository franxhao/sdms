<%--
  Created by IntelliJ IDEA.
  User: admindgl156
  Date: 2021/8/16
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改楼房信息</title>
    <%--	导入外部的js代码--%>
    <jsp:include page="/commons/css.jsp"/>
    <jsp:include page="/commons/js.jsp"/>
</head>
<body>
<div class="container">
    <form  method="post" onsubmit="return false;">
        <div class="form-group">
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
        <button class="btn btn-success" type="button" onclick="add()">提交</button>
    </form>
</div>
<script>
    $(function edit() {
        //页面加载就通过ajax获取数据回显到页面
        $.ajax({
            url:"${pageContext.request.contextPath}/building/queryBuildById",
            type:"post",
            dataType:"json",
            data:{
                id:${param.buildId},
            },
            success:function (data) {
                console.log("数据获取成功");
                $("#buildName1").val(data.buildName);
                $("#romAmount1").val(data.romAmount);
                $("#floorAmount1").val(data.floorAmount);
                $("#personAmount1").val(data.personAmount);

            }
        });
    })


    //给提交按钮绑定单击事件
    function add(){
        $.ajax({
            url:"${pageContext.request.contextPath}/building/updateBuildDo",
            type: "post",
            data:{
                buildId:${param.buildId},
                buildName: $("#buildName1").val(),
                romAmount: $("#romAmount1").val(),
                floorAmount: $("#floorAmount1").val(),
                personAmount: $("#personAmount1").val(),

            },
            success:function (data) {
                alert("修改成功");
                //刷新父层
                parent.location.reload();
                //关闭本层
                layer_close();
            },
            error:function () {
                console.log("通信错误");
            }
        });
    }
</script>

</body>
</html>
