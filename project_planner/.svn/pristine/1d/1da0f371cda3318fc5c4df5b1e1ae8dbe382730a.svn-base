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
<title>PROJECT PLANNER Chatting</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:scroll;text-align:left;
		border:1px solid green;
	}	
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	



	// 1. 소켓서버접속 변수
	var wsocket=null;
	$(document).ready(function(){
		$("#id").keyup(function(){
			if(event.keyCode == 13){
				ws_conn()
			}
		})
		$("#enterBtn").click(function(){
			ws_conn()
		})
		function ws_conn(){
			var socketServer = '${socketServer}'.replace(/^"|"$/g,'')
			//alert(socketServer)
			//var socketServer = 'ws:localhost:3030/chat'
			wsocket = new WebSocket(socketServer)
			//console.log(wsocket)
			wsocket.onopen=function(evt){
				//console.log(evt)
				wsocket.send($("#id").val()+":접속하셨습니다!")
			}
			// 전송한 메시지를 받는 메서드 선언. 서버단에서 ws.sendMessage(message)로 보냈을 때
			// 받는 처리하는 메서드..
			wsocket.onmessage = function(evt){
				revMsg(evt.data)
			}
			wsocket.onclose =function(){
				wsocket.close()
			}			
		}
		
		// sndBtn msg
		$("#sndBtn").click(function(){
			sendMsg()
		})
		$("#msg").keyup(function(){
			if(event.keyCode==13){
				sendMsg()
			}
		})
	});
	function sendMsg(){
		wsocket.send($("#id").val()+":"+$("#msg").val())
		$("#msg").val("")		
	}
	// 최대 크기 함수 위에 전역변수로 선언..
	var mx = 0
	function revMsg(msg){
		// 1. 보내는 메시지 오른쪽, 받는 메시지 왼쪽 정렬 처리..
		var alignOpt = "left"
		var msgArr = msg.split(":") // 사용자명:메시지  구분하여 처리
		var sndId = msgArr[0]// 보내는 사람 메시지 id
		if($("#id").val() == sndId){
			// 보내는 사람과 받는 사람의 아이디가 동일 하면 현재 접속한 사람이 보낸 메시지. ==> 정렬 오른쪽
			alignOpt = "right"
			msg = msgArr[1]  // 내가 보낸 메시지이기에 id삭제..
		}
		// 정렬 처리된 메시지 
		var msgObj = $("<div></div>").text(msg).attr("align", alignOpt).css("width",$("#chatArea").width()-20)
		$("#chatMessageArea").append(msgObj)
		//$("#chatMessageArea").append(msg+"<br>")
		// 2. 메시지 스크롤 처리..(최하단에 있는 메시지 내용 확인할 수 있게 자동 스크롤 처리..)
		//   1) 전체 해당 데이터의 높이를 구하기
		// 	 2) 포함하고 있는 부모 객체(#chatArea)에서 스크롤 기능 메서드로 스크롤되게 처리 scrollTop()
		var height = parseInt($("#chatMessageArea").height())
		mx += height + 20
		$("#chatArea").scrollTop(mx)
		
		
		
		
	}
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2><b>:P:P 실시간 채팅</b></h2>
</div>
<div class="container">
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">아이디</span>
		</div>
		<input id="id" class="form-control" placeholder="접속할 아이디 입력" value="" />	
		<input type="button" class="btn btn-primary" value="채팅방입장" id="enterBtn"/>
		<input type="button" class="btn btn-danger" value="채팅방퇴장" id="exitBtn"/>		
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">채팅창</span>
		</div>
		<div id="chatArea" style="overflow-x:hidden;overflow-y: scroll;" class="input-group-append">
			<div id="chatMessageArea"></div>
		</div>
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">메시지</span>
		</div>
		<input id="msg" class="form-control" value="" placeholder="전송할 메세지를 입력해주세요"/>	
		<input  type="button" class="btn btn-info" value="전송" id="sndBtn"/>
	</div>		
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">검색</span>
		</div>
		<input type="button" class="btn btn-primary" value="메시지 검색"/>
	</div>		
		
</div>
</body>
</html>