<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style>
.h2 {
	width: 50%;
	border-radius: 10px;
	text-align: center;
	padding: 10px;
	margin: 50px auto 100px;
	box-shadow: 2px 4px 6px gray;
	background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
}

.content {
	border: 3px dotted black;
	width: 80%;
	border-radius: 20px;
	padding: 30px;
	margin: auto;
	height: 600px;
	background: #F4F4F4;
}

.div01 {
	border: 2px solid black;
	border-radius: 10px;
	box-shadow: 1px 2px 2px grey;
	margin: 10px;
	padding: 5px;
	background: #F4F4F4;
	font-weight: bold;
}

input:focus {
	outline: none;
}
.input01 {
	border: none;
	background: #F4F4F4;
}

.Btn01 {
	background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
	float: right;
	margin: 10px;
	border-radius: 10px;
	font-size:20px;
}

.Btn01:hover {
	box-shadow: 2px 2px 2px grey;
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var msg = "${msg}"
		if (msg != "") {
			alert(msg) // 등록 성공 alert()로딩 : 모델 데이터를 받아서..
			$("[name=refno]").val("0")
			$("[name=subject]").val("")
			$("[name=content]").val("")
			//$("form")[0].reset()
			location.href = "freeBoardList"
		}
	});
</script>
</head>
<body>
	<div>
		<h2 class="h2">자유게시판 글 등록</h2>
	</div>
	<div class="content">
		<form action="freeBoardInsert" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="refno"
				value="${empty param.refno?'0':param.refno}" />
			<div class="">
				<div class="div01">
					<span class="">제목 : </span> <input type="text" name="subject"
						class="input01" value="${param.subject}" placeholder="제목입력" />
				</div>
			</div>
			<div class="">
				<div class="div01">
					<span class="">작성자 : </span> <input name="writer" class="input01"
						value="${writer}" readonly/>
				</div>
			</div>
			<div class="">
				<div class="div01">
					<span class="">내용</span>
				</div>
				<textarea name="content" rows="20" cols="120" class="div01"
					placeholder="내용입력" style="width:97%">${param.content}</textarea>
			</div>
			<div class="">
				<div class="div01">
					<span class="input01">첨부파일 : </span> <input type="file"
						name="reports" multiple="multiple" class="input01" value="" />
				</div>
			</div>
			<div style="text-align: right;">
				<input type="button" class="Btn01" value="등록" id="regBtn" /> <input
					type="button" class="Btn01" value="초기화" id="initBtn" /> <input
					type="button" class="Btn01" value="메인화면" id="mainBtn" />
			</div>
		</form>
		<script type="text/javascript">
			$("#initBtn").click(function() {
				$("form")[0].reset()
			})
			$("#regBtn").click(function() {
				if (confirm("등록하시겠습니까?")) {
					$("form").submit()
				}
			})
			$("#mainBtn").click(function() {
				location.href = "freeBoardList"
			})
		</script>
	</div>
</body>
</html>