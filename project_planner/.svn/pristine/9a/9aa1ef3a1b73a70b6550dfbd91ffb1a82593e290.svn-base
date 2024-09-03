package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.MailListDao;
import com.web.projectplanner.a04_vo.Mail;
import com.web.projectplanner.a04_vo.User;

import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;




@Service
public class MailService {

		@Autowired(required = false)
		private JavaMailSender sender;
		
		@Autowired(required = false)
		private MailListDao dao;



		public String sendMail(Mail email) {
			String msg = "메일 전송 성공";
			// 1. 메일 발송 데이터 전송을 위한 객체 생성
			MimeMessage mmsg = sender.createMimeMessage();
			// 2. 메일 발송 객체에 요청값으로 받은 데이터 할당(Mail ==> MimeMessage)
			try {
				// 1) 제목
				mmsg.setSubject(email.getTitle());
				// 2) 수신자
				mmsg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
				// 3) 발신자
				mmsg.setSender(new InternetAddress(email.getSender()));
				// 4) 내용
				mmsg.setText(email.getContent());
			// 3. 발송처리
				sender.send(mmsg);
			} catch (MessagingException e) {
				System.out.println("메일 전송 에러"+e.getMessage());
				msg = "메일 전송 에러"+e.getMessage();
			}catch(Exception e) {
				System.out.println("메일 전송 에러"+e.getMessage());
				msg = "메일 전송 에러"+e.getMessage();
			}
			return msg;
		}



		public String makeEmpMail(User user) { //사원등록 메일발송 내용
			  String msg = "";
				// 1. 메일 발송 데이터 전송을 위한 객체 생성
		        MimeMessage mmsg = sender.createMimeMessage();
		        // 2. 메일 발송 객체에 요청값으로 받은 데이터 할당(User ==> MimeMessage)
		        try {

		            mmsg.setSubject(user.getName() + "님, 사원등록이 완료되었습니다!");
		            //1) 제목
		            mmsg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
		            //2) 수신자 : RecipientType.TO, 이메일 주소 할당 : InternetAddress
		            String content = user.getName()+"님, :P:P 사이트 회원이 되신 것을 진심으로 축하드립니다!\r\n"
		            		+ "사원등록이 완료되었습니다.\r\n"
		                    + user.getName()+"님의 사원번호는 " + user.getEmpno() + " 이며,\r\n"
		                    + "임시 비밀번호는 " + user.getPassword() + " 입니다.\r\n"
		                    + "이 계정으로 로그인하신 뒤,\r\n"
		                    + "개인정보 보호를 위하여, 내정보에서 임시 비밀번호를 새비밀번호로 수정해주세요!\r\n"
		                    + ":P:P 사이트 로그인 링크는 http://project_planner/login 입니다.";
		            //3) 메세지 내용

		            mmsg.setText(content);
		            sender.send(mmsg);
		            //4) 위 메세지 내용 발송 처리

		        } catch (MessagingException e) {
		            System.out.println("메일 전송 에러: " + e.getMessage());
		            msg = "메일 전송 에러: " + e.getMessage();
		        } catch (Exception e) {
		            System.out.println("기타 에러: " + e.getMessage());
		            msg = "기타 에러: " + e.getMessage();
		        }
		        //3. 예외처리

		        return msg;
		        //4. msg 메서드 결과 반환처리 : 성공 시 ==> 메세지 내용,
		             //실패 시 ==> 예외처리
		    }
		
		
		//로그인 페이지-비밀번호 재설정(임시 비밀번호) 메세지 발송 내용
		public String sendTemporaryPasswordMail(User user) {
	        String msg = "";
	        MimeMessage mmsg = sender.createMimeMessage();
	        try {
	            mmsg.setSubject(user.getName()+"님, 임시 비밀번호가 발송되었습니다."); //제목
	            
	            mmsg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
	            mmsg.setSender(new InternetAddress("your-email@example.com")); 
	            String content = user.getName() + "님, 안녕하세요!\r\n" +
	                             "임시 비밀번호는 " + user.getPassword() + " 입니다.\r\n" +
	                             "이 비밀번호로 로그인 한 뒤, 비밀번호를 변경해 주세요.\r\n" +    
	                             "이 계정으로 로그인하신 뒤,\r\n" +
	 		                     "개인정보 보호를 위하여, 내정보에서 임시 비밀번호를 새비밀번호로 수정해주세요!\r\n" +
	 		                     ":P:P 사이트 로그인 링크는 http://project_planner/login 입니다.";
	            mmsg.setText(content);
	            sender.send(mmsg);
	            
	        } catch (MessagingException e) {
	            msg = "메일전송 에러 : " + e.getMessage();
	       }
	        
	        
	      return msg;
	  }
	/////////////////////////////////////////////////
		public List<User> getEmpList(User sch){
			if(sch.getEmpno()==null) {sch.setEmpno("");}
			if(sch.getName()==null) {sch.setName("");}
		return dao.getEmpList(sch);
		}
		
		public User getEmp(String empno) {
			return dao.getEmp(empno);
		}

}
