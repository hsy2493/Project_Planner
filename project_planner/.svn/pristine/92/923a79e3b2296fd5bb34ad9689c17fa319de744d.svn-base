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
<title>PROJECT PLANNER MyPage</title>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link rel="stylesheet" href="${path}/a00_com/css/styles.css">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<style>
    .container {
        display: flex;
        justify-content: space-between;
    }
    .section {
        flex: 1;
        margin: 0 10px;
    }
    .section h2 {
        margin-bottom: 20px;
    }
    .ppap {
        margin-bottom: 10px;
    }
    /* 모달 스타일 */
    .modal {
        display: none; 
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgb(0,0,0);
        background-color: rgba(0,0,0,0.4);
    }
    .modal-content {
        background-color: #fefefe;
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    .modal-password-content {
        background-color: #ffffff; /* 흰색 배경 */
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #ddd;
        width: 80%;
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
        color: black;
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
</style>
</head>

<body>
<header>
    <div class="logo">
        <h1>Project Planner :P:P</h1>
    </div>
    <div class="user-buttons">
        <button class="home-button" id="goHome">메인 홈으로</button>
    </div>
</header>

<nav>
    <ul>
        <h1>:P:P 내정보</h1>
    </ul>
</nav>

<main>
<div class="container">
    <section class="section mem-content">  
        <h2>개인 정보</h2>
        <c:forEach var="user" items="${userList}">
            <p class="ppap">
                이름 : ${user.name}
            </p>
            <p class="ppap">
                이메일 : ${user.email}
            </p>
        </c:forEach>
        <br>
        <br>
        <button class="viewTrain-button" id="findpwd">비밀번호 재설정</button>
    </section>

    <section class="section mem-content">
        <h2>사원 정보</h2>
        <c:forEach var="user" items="${userList}">
            <p class="ppap" id="empNo">
                사원번호 : ${user.empno}
            </p>           
            <p class="ppap" id="roleDisplay">
                역할 : ${user.role}
            </p>
        </c:forEach>

          <br><br><button class="viewTrain-button" id="openModal">역할 변경</button>
    </section>
</div>
</main>

<!-- 역할 변경 -->
<div id="roleModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>역할 선택</h2>
        <form id="roleForm" method="post" action="/updateUserRole">
            <p class="ppap">
                역할:
                <select name="role" id="roleSelect">
                    <option value="PM" <c:if test="${user.role == 'PM'}">selected</c:if>>Project-Manager</option>
                    <option value="FE" <c:if test="${user.role == 'FE'}">selected</c:if>>Front-End</option>
                    <option value="BE" <c:if test="${user.role == 'BE'}">selected</c:if>>Back-End</option>
                    <option value="DB" <c:if test="${user.role == 'DB'}">selected</c:if>>Data-base</option>
                </select>
            </p>
            <br><br>
            <button class="viewTrain-button" type="button" id="updateRole">확인</button>
        </form>
    </div>
</div>

<!-- 비밀번호 재설정 -->
<div id="passwordModal" class="modal">
    <div class="modal-password-content">
        <span class="close">&times;</span>
        <h2>비밀번호 재설정</h2>
        <form id="passwordForm" method="post" action="/updatePwd">
            <p class="ppap">
                사원번호: <!-- 본인인증 -->
                <input type="text" name=empno id="empno" required>
            </p>
            <p class="ppap">
                새 비밀번호:
                <input type="password" name="newPassword" id="newPassword" required>
            </p>
            <p class="ppap">
                새 비밀번호 재확인:
                <input type="password" name="confirmPassword" id="confirmPassword" required>
            </p>
            <br><br>
            <button class="viewTrain-button" type="button" id="resetPassword">확인</button>
        </form>
    </div>
</div>

<script type="text/javascript">
    // 역할 변경 모달
    var roleModal = document.getElementById("roleModal");
    var roleBtn = document.getElementById("openModal");
    var roleSpan = document.getElementsByClassName("close")[0];
    var updateRoleBtn = document.getElementById("updateRole");

    // 역할 변경 모달 열기
    roleBtn.onclick = function() {
        roleModal.style.display = "block";
    }

    // 역할 변경 모달 닫기
    roleSpan.onclick = function() {
        roleModal.style.display = "none";
    }

    // 역할 변경 모달 외부 클릭 시, 모달 닫기
    window.onclick = function(event) {
        if (event.target == roleModal) {
            roleModal.style.display = "none";
        }
    }

    // 역할 선택 후, 폼 제출
    updateRoleBtn.onclick = function() {
        var roleSelect = document.getElementById("roleSelect");
        var selectedRole = roleSelect.options[roleSelect.selectedIndex].text;
        var roleDisplay = document.getElementById("roleDisplay");

        if (confirm("선택하시겠습니까?")) {
            // 역할 선택 후, 화면 단에 업데이트
            roleDisplay.textContent = '역할 : ' + selectedRole;
            // 폼 제출
            document.getElementById("roleForm").submit();
        }
    };

    // 비밀번호 재설정 모달
    var passwordModal = document.getElementById("passwordModal");
    var findPwdBtn = document.getElementById("findpwd");
    var passwordSpan = document.getElementsByClassName("close")[1];
    var resetPasswordBtn = document.getElementById("resetPassword");

    // 비밀번호 재설정 모달 열기
    findPwdBtn.onclick = function() {
        passwordModal.style.display = "block";
    }

    // 비밀번호 재설정 모달 닫기
    passwordSpan.onclick = function() {
        passwordModal.style.display = "none";
    }

    // 비밀번호 재설정 모달 외부 클릭 시, 모달 닫기
    window.onclick = function(event) {
        if (event.target == passwordModal) {
            passwordModal.style.display = "none";
        }
    }

    //비밀번호 재설정 후, 새비밀번호 데이터 저장
   resetPasswordBtn.onclick = function() {
    var newPassword = document.getElementById("newPassword").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (newPassword !== confirmPassword) { //일치하지 않은 경우
        alert("새 비밀번호가 일치하지 않습니다.");
        return;
    }

    if (confirm("비밀번호를 재설정하시겠습니까?")) { //일치한 경우
        //form 입력 데이터 제출
        document.getElementById("passwordForm").submit();
    }
  };

    var msg = "${msg}";
    if (msg != "") { //알림 메세지 출력
        alert(msg);
    }

    // 홈버튼 클릭 시, 메인창으로 이동
    $("#goHome").click(function(){ 
        location.href = "${path}/my";
    });
</script>
</body>
</html>