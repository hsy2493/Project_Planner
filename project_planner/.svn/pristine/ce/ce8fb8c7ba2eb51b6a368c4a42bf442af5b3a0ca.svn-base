<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)  // 등록 성공 alert()로딩 : 모델 데이터를 받아서..
			$("[name=refno]").val("0")
			$("[name=subject]").val("")
			$("[name=content]").val("")
			//$("form")[0].reset()
		}
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>게시물 등록</h2>
</div>
<div class="container">
	<form action="boardInsert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="refno" value="${empty param.refno?'0':param.refno}"/>
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">제목</span>
		</div>
		<input type="text" name="subject" class="form-control" value="${param.subject}" />
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">작성자</span>
		</div>
		<input name="writer" class="form-control" value="" />	
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend">
			<span class="input-group-text  justify-content-center">내용</span>
		</div>
		<textarea name="content" rows="10" class="form-control" >${param.content}</textarea>
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend">
			<span class="input-group-text  justify-content-center">첨부파일</span>
		</div>
		<input type="file"  name="reports" multiple="multiple" class="form-control" value="" />	
	</div>	
	<div style="text-align:right;">
			<input type="button" class="btn btn-success" value="등록" id="regBtn"/>
			<input type="button" class="btn btn-secondary" value="초기화" id="initBtn" />
			<input type="button" class="btn btn-primary" value="메인화면" id="mainBtn"/>
	</div>	
	</form>	
	<script type="text/javascript">

		$("#initBtn").click(function(){
			$("form")[0].reset()
		})	
		$("#regBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				$("form").submit()
			}
		})
		$("#mainBtn").click(function(){
			location.href="boardList.do"
		})
	
	</script>
</div>	
</body>
</html>