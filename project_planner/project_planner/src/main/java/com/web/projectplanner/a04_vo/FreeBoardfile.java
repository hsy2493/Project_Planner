package com.web.projectplanner.a04_vo;

import java.util.Date;

public class FreeBoardfile {
	private int no;
	private String fname;
	private String etc;
	private Date regdte;
	private Date uptdte;
	public FreeBoardfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeBoardfile(String fname, String etc) {
		super();
		this.fname = fname;
		this.etc = etc;
	}

	public FreeBoardfile(int no, String fname, String etc, Date regdte, Date uptdte) {
		super();
		this.no = no;
		this.fname = fname;
		this.etc = etc;
		this.regdte = regdte;
		this.uptdte = uptdte;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
}
