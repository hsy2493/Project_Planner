<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER  Persona Chatting</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        justify-content: flex-start;
    }

    header {
        background-color: #ffffff;
        width: 100%;
        padding: 15px 20px;
        text-align: left;
        font-size: 24px;
        font-weight: bold;
        color: #333;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .chat-container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        margin-top: 20px;
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
        margin-top: 20px;
        width: 100%;
        max-width: 410px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 15px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .message-title {
        font-size: 18px;
        font-weight: bold;
        color: #333;
        margin-bottom: 20px;
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
        border-radius: 10px;
        max-width: 80%;
        clear: both;
    }

    .my-message {
        background-color: #e0f7fa;
        color: #00796b;
        align-self: flex-start;
    }

    .other-message {
        background-color: #c8e6c9;
        color: #388e3c;
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
    <header>&nbsp;&nbsp;PROJECT PLANNER</header>

    <div class="chat-container">
        <div class="chat-title">:P:P 일대일 개인 채팅</div>
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
                if ((curName === obj.name && targetName === obj.receiver) ||  //현재 유저와 상대방 간의 메세지인지 확인 후, 조건에 맞는 경우 메세지 화면에 출력 
                    (curName === obj.receiver && targetName === obj.name)) {
                    var className = curName === obj.name ? 'my-message' : 'other-message';
                    document.querySelector("#show").innerHTML += "<div class='message " + className + "'><p>" + obj.name + ": " + obj.msg + "</p></div>";
                }
            });
        });

        function sendName() { //메세지 전송 
            var name = document.getElementById('curName').value; //내 이름
            var receiver = document.getElementById('name').value; //상대 이름  
            var msg = document.getElementById('msg').value; //메세지 내용 출력 
         
            stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'receiver': receiver, 'msg': msg})); //서버로 메세지 전송 후, json 형식으로 반환
            document.getElementById('msg').value = ''; // 메시지 전송 후 입력창 비우기
            document.querySelector("#show").scrollTop = document.querySelector("#show").scrollHeight; // 자동 스크롤
        }
    </script>
</body>
</html>
