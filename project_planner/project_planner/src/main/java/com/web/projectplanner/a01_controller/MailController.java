package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.MailService;
import com.web.projectplanner.a04_vo.Mail;
import com.web.projectplanner.a04_vo.User;

@Controller
public class MailController {

	@Autowired(required=false)
	private MailService service;
	
	// http://localhost:7070/mail
	@GetMapping("mail")
	public String  mailFrm() {
		return "z04_MailFrm";
	}
	@PostMapping("mail")
	public String sendMail(Mail mail,Model d) {
		d.addAttribute("msg",service.sendMail(mail));
		return "z04_MailFrm";
	}

	////////////////////////////////////////////////////////////////
	
	// http://localhost:7070/getEmpList
	@GetMapping("/getEmpList")
    public ResponseEntity<List<User>> getEmpList(@ModelAttribute User sch) {
        List<User> users = service.getEmpList(sch); 
        return ResponseEntity.ok(users); 
    }
	 
	 // http://localhost:7070/getEmp?empno=24SEC10004
	 @GetMapping("/getEmp")
	 public ResponseEntity<User> getEmp(@RequestParam("empno") String empno) {
		 User emp = service.getEmp(empno);
		 return ResponseEntity.ok(emp);
	 }
	
}
