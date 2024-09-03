package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.projectplanner.a02_service.TodoService;
import com.web.projectplanner.a04_vo.Todo;
import com.web.projectplanner.a04_vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApprovalController {
	
	@Autowired(required =false)
	private TodoService todoService;
	
	// http://localhost:7070/approval
	@GetMapping("/approval")
	public String getApprovalList(Model model, HttpSession session) {
	    String empno = (String)session.getAttribute("empno");
	    
	    if (empno != null) {
	        List<Todo> approvalTodos = todoService.getApprovalTodos(empno);
	        model.addAttribute("approvalTodos", approvalTodos);
	        model.addAttribute("empno", empno);
	        return "approvalList"; // 결재 목록 페이지 리턴
	    } else {
	        return "redirect:/login"; // 로그인하지 않은 경우 로그인 페이지로 리다이렉트
	    }
	}
}