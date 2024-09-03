<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>ToDo List</title>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <style>
        .board {
            display: flex;
            justify-content: space-around;
            margin: 20px;
        }
        .column {
            width: 30%;
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .task-item {
            background-color: #e9ecef;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
            cursor: pointer;
        }
        .task-title {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .task-meta {
            font-size: 14px;
            color: #6c757d;
        }
        .status-header {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <%@ include file="a02_sliderBar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="a03_topBar.jsp" %>
                <div class="container-fluid">
                    <div class="board">
                        <!-- 할 일 -->
                        <div id="todo" class="column">
                            <div class="status-header">할 일</div>
                            <c:forEach var="taskTodo" items="${taskTodos}">
                                <c:if test="${taskTodo.todo_status == '예정'}">
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" onclick="showDetails('${taskTodo.todoid}', 
                                    '${taskTodo.todo_text}', '${taskTodo.task_start_date}', '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}')">
                                        <div class="task-title">${taskTodo.todo_text}</div>
                                        <div class="task-meta">
									    시작: ${taskTodo.task_start_date.substring(0, 10)} <br> 
									    끝: ${taskTodo.task_end_date.substring(0, 10)}
									</div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>

                        <!-- 진행 중 -->
                        <div id="in-progress" class="column">
                            <div class="status-header">진행 중</div>
                            <c:forEach var="taskTodo" items="${taskTodos}">
                                <c:if test="${taskTodo.todo_status == '진행중'}">
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" onclick="showDetails('${taskTodo.todoid}', 
                                    '${taskTodo.todo_text}', '${taskTodo.task_start_date}', '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}')">
                                        <div class="task-title">${taskTodo.todo_text}</div>
                                      <div class="task-meta">
									    시작: ${taskTodo.task_start_date.substring(0, 10)} <br> 
									    끝: ${taskTodo.task_end_date.substring(0, 10)}
									</div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>

                        <!-- 완료 -->
                        <div id="done" class="column">
                            <div class="status-header">완료</div>
                            <c:forEach var="taskTodo" items="${taskTodos}">
                                <c:if test="${taskTodo.todo_status == '완료'}">
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" onclick="showDetails('${taskTodo.todoid}', 
                                    '${taskTodo.todo_text}', '${taskTodo.task_start_date}', '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}')">
                                        <div class="task-title">${taskTodo.todo_text}</div>
                                       <div class="task-meta">
									    시작: ${taskTodo.task_start_date.substring(0, 10)} <br> 
									    끝: ${taskTodo.task_end_date.substring(0, 10)}
									</div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 모달 창 -->
    <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="detailsModalLabel">업무 상세</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskName">업무 이름</label>
                        <input type="text" id="taskName" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="taskStart">시작 날짜</label>
                        <input type="text" id="taskStart" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="taskEnd">끝나는 날짜</label>
                        <input type="text" id="taskEnd" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="taskEmpno">담당자</label>
                        <input type="text" id="taskEmpno" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="statusSelect">상태</label>
                        <select id="statusSelect" class="form-control">
                            <option value="예정">예정</option>
                            <option value="진행중">진행중</option>
                            <option value="완료">완료</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="saveChanges()">저장</button>
                </div>
            </div>
        </div>
    </div>

    <script>
    let selectedTodoId;

    function showDetails(todoid, taskName, taskStart, taskEnd, empno, status) {
        selectedTodoId = todoid; // 변수명을 selectedTaskId에서 selectedTodoId로 변경
        $('#taskName').val(taskName);
        $('#taskStart').val(taskStart);
        $('#taskEnd').val(taskEnd);
        $('#taskEmpno').val(empno);
        $('#statusSelect').val(status);
        $('#detailsModal').modal('show');
    }

    function saveChanges() {
        const newStatus = $('#statusSelect').val();

        $.ajax({
            url: '${path}/tasks/updateStatus',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ todoid: selectedTodoId, status: newStatus }), // 변수명을 todoid로 변경
            success: function(response) {
                console.log('Status updated:', response);
                $('#detailsModal').modal('hide');
                location.reload(); // 페이지 새로고침
            },
            error: function(xhr, status, error) {
                console.error('Error updating status:', error);
            }
        });
    }

    </script>
</body>
</html>
