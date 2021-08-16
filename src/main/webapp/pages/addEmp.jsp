<%--
  Created by IntelliJ IDEA.
  User: 14097
  Date: 2021/8/14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
    <%--	导入外部的js代码--%>
    <jsp:include page="/commons/css.jsp"/>
    <jsp:include page="/commons/js.jsp"/>
</head>
<body>


<%--    <h3>添加员工</h3>--%>
   <div class="container">
    <form  method="post" onsubmit="return false;">
        <div class="form-group">
            <label>用户名</label>
            <input id="empUserName" type="text" name="empUserName" value="阳桑"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>用户密码</label>
            <input id="empPassword" type="text" name="empPassword" value="123456"
                   class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input id="empName" type="text" name="empName" value="谢金赤" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>性别</label>
            <input id="empSex" type="text" name="empSex" value="男" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>年龄</label>
            <input id="empAge" type="text" name="empAge" value="22" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>职位</label>
            <input id="empJob" type="text" name="empJob" value="宿管" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>联系电话</label>
            <input id="empPhone" type="text" name="empPhone" value="13456897531"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>家庭住址</label>
            <input id="empAddress" type="text" name="empAddress" value="金牛区九里提"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>角色</label> <br/>
            <input id="roleId" type="radio" name="roleId" value="2" checked >管理员<br/>
        </div>
        <div class="form-group">
            <label>寝室楼栋</label>
            <input id="buildId" type="text" name="buildId" value="1"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>备注</label>
            <input id="empDes" type="text" name="empDes" value="啥也没有"  class="form-control"><br/>
        </div>
        <button class="btn btn-success" type="button" onclick="add()">提交</button>
    </form>
  </div>

<script>
        //给提交按钮绑定单击事件
        function add(){
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/addEmp",
                    type: "post",
                    data:{
                        empUsername: $("#empUserName").val(),
                        empPassword: $("#empPassword").val(),
                        empName: $("#empName").val(),
                        empSex: $("#empSex").val(),
                        empAge: $("#empAge").val(),
                        empJob: $("#empJob").val(),
                        empPhone: $("#empPhone").val(),
                        roleId: $("#roleId").val(),
                        buildId:$("#buildId").val(),
                        empAddress: $("#empAddress").val(),
                        empDes: $("#empDes").val(),
                    },
                    success:function (data) {
                            alert("添加成功");
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
