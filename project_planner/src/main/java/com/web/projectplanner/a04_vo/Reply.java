package com.web.projectplanner.a04_vo;

import java.util.Date;

public class Reply {

	private int no;
	private int replyno;
	private String replyid;
	private String content;
	private Date regdte;
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int no, int replyno, String replyid, String content, Date regdte) {
		super();
		this.no = no;
		this.replyno = replyno;
		this.replyid = replyid;
		this.content = content;
		this.regdte = regdte;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public String getReplyid() {
		return replyid;
	}
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

}
