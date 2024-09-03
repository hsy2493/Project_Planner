<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Projects</title>
    <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <%@ include file="a02_sliderBar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="a03_topBar.jsp" %>
                <div class="container-fluid">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">My Projects</h1>
                                        </div>
                                        
                                        <!-- PM만 프로젝트 생성 버튼을 볼 수 있게 설정 -->
                                        
                                            <div class="mb-3 text-right">
                                               
                                                <a class="btn btn-success" href="#" data-toggle="modal" data-target="#createProjectModal">프로젝트 생성</a>
                                            </div>
                                    

                                        <c:if test="${not empty projects}">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Project Name</th>
                                                        <th>Created By</th>
                                                        <th>Created At</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="project" items="${projects}">
                                                        <tr>
                                                            <td>${project.projectname}</td>
                                                            <td>${project.empno}</td>
                                                            <td><fmt:formatDate value="${project.createdat}"
                                                                    pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                                            <td>
                                                                <a href="${path}/project/${project.projectid}"
                                                                class="btn btn-primary">자세히 보기</a> 
                                                               
                                                                    <a href="${path}/project/edit/${project.projectid}"
                                                                    class="btn btn-warning">수정</a>
                                                                 

                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${empty projects}">
                                            <p>프로젝트가 존재하지 않습니다.</p>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
