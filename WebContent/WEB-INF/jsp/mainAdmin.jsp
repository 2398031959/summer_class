<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页面</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/formatDate.js"></script>
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
	$(document).ready(function() {
		$(".col-md-8").css("display", "none");
	});
	/* 初始化学生列表 */
	function listStudentIndex() {
		$(".col-md-8").css("display", "none");
		var pageSize = 5;
		var pageNum = 1;
		$
				.ajax({
					url : "${pageContext.request.contextPath}/selectAllStudent",
					type : "post",
					data : {
						pageSize : pageSize,
						pageNum : pageNum
					},
					dataType : "json",
					success : function(pageStudent) {
						$("#sName").val(null);
						$("#sClass").val(0);
						$("#sClasstype").val(0);
						$("#studentList").css("display", "block");
						$("#students").html("");
						var tabel_header = "<tr><td>姓名</td><td>性别</td><td>班级</td><td>班级类型</td><td>联系方式</td><td>居住地址</td><td>入学日期</td><td>学费</td><td>操作</td></tr>"
						$("#students").append(tabel_header);
						studentTableAdd(pageStudent);
						studentPageAdd(pageStudent);
					}
				});
	}
	/* 查询符合条件的学生列表 */
	function studentsByselectStudent(pageNum) {
		var sName = $("#sel_sName").val();
		var sClass = $("#sel_sClass").val();
		var sClasstype = $("#sel_sClasstype").val();
		if (pageNum == null) {
			pageNum = 1;
		}
		$
				.ajax({
					url : "${pageContext.request.contextPath}/studentsByselectStudent",
					type : "post",
					data : {
						sName : sName,
						sClass : sClass,
						sClasstype : sClasstype,
						pageNum : pageNum
					},
					dataType : "json",
					success : function(pageStudent) {
						$("#students").html("");
						var tabel_header = "<tr><td>姓名</td><td>性别</td><td>班级</td><td>班级类型</td><td>联系方式</td><td>居住地址</td><td>入学日期</td><td>学费</td><td>操作</td></tr>"
						$("#students").append(tabel_header);

						studentTableAdd(pageStudent);
						studentPageAdd(pageStudent);
					}
				});
	}
	/* 学生列表的页面跳转 */
	function studentSkip(pageNum, pages) {
		var sName = $("#sel_sName").val();
		var sClass = $("#sel_sClass").val();
		var sClasstype = $("#sel_sClasstype").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/studentSkip",
					type : "post",
					data : {
						sName : sName,
						sClass : sClass,
						sClasstype : sClasstype,
						pageNum : pageNum,
						pages : pages
					},
					dataType : "json",
					success : function(pageStudent) {
						$("#students").html("");
						var tabel_header = "<tr><td>姓名</td><td>性别</td><td>班级</td><td>班级类型</td><td>联系方式</td><td>居住地址</td><td>入学日期</td><td>学费</td><td>操作</td></tr>"
						$("#students").append(tabel_header);
						studentTableAdd(pageStudent);
						studentPageAdd(pageStudent);
					}
				});
	}
	/*列出待修改的学生信息*/
	function updateBefore(sPhone, sPwd) {
		$.ajax({
			url : "${pageContext.request.contextPath}/updateBefore",
			type : "post",
			data : JSON.stringify({
				sPhone : sPhone,
				sPwd : sPwd
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(student) {
				$("input[type=checkbox][name=subId]").prop("checked", false);

				$("#studentList").css("display", "none");
				$("#updateBefore").css("display", "block");

				$("#sId").val(student.sId);
				$("#sName").val(student.sName);
				var sSex = student.sSex;
				$("input[type=radio][name=sSex][value='" + sSex + "']").prop(
						"checked", true);
				$("#sSex").val(student.sSex);
				$("#sClass").val(student.sClass);
				$("#sClasstype").val(student.sClasstype);
				var subjects = student.subjects;
				for (var i = 0; i < subjects.length; i++) {
					$(
							"input[type=checkbox][name=subId][value='"
									+ subjects[i].subId + "']").prop("checked",
							true);
				}
				$("#sPhone").val(student.sPhone);
				$("#sAddress").val(student.sAddress);
				$("#sTuition").val(student.sTuition);
			}
		});
	}
	/* 修改信息 */
	function updateStudent() {
		var sId = $("#sId").val();
		var sName = $("#sName").val();
		var sSex = $('input[name="sSex"]:checked').val();
		var sPhone = $("#sPhone").val();
		var sClass = $("#sClass").val();
		var sClasstype = $("#sClasstype").val();
		var sAddress = $("#sAddress").val();
		var sTuition = $("#sTuition").val();
		var subIds = getSubIds();
		if (subIds == "") {
			alert("科目未选择！");
			return false;
		}
		if (sName == "" || sAddress == "" || sPhone == "") {
			alert("信息填写不全");
			return false;
		}
		$
				.ajax({
					url : "${pageContext.request.contextPath}/updateStudent",
					type : "post",
					data : JSON.stringify({
						sId : sId,
						sName : sName,
						sSex : sSex,
						sPhone : sPhone,
						sClass : sClass,
						sClasstype : sClasstype,
						sAddress : sAddress,
						sTuition : sTuition,
					}),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(message) {
						$
								.ajax({
									url : "${pageContext.request.contextPath}/updateStudentSubject",
									type : "post",
									data : JSON.stringify({
										sId : sId,
										subIds : subIds
									}),
									contentType : "application/json;charset=UTF-8",
									dataType : "json",
									success : function(rows) {
										if (rows > 0) {
											alert("修改成功");
											var studentPages = $(
													"#studentPages").val();
											var studentPageNum = $(
													"#studentPageNum").val();
											studentSkip(studentPageNum,
													studentPages);
											backToStudentList();
										}
									}
								});
					}
				});
	}
	/* 学生修改表单返回列表 */
	function backToStudentList() {
		$("#studentList").css("display", "block");
		$("#updateBefore").css("display", "none");
	}
	function deleteStudent(sId) {
		$.ajax({
			url : "${pageContext.request.contextPath}/deleteStudent",
			type : "post",
			data : JSON.stringify({
				sId : sId,
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				if (rows > 0) {
					alert("删除成功");
					var studentPages = $("#studentPages").val();
					var studentPageNum = $("#studentPageNum").val();
					studentSkip(studentPageNum, studentPages);
					backToStudentList();
				}
			}
		});
	}
	/* student_table数据的添加 */
	function studentTableAdd(pageStudent) {
		var students = pageStudent.list;
		for (i = 0; i < students.length; i++) {
			var sDate = dateFormat("YYYY-mm-dd HH:MM", new Date(
					students[i].sDate));
			var student = "<tr><td>"
					+ students[i].sName
					+ "</td><td>"
					+ students[i].sSex
					+ "</td><td>"
					+ students[i].studentClass.cName
					+ "</td><td>"
					+ students[i].classType.ctName
					+ "</td><td>"
					+ students[i].sPhone
					+ "</td><td>"
					+ students[i].sAddress
					+ "</td><td>"
					+ sDate
					+ "</td><td>"
					+ students[i].sTuition
					+ "</td><td><button class='btn btn-default' onclick='updateBefore(\""
					+ students[i].sPhone
					+ "\",\""
					+ students[i].sPwd
					+ "\")'>修改</button>&nbsp;&nbsp;<button class='btn btn-default' onclick='deleteStudent("
					+ students[i].sId + ")'>删除</button></td></tr>";
			$("#students").append(student);
		}
	}
	/* 学生分页信息的添加 */
	function studentPageAdd(pageStudent) {
		var pageNum = pageStudent.pageNum;
		var pages = pageStudent.pages;
		var navigateLastPage = pageStudent.navigateLastPage;
		$("#pageStudent").html("");
		if (pages > 0) {
			$("#studentPages").val(pages);
			$("#studentPageNum").val(pageNum);
			var page = "共"
					+ pages
					+ "页/当前第"
					+ pageNum
					+ "页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<a onclick='studentSkip(1," + pages
					+ ")'>首页</a>&nbsp;&nbsp;" + "<a onclick='studentSkip("
					+ (pageNum - 1) + "," + pages + ")'>上一页</a>&nbsp;&nbsp;"
					+ "<a onclick='studentSkip(" + (pageNum + 1) + "," + pages
					+ ")'>下一页</a>&nbsp;&nbsp;" + "<a onclick='studentSkip("
					+ navigateLastPage + "," + pages + ")'>末页</a>";
			$("#pageStudent").append(page);
		}
	}

	/* 初始化老师列表 */
	function listTeacherIndex() {
		$(".col-md-8").css("display", "none");
		$
				.ajax({
					url : "${pageContext.request.contextPath}/listTeacherIndex",
					type : "post",
					data : {
						pageNum : 1,
						pageSize : 5
					},
					dataType : "json",
					success : function(pageTeacher) {
						$("#teachers").html("");
						var tabel_header = "<tr><td>姓名</td><td>性别</td><td>联系方式</td><td>毕业学校</td><td>学历</td><td>居住地址</td><td>录用日期</td><td>操作</td></tr>"
						$("#teachers").append(tabel_header);
						teacherTableAdd(pageTeacher);
						teacherPageAdd(pageTeacher);
						$("#teacherList").css("display", "block");
					}
				});
	}
	/* teacher_table数据的添加 */
	function teacherTableAdd(pageTeacher) {
		var teachers = pageTeacher.list;
		for (i = 0; i < teachers.length; i++) {
			var tDate = dateFormat("YYYY-mm-dd HH:MM", new Date(
					teachers[i].tDate));
			var teacher = "<tr><td>"
					+ teachers[i].tName
					+ "</td><td>"
					+ teachers[i].tSex
					+ "</td><td>"
					+ teachers[i].tPhone
					+ "</td><td>"
					+ teachers[i].tSchool
					+ "</td><td>"
					+ teachers[i].education.eName
					+ "</td><td>"
					+ teachers[i].tAddress
					+ "</td><td>"
					+ tDate
					+ "</td><td><button class='btn btn-default' onclick='updateTeacherBefore("
					+ teachers[i].tId
					+ ")'>修改</button>&nbsp;&nbsp;<button class='btn btn-default' onclick='deleteTeacher("
					+ teachers[i].tId + ")'>删除</button></td></tr>";
			$("#teachers").append(teacher);
		}
	}
	/* 老师分页信息的添加 */
	function teacherPageAdd(pageTeacher) {
		var pageNum = pageTeacher.pageNum;
		var pages = pageTeacher.pages;
		var navigateLastPage = pageTeacher.navigateLastPage;
		$("#pageTeacher").html("");
		if (pages > 0) {
			$("#teacherPages").val(pages);
			$("#teacherPageNum").val(pageNum);
			var page = "共"
					+ pages
					+ "页/当前第"
					+ pageNum
					+ "页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<a onclick='teacherSkip(1," + pages
					+ ")'>首页</a>&nbsp;&nbsp;" + "<a onclick='teacherSkip("
					+ (pageNum - 1) + "," + pages + ")'>上一页</a>&nbsp;&nbsp;"
					+ "<a onclick='teacherSkip(" + (pageNum + 1) + "," + pages
					+ ")'>下一页</a>&nbsp;&nbsp;" + "<a onclick='teacherSkip("
					+ navigateLastPage + "," + pages + ")'>末页</a>";
			$("#pageTeacher").append(page);
		}
	}
	/* 显示老师注册页面*/
	function teacherAdd() {
		$("#tman").removeAttr("checked");
		$("#twoman").removeAttr("checked");
		$(".col-md-8").css("display", "none");
		$("#teacherAddPage").css("display", "block");
	}
	/* 添加老师 */
	function addTeacher() {
		$.post("${pageContext.request.contextPath}/addTeacher", $(
				"#teacherAddForm").serialize(), function(rows) {
			alert("添加成功");
			$("#addtName").val("");
			$("#tman").removeAttr("checked");
			$("#twoman").removeAttr("checked");
			$("#addtPhone").val("");
			$("#addtSchool").val("");
			$("#addtEducation").val("0");
			$("#addtAddress").val("");
			listTeacherIndex();
		});
	}
	/* 返回老师列表 */
	function showTeacherList() {
		$(".col-md-8").css("display", "none");
		$("#teacherList").css("display", "block");
	}
	/* 老师页面跳转 */
	function teacherSkip(pageNum, pages) {
		var tName = $("#sel_tName").val();
		var tEducation = $("#sel_tEducation").val();
		var tSchool = $("#sel_tSchool").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/teacherSkip",
					type : "post",
					data : {
						tName : tName,
						tEducation : tEducation,
						tSchool : tSchool,
						pageNum : pageNum,
						pages : pages
					},
					dataType : "json",
					success : function(pageTeacher) {
						$("#teachers").html("");
						var tabel_header = "<tr><td>姓名</td><td>性别</td><td>联系方式</td><td>毕业学校</td><td>学历</td><td>居住地址</td><td>录用日期</td><td>操作</td></tr>"
						$("#teachers").append(tabel_header);
						teacherTableAdd(pageTeacher);
						teacherPageAdd(pageTeacher);
					}
				});
	}
	/* 按条件查询列表 */
	function teachersByselectTeacher() {
		$
				.post(
						"${pageContext.request.contextPath}/teachersByselectTeacher",
						$("#selectTeacherForm").serialize(),
						function(pageTeacher) {
							$("#teachers").html("");
							var tabel_header = "<tr><td>姓名</td><td>性别</td><td>联系方式</td><td>毕业学校</td><td>学历</td><td>居住地址</td><td>录用日期</td><td>操作</td></tr>"
							$("#teachers").append(tabel_header);
							teacherTableAdd(pageTeacher);
							teacherPageAdd(pageTeacher);
						});
	}
	/* 显示老师旧信息 */
	function updateTeacherBefore(tId) {
		$.ajax({
			url : "${pageContext.request.contextPath}/updateTeacherBefore",
			type : "post",
			data : JSON.stringify({
				tId : tId,
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(teacher) {
				$(".col-md-8").css("display", "none");
				$("#teacherUpdatePage").css("display", "block");
				$("#tId").val(teacher.tId);
				$("#tName").val(teacher.tName);
				$('input[name="tSex"][value="' + teacher.tSex + '"]').prop(
						"checked", true);
				$("#tPhone").val(teacher.tPhone);
				$("#tSchool").val(teacher.tSchool);
				$("#tAddress").val(teacher.tAddress);
				$("#tEducation").val(teacher.tEducation);
			}
		});
	}
	/* 修改老师信息 */
	function updateTeacher() {
		$.post("${pageContext.request.contextPath}/updateTeacher", $(
				"#teacherUpdateForm").serialize(), function(rows) {
			if (rows > 0) {
				alert("修改成功！");
				teacherSkip($("#teacherPageNum").val(), $("#teacherPages")
						.val());
				showTeacherList();
			}
		});
	}
	/* 删除老师 */
	function deleteTeacher(tId) {
		$.ajax({
			url : "${pageContext.request.contextPath}/deleteTeacher",
			type : "post",
			data : JSON.stringify({
				tId : tId,
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				if (rows > 0) {
					alert("删除成功！");
					teacherSkip($("#teacherPageNum").val(), $("#teacherPages")
							.val());
					showTeacherList();
				}
			}
		});
	}
	/* 管理员退出登录 */
	function adminLogout() {
		window.location.href = "${pageContext.request.contextPath}/adminLogout";
	}
	/* 初始化假条列表  */
	function listFackIndex() {
		$
				.ajax({
					url : "${pageContext.request.contextPath}/selectAllNotPass",
					dataType : "json",
					success : function(fackPage) {
						$("#facks").html("");
						var tabel_header = "<tr><td>姓名</td><td>班级</td><td>班级类型</td><td>开始时间</td><td>结束时间</td><td>请假原因</td><td>操作</td></tr>"
						$("#facks").append(tabel_header);
						fackTableAdd(fackPage);
						fackPageAdd(fackPage);
						showFackList();
					}
				});
	}
	/* 假条表格的添加 */
	function fackTableAdd(fackPage) {
		var facks = fackPage.list;
		for (i = 0; i < facks.length; i++) {
			var fack = "<tr><td>"
					+ facks[i].student.sName
					+ "</td><td>"
					+ facks[i].student.studentClass.cName
					+ "</td><td>"
					+ facks[i].student.classType.ctName
					+ "</td><td>"
					+ facks[i].fStart
					+ "</td><td>"
					+ facks[i].fEnd
					+ "</td><td>"
					+ facks[i].fReason
					+ "</td><td><button class='btn btn-default' onclick='agreeFack("
					+ facks[i].fId
					+ ")'>同意</button>&nbsp;&nbsp;<button class='btn btn-default' onclick='againstFack("
					+ facks[i].fId + ")'>驳回</button></td></tr>";
			$("#facks").append(fack);
		}
	}
	/* 假条分页的信息添加 */
	function fackPageAdd(fackPage) {
		var pageNum = fackPage.pageNum;
		var pages = fackPage.pages;
		var navigateLastPage = fackPage.navigateLastPage;
		$("#pageFack").html("");
		if (pages > 0) {
			$("#fackPages").val(pages);
			$("#fackPageNum").val(pageNum);
			var page = "共"
					+ pages
					+ "页/当前第"
					+ pageNum
					+ "页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<a onclick='fackSkip(1," + pages
					+ ")'>首页</a>&nbsp;&nbsp;" + "<a onclick='fackSkip("
					+ (pageNum - 1) + "," + pages + ")'>上一页</a>&nbsp;&nbsp;"
					+ "<a onclick='fackSkip(" + (pageNum + 1) + "," + pages
					+ ")'>下一页</a>&nbsp;&nbsp;" + "<a onclick='fackSkip("
					+ navigateLastPage + "," + pages + ")'>末页</a>";
			$("#pageFack").append(page);
		}
	}
	/* 按条件查询假条列表 */
	function facksByStudent() {
		$
				.post(
						"${pageContext.request.contextPath}/facksByStudent",
						$("#fackSelectForm").serialize(),
						function(fackPage) {
							$("#facks").html("");
							var tabel_header = "<tr><td>姓名</td><td>班级</td><td>班级类型</td><td>开始时间</td><td>结束时间</td><td>请假原因</td><td>操作</td></tr>"
							$("#facks").append(tabel_header);
							fackTableAdd(fackPage);
							fackPageAdd(fackPage);
							showFackList();
						});
	}
	/* 假条页面跳转 */
	function fackSkip(pageNum, pages) {
		var sName = $("#fack_sName").val();
		var sClass = $("#fack_sClass").val();
		var sClasstype = $("#fack_sClasstype").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath}/fackSkip",
					type : "post",
					data : {
						sName : sName,
						sClass : sClass,
						sClasstype : sClasstype,
						pageNum : pageNum,
						pages : pages
					},
					dataType : "json",
					success : function(fackPage) {
						$("#facks").html("");
						var tabel_header = "<tr><td>姓名</td><td>班级</td><td>班级类型</td><td>开始时间</td><td>结束时间</td><td>请假原因</td><td>操作</td></tr>"
						$("#facks").append(tabel_header);
						fackTableAdd(fackPage);
						fackPageAdd(fackPage);
					}
				});
	}
	/* 同意假条 */
	function agreeFack(fId) {
		var pages = $("#fackPages").val();
		var pageNum = $("#fackPageNum").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/changeFack",
			type : "post",
			data : JSON.stringify({
				fId : fId,
				fStatus : "同意"
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				fackSkip(pageNum, pages);
			}
		});
	}
	/* 驳回假条 */
	function againstFack(fId) {
		var pages = $("#fackPages").val();
		var pageNum = $("#fackPageNum").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/changeFack",
			type : "post",
			data : JSON.stringify({
				fId : fId,
				fStatus : "驳回"
			}),
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(rows) {
				fackSkip(pageNum, pages);
			}
		});
	}
	/* 只显示假条列表 */
	function showFackList() {
		$(".col-md-8").css("display", "none");
		$("#fackList").css("display", "block");
	}
