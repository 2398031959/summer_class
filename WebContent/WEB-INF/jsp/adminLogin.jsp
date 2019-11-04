<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录界面</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function checkAdminLogin() {
		var aUsername = $("#aUsername").val();
		var aPassword = $("#aPassword").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/selectAdmin.action",
					type : "POST",
					data : JSON.stringify({
						aUsername : aUsername,
						aPassword : aPassword
					}),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(message) {
						if (message.msg == "success") {
							window.location.href = "${pageContext.request.contextPath}/toMainAdmin";
						}
						if (message.msg == "fail") {
							$("#tip").html(message.map["tip"]);
						}
					}
				});
	}
	function studentIndex(){
		window.location.href="${pageContext.request.contextPath}/toLogin.action";
	}
</script>
<body>
	<div class="container">
		<div class="row" style="margin-top: 50px">
			<div class="col-md-3 col-md-offset-4">
				<h1>管理员登录</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-md-3 col-md-offset-4" style="color: red" id="tip">
			${msg}
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				用户名：<input type="text" id="aUsername" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" id="aPassword" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<button class="btn btn-success" onclick="checkAdminLogin()">登录</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<button class="btn btn-success" onclick="studentIndex()">学生登录</button>
			</div>
		</div>
	</div>
</body>
</html>