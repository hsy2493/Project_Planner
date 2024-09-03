package com.web.projectplanner.a01_controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller

public class MainController {


	// http://localhost:7070/init_page
    @GetMapping("/init_page")
    public String initPage() {
        return "a01_index";
    }

    // http://localhost:7070/main
    @GetMapping("/main")
    public String mainPage(HttpServletRequest request) {
        return "a01_index";
    }

    // http://localhost:7070/gantt
    @GetMapping("gantt")
    public String ganttPage() {
        return "gantt";
    }

    // http://localhost:7070/chatting
    @GetMapping("chatting")
    public String chattingPage() {
        return "a10_chatting";
    }

}
