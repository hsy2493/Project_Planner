package com.web.projectplanner.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DeptController {


	// http://localhost:7070/deptList
	@RequestMapping("deptList")
	public String deptList() {
		return "a04_deptList";
	}
}
