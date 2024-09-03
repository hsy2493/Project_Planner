<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
 <!-- jQuery (필수 자바스크립트 라이브러리) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Bootstrap CSS -->
<link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- FontAwesome CSS -->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Google Fonts CSS -->
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- Custom CSS (SB Admin 2 스타일 등) -->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<!-- DHTMLX Gantt CSS -->
<link rel="stylesheet" href="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.css">
<!-- Bootstrap JS (Bootstrap의 자바스크립트 기능) -->
<script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DHTMLX Gantt JS -->
<script src="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.js"></script>
<!-- 기타 추가적인 스크립트나 스타일이 필요한 경우 -->
<meta charset="UTF-8">
<title>Gantt Chart</title>
  
    <style>
        .gantt-controls {
            margin-bottom: 20px;
            text-align: right;
        }
        .gantt-controls button {
            margin-right: 10px;
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
                    <div id="gantt_here" style="width:100%; height:500px;"></div>
                    <div class="gantt-controls">
                        <button onclick="setScale('day')">일</button>
                        <button onclick="setScale('week')">주</button>
                        <button onclick="setScale('month')">월</button>
                        <button onclick="setScale('quarter')">분기</button>
                    </div>
                </div>
                <a class="nav-link" href="${path}/projects/${projectId}/todo"> <button class="btn btn-primary">Todo List</button></a>  
            </div>
        </div>
    </div>
   <script>
   var msg = "${msg}"
   if(msg != ""){
	alert(msg)
   }
   $(document).ready(function() {
	    var projectId = "${projectId}";
	    
	    // 프로젝트 팀원 정보를 불러오는 API 호출
	    $.ajax({
	        url: "${path}/project/" + projectId + "/members1",
	        type: "GET",
	        dataType: "json",
	        success: function(members) {
	            // 팀원 정보를 Gantt serverList로 설정
	            var empnoOptions = members.map(function(member) {
	                return { key: member.empno, label: member.name };
	            });
	            gantt.serverList("empno", empnoOptions);
	            
	            // 기존의 tasks 정보를 불러오는 AJAX 호출
	            $.ajax({
	                url: "${path}/projects/" + projectId + "/tasks/json",
	                type: "GET",
	                dataType: "json",
	                success: function(data) {
	                    var now = new Date();
	                    data.sort(function(a, b) {
	                        var dateA = gantt.date.str_to_date("%Y-%m-%d %H:%i:%s")(a.start_date);
	                        var dateB = gantt.date.str_to_date("%Y-%m-%d %H:%i:%s")(b.start_date);
	                        return Math.abs(dateB - now) - Math.abs(dateA - now);
	                    });
	                    console.log(data);
	                    gantt.config.date_format = "%Y-%m-%d %H:%i:%s";

	                    gantt.serverList("progress", [
	                        { key: "예정", label: "예정" },
	                        { key: "진행중", label: "진행중" },
	                        { key: "완료", label: "완료" }
	                    ]);
	                    // Lightbox 설정
	                    gantt.i18n.setLocale({
	                        labels: {
	                            section_empno: "담당자",
	                            section_description: "일정/업무 내용",
	                            section_time: "기간",
	                            section_progress: "상태"
	                        }
	                    });

	                    gantt.config.lightbox.sections = [
	                        {name: "description", height: 38, map_to: "text", type: "textarea", focus: true},
	                        {name: "empno", height: 22, map_to: "empno", type: "select", options: gantt.serverList("empno")},
	                        {name: "progress", height: 22, map_to: "progress", type: "select", options: gantt.serverList("progress")},
	                        {name: "time", type: "duration", map_to: "auto"}
	                    ];

	                    gantt.init("gantt_here");
	                    gantt.parse({data: data});
	
	                },
	                error: function(xhr, status, error) {
	                    alert('Error: ' + error);
	                }
	            });
	        },
	        error: function(xhr, status, error) {
	            alert('Error loading members: ' + error);
	        }
	    });

	    var date_to_str = gantt.date.date_to_str("%Y-%m-%d %H:%i:%s");
		
	    // Add event listener for saving changes to the server
	    gantt.attachEvent("onAfterTaskAdd", function(id, item) {
	    	 console.log(item.empno); 	
	        $.ajax({
	            url: "${path}/tasks",
	            type: "POST",
	            contentType: "application/json",
	            data: JSON.stringify({
	                text: item.text,
	                empno: item.empno, // 추가된 empno 필드
	                start_date: date_to_str(item.start_date),
	                end_date: date_to_str(gantt.calculateEndDate(item.start_date, item.duration)),
	                progress: item.progress,
	                projectid: projectId
	            }),
	            success: function(response) {
	                console.log("Task added: ", response);
	                location.reload();
	            },
	            error: function(xhr, status, error) {
	                console.error('Error: ', error);
	                console.error('Response: ', xhr.responseText);
	            }
	        });
	    });
	
	    gantt.attachEvent("onAfterTaskUpdate", function(id, item) {
	        // 만약 'id'가 Gantt 차트에서 자체적으로 관리하는 ID라면, 이 ID 대신 'item.taskid'를 사용해야 합니다.
	        $.ajax({
	            url: "${path}/tasks/" + item.taskid,  // id 대신 item.taskid 사용
	            type: "PUT",
	            contentType: "application/json",
	            data: JSON.stringify({
	                taskid: item.taskid,  // 서버의 taskid를 정확히 설정
	                text: item.text,
	                empno: item.empno,
	                start_date: date_to_str(item.start_date),
	                end_date: date_to_str(gantt.calculateEndDate(item.start_date, item.duration)),
	                progress: item.progress,
	                projectid: projectId
	            }),
	            success: function(response) {
	                console.log("Task updated: ", response);
	            },
	            error: function(xhr, status, error) {
	                console.error('Error: ', error);
	                console.error('Response: ', xhr.responseText);
	            }
	        });
	    });

	    gantt.attachEvent("onAfterTaskDelete", function(id, item) {
	        $.ajax({
	            url: "${path}/tasks/" + item.taskid,
	            type: "DELETE",
	            success: function(response) {
	                console.log("Task delete: ", response);
	                alert(response);
	            },
	            error: function(xhr, status, error) {
	                console.error('Error: ', error);
	                console.error('Response: ', xhr.responseText);
	            }
	        });
	    });
	});

	function setScale(scale) {
	    switch (scale) {
	        case 'day':
	            gantt.config.scale_unit = "day";
	            gantt.config.date_scale = "%d %M";
	            gantt.config.subscales = [
	                {unit: "hour", step: 1, date: "%H"}
	            ];
	            gantt.config.scale_height = 50;
	            break;
	        case 'week':
	            gantt.config.scale_unit = "week";
	            gantt.config.date_scale = "Week #%W";
	            gantt.config.subscales = [
	                {unit: "day", step: 1, date: "%d %M"}
	            ];
	            gantt.config.scale_height = 50;
	            break;
	        case 'month':
	            gantt.config.scale_unit = "month";
	            gantt.config.date_scale = "%F, %Y";
	            gantt.config.subscales = [
	                {unit: "week", step: 1, date: "Week #%W"}
	            ];
	            gantt.config.scale_height = 50;
	            break;
	        case 'quarter':
	            gantt.config.scale_unit = "quarter";
	            gantt.config.date_scale = "%M";
	            gantt.config.subscales = [
	                {unit: "month", step: 1, date: "%M"}
	            ];
	            gantt.config.scale_height = 50;
	            break;
	    }
	    gantt.render();
	}

</script>
