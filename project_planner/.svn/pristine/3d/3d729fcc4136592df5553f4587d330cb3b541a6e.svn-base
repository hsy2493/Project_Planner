<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER Persona Chatting</title>
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
    width: 400px;
    background-color: #343a40;
    color: white;
    height: 200%;
    position: fixed;
    top: 0;
    left: 0;
    overflow-y: auto;
}

.content-wrapper {
    margin-left: 225px; /* Same width as sidebar */
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    width: calc(100% - 400px); /* Full width minus sidebar width */
    overflow-y: auto;
}

header {
    background-color: #00bcd4;
    color: white;
    padding: 0.5rem 1rem;
    text-align: left;
    border-bottom: 2px solid #00a3d9;
}

header h1 {
    margin: 0;
    font-size: 2.5rem;
}

.chat-container {
    background-color: #ffffff;
    padding: 20px; /* Adjusted padding */
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 600px;
    margin: 0 auto; /* Center-aligns the chat container */
}

.chat-title {
    font-size: 20px;
    font-weight: bold;
    text-align: center;
    color: #333;
    margin-bottom: 15px;
}

.chat-container label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #333;
}

.chat-container input[type="text"] {
    width: calc(100% - 22px);
    padding: 10px;
    margin-bottom: 15px;
    border: 2px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
    color: #333;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.chat-container button {
    background-color: #333;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    transition: background-color 0.3s ease;
}

.chat-container button:hover {
    background-color: #555;
}

.message-box {
    margin: 10px auto; /* Centers the box horizontally and provides space at the top */
    width: 100%;
    max-width: 600px;
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 10px;
    display: flex;
    flex-direction: column;
    align-items: center; /* Center-aligns items inside the box horizontally */
    text-align: center;  /* Center-aligns text inside the box */
}

.message-title {
    font-size: 18px;
    font-weight: bold;
    color: #333;
    margin-bottom: 10px; /* Reduced margin */
    border-bottom: 2px solid #ccc;
    padding-bottom: 10px;
    width: 100%;
    text-align: center;
}

#show {
    width: 95%;
    background-color: #f0f0f0;
    padding: 15px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow-y: auto;
    max-height: 300px;
    color: #333;
    display: flex;
    flex-direction: column;
}

.message {
    margin: 5px 0;
    padding: 10px;
    border-radius: 15px;
    max-width: 80%;
    clear: both;
    text-align: left; /* Align text to the left for better readability */
}

.my-message {
    background-color: #696969; /* Bright blue for outgoing messages */
    color: #ffffff; /* White text for contrast */
    align-self: flex-start;
}

.other-message {
    background-color: #1E90FF; /* Bright green for incoming messages */
    color: #ffffff; /* White text for contrast */
    align-self: flex-end;
}

#show::-webkit-scrollbar {
    width: 5px;
}

#show::-webkit-scrollbar-thumb {
    background-color: #bbb;
    border-radius: 10px;
}
</style>
</head>

<body>
    <div id="wrapper">
        <div class="sidebar">
            <%@ include file="a02_sliderBar.jsp" %>
        </div>
        <div id="content-wrapper" class="content-wrapper d-flex flex-column">
            <%@ include file="a03_topBar.jsp" %>
             <h2 style="text-align: center;">실시간 채팅</h2>
               <hr>
            <div class="chat-container">
                <div class="chat-title">개인 채팅</div>
                <hr>
                <label for="curName">내 이름:</label>
                <input id="curName" type="text" placeholder="내 이름 입력" />
                <label for="name">상대방 이름:</label>
                <input id="name" type="text" placeholder="받을 사람 이름 입력" />
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

    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
    <script type="text/javascript">
        var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting){
                var obj = JSON.parse(greeting.body);
                var curName = document.getElementById('curName').value; //내 이름
                var targetName = document.getElementById('name').value; //상대방 이름
                
                //자신과 상대방의 메시지만 표시
                if ((curName === obj.name && targetName === obj.receiver) || 
                    (curName === obj.receiver && targetName === obj.name)) {
                    var className = curName === obj.name ? 'my-message' : 'other-message';
                    document.querySelector("#show").innerHTML += "<div class='message " + className + "'><p>" + obj.name + ": " + obj.msg + "</p></div>";
                }
            });
        });

        function sendName() { //메세지 전송 
            var name = document.getElementById('curName').value; //내 이름
            var receiver = document.getElementById('name').value; //상대 이름  
            var msg = document.getElementById('msg').value; //메세지 내용 
         
            stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'receiver': receiver, 'msg': msg})); //서버로 메세지 전송
            document.getElementById('msg').value = ''; // 메시지 전송 후 입력창 비우기
            document.querySelector("#show").scrollTop = document.querySelector("#show").scrollHeight; // 자동 스크롤
        }
    </script>
</body>
</html>
