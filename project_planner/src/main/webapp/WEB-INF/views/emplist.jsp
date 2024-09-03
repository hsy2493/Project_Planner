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
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link rel="stylesheet" href="${path}/a00_com/css/styles.css">
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<style>
body {
    margin: 0;
    font-family: 'Nunito', sans-serif; /* Improved font */
    background-color: #e0f7fa; /* Light sky blue background */
}

#wrapper {
    display: flex;
    height: 100vh; /* Full viewport height */
    overflow: hidden; /* Prevent horizontal scrolling */
}

.sidebar {
    width: 400px;
    background-color: #343a40; /* Dark background for sidebar */
    color: white;
    
    height: 200%; /* Full height */
    position: fixed;
    top: 0; 
    left: 0;
    overflow-y: auto; /* Scroll if content overflows */
}

.content-wrapper {
    margin-left: 225px; /* Same width as sidebar */
    background-color: #ffffff; /* White background for content area */
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    width: calc(100% - 250px); /* Full width minus sidebar width */
    overflow-y: auto; /* Scroll if content overflows */
}

header {
    background-color: #00bcd4; /* Sky blue */
    color: white;
    padding: 0.5rem 1rem;
    text-align: left;
    border-bottom: 2px solid #00a3d9;
}

header h1 {
    margin: 0;
    font-size: 2.5rem;
}

.jumbotron {
    background-color: #4fc3f7; /* Medium sky blue */
    color: white;
    padding: 2rem 1rem;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.jumbotron h2 {
    margin: 0;
    font-size: 1.6rem;
}

.navbar {
    background-color: #03a9f4; /* Darker sky blue */
    padding: 0.5rem 1rem;
    border-radius: 8px;
    margin-bottom: 10px;
    display: flex;
    align-items: center; /* Center vertically */
    gap: 10px; /* Space between elements */
}

.navbar .form-control {
    border-color: #03a9f4;
    background-color: #b3e5fc; /* Light sky blue */
}

.navbar .btn-info {
    background-color: #4fc3f7; /* Medium sky blue */
    border-color: #4fc3f7;
    border-radius: 4px;
    
}

.navbar .btn-info:hover {
    background-color: #0288d1; /* Darker sky blue */
    border-color: #0288d1;
}

.table-wrapper {
    margin-top: 20px;
    
}

table {
    background-color: #ffffff; /* White background */
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

thead {
    background-color: #4fc3f7; /* Medium sky blue */
    color: white;
}

tbody tr:nth-child(even) {
    background-color: #e0f7fa; /* Light sky blue */
}

tbody tr:nth-child(odd) {
    background-color: #ffffff; /* White */
}

tbody td {
    text-align: center;
    padding: 0.75rem;
}

th, td {
    border: 1px solid #b3e5fc; /* Light sky blue border */
}

.form {
    margin-bottom: 20px;
}

.btn-info {
    background-color: #4fc3f7; /* Medium sky blue */
    border-color: #4fc3f7;
    border-radius: 5px;
    width: 250px;
    height: 100%;
}

h2 {
    text-align: center; /* Center align text */
    margin-bottom: 20px;
}
</style>
</head>

<body>
    <div id="wrapper">
        <div class="sidebar">
            <%@ include file="a02_sliderBar.jsp" %>
        </div>
        <div id="content-wrapper" class="content-wrapper d-flex flex-column">
            <%@ include file="a03_topBar.jsp" %>
            <h2><b>:P:P 사원정보 List</b></h2>
            <div class="container">
                <form id="frm01" class="form" method="post" action="empList">
                    <nav class="navbar navbar-expand-sm navbar-dark">
                        <input placeholder="이름" name="name" value="${param.name}" class="form-control" />
                        <input placeholder="역할 PM, DB, BE, FE 중 검색 " name="role" value="${param.role}" class="form-control"/>
                        <button class="btn btn-info" type="submit">검색</button>
                    </nav>
                </form>
                <div class="table-wrapper">
                    <table class="table table-hover table-striped">
                        <col width="20%">
                        <col width="20%">
                        <col width="20%">
                        <col width="20%">
                        <col width="20%">
                        <thead>
                            <tr class="text-center">
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
            </div>    
        </div>
    </div>
</body>
</html>
