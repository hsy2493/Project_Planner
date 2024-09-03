package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.CalendarDao;
import com.web.projectplanner.a04_vo.Calendar;

@Service
public class CalendarService {

	@Autowired(required = false)
	private CalendarDao dao;

	public List<Calendar> getCalendarList(String writer){
		return dao.getCalendarList(writer);
	}

	public String insertCalendar(Calendar ins) {
		return dao.insertCalendar(ins)>0?"등록 성공":"등록 실패";
	}

	public String updateCalendar(Calendar upt) {
		return dao.updateCalendar(upt)>0?"수정 성공":"수정 실패";
	}

	public String deleteCalendar(int id, String writer) {
		return dao.deleteCalendar(id, writer)>0?"삭제 성공":"삭제 실패";
	}
}
