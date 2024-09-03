package com.web.projectplanner.a01_controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.UserService;
import com.web.projectplanner.a04_vo.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	    @Autowired(required=false)
	    private UserService userService; //유저 service
	    
	    // 로그인 페이지 
	    //http://localhost:7070/login
	    @GetMapping("/login")
	    public String loginForm() {
	        return "a83_login";
	    }

	    // 로그인 처리
	    @PostMapping("/login") //로그인 정보 : 아이디(이메일), 비밀번호
	    public String login(@RequestParam("email") String email,
	                        @RequestParam("password") String password,
	                        
	                        //이메일 저장하기  
	                        @RequestParam(value = "rememberMe", required = false) String rememberMe,
	                        //rememberMe : 이메일 저장하기 체크박스 ==> false인 경우, 선택적 
	                        HttpSession session, HttpServletResponse response, Model d) {
	    	                //session으로 입력한 이메일 정보값 로그인 페이지에 저장,  HTTP : 응답 처리
	        List<User> userList = userService.authenticate(email, password);
	        //로그인 정보 ==> 사원 정보
	        
	        if (!userList.isEmpty()) { //사원정보가 비어 있지 않은 경우, 인증 성공 ==> db 사원정보 데이터와 유효성 검토
	            session.setAttribute("userList", userList);
	            //로그인 이메일, 비밀번호 사원정보랑 유효성 검사 <= 성공한 로그인 정보 저장(session)

	            
	            //이메일 저장하기 
	            if (rememberMe != null) { //이메일 저장하기 체크박스
	                Cookie cookie = new Cookie("rememberEmail", email); //이메일 정보 저장한 쿠키
	                cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효기간 30일로 설정
	                response.addCookie(cookie);
	                
	            } else {
	                // 선택되지 않은 경우, 기존 쿠키 삭제
	                Cookie cookie = new Cookie("rememberEmail", null);
	                cookie.setMaxAge(0);
	                response.addCookie(cookie);
	            }
	            return "redirect:/my"; // 로그인 성공 후, 메인 페이지로 리다이렉트

	        } else {
	            d.addAttribute("error", "아이디 또는 비밀번호가 옳지 않습니다");
	            return "a83_login"; // 로그인 실패 시, 로그인 페이지로 돌아감
	        }
	    }

	    // 로그아웃 
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // 세션 무효화
	        return "redirect:/login"; // 로그아웃 후, 로그인 페이지로 리다이렉트
	    }


	    
	    // http://localhost:7070/mypage
	    @GetMapping("/mypage") //마이페이지(내정보)
	    public String myPage() {
	        return "mypage";
	    }

	    //역할 선택 후 수정
	    @PostMapping("/updateUserRole")
	    public String updateUserRole(HttpSession session,
	                                 @RequestParam("role") String role, Model d) {

	        // 세션에 저장된 현재 로그인된 사용자정보(userList) 불러오기
	    	//List<User>로 캐스팅 : 메서드가 반환된 값이 object 타입이기 때문에
	        List<User> userList = (List<User>) session.getAttribute("userList");

	        if (userList == null || userList.isEmpty()) {
	        	//userList가 비어 있거나
	        	// 미로그인인 경우, 로그인 페이지로 이동
	            return "redirect:/login";
	        }

	        //유저 정보 가져오기
	        //0인 경우, 미로그인,
	        //1인 경우, 첫번째 로그인인 경우
	        //==> 하나의 아이디/비밀번호로만 저장되어 있기 때문에, 1인 경우(첫번째 사용자)만 로그인 가능
	        //==> 첫번째 사용자 정보 가져오기
	        User currentUser = userList.get(0);

	        // 역할 업데이트
	        boolean isUpdate = userService.updateUserRole(currentUser.getEmpno(), role);

	        if (isUpdate) {
	            currentUser.setRole(role); // 세션의 사용자 역할 정보 수정
	            session.setAttribute("userList", userList); // 세션 정보 갱신
	            d.addAttribute("user", currentUser); //유저정보 가져오기
	            d.addAttribute("msg", "역할 선택 성공!");
	            return "redirect:/mypage"; // 성공 시, 마이페이지로 리다이렉트

	        }else{
	            d.addAttribute("msg", "역할 선택 실패!!");
	            return "a01_index"; // 실패 시, 메인페이지로 이동
	        }
	    }

	    //마이페이지-비밀번호 재설정
	    @PostMapping("/updatePwd")
	    public String updatePwd(@RequestParam("empno") String empno,
	                            @RequestParam("newPassword") String newPassword, //새비밀번호
	                            @RequestParam("confirmPassword") String confirmPassword, //새비밀번호 재확인
	                            Model d) {
	        if (!newPassword.equals(confirmPassword)) {
	            d.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
	            return "mypage"; // 비밀번호 확인 실패 시, 마이페이지로 재이동
	        }

	        boolean isUpdate = userService.updatePwd(empno, newPassword);
	        if (isUpdate) { // 변경 성공인 경우
	            d.addAttribute("msg", "비밀번호가 변경되었습니다.");

	        } else { // 변경 실패인 경우
	            d.addAttribute("msg", "비밀번호 변경에 실패하였습니다. 다시 시도해주세요.");
	        }
	        return "mypage"; // 비밀번호 변경 성공 또는 실패 후, 마이페이지로 이동
	    }
	    

	    //로그인 페이지-비밀번호 재설정 페이지
	    //http://localhost:7070/sendTemporaryPassword
	    @GetMapping("/sendTemporaryPassword")
	    public String newpwd() {
	    	 return "newpwd";
	   }
	    
		 // 비밀번호 재설정 요청 처리
		 @PostMapping("/sendTemporaryPassword")
		 public String sendTemporaryPassword(@RequestParam("email") String email, Model d) {
		        String result = userService.sendTemporaryPassword(email);
		        d.addAttribute("msg", result);
		    return "newpwd"; 
		  }
		 
		 
		 
		 //사원정보 List 페이지
		 //http://localhost:7070/empList
		 @RequestMapping("empList") //사원명, 역할로 사원 검색
		 public String empListsch(User sch, Model d) {			 
			 d.addAttribute("emplist", userService.getEmpList(sch));	
			 return "emplist";
		 }
		 
	
}