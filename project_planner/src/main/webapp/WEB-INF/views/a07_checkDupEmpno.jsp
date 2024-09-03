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
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("[name=empno]").keyup(function(){
			if(event.keyCode==13) ckDupEmpno()
		})
		$("#ckBtn").click(function(){ 
			ckDupEmpno()
		})
	});
	function ckDupEmpno(){
		$.ajax({
			url:"dupChkEmpno", // @GetMapping("dupChkEmpno")
			data:"empno="+$("[name=empno]").val(), // dupChkEmpno(@RequestParam("empno") int empno)
			success:function(msg){       // return ResponseEntity.ok(service.checkEmpno(empno))
				alert(msg)               // return dao.checkEmpno(empno)>0?"등록된 사원번호가 있음":"해당 사원번호로 등록 가능";
			},
			error:function(err){
				console.log(err)
            }
		})
	}
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>사원번호 중복 check Ajax</h2>
</div>
<div class="container">
	
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="사원번호입력" name="empno"  class="form-control mr-sm-2" />
	    <button class="btn btn-info" type="button" id="ckBtn">중복확인</button>
 	</nav>
	
</div>	
</body>
</html>