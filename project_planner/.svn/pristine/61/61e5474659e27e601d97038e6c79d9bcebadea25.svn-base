<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PROJECT PLANNER Groupchat Chatting</title>
    <link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
    <link rel="stylesheet" href="${path}/a00_com/css/styles.css">
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path}/a00_com/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${path}/a00_com/jquery.min.js"></script>
    <script src="${path}/a00_com/popper.min.js"></script>
    <script src="${path}/a00_com/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>

    <style>
        body {
            margin: 0;
            font-family: 'Nunito', sans-serif;
            background-color: #e0f7fa;
        }

        #wrapper {
            display: flex;
            height: 100vh;
            overflow: hidden;
        }

        .sidebar {
            width: 280px;
            background-color: #343a40;
            color: white;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        }

        .content-wrapper {
    margin-left: 225px; /* 사이드바 너비를 조정하여 왼쪽으로 이동 */
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    width: calc(100% - 200px); /* 사이드바 너비를 뺀 전체 너비 */
    overflow-y: auto;
    display: flex;
    flex-direction: column;
}


        header {
            background-color: #00bcd4;
            color: white;
            padding: 0.5rem 1rem;
            text-align: left;
            border-bottom: 2px solid #00a3d9;
            margin-left: 0; /* 헤더를 사이드바에 맞춤 */
        }

        header h1 {
            margin: 0;
            font-size: 2.5rem;
        }

        .chat-container {
            background-color: #0277bd;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 800px;
            margin: 20px auto;
        }

        .chat-title {
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            color: #e1f5fe;
            margin-bottom: 15px;
        }

        .chat-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #e1f5fe;
        }

        .chat-container input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 2px solid #0288d1;
            border-radius: 5px;
            background-color: #e1f5fe;
            color: #01579b;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .chat-container button {
            background-color: #0288d1;
            color: #e1f5fe;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease;
        }

        .chat-container button:hover {
            background-color: #0277bd;
        }

        .message-box {
            margin-top: 10px;
            width: calc(100% - 40px); /* 사이드바와 동일한 너비 조정 */
            max-width: 800px;
            background-color: #0277bd;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 15px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-left: auto;
            margin-right: auto;
        }

        .message-title {
            font-size: 18px;
            font-weight: bold;
            color: #e1f5fe;
            margin-bottom: 20px;
            border-bottom: 2px solid #e1f5fe;
            padding-bottom: 10px;
            width: 100%;
            text-align: center;
        }

        #show {
            width: 100%;
            background-color: #4fc3f7;
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            overflow-y: auto;
            max-height: 300px;
            color: #01579b;
            display: flex;
            flex-direction: column;
        }

        .message {
            margin: 5px 0;
            padding: 10px;
            border-radius: 10px;
            max-width: 80%;
            clear: both;
        }

        .my-message {
            background-color: #e1f5fe;
            color: #01579b;
            align-self: flex-start;
        }

        .other-message {
            background-color: #0277bd;
            color: #e1f5fe;
            align-self: flex-end;
        }

        #show::-webkit-scrollbar {
            width: 5px;
        }

        #show::-webkit-scrollbar-thumb {
            background-color: #0288d1;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <div class="sidebar">
            <%@ include file="a02_sliderBar.jsp" %> 
        </div>
        <div class="content-wrapper">       
            <%@ include file="a03_topBar.jsp" %>
            <h2 style="text-align: center;">실시간 채팅</h2>
            <hr>
            <div class="chat-container">
                <div class="chat-title">그룹 채팅</div>
                <hr>
                <label for="curName">아이디:</label>
                <input id="curName" type="text" placeholder="내 아이디 입력" />
                <label for="msg">메시지 내용:</label>
                <input id="msg" type="text" placeholder="메시지를 입력해주세요" onkeydown="if(event.key === 'Enter') sendName();" />
                <button type="button" onclick="sendName()"><b>메세지 전송</b></button>
            </div>
            <div class="message-box">
                <div class="message-title">채팅창</div>
                <div id="show"></div> 
            </div>
        </div>
    </div>

    <script type="text/javascript">
        // 웹소켓 연결 및 STOMP 클라이언트 설정
        var socket = new SockJS('/ws'); // 서버 웹소켓 엔드포인트
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting){
                console.log('Received: ' + greeting.body);
                var obj = JSON.parse(greeting.body);
                var curName = document.getElementById('curName').value;
                if (curName !== obj.name) {
                    var showDiv = document.querySelector("#show");
                    showDiv.innerHTML += "<div class='message other-message'><p>" + obj.name + ": " + obj.msg + "</p></div>";
                    showDiv.scrollTop = showDiv.scrollHeight; // 최신 메시지가 보이도록 스크롤
                }
            });
        });

        function sendName() {
            var name = document.getElementById('curName').value;
            var msg = document.getElementById('msg').value;
            if (name && msg) {
                var showDiv = document.querySelector("#show");
                showDiv.innerHTML += "<div class='message my-message'><p>나: " + msg + "</p></div>";
                stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'msg': msg}));
                document.getElementById('msg').value = '';
                showDiv.scrollTop = showDiv.scrollHeight; // 최신 메시지가 보이도록 스크롤
            } else {
                alert("아이디와 메시지를 입력하세요.");
            }
        }
    </script>
</body>
</html>
