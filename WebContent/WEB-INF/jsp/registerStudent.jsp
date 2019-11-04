<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<title>学生注册页面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/countTuition.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		var sTuition = $("#sTuition");
		sTuition.attr("readonly", true);
		var sClasstype = $("#sClasstype");
		$("#sClasstype").change(function() {
			sTuition.val(getTuition(sClasstype));
		});
		$("input:checkbox").click(function() {
			sTuition.val(getTuition(sClasstype));
		});
	});

	function insertStudentAction() {
		var subIds=getSubIds();
		if(subIds==""){
			alert("科目未选择！");
			return null;
		}
		$
				.ajax({
					url : "${pageContext.request.contextPath}/insertStudent.action",
					type : "POST",
					data : JSON.stringify({
						sName : $("#sName").val(),
						sSex : $('input[name="sSex"]:checked').val(),
						sClass : parseInt($("#sClass").val()),
						sClasstype : parseInt($("#sClasstype").val()),
						sPhone : $("#sPhone").val(),
						sAddress : $("#sAddress").val(),
						sTuition : parseInt($("#sTuition").val())
					}),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(message) {
						if (message.msg == "success"
								&& message.map["rows"] >= 1) {
							$("#phoneTip").html("");
							$
									.ajax({
										url : "${pageContext.request.contextPath}/selectsIdByNameAndPhone.action",
										type : "POST",
										data : JSON.stringify({
											sName : $("#sName").val(),
											sPhone : $("#sPhone").val(),
										}),
										contentType : "application/json;charset=UTF-8",
										dataType : "json",
										success : function(sId) {
											if (sId > 0) {
												$
														.ajax({
															url : "${pageContext.request.contextPath}/insertStudentSubject.action",
															type : "POST",
															data : JSON
																	.stringify({
																		sId : sId,
																		subIds : subIds
																	}),
															contentType : "application/json;charset=UTF-8",
															dataType : "json",
															success : function(
																	rows) {
																if (rows > 0) {
																	alert("注册成功");
																	alert("用户名为联系方式\n密码初始为六个0");
																	window.location.href = "${pageContext.request.contextPath}/toLogin.action";
																}
															}
														});
											}
										}
									});
						}
						if (message.msg == "fail") {
							for ( var key in message.map) {
								if (key == "phoneTip") {
									$("#phoneTip").html(message.map[key]);
								}
								if (key == "nullTip") {
									alert(message.map[key]);
									$("#phoneTip").html("");
								}
							}
						}
					}
				});
	}
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				<h1>学生信息表单</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-4">
				姓名：<input type="text" id="sName" />
			</div>
			<div class="col-md-6"></div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				性别： <input type="radio" name="sSex" value="男" />男 <input
					type="radio" name="sSex" value="女" />女
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				报名班级： <select id="sClass">
					<c:forEach items="${clazz}" var="sclass">
						<option value="${sclass.cId}">${sclass.cName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				班级类型： <select id="sClasstype">
					<c:forEach items="${classTypes}" var="classType">
						<option value="${classType.ctId}">${classType.ctName}:${classType.ctPrice}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				科目：<br>
				<c:forEach items="${subjects}" var="subject">
					<input type="checkbox" name="subId" value="${subject.subId}" />${subject.subName}:${subject.subPrice}元<br>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				联系方式： <input type="text" id="sPhone" />
			</div>
			<div class="col-md-5" id="phoneTip" style="color: red;"></div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				家庭住址： <input type="text" id="sAddress" />
			</div>
			<div class="col-md-5"></div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				缴费金额： <input type="text" id="sTuition" value="0" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-4">
				<button class="btn btn-primary" onclick="insertStudentAction()">提交</button>
			</div>
		</div>
	</div>
</body>
</html>