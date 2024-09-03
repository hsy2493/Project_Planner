<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>결재 리스트</title>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <!-- 사이드바 삽입 -->
        <%@ include file="a02_sliderBar.jsp" %>
        
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <!-- 탑바 삽입 -->
                <%@ include file="a03_topBar.jsp" %>
                
                <div class="container-fluid">
                    <h1 class="h3 mb-4 text-gray-800">결재 리스트</h1>
                    
                    <!-- 사용자 역할이 PM인지 확인 -->
                    <c:if test="${userList[0].role eq 'PM' or userList[0].role eq 'CEO' }">
                        <c:if test="${not empty approvalTodos}">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>내용</th>
                                        <th>상태</th>
                                        <th>담당자</th>
                                        <th>결재 상태</th>
                                        <th>승인여부</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="todo" items="${approvalTodos}">
                                        <tr>
                                            <td>${todo.text}</td>
                                            <td>${todo.status}</td>
                                            <td>${todo.empno}</td>
                                            <td>${todo.review_status}</td>
                                            <c:if test="${todo.review_status != '결재 완료'}">
                                            <td>
                                                <button class="btn btn-success" onclick="approve(${todo.todoid})">승인</button>
                                                <button class="btn btn-danger" onclick="showRejectModal(${todo.todoid})">반려</button>
                                            </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty approvalTodos}">
                            <p>결재 요청된 항목이 없습니다.</p>
                        </c:if>
                    </c:if>

                    <!-- PM 역할이 아닌 사용자가 접근할 때 -->
                    <c:if test="${userList[0].role ne 'PM' and userList[0].role ne 'CEO' }">
                        <p>이 페이지는 PM만 접근할 수 있습니다.</p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <!-- 반려 모달 -->
    <div class="modal fade" id="rejectModal" tabindex="-1" role="dialog" aria-labelledby="rejectModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="rejectModalLabel">반려 사유 입력</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <textarea id="rejectReason" class="form-control" placeholder="반려 사유를 입력하세요"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-danger" onclick="reject()">반려</button>
                </div>
            </div>
        </div>
    </div>

    <script>
    let selectedTodoId;

    function approve(todoid) {
        $.ajax({
            url: '${path}/approve',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ todoid: todoid }),
            success: function(response) {
                alert(response);
                location.reload(); // 페이지 새로고침
            },
            error: function(xhr, status, error) {
                console.error('Error approving task:', error);
            }
        });
    }

    function showRejectModal(todoid) {
        selectedTodoId = todoid;
        $('#rejectModal').modal('show');
    }

    function reject() {
        const reason = $('#rejectReason').val();
        if (reason.trim() === '') {
            alert('반려 사유를 입력하세요.');
            return;
        }

        $.ajax({
            url: '${path}/reject',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ todoid: selectedTodoId, reason: reason }),
            success: function(response) {
                alert('반려되었습니다.');
                $('#rejectModal').modal('hide');
                location.reload(); // 페이지 새로고침
            },
            error: function(xhr, status, error) {
                console.error('Error rejecting task:', error);
            }
        });
    }
    </script>
</body>
</html>
