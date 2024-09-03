<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER NewPassword</title>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link rel="stylesheet" href="${path}/a00_com/css/styles.css">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
</head>
<body>
<header>
    <div class="logo">
        <h1>Project Planner :P:P</h1>
    </div>
    <div class="user-buttons">
        <button class="goupt-button" id="Login">로그인</button>
    </div>
</header>
<nav>
    <ul>
        <h2>:P:P 비밀번호 재설정</h2>
    </ul>
</nav>
<main>
    <form method="post" action="/sendTemporaryPassword" id="authform">
        <section class="mem-content">    
            <h2 style="margin-bottom: 30px;">임시 비밀번호</h2>
            <p class="ppap">
                이메일 : <input type="email" name="email" required>
            </p>
            <br><button class="viewTrain-button" id="authBtn">전송</button>
        </section>
    </form>
</main>
<script type="text/javascript">    
    $("#Login").click(function(){//로그인 페이지 이동 버튼
        location.href = "${path}/login";
    });
    
    var msg = "${msg}";
    if (msg != "") { //알림 메세지 출력
        alert(msg);
    }
</script>
</body>
</html>
