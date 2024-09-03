<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>팀원 관리</title>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <%@ include file="a02_sliderBar.jsp" %> <!-- 사이드바 포함 -->
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="a03_topBar.jsp" %> <!-- 탑바 포함 -->
                <div class="container-fluid">
                    <!-- 페이지 내용 시작 -->
                    <div class="container">
                        <h2>팀원 관리 - ${project.projectname}</h2>
                        
                        <!-- 팀원 목록 -->
                      <h3>현재 팀원</h3>
						<ul>
						    <c:forEach var="member" items="${projectMembers}">
						        <li>${member.name} (${member.role}) &nbsp;&nbsp;
						            <button type="button" class="btn btn-danger btn-sm" onclick="removeMember('${member.empno}')">제거</button>
						        </li>
						    </c:forEach>
						</ul>
                        <!-- 팀원 추가 폼 -->
                        <h3>팀원 추가</h3>
                        <form action="${path}/project/invite" method="post">
                            <input type="hidden" name="projectid" value="${project.projectid}">
                            <div class="form-group">
                                <label for="empno">사용자</label>
                                <select id="empno" name="empno" class="form-control">
                                    <c:forEach var="user" items="${availableUsers}">
                                        <option value="${user.empno}">${user.name}</option>
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
                            <button type="submit" class="btn btn-primary">추가</button>
                        </form>
                    </div>
                    <!-- 페이지 내용 끝 -->
                </div>
            </div>
        </div>
    </div>

    <script>
    function removeMember(empno) {
        if (confirm("이 팀원을 제거하시겠습니까?")) {
            $.ajax({
                url: '${path}/project/${project.projectid}/removeMember',
                type: 'DELETE',
                data: { empno: empno },
                success: function(response) {
                    alert('팀원이 성공적으로 제거되었습니다.');
                    location.reload(); // 페이지 새로고침
                },
                error: function(xhr, status, error) {
                    console.error('팀원 제거 중 오류 발생:', error);
                }
            });
        }
    }
    </script>
</body>
</html>
