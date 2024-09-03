<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Invite Team Member</title>
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
                                <h1 class="h4 text-gray-900 mb-4">Invite Team Member</h1>
                            </div>
                            <form action="${path}/project/invite" method="post">
                                <input type="hidden" name="projectid" value="${projectid}" readonly />
                                <div class="form-group">
                                    <label for="empno">Select Team Member</label>
                                    <select name="empno" class="form-control" required>
                                        <c:forEach var="user" items="${availableUsers}">
                                            <option value="${user.empno}">${user.name} (${user.role})</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="role">Role in Project</label>
                                    <select name="role" class="form-control" required>
                                        <option value="PM">프로젝트매니저</option>
                                        <option value="BACK">백엔드개발자</option>
                                        <option value="FRONT">프론트엔드 개발자</option>
                                        <option value="DB">DB관리자</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">초대</button>
                                <a href="${path}/project/${projectid}" class="btn btn-secondary">Cancel</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
