package com.web.projectplanner.a01_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.CalendarService;
import com.web.projectplanner.a02_service.ProjectService;
import com.web.projectplanner.a04_vo.Calendar;
import com.web.projectplanner.a04_vo.Project;
import com.web.projectplanner.a04_vo.Task;

import jakarta.servlet.http.HttpSession;

@Controller
public class CalendarController {

    @Autowired(required = false)
    private CalendarService service;
    
    @Autowired(required = false)
    private ProjectService proservice;

    private Integer getProjectId(HttpSession session, Integer projectid) {
        if (projectid == null) {
            projectid = (Integer) session.getAttribute("projectid");
            if (projectid == null) {
                projectid = 47; // 기본값 설정
            }
        }
        return projectid;
    }

    // http://localhost:7070/calendar
    @GetMapping("calendar")
    public String calendar(HttpSession session, Model model,
                           @RequestParam(defaultValue = "", value = "div") String div,
                           @RequestParam(defaultValue = "47", value="projectid") Integer projectid,
                           @RequestParam(defaultValue = "false", value = "gant") Boolean gant) {

        // 세션에서 writer와 projectid 가져오기
        String writer = (String) session.getAttribute("empno");
        projectid = getProjectId(session, projectid);

        List<Calendar> calendarList = new ArrayList<>();
        List<Project> projects = proservice.getAllProjects();
        
        // div에 따라 적절한 서비스 메소드 호출
        if (!div.isEmpty()) {
            calendarList.addAll(service.getCalendarList(writer, div, projectid));
        }

        // 간트는 별도로 처리
        if (gant != null && gant) {
            calendarList.addAll(service.getCalendarList3(projectid));
        }

        // 모델에 데이터 추가
        model.addAttribute("calendarList", calendarList);
        model.addAttribute("writer", writer);
        model.addAttribute("div", div);
        model.addAttribute("projectid", projectid);
        model.addAttribute("projectList", projects);

        return "z05_Calendar"; // JSP 페이지 이름
    }

    // http://localhost:7070/calList
    @GetMapping("calList")
    public ResponseEntity<List<Calendar>> getCalList(
            HttpSession session,Model model,
            @RequestParam(defaultValue = "", value = "div") List<String> div,
            @RequestParam(defaultValue = "47", value="projectid") Integer projectid,
            @RequestParam(defaultValue = "true", value = "gant") Boolean gant) {

        // 세션에서 projectid 가져오기
        String writer = (String) session.getAttribute("empno");
        projectid = getProjectId(session, projectid);

        List<Calendar> calendarList = new ArrayList<>();
        List<Project> projects = proservice.getAllProjects();

        model.addAttribute("projectList", projects);
        
        // div 필터링
        if (div != null && !div.isEmpty()) {
            for (String d : div) {
                calendarList.addAll(service.getCalendarList(writer, d, projectid));
            }
        }

        if (gant != null && gant) {
            calendarList.addAll(service.getCalendarList3(projectid));
        }

        return ResponseEntity.ok(calendarList);
    }

    @PostMapping("insertCalendar")
    public ResponseEntity<?> insertCalendar(Calendar ins, 
            @RequestParam("writer") String writer,
            @RequestParam("projectid") Integer projectid, 
            @RequestParam("div") String div) {
        // 간트 캘린더인 경우, 등록을 허용하지 않음
        if ("간트".equals(div)) {
            return ResponseEntity.badRequest().body(new Msg("간트 캘린더에서는 등록할 수 없습니다."));
        }

        // Calendar 객체에 div 및 projectid 설정
        ins.setWriter(writer);
        ins.setProjectid(projectid);
        ins.setDiv(div);

        // 개인 및 팀 캘린더인 경우 등록 처리
        String isInserted = service.insertCalendar(ins);
        List<Calendar> calendarList = service.getCalendarList(writer, div, projectid);

        return ResponseEntity.ok(new MsgList(isInserted, calendarList));
    }

    @PostMapping("updateCalendar")
    public ResponseEntity<?> updateCalendar(Calendar upt, 
            @RequestParam("writer") String writer,
            @RequestParam("projectid") Integer projectid, 
            @RequestParam("div") String div) {
        // 간트 캘린더인 경우, 수정하지 않음
        if ("간트".equals(div)) {
            return ResponseEntity.badRequest().body(new Msg("간트 캘린더에서는 수정할 수 없습니다."));
        }

        // Calendar 객체에 div 및 projectid 설정
        upt.setWriter(writer);
        upt.setProjectid(projectid);
        upt.setDiv(div);

        // 개인 및 팀 캘린더인 경우 수정 처리
        String isUpdated = service.updateCalendar(upt);
        List<Calendar> calendarList = service.getCalendarList(writer, div, projectid);

        return ResponseEntity.ok(new MsgList(isUpdated, calendarList));
    }

    @PostMapping("deleteCalendar")
    public ResponseEntity<?> deleteCalendar(@RequestParam("id") int id, 
            @RequestParam("writer") String writer,
            @RequestParam("projectid") Integer projectid, 
            @RequestParam("div") String div) {
        // 간트 캘린더인 경우, 삭제하지 않음
        if ("간트".equals(div)) {
            return ResponseEntity.badRequest().body(new Msg("간트 캘린더에서는 삭제할 수 없습니다."));
        }

        // 개인 및 팀 캘린더인 경우 삭제 처리
        String isDeleted = service.deleteCalendar(id, writer, div);

        // 삭제 후 캘린더 목록을 다시 가져옵니다.
        List<Calendar> calendarList = service.getCalendarList(writer, div, projectid);

        return ResponseEntity.ok(new MsgList(isDeleted, calendarList));
    }
}

class MsgList {
    private String msg;
    private List<Calendar> calList;

    public MsgList() {
        super();
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

class Msg {
    private String message;

    public Msg() {
        super();
    }

    public Msg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}