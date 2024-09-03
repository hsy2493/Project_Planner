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
        .btn-danger {
    background-color: #dc3545;
    color: white;
    border-radius: 5px;
    margin-left: 10px;
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
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" 
                                         onclick="showDetails('${taskTodo.todoid}', '${taskTodo.todo_text}', '${taskTodo.task_start_date}', 
                                         '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}', '${taskTodo.todo_review_status}')">
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
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" 
                                         onclick="showDetails('${taskTodo.todoid}', '${taskTodo.todo_text}', '${taskTodo.task_start_date}', 
                                         '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}', '${taskTodo.todo_review_status}')">
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
                                <c:if test="${taskTodo.todo_status == '완료' &&taskTodo.todo_review_status != '결재 완료'}">
                                    <div class="task-item" data-toggle="modal" data-target="#detailsModal" 
                                         onclick="showDetails('${taskTodo.todoid}', '${taskTodo.todo_text}', '${taskTodo.task_start_date}', 
                                         '${taskTodo.task_end_date}', '${taskTodo.empno}', '${taskTodo.todo_status}', '${taskTodo.todo_review_status}')">
                                        <div class="task-title">${taskTodo.todo_text}</div>
                                        <div class="task-meta">
                                            시작: ${taskTodo.task_start_date.substring(0, 10)} <br>
                                            끝: ${taskTodo.task_end_date.substring(0, 10)} <br>
                                            결재 상태: ${taskTodo.todo_review_status}
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                      
						<!-- 반려 목록 -->
						<div id="rejected" class="column">
						    <div class="status-header">반려 목록</div>
						    <c:forEach var="taskTodo" items="${taskTodos}">
						        <c:if test="${taskTodo.todo_review_status == '반려'}">
						            <div class="task-item">
						                <div class="task-title">${taskTodo.todo_text}</div>
						                <div class="task-meta">
						                    시작: ${taskTodo.task_start_date.substring(0, 10)} <br>
						                    끝: ${taskTodo.task_end_date.substring(0, 10)} <br>
						                    결재 상태: ${taskTodo.todo_review_status} <br>
						                    반려 사유: ${taskTodo.reason} <br>
						                    <button type="button" class="btn btn-primary btn-sm" onclick="resubmitRequest('${taskTodo.todoid}')">재요청</button>
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
                    <div class="form-group">
                        <label for="reviewStatus">결재 상태</label>
                        <input type="text" id="reviewStatus" class="form-control" readonly>
                    </div>
                     <div class="form-group">
                        <label for="files">파일 업로드</label>
                        <input type="file" id="files" name="files" class="form-control" multiple>
                    </div>
                    <div class="form-group">
					     <label for="uploadedFiles">업로드된 파일목록</label>
						    <ul id="uploadedFiles">
						    <c:forEach var="file" items="${todoFiles}">
						        <li>
						            ${file.filename}
						            <a href="${path}/todos/${file.todoid}/download/${file.filename}" class="btn btn-link">다운로드</a>
						        </li>
						    </c:forEach>
						    </ul>
						     <button type="button" class="btn btn-danger btn-sm" onclick="deleteAllFiles('${taskTodo.todoid}')">전체 파일 삭제</button>
					</div>
                </div>
                <!-- 모달 창 안에 파일 목록을 표시하는 부분 -->
					
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="saveChanges(); uploadFiles();">저장</button>
                    <c:if test="${taskTodo.todo_review_status != '결재 대기' }">
                        <button type="button" class="btn btn-primary" onclick="requestApproval('${taskTodo.todoid}')">결재 요청</button>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
let selectedTodoId;

function showDetails(todoid, taskName, taskStart, taskEnd, empno, status, reviewStatus, reason) {
    selectedTodoId = todoid; 
    $('#taskName').val(taskName);
    $('#taskStart').val(taskStart);
    $('#taskEnd').val(taskEnd);
    $('#taskEmpno').val(empno);
    $('#statusSelect').val(status);
    $('#reviewStatus').val(reviewStatus);
    
    // 반려 사유가 있을 경우, 모달에 표시
    if (reviewStatus === '반려' && reason) {
        $('#reasonField').val(reason);
        $('#reasonField').show();  // 반려 사유 필드가 있다면 표시
    } else {
        $('#reasonField').hide();  // 없으면 숨김
    }

    $('#detailsModal').modal('show');
    
    // 파일 목록 불러오기
	$.ajax({
    url: '${path}/todos/' + todoid + '/files',
    type: 'GET',
    success: function(files) {
        let fileListHtml = '';
        files.forEach(function(file) {
            // 파일명에 대한 URL 인코딩 적용
            let encodedFilename = encodeURIComponent(file.filename);
            fileListHtml += '<li><a href="${path}/todos/' + file.todoid + '/download/' + encodedFilename + '" target="_blank">' + file.filename + '</a></li>';
        });
        $('#uploadedFiles').html(fileListHtml);
    },
    error: function(xhr, status, error) {
        console.error('Error loading files:', error);
    }
});

    $('#detailsModal').modal('show');
}

function saveChanges() {
    const newStatus = $('#statusSelect').val();

    $.ajax({
        url: '${path}/tasks/updateStatus',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ todoid: selectedTodoId, status: newStatus }),
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

function uploadFiles() {
    const files = $('#files')[0].files;

    let formData = new FormData();
    formData.append('todoid', selectedTodoId);

    if (files.length > 0) {
        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }
    }

    $.ajax({
        url: '${path}/todos/' + selectedTodoId + '/upload',
        type: 'POST',
        data: formData,
        processData: false, // 파일 데이터를 인코딩하지 않음
        contentType: false, // 파일 전송에 적합한 멀티파트 설정
        success: function(response) {
            console.log('Files uploaded successfully:', response);
            $('#detailsModal').modal('hide');
            location.reload(); // 페이지 새로고침
        },
        error: function(xhr, status, error) {
            console.error('Error uploading files:', error);
        }
    });
}

function requestApproval(todoid) {
    console.log('Requesting approval for todoid:', todoid); // 확인용 로그
    $.ajax({
        url: '${path}/tasks/requestApproval',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ todoid: selectedTodoId }),
        success: function(response) {
            console.log('Approval requested:', response);
            location.reload(); // 페이지 새로고침
        },
        error: function(xhr, status, error) {
            console.error('Error requesting approval:', error);
        }
    });
}

function deleteAllFiles(todoid) {
    if (confirm("정말로 모든 파일을 삭제하시겠습니까?")) {
        $.ajax({
            url: '${path}/todos/' + selectedTodoId + '/deleteFiles',
            type: 'DELETE',
            success: function(response) {
                alert(response );
                $('#uploadedFiles').empty(); // 목록을 비웁니다.
            },
            error: function(xhr, status, error) {
                console.error('Error deleting files:', error);
                alert('파일 삭제 중 오류가 발생했습니다.');
            }
        });
    }
}

function resubmitRequest(todoid) {
    $.ajax({
        url: '${path}/tasks/requestApproval',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ todoid: todoid }),
        success: function(response) {
            alert('재요청이 성공적으로 처리되었습니다.');
            location.reload(); // 페이지 새로고침
        },
        error: function(xhr, status, error) {
            console.error('Error re-submitting request:', error);
            alert('재요청 처리 중 오류가 발생했습니다.');
        }
    });
}
</script>

</html>

