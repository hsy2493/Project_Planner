package com.web.projectplanner.a05_util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
//chatHandler
@Component
public class ChatHandler extends TextWebSocketHandler{

	// 접속한 socket session(클라이언트) 저장할 필드 선언..
	// key(소켓세션 id), value(session객체)를 할당할 Map 형식으로 설정 처리
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();

	// 접속시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.put(session.getId(), session);
		// WebSocketSession : socket client 정보, 메시지를 전송/전달받는 정보를 가지고 있음..
		System.out.println(session.getId()+"님 접속합니다."+ users.size()+"명 접속중 ");
	}
	// 메시지 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId()+"에서 온 메시지:"+message.getPayload());
		// 한 클라이언트가 보낸 메시지를 접속한 소켓 클라이언트에게 전송
		for(WebSocketSession ws:users.values()) {
			// 메시지를 각각 소켓세션에 보냄...
			ws.sendMessage(message);
		}
	}


	// 접속종료
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+" 접속 종료합니다.");
		// 기존에 등록된 session에서 삭제 처리..
		users.remove(session.getId());
	}

	// 예외처리
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(session.getId()+"에러 발생! 예외 내용:"+exception.getMessage());
	}

}
