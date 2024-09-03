package com.web.projectplanner.a02_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.RegisterDao;
import com.web.projectplanner.a04_vo.User;
import com.web.projectplanner.a04_vo.Util;

@Service
public class RegisterService { //사원등록
   @Autowired(required = false)
   private RegisterDao dao; //사원등록 dao

   @Autowired(required = false)
   private MailService mailservice; //메세지 service

     public String insertEmp(User user) {
           user.setPassword(Util.mkTPwd());
           // 사원 등록 처리
           int result = dao.insertUser(user);

           if (result > 0) {
               // 사원번호 생성 후 메일 발송
               User dbUser = dao.getUser(user.getEmail());
               String mailResult = mailservice.makeEmpMail(dbUser); //사원등록 메일발송내용
               return "사원등록 완료! " + mailResult;
           }

          return "사원등록 실패";
      }

     //이메일 중복확인
     public int emailDupck(String email) {
         return dao.emailDupck(email);
     }
}