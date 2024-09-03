package com.web.projectplanner.a05_util;
//
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("downloadView") // downloadView 자동 등록 처리.
public class DownloadView extends AbstractView{
	
	@Value("${user.upload}")
	private String upload;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest requst, HttpServletResponse response)
			throws Exception {

		String fname = (String)model.get("downloadFile");
		
		File file = new File(upload+fname);

		
		response.setContentType("application/download;charset=utf-8");
		
		response.setContentLengthLong((int)file.length());
		
		fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+"," ");
		
		response.setHeader("Content-Disposition",
							"attachment;filename=\""+fname+"\"");
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
	
		FileCopyUtils.copy(fis, out);
	
		out.flush();
	}




}