</script>
<body>
	<div class="container">
		<div class="row">
			<h1>欢迎管理员进入管理界面</h1>
		</div>
		<div class="row">
			<div class="col-md-2">
				<ul class="list-unstyled" style="margin-left: 30px;">
					<li onclick="listStudentIndex()">学生管理</li>
					<li onclick="listTeacherIndex()">老师管理</li>
					<li onclick="listFackIndex()">假条管理</li>
					<li onclick="adminLogout()">退出登录</li>
				</ul>
			</div>
			<div class="col-md-8" id="studentList">
				<form class="form-inline" onsubmit="return false">
					<div class="form-group">
						<label>姓名：</label> <input type="text" class="form-control"
							id="sel_sName">
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label>班级：</label> <select id="sel_sClass" class="form-control">
							<option value="0">请选择</option>
							<c:forEach items="${clazz}" var="studentClass">
								<option value="${studentClass.cId}">${studentClass.cName}</option>
							</c:forEach>
						</select>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label>班级类型：</label> <select id="sel_sClasstype"
							class="form-control">
							<option value="0">请选择</option>
							<c:forEach items="${classTypes}" var="classType">
								<option value="${classType.ctId}">${classType.ctName}</option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-default" onclick="studentsByselectStudent()">查询</button>
				</form>
				<input type="hidden" id="studentPages" /> <input type="hidden"
					id="studentPageNum" />
				<table class="table table-bordered" id="students"
					style="margin-top: 10px;">
				</table>
				<p id="pageStudent"></p>
			</div>
			<div class="col-md-8" id="updateBefore">
				<div class="container">
					<div class="row">
						<div class="col-md-3 ">
							<h3>学生信息修改表单</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 ">
							<input type="hidden" id="sId" /> 姓名：<input type="text"
								id="sName" />
						</div>
						<div class="col-md-6"></div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							性别： <input type="radio" name="sSex" value="男" />男 <input
								type="radio" name="sSex" value="女" />女
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							报名班级： <select id="sClass">
								<c:forEach items="${clazz}" var="sclass">
									<option value="${sclass.cId}">${sclass.cName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							班级类型： <select id="sClasstype">
								<c:forEach items="${classTypes}" var="classType">
									<option value="${classType.ctId}">${classType.ctName}:${classType.ctPrice}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							科目：<br>
							<c:forEach items="${subjects}" var="subject">
								<input type="checkbox" name="subId" value="${subject.subId}" />${subject.subName}:${subject.subPrice}元<br>
							</c:forEach>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							联系方式： <input type="text" id="sPhone" />
						</div>
						<div class="col-md-5" id="phoneTip" style="color: red;"></div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							家庭住址： <input type="text" id="sAddress" />
						</div>
						<div class="col-md-5"></div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							缴费金额： <input type="text" id="sTuition" value="0" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 ">
							<button class="btn btn-primary" onclick="updateStudent()">更新</button>
							<button class="btn btn-primary" onclick="backToStudentList()">返回</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8" id="teacherList">
				<form method="post" id="selectTeacherForm" class="form-inline"
					onsubmit="return false">
					<div class="form-group">
						<label>姓名：</label> <input type="text" class="form-control"
							id="sel_tName" name="tName">
					</div>
					<div class="form-group">
						<label>学校：</label> <input type="text" class="form-control"
							id="sel_tSchool" name="tSchool">
					</div>
					<div class="form-group">
						<label>学历：</label> <select id="sel_tEducation" name="tEducation"
							class="form-control">
							<option value="0">请选择</option>
							<c:forEach items="${educations}" var="education">
								<option value="${education.eId}">${education.eName}</option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-default" onclick="teachersByselectTeacher()">查询</button>
				</form>
				<button class="btn btn-default" onclick="teacherAdd()">新增教师</button>
				<table class="table table-bordered" id="teachers"
					style="margin-top: 10px;"></table>
				<p id="pageTeacher"></p>
			</div>
			<div class="col-md-8" id="teacherAddPage">
				<form method="post" id="teacherAddForm" onsubmit="return false">
					<div class="form-group">
						<label>姓名：</label> <input type="text" class="form-control"
							name="tName" id="addtName">
					</div>
					<div class="form-group">
						<label>性别：</label> <input type="radio" name="tSex" value="男"
							id="tman">男<input type="radio" name="tSex" value="女"
							id="twoman">女
					</div>
					<div class="form-group">
						<label>联系方式：</label> <input type="text" class="form-control"
							name="tPhone" id="addtPhone">
					</div>
					<div class="form-group">
						<label>学校：</label> <input type="text" class="form-control"
							name="tSchool" id="addtSchool">
					</div>
					<div class="form-group">
						<label>学历：</label> <select name="tEducation" id="addtEducation">
							<option value="0">请选择</option>
							<c:forEach items="${educations}" var="education">
								<option value="${education.eId}">${education.eName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>现居地址：</label> <input type="text" class="form-control"
							name="tAddress" id="addtAddress">
					</div>
					<button onclick="addTeacher()">添加</button>
					<button onclick="showTeacherList()">返回</button>
				</form>
			</div>
			<div class="col-md-8" id="teacherUpdatePage">
				<form method="post" id="teacherUpdateForm" onsubmit="return false">
					<div class="form-group">
						<input type="hidden" name="tId" id="tId" /> <input type="hidden"
							id="teacherPages" value="1" /> <input type="hidden"
							id="teacherPageNum" /> <label>姓名：</label> <input type="text"
							class="form-control" name="tName" id="tName">
					</div>
					<div class="form-group">
						<label>性别：</label> <input type="radio" name="tSex" value="男">男<input
							type="radio" name="tSex" value="女">女
					</div>
					<div class="form-group">
						<label>联系方式：</label> <input type="text" class="form-control"
							name="tPhone" id="tPhone">
					</div>
					<div class="form-group">
						<label>学校：</label> <input type="text" class="form-control"
							name="tSchool" id="tSchool">
					</div>
					<div class="form-group">
						<label>学历：</label> <select name="tEducation" id="tEducation">
							<option value="0">请选择</option>
							<c:forEach items="${educations}" var="education">
								<option value="${education.eId}">${education.eName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>现居地址：</label> <input type="text" class="form-control"
							name="tAddress" id="tAddress">
					</div>
					<button onclick="updateTeacher()">修改</button>
					<button onclick="showTeacherList()">返回</button>
				</form>
			</div>
			<div class="col-md-8" id="fackList">
				<form class="form-inline" id="fackSelectForm"
					onsubmit="return false">
					<div class="form-group">
						<input type="hidden" id="fackPages" /> <input type="hidden"
							id="fackPageNum" /> <label>姓名：</label> <input type="text"
							class="form-control" id="fack_sName" name="sName">
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label>班级：</label> <select name="sClass" id="fack_sClass"
							class="form-control">
							<option value="0">请选择</option>
							<c:forEach items="${clazz}" var="studentClass">
								<option value="${studentClass.cId}">${studentClass.cName}</option>
							</c:forEach>
						</select>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label>班级类型：</label> <select name="sClasstype"
							id="fack_sClasstype" class="form-control">
							<option value="0">请选择</option>
							<c:forEach items="${classTypes}" var="classType">
								<option value="${classType.ctId}">${classType.ctName}</option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-default" onclick="facksByStudent()">查询</button>
				</form>
				<table class="table table-bordered" id="facks"
					style="margin-top: 10px;"></table>
				<p id="pageFack"></p>
			</div>
		</div>
	</div>
</body>
</html>