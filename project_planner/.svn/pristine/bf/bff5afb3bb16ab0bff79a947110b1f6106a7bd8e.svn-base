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
    <title>프로젝트 수정</title>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">프로젝트 수정</h1>
                            </div>
                            <form action="${path}/project/update" method="post">
                                <input type="hidden" name="projectid" value="${project.projectid}" />
                                <div class="form-group">
                                    <label for="projectname">Project Name</label>
                                    <input type="text" class="form-control" id="projectname" name="projectname" value="${project.projectname}" required>
                                </div>
                                <div class="form-group">
                                    <label for="empno">Created By</label>
                                    <input type="text" class="form-control" id="empno" name="empno" value="${project.empno}" required readonly>
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                                <a href="${path}/my" class="btn btn-secondary">Cancel</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
</body>
</html>
