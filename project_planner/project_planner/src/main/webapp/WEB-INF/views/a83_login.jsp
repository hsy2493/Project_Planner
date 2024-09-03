<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<%
    Cookie[] cookies = request.getCookies();
    String rememberEmail = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("rememberEmail")) {
                rememberEmail = cookie.getValue();
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER Login</title>
<style>
    .links-container {
        display: flex;
        justify-content: flex-end; /* 오른쪽 정렬 */
        gap: 10px; /* 링크 사이의 간격 설정 */
        font-size: 14px; /* 텍스트 크기 설정 */
    }
    .links-container a {
        text-decoration: none; /* 링크 밑줄 제거 */
        color: blue; /* 링크 색상 */
    }
    .links-container a:not(:last-child)::after {
        content: '/';
        margin-left: 10px; /* 슬래시와 링크 사이의 간격 설정 */
        color: black; /* 슬래시 색상 */
    }
</style>
<script type="text/javascript">
$(document).ready(function() {
	var error = "${error}"
	if(error!=""){
   alert(error)
	}

	$("#newpwd").click(function(){ //비밀번호 재설정 페이지 이동버튼			
	location.href = "${path}/newpwd";
	});
});

</script>
<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">
    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"><img src="${path}/img/PPLogo.png" style="width:490px; height:10.7cm;"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4"><b>:P:P 로그인</b></h1>
                                    </div>
                                    <form class="user" method="post" action="${path}/login">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="exampleInputEmail" name="email" aria-describedby="emailHelp" placeholder="이메일" value="<%= rememberEmail %>" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" id="exampleInputPassword" name="password" placeholder="비밀번호" required>
                                        </div>
                                        &nbsp;&nbsp;<input type="checkbox" id="rememberMe" name="rememberMe"><a style="font-size:10px;">&nbsp;&nbsp;이메일 저장하기</a>
                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="로그인">
                                        <hr>
                                    </form>
                                    <div class="links-container">
                                        <div class="text-center">
                                            <a class="small" href="sendTemporaryPassword" style="color:blue;" id="newpwd">비밀번호 재설정</a>
                                        </div>
                           
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
    <!-- Page level plugins -->
    <script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>
    <!-- Page level custom scripts -->
    <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
    <script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>
</body>
</html>
