<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>일정 관리</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<style>
body {
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 100%;
}

.input-group-text {
	width: 100%;
	background-color: linen;
	color: black;
	font-weight: bolder;
}

.input-group-prepend {
	width: 30%;
}
.form-group{
	margin-left:20px;
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.2/main.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.2/main.min.css" />
</head>
<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar">
			<jsp:include page="a02_sliderBar.jsp" />
		</div>

		<!-- Content Wrapper -->
		<div id="content-wrapper">

			<!-- Topbar -->
			<jsp:include page="a03_topBar.jsp" />

			<!-- Main Content -->
			<div id="content">
			<div class="form-group">
            <label for="divPersonal">
                <input type="checkbox" id="divPersonal"> 개인
            </label>
            <label for="divTeam">
                <input type="checkbox" id="divTeam"> 팀
            </label>
            <label for="divGantt">
                <input type="checkbox" id="divGantt"> 간트
            </label>
        	</div>
        	
        	프로젝트 ID :
        	<select id="projectSelect" name="projectid" class="form-control">
    			<c:forEach var="proList" items="${projectList}">
       				<option value="${proList.projectid}" 
        		    	<c:if test="${proList.projectid == 47}">selected</c:if>>
            			${proList.projectid} - ${proList.projectname}
        			</option>
    			</c:forEach>
    			<option value="0">없음</option>
			</select>
			<br>
        	
				<div id='calendar'></div>

				<!-- Modal -->
				<div id="showModel" data-toggle="modal" data-target="#calModal"></div>

				<div class="modal fade" id="calModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalTitle">타이틀</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form id="frm02" class="form" method="post">
									<input type="hidden" name="id" value="0" />
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">일정명</span>
										</div>
										<input name="title" placeholder="일정 입력" class="form-control" />
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">작성자</span>
										</div>
										<input name="writer" class="form-control" value="${writer}"
											readonly />
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">시작(일/시)</span>
										</div>
										<input id="start" class="form-control" readonly/> <input name="start"
											type="hidden" />
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">종료(일/시)</span>
										</div>
										<input id="end" class="form-control" readonly/> <input name="end"
											type="hidden" />
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">내용</span>
										</div>
										<textarea name="content" rows="5" cols="10"
											class="form-control"></textarea>
									</div>
									<div class="input-group mb-3" style="display:none;">	
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">배경색상</span>
										</div>
										<input name="backgroundColor" value="#0099cc" type="color" placeholder="색상선택"  class="form-control" />	
									</div>	
									<div class="input-group mb-3" style="display:none;">	
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">글자색상</span>
										</div>
										<input name="textColor"   value="#ccffff"  type="color" placeholder="글자선택"  class="form-control" />	
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">종일여부</span>
										</div>
										<select name="allDay" class="form-control">
											<option value="1">종일</option>
											<option value="0">시간</option>
										</select>
									</div>
									
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">연관페이지</span>
										</div>
										<input name="urlLink" placeholder="연관 URL 링크 주소 입력"
											class="form-control" />
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">팀/개인</span>
										</div>
										<select name="div" class="form-control">
											<option value="팀">팀</option>
											<option value="개인">개인</option>
										</select>
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text justify-content-center">프로젝트ID</span>
										</div>
									<select id="projectSelect" name="projectid" class="form-control" required>
    									<c:forEach var="proList" items="${projectList}">
       										<option value="${proList.projectid}" 
        		    							<c:if test="${proList.projectid == 47}">selected</c:if>>
            									${proList.projectid} - ${proList.projectname}
        									</option>
    									</c:forEach>
    										<option value=0>없음</option>
									</select>	
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button id="regBtn" type="button" class="btn btn-primary">등록</button>
								<button id="uptBtn" type="button" class="btn btn-info">수정</button>
								<button id="delBtn" type="button" class="btn btn-danger">삭제</button>
								<button id="clsBtn" type="button" class="btn btn-secondary"
									data-dismiss="modal">창닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
	    var calendar;
	    var isGanttChecked = false;

	    // 페이지 로드 시 '개인' 체크박스 체크
	    document.getElementById('divPersonal').checked = true;

	    var projectSelect = document.getElementById('projectSelect');
	    projectSelect.value = '47'; // 기본값을 '47'로 설정

	    var calendarEl = document.getElementById('calendar');
	    var today = new Date();
	    var todayTitle = today.toISOString().split("T")[0];
	    calendar = new FullCalendar.Calendar(calendarEl, {
	        headerToolbar: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'dayGridMonth,timeGridWeek,timeGridDay'
	        },
	        initialDate: todayTitle,
	        navLinks: true,
	        selectable: true,
	        selectMirror: true,
	        select: function(arg) {
	            if (!isGanttChecked) {
	                $("#showModel").click();
	                $("#modalTitle").text("일정등록");
	                $("#regBtn").show();
	                $("#uptBtn").hide();
	                $("#delBtn").hide();
	                addForm(arg, "I");
	            }
	        },
	        eventClick: function(arg) {
	            $("#modalTitle").text("일정상세");
	            $("#showModel").click();
	            $("#regBtn").hide();
	            $("#uptBtn").toggle(!isGanttChecked); // Gantt가 체크되면 숨기기
	            $("#delBtn").toggle(!isGanttChecked); // Gantt가 체크되면 숨기기
	            addForm(arg.event);
	        },
	        eventDrop: function(arg) {
	            if (!isGanttChecked) {
	                addForm(arg.event);
	                ajaxFun("updateCalendar");
	            }
	        },
	        eventResize: function(arg) {
	            if (!isGanttChecked) {
	                addForm(arg.event);
	                ajaxFun("updateCalendar");
	            }
	        },
	        editable: true,
	        dayMaxEvents: true,
	        events: function(info, successCallback, failureCallback) {
	            var divArray = getDivArray();
	            var selectedProjectId = $("#projectSelect").val();
	            $.ajax({
	                url: "calList",
	                dataType: "json",
	                traditional: true,
	                data: {
	                    div: divArray,
	                    gant: $("#divGantt").is(":checked"),
	                    projectid: selectedProjectId
	                },
	                success: function(data) {
	                    calendar.removeAllEvents();
	                    calendar.addEventSource(data.calList);
	                    successCallback(data);
	                },
	                error: function(err) {
	                    failureCallback(err);
	                }
	            });
	        }
	    });
	    calendar.render();

	    // 체크박스 상태에 따라 일정을 새로 고칩니다.
	    $("#divPersonal, #divTeam, #divGantt, #projectSelect").change(function() {
	        console.log("Refetching events...");
	        isGanttChecked = $("#divGantt").is(":checked");
	        calendar.refetchEvents();
	    });

	    $("#regBtn").click(function() {
	        if (confirm("등록하시겠습니까?")) {
	            ajaxFun("insertCalendar");
	        }
	    });
	    $("#uptBtn").click(function() {
	        if (confirm("수정하시겠습니까?")) {
	            ajaxFun("updateCalendar");
	        }
	    });
	    $("#delBtn").click(function() {
	        if (confirm("삭제하시겠습니까?")) {
	            ajaxFun("deleteCalendar");
	        }
	    });

	    function addForm(event, proc) {
	        $("#frm02")[0].reset();
	        if (proc !== "I") {
	            $("[name=id]").val(event.id);
	            $("[name=backgroundColor]").val(event.backgroundColor);
	            $("[name=textColor]").val(event.textColor);
	            $("[name=writer]").val(event.extendedProps.writer);
	            $("[name=content]").val(event.extendedProps.content);
	            $("[name=urlLink]").val(event.extendedProps.urlLink);
	            $("[name=div]").val(event.extendedProps.div);
	            $("[name=projectid]").val(event.extendedProps.projectid || 0);
	        }
	        $("[name=title]").val(event.title);
	        $("[name=start]").val(event.startStr);
	        $("#start").val(event.start.toLocaleString());
	        if (event.end != null) {
	            $("[name=end]").val(event.endStr);
	            $("#end").val(event.end.toLocaleString());
	        } else {
	            $("[name=end]").val(event.startStr);
	            $("#end").val(event.start.toLocaleString());
	        }
	        $("[name=allDay]").val(event.allDay ? 1 : 0);
	        if (proc === "I") {
	            $("[name=div]").val("팀");
	            $("[name=projectid]").val(0);
	        }
	    }

	    function ajaxFun(url) {
	        $.ajax({
	            type: "post",
	            url: url,
	            data: $("form").serialize(),
	            dataType: "json",
	            success: function(data) {
	                calendar.removeAllEvents();
	                calendar.addEventSource(data.calList);
	                if (data.msg.indexOf("수정") === -1) {
	                    $("#clsBtn").click();
	                }
	            },
	            error: function(err) {
	                console.log(err);
	            }
	        });
	    }

	    function getDivArray() {
	        var div = [];
	        if ($("#divPersonal").is(":checked")) div.push("개인");
	        if ($("#divTeam").is(":checked")) div.push("팀");
	        if ($("#divGantt").is(":checked")) div.push("간트");
	        return div;
	    }
	});

</script>

</body>
</html>
