package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.CalendarService;
import com.web.projectplanner.a04_vo.Calendar;

import jakarta.servlet.http.HttpSession;

@Controller
public class CalendarController {
	@Autowired(required = false)
	private CalendarService service;

	// http://localhost:7070/calendar
	 @GetMapping("calendar")
	    public String calendar(HttpSession session, Model d) {
		 
		 	session.setAttribute("empno", "테스트 작성자1");
	        String writer = (String) session.getAttribute("empno");
	        
	        if (writer == null) {
	            throw new IllegalStateException("Session attribute 'writer' not found");
	        }
	        List<Calendar> calendarList = service.getCalendarList(writer);
	        d.addAttribute("writer", writer); // 추가: JSP에서 사용할 수 있도록 empno를 모델에 추가
	        return "z05_Calendar"; // JSP 페이지 이름
	    }
	
	// http://localhost:7070/calList
		@GetMapping("calList")
		public ResponseEntity<List<Calendar>> getCalList(HttpSession session){
			
			session.setAttribute("empno", "테스트 작성자1");
			String writer = (String) session.getAttribute("empno");
			
			return ResponseEntity.ok(service.getCalendarList(writer));
		}

	@PostMapping("insertCalendar")
	public ResponseEntity<?> insertCalendar(Calendar ins, @RequestParam("writer") String writer){
		return ResponseEntity.ok(
				new MsgList( service.insertCalendar(ins),
						     service.getCalendarList(writer)));
	}

	@PostMapping("updateCalendar")
	public ResponseEntity<?> updateCalendar(Calendar upt, @RequestParam("writer") String writer){
		return ResponseEntity.ok(
				new MsgList( service.updateCalendar(upt), 
							 service.getCalendarList(writer)));
	}

	@PostMapping("deleteCalendar")
	public ResponseEntity<?> deleteCalendar(@RequestParam("id") int id,
											@RequestParam("writer") String writer){
		return ResponseEntity.ok(
				new MsgList( service.deleteCalendar(id,writer),
							 service.getCalendarList(writer)));
	}

}

	class MsgList{
		private String msg;
		private List<Calendar> calList;
		public MsgList() {
			super();
			// TODO Auto-generated constructor stub
		}
		public MsgList(String msg, List<Calendar> calList) {
			super();
			this.msg = msg;
			this.calList = calList;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public List<Calendar> getCalList() {
			return calList;
		}
		public void setCalList(List<Calendar> calList) {
			this.calList = calList;
		}
}
