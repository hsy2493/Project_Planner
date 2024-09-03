<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT PLANNER Groupchat Chatting</title>
<style>
    /* 전체 배경을 어두운 바다색으로 설정 */
    body {
        font-family: Arial, sans-serif;
        background-color: #01579b;
        color: #e1f5fe;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        justify-content: flex-start;
    }

    /* 헤더 스타일 - 왼쪽 정렬 */
    header {
        background-color: #0277bd;
        width: 100%;
        padding: 15px 20px;
        text-align: left;
        font-size: 24px;
        font-weight: bold;
        color: #e1f5fe;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    /* 입력 섹션 및 채팅 제목을 감싸는 컨테이너 */
    .chat-container {
        background-color: #0277bd;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 400px;
        margin-top: 20px;
    }

    /* 채팅 제목 스타일 */
    .chat-title {
        font-size: 20px;
        font-weight: bold;
        text-align: center;
        color: #e1f5fe;
        margin-bottom: 15px;
    }

    /* 각 입력 필드와 레이블 */
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

    /* 전송 버튼 스타일 */
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

    /* 채팅 메시지 박스 */
    .message-box {
        margin-top: 20px;
        width: 100%;
        max-width: 410px;
        background-color: #0277bd;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        padding: 15px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    /* 채팅 메시지 제목 스타일 */
    .message-title {
        font-size: 18px;
        font-weight: bold;
        color: #e1f5fe;
        margin-bottom: 20px;
        border-bottom: 2px solid #e1f5fe; /* 제목과 메시지 박스 구분 */
        padding-bottom: 30px;
        width: 100%;
        text-align: center;
    }

    /* 메시지를 보여주는 영역 스타일 */
    #show {
        width: 95%;
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

    /* 개별 메시지 스타일 */
    .message {
        margin: 5px 0;
        padding: 10px;
        border-radius: 10px;
        max-width: 80%;
        clear: both;
    }

    /* 내 메시지 스타일 */
    .my-message {
        background-color: #e1f5fe;
        color: #01579b;
        align-self: flex-start; /* 왼쪽 정렬 */
    }

    /* 상대방 메시지 스타일 */
    .other-message {
        background-color: #0277bd;
        color: #e1f5fe;
        align-self: flex-end; /* 오른쪽 정렬 */
    }

    /* 메시지 박스 내부의 스크롤바 스타일 */
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
    <header>&nbsp;&nbsp;PROJECT PLANNER</header>

    <div class="chat-container">
        <div class="chat-title">:P:P 단체 채팅</div>
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

    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script><!-- 웹소켓 지원 -->
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script><!-- 메세지 프로토콜 -->
    <script type="text/javascript">
        var socket = new SockJS('/ws'); //서버-소켓 연결
        var stompClient = Stomp.over(socket); //stomp 클라이언트 초기화

        stompClient.connect({}, function(frame) { //stomp 클라이언트 - 서버 연결
            console.log('Connected: ' + frame); //json 객체, 메세지 내용 출력
            stompClient.subscribe('/topic/greetings', function(greeting){
                console.log(greeting.body);
                var obj = JSON.parse(greeting.body);
                var curName = document.getElementById('curName').value; 
                if(curName != obj.name) { //현재 유저가 보낸 메세지가 아닌 경우 화면에 미출력
                    document.querySelector("#show").innerHTML += "<div class='message other-message'><p>" + obj.name + ": " + obj.msg + "</p></div>";
                }
            });
        });

        function sendName() { //메세지 전송 버튼
            var name = document.getElementById('curName').value; //유저 아이디
            var msg = document.getElementById('msg').value; //메세지 내용
            document.querySelector("#show").innerHTML += "<div class='message my-message'><p>나: " + msg + "</p></div>"; //나 + 메세지 내용 화면단에 추가 출력
            stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'msg': msg}));  //서버로 메세지 전송 후, json 형식으로 반환
            document.getElementById('msg').value = ''; //메시지 전송 후 입력창 비우기
            document.querySelector("#show").scrollTop = document.querySelector("#show").scrollHeight; //자동 스크롤
        }
    </script>
</body>
</html>
