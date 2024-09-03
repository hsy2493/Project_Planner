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

    // 개인 및 팀 캘린더 일정조회
    public List<Calendar> getCalendarList(String writer, String div, Integer projectid) {
        if ("개인".equals(div)) {
            return dao.getCalendarList(writer, projectid);
        } else if ("팀".equals(div)) {
            return dao.getCalendarList2(projectid);
        } else {
            return List.of(); // 빈 리스트 반환
        }
    }

    // 간트 캘린더 일정조회
    public List<Calendar> getCalendarList3(int projectid) {
        return dao.getCalendarList3(projectid);
    }

    // 캘린더 일정등록
    public String insertCalendar(Calendar ins) {
        return dao.insertCalendar(ins) > 0 ? "등록 성공" : "등록 실패";
    }

    // 캘린더 일정 수정
    public String updateCalendar(Calendar upt) {
        int result = dao.updateCalendar(upt);
        return result > 0 ? "수정 성공" : "수정 실패";
    }

    // 캘린더 일정 삭제
    public String deleteCalendar(int id, String writer, String div) {
        int result = dao.deleteCalendar(id, writer, div);
        return result > 0 ? "삭제 성공" : "삭제 실패";
    }
}
