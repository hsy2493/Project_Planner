package com.web.projectplanner.a01_controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MsgController {

	
	// http://localhost:7070/groupchat
	@GetMapping("groupchat")
	public String groupchat() { //단체 채팅 페이지
		return "GroupchatChatting";
	}		
	
	// http://localhost:7070/personchat
	@GetMapping("personchat")
	public String personchat() { //1:1 개인 페이지
		return "PersonaChatting";
	}		
	
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) {
    	System.out.println("# 메시지가 발송되었습니다. #"+message);
    	
    	
        return message;
    }
    
    
    
}
