 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER EmpList</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   body {
        background-color: #e0f7fa; /* 연한 하늘색 배경 */
        color: #333; /* 어두운 텍스트 색상 */
        font-family: Arial, sans-serif; /* 폰트 설정 */
    }
    header {
        background-color: #00bcd4; /* 하늘색 */
        color: white;
        padding: 0.5rem 1rem;
        text-align: left; /* 왼쪽 정렬 */
    }
    header h1 {
        margin: 0;
        font-size: 2.5rem; /* 글자 크기 증가 */
    }
    .jumbotron {
        background-color: #4fc3f7; /* 중간 하늘색 */
        color: white;
        padding: 2rem 1rem;
        border-radius: 0rem;
        text-align: center;
    }
    .jumbotron h2 {
        margin: 0;
        font-size: 1.6rem; /* 글자 크기 감소 */
    }
    .navbar {
        background-color: #03a9f4; /* 진한 하늘색 */
        padding: 0.5rem 1rem;
    }
    .navbar .form-control {
        border-color: #03a9f4;
        background-color: #b3e5fc; /* 연한 하늘색 */
    }
    .navbar .btn-info {
        background-color: #4fc3f7; /* 중간 하늘색 */
        border-color: #4fc3f7;
    }
    .navbar .btn-info:hover {
        background-color: #0288d1; /* 어두운 하늘색 */
        border-color: #0288d1;
    }
    table {
        background-color: #ffffff; /* 흰색 배경 */
        border-radius: 0.3rem;
        overflow: hidden;
        margin-top: 1rem;
    }
    thead {
        background-color: #4fc3f7; /* 중간 하늘색 */
        color: white;
    }
    tbody tr:nth-child(even) {
        background-color: #e0f7fa; /* 연한 하늘색 */
    }
    tbody tr:nth-child(odd) {
        background-color: #ffffff; /* 흰색 */
    }
    tbody td {
        text-align: center;
        padding: 0.75rem;
    }
    th, td {
        border: 1px solid #b3e5fc; /* 연한 하늘색 테두리 */
    }
    .container {
        margin-top: 20px;
    }
    .form {
        margin-bottom: 20px;
    }
    .btn-info {
        background-color: #4fc3f7; /* 중간 하늘색 */
        border-color: #4fc3f7;
    }
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
	});
</script>
</head>

<body>
<header>
    <h1><b>Project Planner :P:P</b></h1>
</header>
<div class="jumbotron text-center">
  <h2><b>:P:P 사원정보 List</b></h2>
</div>

<div class="container">
	<form id="frm01" class="form" method="post" action="empList">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="이름" name="name" value="${param.name}" class="form-control mr-sm-2" />
	    <input placeholder="역할 PM, DB, BE, FE 중 검색 " name="role" value="${param.role}" class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">검색</button>
	 

 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
    <thead>
    
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>역할</th>
        <th>프로젝트</th>
      </tr>

    </thead>

    <tbody>
     <c:choose>
        <c:when test="${empty emplist}">
            <tr>
                <td colspan="5">검색결과가 존재하지 않습니다.</td>
            </tr>
        </c:when>
         <c:otherwise>
       <c:forEach var="emp" items="${emplist}">
	    	<tr>
	    	     <td>${emp.empno}</td>
	    	     <td>${emp.name}</td>
	    	     <td>${emp.email}</td>
		   	     <td>${emp.role}</td>
		   	     <td>${emp.projectStatus}</td>

	        </tr> 
        </c:forEach>    
          </c:otherwise>
    </c:choose>     	
    </tbody>
   
	</table>
	</div>    
</body>
</html>