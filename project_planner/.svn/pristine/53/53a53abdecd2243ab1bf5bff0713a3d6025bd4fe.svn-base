package com.web.projectplanner.a00_configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.web.projectplanner.a05_util.ChatHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	private final ChatHandler chatHandler;

	public WebSocketConfig(ChatHandler chatHandler) {
		this.chatHandler = chatHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(chatHandler, "/chat").setAllowedOrigins("*");
	}

}
