package com.web.projectplanner.a05_util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
// DownLoadCtrl.java
	public String downLoad(@RequestParam("fname") String fname,
			                 Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadView";/

*/
@Controller
public class DownLoadCtrl {
	// http://localhost:7080/downLoad.do?fname=a01_spring.txt
	// 호출시 특정 파일을 다운로드 처리..
	@GetMapping("downLoad.do")
	public String downLoad(@RequestParam("fname") String fname,
			                 Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadView";// downloadView downloadFile
	}
}
