package com.web.projectplanner.a01_controller;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
      if (sch.getStartBlock() < 1 || sch.getEndBlock() < 1 || sch.getCurPage() < 1) {
          return "redirect:freeBoardList"; // 유효하지 않은 경우 리다이렉트
      }
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
      return "z02_FreeBoardInsert";
   }
   ///////////////////////////////////////////////////////////////
   @GetMapping("freeBoardDetail")
   public String freeBoardDetail(@RequestParam("no") int no, Model d,HttpSession session) {
      d.addAttribute("freeBoard", service.detail(no));
      d.addAttribute("rlist",service2.getReplyList(no));
      
      String writer = (String) session.getAttribute("writer");
      
      return "z03_FreeBoardDetail";
   }

   @GetMapping("downLoad")
	public String downLoad(@RequestParam("fname") String fname,
			                 Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadView";// downloadView downloadFile
	}
   ///////////////////////////////////////////////////////////////
   @PostMapping("freeBoardUpdate")
    public String updateFreeboard(@RequestParam("no") int no,
                                  @RequestParam("subject") String subject,
                                  @RequestParam("content") String content,
                                  HttpSession session, Model d) {
      
      String writer = (String) session.getAttribute("writer");
      
      service.updateFreeboard(no, writer, subject, content);
        return "redirect:freeBoardDetail?no=" + no;
    }

    @GetMapping("freeBoardDelete")
       public String deleteFreeboard(@RequestParam("no") int no, HttpSession session, Model d) {
          
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
