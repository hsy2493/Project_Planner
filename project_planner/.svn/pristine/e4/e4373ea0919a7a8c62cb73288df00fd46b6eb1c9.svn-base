package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.UserDao;
import com.web.projectplanner.a04_vo.User;
import com.web.projectplanner.a04_vo.Util;


@Service
public class UserService {
	 	@Autowired(required=false)
	    private UserDao userDao;
	 	
	 	@Autowired(required = false)
	    private MailService mailservice; //메세지 service

	 public List<User> authenticate(String email, String password) { //로그인
	        return userDao.findByEmailAndPassword(email, password);
	    }
	 

	 public User getUserList(String empno) { //마이페이지
		 return userDao.getUserList(empno);
	 }

	 public boolean updateUserRole(String empno, String role) { //마이페이지-역할 선택 후 수정
	        return userDao.updateUserRole(empno, role) > 0;
	  }

	 //마이페이지-비밀번호 재설정
	 public boolean updatePwd(String empno, String password) {
		 return userDao.updatePwd(empno, password) > 0;
	 }
	
	 
	 //로그인 페이지-비밀번호 재설정
	 public String sendTemporaryPassword(String email) {
	        User user = userDao.getUserByEmail(email);
	        if (user == null) { //이메일 등록 유무 유효성 검사
	            return "등록되지 않은 이메일입니다.";
	        }
	        

	        String tempPassword = Util.mkTPwd(); //임시 비밀번호 생성
	        user.setPassword(tempPassword); //전송된 임시 비밀번호 사원정보에 저장

	        try{// 임시 비밀번호로 업데이트             
	            userDao.changepwd(tempPassword, email); 

	            // 이메일 발송은 트랜잭션 외부에서 수행
	            String mailResult = mailservice.sendTemporaryPasswordMail(user);
	            return "임시 비밀번호가 이메일로 전송되었습니다." + mailResult;

	        }catch(Exception e){//예외처리, 트랜잭션 롤백
	            return "예외 처리로 임시 비밀번호 발송에 실패하였습니다" + e.getMessage();
	        }
	    }
	 
	 //사원정보 List
	 //사원명, 역할로 사원 검색 
	 public List<User> getEmpList(User sch){
		 if(sch.getName() == null) sch.setName("");
		 if(sch.getRole()== null) sch.setRole("");
		 return userDao.getEmpList(sch);
	 }

    

 
}