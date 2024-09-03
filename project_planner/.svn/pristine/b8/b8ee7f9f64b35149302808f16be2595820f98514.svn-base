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
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<style>
 html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }

    #wrapper {
        min-height: 100vh; /* 뷰포트 높이의 최소값 설정 */
        display: flex;
        flex-direction: column;
    }

    #content-wrapper {
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center; /* 콘텐츠가 중앙에 위치하도록 조정 */
    }

    main {
        padding: 20px;
    }

    .section {
        margin: 0 10px;
    }

    .section h2 {
        margin-bottom: 20px;
    }

    .ppap {
        margin-bottom: 10px;
    }

    .modal-content {
        background-color: #fefefe;
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 100%;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    .modal-password-content {
        background-color: #ffffff; /* 흰색 배경 */
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #ddd;
        width: 150%;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        text-decoration: none;
        cursor: pointer;
    }

    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin: 6px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button.viewTrain-button {
    display: block;
    margin: 20px auto; /* 기존 여백 */
    margin-top: 10px; /* 상단 여백 추가 */
    }

    body {
        overflow-y: auto; /* 세로 스크롤을 활성화 */
    }
</style>
</head>
<body>
    <div id="wrapper">
        
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
            

                <!-- Main Content Area -->
                <br>
                <h1 style="text-align: center;">:P:P 임시 비밀번호 전송</h1>
                <hr>
                <main>
                    <form method="post" action="/sendTemporaryPassword" id="authform">
                        <section class="mem-content">    
                            <h2 style="margin-bottom: 30px;">임시 비밀번호</h2>
                            <p class="ppap">
                                이메일 : <input type="email" name="email" required>
                            </p>
                            <br>
                            <br>
                            <button class="viewTrain-button" id="authBtn">전송</button>
                        </section>
                    </form>
                </main>
            </div>
        </div>
    </div>

    <script type="text/javascript">    
        $("#Login").click(function(){ // 로그인 페이지 이동 버튼
            location.href = "${path}/login";
        });

        var msg = "${msg}";
        if (msg != "") { // 알림 메세지 출력
            alert(msg);
        }
    </script>
</body>
</html>
