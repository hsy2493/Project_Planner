package com.web.projectplanner.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.FreeBoardService;
import com.web.projectplanner.a02_service.ReplyService;
import com.web.projectplanner.a04_vo.FreeBoard;
import com.web.projectplanner.a04_vo.FreeBoardSch;

import jakarta.servlet.http.HttpSession;


@Controller
public class FreeBoardController {
   @Autowired(required = false)
   private FreeBoardService service;

   @Autowired(required = false)
   private ReplyService service2;

   // http://localhost:7070/freeBoardList
   @RequestMapping("freeBoardList")
   public String freeBoardList(@ModelAttribute("sch") FreeBoardSch sch, Model d) {
      d.addAttribute("flist", service.getFreeBoardList(sch));
      return "z01_FreeBoardList";
   }
   ///////////////////////////////////////////////////////////////
   @RequestMapping("freeBoardInsertFrm")
   public String freeBoardInsertFrm() {
      return "z02_FreeBoardInsert";
   }
   @PostMapping("freeBoardInsert")
   public String freeBoardInsert(FreeBoard ins, Model d,HttpSession session) {
      d.addAttribute("msg", service.freeBoardInsert(ins));
      
      session.setAttribute("writer","테스트 작성자1");
      String writer = (String) session.getAttribute("writer");
      
      return "z02_FreeBoardInsert";
   }
   ///////////////////////////////////////////////////////////////
   @GetMapping("freeBoardDetail")
   public String freeBoardDetail(@RequestParam("no") int no, Model d,HttpSession session) {
      d.addAttribute("freeBoard", service.detail(no));
      d.addAttribute("rlist",service2.getReplyList(no));
      
      session.setAttribute("writer","테스트 작성자1");
      String writer = (String) session.getAttribute("writer");
      
      return "z03_FreeBoardDetail";
   }
   ///////////////////////////////////////////////////////////////
   @PostMapping("freeBoardUpdate")
    public String updateFreeboard(@RequestParam("no") int no,
                                  @RequestParam("subject") String subject,
                                  @RequestParam("content") String content,
                                  HttpSession session, Model d) {
      
      session.setAttribute("writer","테스트 작성자1");
      String writer = (String) session.getAttribute("writer");
      
      service.updateFreeboard(no, writer, subject, content);
        return "redirect:freeBoardDetail?no=" + no;
    }

    @GetMapping("freeBoardDelete")
       public String deleteFreeboard(@RequestParam("no") int no, HttpSession session, Model d) {
          
       session.setAttribute("writer","테스트 작성자1");
        String writer = (String) session.getAttribute("writer");

           // 서비스 메서드 호출
           int result = service.deleteFreeboard(no, writer);
           if (result > 0) {
               d.addAttribute("msg", "삭제 성공");
           } else {
               d.addAttribute("msg", "삭제 실패: 권한이 없습니다.");
           }
           return "redirect:freeBoardList";
       }   

}
