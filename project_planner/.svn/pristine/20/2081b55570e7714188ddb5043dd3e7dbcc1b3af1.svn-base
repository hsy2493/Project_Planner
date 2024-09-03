<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
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

.input-group {
    display: inline-block;
}

.form-group {
	margin-bottom: 20px; /* 변경된 부분 */
}

.form-control {
    display: block;
}

#divPersonal,
#divTeam,
#divGantt {
    display: inline-block;
}
</style>
</head>

<body>
	<div id='calendar'></div>

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
						<input type="hidden" name="id" value="0"/>
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">일정명</span>
							</div>
							<input name="div" placeholder="입정 입력"  class="form-control" />	
						</div>	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">작성자</span>
							</div>
							<input name="writer" placeholder="작성자 입력"  class="form-control" />	
						</div>	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">시 작(일/시)</span>
							</div>
							<input id="start"  class="form-control" /><!-- 화면에 보일 날짜/시간.. -->	
							<input name="start" type="hidden"   />	<!-- 실제 저장할 날짜/시간 -->
						</div>	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">종 료(일/시)</span>
							</div>
							<input id="end"  class="form-control" />	
							<input name="end" type="hidden"   />	
						</div>		
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">내용</span>
							</div>
							<textarea name="content" rows="5" cols="10" class="form-control"></textarea>			
						</div>	
																	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">배경색상</span>
							</div>
							<input name="backgroundColor" value="#0099cc" type="color" placeholder="색상선택"  class="form-control" />	
						</div>	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">글자색상</span>
							</div>
							<input name="textColor"   value="#ccffff"  type="color" placeholder="글자선택"  class="form-control" />	
						</div>							
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">종일여부</span>
							</div>
							<select name="allDay"  class="form-control" >
								<option value="1">종일</option>
								<option value="0">시간</option>
							</select>	
						</div>	
						<div class="input-group mb-3">	
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">연관페이지</span>
							</div>
							<input name="urlLink" placeholder="연관 url링크 주소 입력"  class="form-control" />	
						</div>
						<div class="input-group mb-3">	
    						<div class="input-group-prepend ">
       							<span class="input-group-text  justify-content-center">팀/개인</span>
    						</div>
    						<input name="div" class="form-control" readonly/>	
						</div>																									
						<div class="input-group mb-3">	
    						<div class="input-group-prepend ">
        						<span class="input-group-text  justify-content-center">프로젝트id</span>
    						</div>
    						<input name="projectid" placeholder="프로젝트id" class="form-control" readonly/>	
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
	<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script src='${path}/a00_com/dist/index.global.js'></script>
<script type="text/javascript">
	var calendar;
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var today = new Date()
		var todayTitle = today.toISOString().split("T")[0]
		calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : todayTitle,
			navLinks : true, 
			selectable : true,
			selectMirror : true,
			select : function(arg) {
				$("#showModel").click()
				$("#modalTitle").text("일정등록")
				$("#regBtn").show()
				$("#uptBtn").hide()
				$("#delBtn").hide()
				addForm(arg,"I")
			},
			eventClick : function(arg) {
				$("#modalTitle").text("일정상세")
				$("#showModel").click()
				$("#regBtn").hide()
				$("#uptBtn").show()
				$("#delBtn").show()			
				addForm(arg.event)
				
			},
			eventDrop:function(arg){
				addForm(arg.event)
				ajaxFun("updateCalendar")
				
			},
			eventResize:function(arg){
				addForm(arg.event)
				ajaxFun("updateCalendar")
				
			},			
			editable : true,
			dayMaxEvents : true, 
			events : function(info, successCallback, failureCallback) {
				
				var selectedDiv = [];
                if ($('#divPersonal').is(':checked')) selectedDiv.push('개인');
                if ($('#divTeam').is(':checked')) selectedDiv.push('팀');
                
				$.ajax({
					url : "calList",
					dataType : "json",
					data: {
                        div: selectedDiv,
                        gant: $('#divGantt').is(':checked')
                    },
					success : function(data) {
						console.log(data);
						calendar.removeAllEvents();
						successCallback(data);
					},
					error : function(err) {
						failureCallback(err);
					}
				});
			}
		});
		calendar.render();
		
		$("#regBtn").click(function(){
			if(confirm("등록하시겠니까?")){
				// 등록 처리 ajax 처리..
				 ajaxFun("insertCalendar")
			}		
		})
		// uptBtn delBtn
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠니까?")){
				 ajaxFun("updateCalendar")
			}		
		})		
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠니까?")){
				 ajaxFun("deleteCalendar")
			}		
		})			
		
		function addForm(event, proc){
			console.log("#일정#")
			console.log(event)
			$("form")[0].reset()
			if(proc != "I" ){
				$("[name=id]").val(event.id)
				$("[name=backgroundColor]").val(event.backgroundColor)
				$("[name=textColor]").val(event.textColor)
				$("[name=writer]").val(event.extendedProps.writer)
				$("[name=content]").val(event.extendedProps.content)
				$("[name=urlLink]").val(event.extendedProps.urlLink)
				$("[name=div]").val(event.extendedProps.div)
				$("[name=projectid]").val(event.extendedProps.projectid)
			}
			$("[name=title]").val(event.title)
			$("[name=start]").val(event.startStr)
			$("#start").val(event.start.toLocaleString())
			if(event.end != null) {
				$("[name=end]").val(event.endStr)
				$("#end").val(event.end.toLocaleString())
			}else{
				$("[name=end]").val(event.startStr)
				$("#end").val(event.start.toLocaleString())			
			}			
			$("[name=allDay]").val(event.allDay?1:0)
		}
		function ajaxFun(url){
			$.ajax({
				type:"post",
				url:url,
				data:$("form").serialize(),
				dataType:"json",
				success:function(data){
					alert(data.msg)  //  data.msg data.calList
					calendar.removeAllEvents()
					calendar.addEventSource(data.calList)
					// 수정 처리 외외는 창닫기 처리..
					if(data.msg.indexOf("수정")==-1){
						$("#clsBtn").click()	
					}
					
				},
				error:function(err){
					console.log(err)
				}
			})
		}
		
		
	});
</script>
</body>
</html>