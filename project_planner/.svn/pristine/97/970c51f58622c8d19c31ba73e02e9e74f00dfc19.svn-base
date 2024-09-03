package com.web.projectplanner.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.projectplanner.a02_service.RegisterService;
import com.web.projectplanner.a04_vo.User;
import com.web.projectplanner.a04_vo.Util;

@Controller
public class RegisterController {
   @Autowired(required=false)
   private RegisterService registerservice; //사원등록 service

    // 사원등록 전체 페이지
    @GetMapping("register")
    // http://localhost:7070/register
    public String registerPage() {
        return "a84_register";
    }

    // 사원등록 및 메일발송 처리
    @PostMapping("register")
    public String insertEmpMail(User user, Model d) {

        String tempPassword = Util.mkTPwd(); // 임시 비밀번호 생성
        user.setPassword(tempPassword); // 생성된 임시 비밀번호 사원정보에 저장

        // 사원등록 처리
        String regEmp = registerservice.insertEmp(user);

        // 전송 결과 메시지
        d.addAttribute("msg", regEmp);

        // 메일발송 후 메인페이지로 이동
        return "a01_index";
    }

    @PostMapping("emailDupck") //이메일 중복확인
    @ResponseBody
    public String emailDupck(@RequestParam("email") String email) {
        int emailcnt = registerservice.emailDupck(email);
        return emailcnt > 0 ? "1" : "0"; // 사용 중인 이메일인 경우는 1(등록 불가능), 
                                        //사용 중이지 않은 이메일인 경우는 0(등록 가능)으로 반환함.
    }
    

  

}
