<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Tasks</title>
    <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <%@ include file="a02_sliderBar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="a03_topBar.jsp" %>
                <div class="container-fluid">
                    <h1 class="h3 mb-4 text-gray-800">Project Tasks</h1>
                    <c:if test="${not empty msg}">
                        <div class="alert alert-info">${msg}</div>
                    </c:if>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                
                                <th>Task Name</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="task" items="${tasks}">
                                <tr>
                                    
                                    <td>${task.text}</td>
                                    <td>${task.start_date}</td>
                                    <td>${task.end_date}</td>
                                    <td>${task.progress}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="${path}/projects/${project.projectid}/gantt" class="btn btn-primary">Gantt Chart</a> <br><br>
                    <a href="${path}/projects/${project.projectid}/todo" class="btn btn-primary">todoList</a>  <br>   <br>               
                         
                	
					<c:if test="${userList[0].role == 'PM'}">
					    <a href="${path}/project/${project.projectid}/teammanagement" class="btn btn-primary">팀원 관리</a>
					</c:if>              
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
</body>
</html>
