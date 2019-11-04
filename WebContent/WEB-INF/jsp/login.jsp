<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function checkLogin() {
		var sPhone = $("#sPhone").val();
		var sPwd = $("#sPwd").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/selectStudentByPhoneAndPwd.action",
					type : "POST",
					data : JSON.stringify({
						sPhone : sPhone,
						sPwd : sPwd
					}),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(message) {
						if (message.msg=="success") {
							window.location.href = "${pageContext.request.contextPath}/toMainStudent";
						}
						if(message.msg=="fail"){
							$("#tip").html(message.map["tip"]);
						}
					}
				});
	}
	function register() {
		window.location.href = "${pageContext.request.contextPath}/toRegisterStudent.action";
	}
	function toAdminIndex(){
		window.location.href = "${pageContext.request.contextPath}/toAdminLogin.action";
	}
</script>

<body>
	<div class="container">
		<div class="row" style="margin-top: 50px">
			<div class="col-md-3 col-md-offset-4">
				<h1>学生登录</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-md-3 col-md-offset-4" style="color: red" id="tip">
			${msg}
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				用户名：<input type="text" id="sPhone" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" id="sPwd" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<button class="btn btn-success" onclick="checkLogin()">登录</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="btn btn-success" onclick="register()">注册</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<button class="btn btn-success" onclick="toAdminIndex()">管理员登录</button>
			</div>
		</div>
	</div>
</body>
</html>