package com.web.projectplanner.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.ReplyService;
import com.web.projectplanner.a04_vo.Reply;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService service;

	@PostMapping("replyInsert")
	public String replyInsert(@ModelAttribute Reply ins,Model d) {
		d.addAttribute("msg",service.replyInsert(ins));
		d.addAttribute("proc2","suc");
		return "z03_FreeBoardDetail";
	}

	@PostMapping("replyDelete")
	public String replyDelete(@RequestParam("replyid") String replyid,
	                          @RequestParam("replyno") int replyno,
	                          HttpSession session,
	                          Model d) {
		String writer = (String) session.getAttribute("writer");
	    int result = service.deleteReply(replyid, replyno);
	    if (result > 0) {
	        d.addAttribute("msg", "삭제 성공");
	    } else {
	        d.addAttribute("msg", "삭제 실패: 권한이 없습니다.");
	    }
	    return "z03_FreeBoardDetail"; // 삭제 후 이동할 뷰 이름
	}

}
