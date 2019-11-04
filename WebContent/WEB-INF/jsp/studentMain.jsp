<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".col-md-7").css("display", "none");
	});
	//只显示个人信息
	function showMessage() {
		$(".col-md-7").css("display", "none");
		$("#studentMessage").css("display", "block");
	}
	//只显示修改密码
	function showPwd() {
		$(".col-md-7").css("display", "none");
		$("#updatePwd").css("display", "block");
	}
	//只显示我要请假
	function showWriteFack() {
		$(".col-md-7").css("display", "none");
		$("#writeFack").css("display", "block");
	}
	//只显示假条信息
	function showFacks(pageNum,pages) {
		$(".col-md-7").css("display", "none");
		$("#fackList").css("display", "block");
		pageFacks(pageNum, pages);
	}
	//修改按钮
	function update() {
		var sId = $("#sId").val();
		var oldPwd = $("#oldPwd").val();
		var newPwd = $("#newPwd").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/checkOldPwd",
			type : "post",
			data : JSON.stringify({
				sId : sId,
				sPwd : oldPwd
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(message) {
				if (message.msg == "success") {
					$.ajax({
						url : "${pageContext.request.contextPath}/updatePwd",
						type : "post",
						data : JSON.stringify({
							sId : sId,
							sPwd : newPwd
						}),
						contentType : "application/json;charset=UTF-8",
						dataType : "json",
						success : function(message) {
							if (message.msg == "success") {
								$("#oldPwdTip").html("");
								$("#newPwdTip").html("");
								alert("修改成功");
							}
							if (message.msg == "fail") {
								$("#oldPwdTip").html("");
								$("#newPwdTip").html(message.map["errorTip"]);
							}
						}
					});
				}
				if (message.msg == "fail") {
					$("#oldPwdTip").html(message.map["errorTip"]);
				}
			}
		});
	}
	//提交申请按钮
	function insertFack() {
		var fSid = $("#sId").val();
		var fStart = $("#fStart").val();
		var fEnd = $("#fEnd").val();
		var fReason = $("#fReason").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/insertFack",
			type : "post",
			data : JSON.stringify({
				fSid : fSid,
				fStart : fStart,
				fEnd : fEnd,
				fReason : fReason
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				if (rows > 0) {
					alert("申请成功");
					$("#fStart").val("");
					$("#fEnd").val("");
					$("#fReason").val("");
					showFacks();
				}
			}
		});
	}
	//选择页对应的假条
	function pageFacks(pageNum, pages) {
		var fSid = $("#sId").val();
		var pageNum = pageNum;
		var pageSize = 5;
		var pages = pages;
		$
				.ajax({
					url : "${pageContext.request.contextPath}/saveOwnPage",
					type : "post",
					data : JSON.stringify({
						pageNum : pageNum,
						pageSize : pageSize,
						pages : pages
					}),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function() {
						$
								.ajax({
									url : "${pageContext.request.contextPath}/listPageFacks",
									type : "post",
									data : JSON.stringify({
										fSid : fSid,
									}),
									contentType : "application/json;charset=UTF-8",
									dataType : "json",
									success : function(message) {
										$("#list").html("");
										var pageInfo = message.map["pageInfo"];
										var facks = pageInfo.list;
										var pageNum = pageInfo.pageNum;
										var pages = pageInfo.pages;
										var navigateLastPage = pageInfo.navigateLastPage;
										for (var i = 0; i < facks.length; i++) {
											var fId = facks[i].fId;
											var fStart = facks[i].fStart;
											var fEnd = facks[i].fEnd;
											var fReason = facks[i].fReason;
											var fStatus = facks[i].fStatus;
											var list1 = "<div class='row'>"
													+ "<div class='col-md-4' style='border-top:1px solid #000;border-bottom:1px solid #000'>"
													+ "日期：" + fStart + "~"
													+ fEnd + "<br>" + "理由："
													+ fReason + "<br>" + "状态："
													+ fStatus + "</div>";
											var list2;
											if (fStatus == "同意") {
												list2 = "";
											}else if(fStatus == "驳回"){
												list2 ="<div class='col-md-4'>"
													+ "<button class='btn btn-warning' onclick='deleteFack("
													+ fId
													+ ")'>撤回删除</button></div>"
													+ "</div>";
											}
											else {
												list2 = "<div class='col-md-4'>"
														+ "<button class='btn btn-primary' onclick='listUpdate("
														+ fId
														+ ")'>撤回修改</button><br>"
														+ "<button class='btn btn-warning' onclick='deleteFack("
														+ fId
														+ ")'>撤回删除</button></div>"
														+ "</div>";
											}
											var list = list1 + list2;
											$("#list").append(list);
										}
										if (pages > 0) {
											$("#pages").val(pages);
											$("#pageNum").val(pageNum);
											var page = "<div class='row'>"
													+ "<div class='col-md-4 col-md-offset-2'>"
													+ "共"
													+ pages
													+ "页/当前第"
													+ pageNum
													+ "页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
													+ "<a onclick='pageFacks(1,"
													+ pages
													+ ")'>首页</a>&nbsp;&nbsp;"
													+ "<a onclick='pageFacks("
													+ (pageNum - 1)
													+ ","
													+ pages
													+ ")'>上一页</a>&nbsp;&nbsp;"
													+ "<a onclick='pageFacks("
													+ (pageNum + 1)
													+ ","
													+ pages
													+ ")'>下一页</a>&nbsp;&nbsp;"
													+ "<a onclick='pageFacks("
													+ navigateLastPage
													+ ","
													+ pages
													+ ")'>末页</a>&nbsp;&nbsp;"
													+ "</div>" + "</div>";
											$("#list").append(page);
										}
									}
								});
					}
				});
	}
	//退出登录
	function logout() {
		window.location.href = "${pageContext.request.contextPath}/logout";
	}
	//列出需要修改的假条
	function listUpdate(fId) {
		$.ajax({
			url : "${pageContext.request.contextPath}/selectFackById",
			type : "post",
			data : JSON.stringify({
				fId : fId
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(fack) {
				var id = fack.fId;
				var start = fack.fStart;
				var end = fack.fEnd;
				var reason = fack.fReason;
				$("#id").val(id);
				$("#start").val(start);
				$("#end").val(end);
				$("#reason").val(reason);
				$(".col-md-7").css("display", "none");
				$("#updateFack").css("display", "block");
			}
		});
	}
	//修改假条
	function updateFack() {
		var fId = $("#id").val();
		var fStart = $("#start").val();
		var fEnd = $("#end").val();
		var fReason = $("#reason").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/updateFack",
			type : "post",
			data : JSON.stringify({
				fId : fId,
				fStart : fStart,
				fEnd : fEnd,
				fReason : fReason
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				if (rows > 0) {
					alert("修改成功");
					showFacks($("#pageNum").val(),$("#pages").val());
				}
			}
		});
	}
	//删除假条
	function deleteFack(fId) {
		var flag=confirm("确定删除?");
		if(flag==false){
			return null;
		}
		$.ajax({
			url : "${pageContext.request.contextPath}/deleteFack",
			type : "post",
			data : JSON.stringify({
				fId : fId,
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				if (rows > 0) {
					alert("删除成功");
					showFacks($("#pageNum").val(),$("#pages").val());
				}
			}
		});
	}
</script>
<title>学生主页</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-1">
				<h1>欢迎${student.sName}</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-1 col-md-offset-2">
				<ul class="list-unstyled" style="margin-left: -25px;">
					<li onclick="showMessage()">个人信息</li>
					<li onclick="showPwd()">修改密码</li>
					<li onclick="showWriteFack()">我要请假</li>
					<li onclick="showFacks()">假条信息</li>
					<li onclick="logout()">退出登录</li>
				</ul>
			</div>
			<div class="col-md-7" id="studentMessage">
				<table class="table table-bordered">
					<tr>
						<td>学生编号</td>
						<td>${student.sId}</td>
					</tr>
					<tr>
						<td>学生姓名</td>
						<td>${student.sName}</td>
					</tr>
					<tr>
						<td>学生性别</td>
						<td>${student.sSex}</td>
					</tr>
					<tr>
						<td>报名班级</td>
						<td>${student.studentClass.cName}</td>
					</tr>
					<tr>
						<td>班级类型</td>
						<td>${student.classType.ctName}</td>
					</tr>
					<tr>
						<td>补习科目</td>
						<td><c:forEach items="${student.subjects}" var="subject">${subject.subName}&nbsp;&nbsp;&nbsp;</c:forEach></td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td>${student.sPhone}</td>
					</tr>
					<tr>
						<td>居住地址</td>
						<td>${student.sAddress}</td>
					</tr>
					<tr>
						<td>入学时间</td>
						<td><fmt:formatDate value="${student.sDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<td>缴费金额</td>
						<td>${student.sTuition}</td>
				</table>
			</div>
			<div class="col-md-7" id="updatePwd">
				<div class="container">
					<div class="row">
						<div class="col-md-3">
							<input type="hidden" id="sId" value="${student.sId}">
							旧密码：<input type="text" id="oldPwd">
						</div>
						<div class="col-md-3" id="oldPwdTip" style="color: red;"></div>
					</div>
					<div class="row">
						<div class="col-md-3">
							新密码：<input type="text" id="newPwd">
						</div>
						<div class="col-md-3" id="newPwdTip" style="color: red;"></div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<button class="btn btn-primary" onclick="update()">修改</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-7" id="writeFack">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							申请时间：<input type="text" id="fStart" />~<input type="text"
								id="fEnd" />
						</div>
						<div class="col-md-8">申请理由：</div>
						<div class="col-md-8">
							<textarea rows="5" cols="55" style="margin: 5px 20px;"
								id="fReason"></textarea>
						</div>
						<div class="col-md-8">
							<button class="btn btn-primary" onclick="insertFack()">提交申请</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-7" id="fackList">
				<input type="hidden" id="pages"/>
				<input type="hidden" id="pageNum"/>
				<div class="container" id="list">
				</div>
			</div>
			<div class="col-md-7" id="updateFack">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<input type="hidden" id="id" /> 申请时间：<input type="text"
								id="start" />~<input type="text" id="end" />
						</div>
						<div class="col-md-8">申请理由：</div>
						<div class="col-md-8">
							<textarea rows="5" cols="55" style="margin: 5px 20px;"
								id="reason"></textarea>
						</div>
						<div class="col-md-8">
							<button class="btn btn-primary" onclick="updateFack()">修改申请</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>