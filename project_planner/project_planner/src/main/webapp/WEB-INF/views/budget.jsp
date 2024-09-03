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
<title>PROJECT PLANNER BUDGET</title>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link rel="stylesheet" href="${path}/a00_com/css/styles.css">

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<style>
    /* General Body Styles */
    body {
        font-family: 'Arial', sans-serif;
        background-color: #ffffff; /* Set background color to white */
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #3498DB;
        color: white;
        padding: 10px 0;
    }

    h1 {
        margin: 0;
        font-size: 24px;
    }

    nav h2 {
        text-align: center;
        font-size: 20px;
        margin: 0;
        color: white;
    }

    main {
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }

    /* Content Section Styles */
    .mem-content {
        padding: 5px;
        border-radius: 8px;
        width: 80%;
        height:30px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border: none; /* Remove the border to eliminate the blue line */
        margin-top: -110px; /* Move the box further up */
    }

    /* Table Styles */
    table {
        width: 100%; /* Adjust the width as needed */
        max-width: 1300px; /* Set a maximum width if needed */
        border-collapse: collapse;
        margin: 0 auto; /* Center the table horizontally */
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
        vertical-align: middle;
    }

    th {
        background-color: #0288d1;
        color: white;
        font-weight: bold;
        text-align: center;
    }

    td:nth-child(2) {
        background-color: #b3e5fc;
        text-align: center;
    }

    /* Button Styles */
    button {
        padding: 8px 16px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        margin: 0 10px; /* Add horizontal margin for spacing */
    }

    button#view_t {
        background-color: #28a745; /* 지출내역 */
        color: white;
    }

    button#modify {
        background-color: #007bff; /* 수정 */
        color: white;
    }

    button#delete {
        background-color: #dc3545; /* 삭제 */
        color: white;
    }

    button#register {
        background-color: #6c757d; /* 등록 */
        color: white;
    }

    /* Button container alignment */
    .button-container {
        text-align: center; /* Center the buttons */
        margin-top: 15px; /* Space above the buttons */
    }

    footer {
        text-align: center;
        padding: 10px;
        background-color: #01579b;
        color: white;
    }

    footer p {
        margin: 0;
    }

    /* Central alignment style */
    .center-text {
        text-align: center;
        margin-top: 2px; /* Project budget management title positioned higher */
    }
</style>

</head>

<body>
		
<header>
		<div class="logo">
			<h1>Project Planner :P:P</h1>
		</div>
</header>

<nav>
		<ul>
			<h2>:P:P 프로젝트 예산목록</h2>
		</ul>
</nav>

<main>
    <section class="mem-content">
        <h2 class="center-text">:P:P 프로젝트 예산 관리</h2>
        <table>
            <tr>
                <th>항목</th>
                <th>내용</th>
            </tr>
            <tr>
                <td>1. 프로젝트명</td>
                <td>PMS 프로젝트</td>
            </tr>
            <tr>
                <td>2. 프로젝트 ID</td>
                <td>PP-101</td>
            </tr>
            <tr>
                <td>3. 예산 항목</td>
                <td>디자인 비용</td>
            </tr>
            <tr>
                <td>4. 예상 비용</td>
                <td>5,000,000 원</td>
            </tr>
            <tr>
                <td>5. 실제 비용</td>
                <td>2,500,000 원</td>
            </tr>
            <tr>
                <td>6. 예산 사용 비율</td>
                <td>50%</td>
            </tr>
            <tr>
                <td>7. 예산 사용 상태</td>
                <td>정상</td>
            </tr>
            <tr>
                <td>8. 담당자</td>
                <td>홍길동</td>
            </tr>
            <tr>
                <td>9. 예산 승인 상태</td>
                <td>승인됨</td>
            </tr>
        </table>
        <div class="button-container">
            <button id="view_t">지출내역</button>
            <button id="modify">수정</button>
            <button id="delete">삭제</button>
            <br>
            <button id="register">등록</button>
        </div>
    </section>

</main>

<script type="text/javascript">
		$("#gogoBtn").click(function(){
			location.href="mem02.do?m_id=${mem.m_id}"
		})
		$("#view_t").click(function(){
			location.href="train.do?m_id=${mem.m_id}"
		})
		$("#goHome").click(function(){
			location.href="http://localhost:7080/htproject/semi-final/MainHome.jsp"
		})
</script>	

</body>
	
</html>
