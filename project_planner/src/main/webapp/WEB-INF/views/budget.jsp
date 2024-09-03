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
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<style>
/* General Body Styles */
body {
    font-family: 'Nunito', sans-serif;
    margin: 0;
    padding: 0;
}

#wrapper {
    display: flex;
}

.sidebar {
    width: 225px;
    background-color: #343a40;
    color: white;
    height: 100vh;
    position: fixed;
    top: 0; 
    left: 0;
    overflow-y: auto;
}

.content-wrapper {
    margin-left: 225px;
    width: calc(100% - 225px);
    padding: 20px;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

/* Project Budget Management Table */
table {
    width: 100%;
    border-collapse: collapse;
    margin: 0 auto;
    margin-bottom: 20px;
    font-size: 14px;
}

table, th, td {
    border: 1px solid #ddd;
    padding: 8px;
}

th {
    background-color: #0288d1;
    color: white;
    text-align: center;
}

td {
    text-align: left;
}

td.label {
    font-weight: bold;
    background-color: #f2f2f2;
}

.footer-text {
    text-align: right;
    font-size: 12px;
    margin-top: 20px;
}

/* Button Styles */
.button-container {
    display: flex;
    justify-content: flex-end;
    margin-top: 20px;
}

.button-container button {
    padding: 10px 20px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    font-size: 16px;
    margin-left: 10px;
}

.btn-green {
    background-color: #28a745; /* 버튼 배경색 */
    color: white; /* 버튼 텍스트 색상 */
    border: none; /* 기본 테두리 제거 */
    border-radius: 12px; /* 테두리 둥글게 */
    padding: 10px 20px; /* 버튼 안쪽 여백 (위/아래, 좌/우) */
    cursor: pointer; /* 마우스 커서가 손가락 모양으로 변경 */
    margin-left: 450px; /* 버튼의 오른쪽에 추가 여백 */
}

/* 버튼을 오른쪽으로 이동시키기 위한 컨테이너 스타일 */
.button-container {
    display: flex;
    justify-content: flex-end; /* 버튼을 오른쪽으로 이동 */
}

.btn-blue {
    background-color: #007bff;
    color: white;
}

.btn-red {
    background-color: #dc3545;
    color: white;
}

.btn-coral {
    background-color: #F08080;
    color: white;
}

/* Modal Styles */
.modal {
    display: none;
    position: fixed;
    z-index: 1050;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 50%;
    height: 850px;
    max-width: 800px;
    background-color: #fefefe;
    box-shadow: 0 5px 15px rgba(0,0,0,.5);
    padding: 20px;
}

.modal-backdrop {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1040;
}

.modal-content {
    z-index: 1051; /* 모달 배경보다 위에 위치하도록 z-index 설정 */
}

.modal-buttons {
    display: flex;
    justify-content: flex-end;
}

.modal-buttons button {
    padding: 8px 16px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    font-size: 14px;
    margin-left: 10px;
}
</style>
</head>

<body>
    <div id="wrapper">
        <div class="sidebar">
            <%@ include file="a02_sliderBar.jsp" %>
        </div>
        <div id="content-wrapper" class="content-wrapper">
            <%@ include file="a03_topBar.jsp" %>
            
            <h2>프로젝트 예산 관리</h2>
             
            <table>
                <thead>
                    <tr>
                        <th>프로젝트명</th>
                        <th>예산 항목</th>
                        <th>예상 비용</th>
                        <th>실제 비용</th>
                        <th>예산 사용 상태</th>
                        <th>담당자</th>
                        <th>예산 승인 상태</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${budgetList}">
                        <tr>
                            <td>${b.projectname}</td>
                            <td>${b.budcontent}</td>
                            <td>${b.budget} 원</td>
                            <td>${b.budActual} 원</td>
                            <td>${b.status}</td>
                            <td>${b.empno} 님</td>
                            <td>${b.approval}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                     
            <div class="button-container">
                <button class="btn-blue" id="showBudgetModalBtn">새 예산 등록</button>
            </div>
        </div>
    </div>

   

    <!-- The Budget Management Modal -->
    <div id="budgetModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>새 예산 등록</h2>
             <form method="post" action="${path}/projects/${projectid}/insertBudget" id="budgetForm">
                <table>
                    <tr>
                        <td class="label">예산 항목</td>
                        <td><input type="text" name="budcontent" required></td>
                    </tr>
                    <tr>
                        <td class="label">예상 비용</td>
                        <td><input type="number" name="budget" required>원</td>
                    </tr>
                    <tr>
                        <td class="label">실제 비용</td>
                        <td><input type="number" name="budActual" required>원</td>
                    </tr>
                    <tr>
                        <td class="label">사용 상태</td>
                        <td><input type="text" name="status" required></td>
                    </tr>
                    <tr>
                        <td class="label">승인 상태</td>
                        <td><input type="text" name="approval" required></td>
                    </tr>
                </table>
                <button class="btn-green" type="submit"  onclick="return confirmSubmission()">등록</button>
            </form>
            <div class="modal-buttons">
                
               
            </div>
        </div>
    </div>

    <script>
    $(document).ready(function() {
        // Budget Management Modal
        $("#showBudgetModalBtn").click(function() {
            $('#budgetModal').show(); // 모달 열기
        });

        // 모달 닫기
        $(".close").click(function() {
            $(this).closest(".modal").hide(); // 모달 닫기
        });
        
        

        $(window).click(function(event) {
            if ($(event.target).hasClass('modal')) {
                $(event.target).hide();
            }
        });
        
     // 등록 버튼 클릭 시 확인 메시지 표시
        window.confirmSubmission = function() {
            return confirm("예산을 등록하시겠습니까?");
     	};
    });
    </script>

</body>
</html>
