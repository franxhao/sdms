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
    <title>修改员工信息</title>
    <%--	导入外部的js代码--%>
    <jsp:include page="/commons/css.jsp"/>
    <jsp:include page="/commons/js.jsp"/>
</head>
<body>


<%--    <h3>修改员工信息</h3>--%>
   <div class="container">
    <form  method="post" onsubmit="return false;">
        <div class="form-group">
            <label>用户名</label>
            <input id="empUserName" type="text" name="empUserName"   class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>用户密码</label>
            <input id="empPassword" type="text" name="empPassword"
                   class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>姓名</label>
            <input id="empName" type="text" name="empName"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>性别</label>
            <input id="empSex" type="text" name="empSex" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>年龄</label>
            <input id="empAge" type="text" name="empAge"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>职位</label>
            <input id="empJob" type="text" name="empJob" class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>联系电话</label>
            <input id="empPhone" type="text" name="empPhone"   class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>家庭住址</label>
            <input id="empAddress" type="text" name="empAddress"  class="form-control"><br/>
        </div>
        <div class="form-group">
            <label>角色</label> <br/>
            <input id="roleId" type="radio" name="roleId"  checked >宿管<br/>
        </div>
        <div class="form-group">
            <label>寝室楼栋</label>
            <select id="buildId" class="selectpicker form-control" title="-- 请选择楼栋 --" >
                <option class="buildId" value="2">海棠苑男</option>
                <option class="buildId" value="3">桂花苑男</option>
                <option class="buildId" value="4">桂花苑女</option>
                <option class="buildId" value="5">蓝雾苑男</option>
                <option class="buildId" value="6">蓝雾苑女</option>
                <option class="buildId" value="8">海棠苑女</option>
            </select>
<%--            <input id="buildId" type="text" name="buildId"   class="form-control"><br/>--%>
        </div>
        <div class="form-group">
            <label>备注</label>
            <input id="empDes" type="text" name="empDes"   class="form-control"><br/>
        </div>
        <button class="btn btn-success" type="button" onclick="add()">提交</button>
    </form>
  </div>

<script>

    $(function () {
        //页面加载就通过ajax获取数据回显到页面
        $.ajax({
            url:"${pageContext.request.contextPath}/admin/queryEmpById",
            type:"post",
            dataType:"json",
            data:{
                id:${param.empId},
            },
            success:function (data) {
                console.log("数据获取成功");
                $("#empUserName").val(data.empUsername);
                // $("#empPassword1").val(data.empPassword);
                $("#empName").val(data.empName);
                $("#empSex").val(data.empSex);
                $("#empAge").val(data.empAge);
                $("#empJob").val(data.empJob);
                $("#empPhone").val(data.empPhone);
                $("#empAddress").val(data.empAddress);
                $("#roleId").val(data.roleId);
                $("#buildId").val(data.buildId)
                $("#empDes").val(data.empDes);
            }
        });
    })


        //给提交按钮绑定单击事件
        function add(){
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/updateEmp",
                    type: "post",
                    data:{
                        empId:${param.empId},
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
