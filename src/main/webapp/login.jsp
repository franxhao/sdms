<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>学生宿舍管理系统 | Log in</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>十二组</b>学生宿舍管理系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登录系统</p>

			<form action="${pageContext.request.contextPath}/user/login"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" id="username" name="username" class="form-control"
						placeholder="用户名" value="${cookie.name.value}"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
					<span id="errorMsg" style="color: red"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" id="password" class="form-control"
						placeholder="密码" value="${cookie.password.value}"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					管理员<input type="radio" name="flag" value="1" class="form-control">&nbsp; &nbsp; &nbsp; &nbsp;
					员工<input  type="radio" name="flag"   value="2" class="form-control">
				</div>
				<div class="form-group has-feedback">
					<label>验证码：</label>
					<input class="itxt" type="text" name="verification" style="width: 130px;" id="code"/>
					<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 30px ; width:90px; height: 28px">
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input type="checkbox"> 记住密码</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button id="sub_btn" type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

<%--			<a href="#">忘记密码</a><br>--%>


		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/layer-3.5.1/layer.js"></script>

	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});


		$("#username").blur(function () {
			//1.获取用户名
			var username = this.value;
			//2.
			$.ajax({
				url:"${pageContext.request.contextPath}/user/ajaxQueryUsername",
				type:"post",
				data:{
					"username":username,
				},
				dataType:"json",
				success:function (data) {
					console.log(data);
					if(data.existsUsername){
						//true用户名已经存在
						//$("#errorMsg").text("用户名存在");
					}else{
						//false用户名不存在
						if(username == ""){
							//什么也不显示
							$("#errorMsg").text("");
						}else{
							$("#errorMsg").text("用户名不存在");
						}
					}
				}
			});
		});


		//给验证码图片绑定单击事件
		$("#code_img").click(function () {
			//在事件响应的function函数中有一个this函数，这个this对象，是当前正在响应事假的dom对象。
			this.src="${pageContext.request.contextPath}/kaptcha.jpg?d="+new Date();
		});
       $("#sub_btn").click(function () {

		   //验证用户密码：必须由字母，数字下划线组成，并且长度为5-12位
		   //1.获取用户密码输入框里的内容
		   var passwordText =  $("#password").val();
		   //2.创建正则表达式对象
		   var  passwordPatt =/^\w{5,10}$/;
		   //3.使用test方法验证
		   if(!passwordPatt.test(passwordText)){
			   //4.返回false提示用户结果
			   layer.msg("用户密码应在5-10位");
			   return false;
		   }


          //验证码，现在只需要验证用户已输入，因为还没讲到服务器，验证码生成
		  var codeText = $("#code").val();
		  //去掉验证码前后空格
		  codeText =$.trim(codeText);
		  if(codeText == null || codeText == ""){
			  layer.msg("验证码不能为空");
			  return false;
		  }

	  })

	</script>
</body>

</html>