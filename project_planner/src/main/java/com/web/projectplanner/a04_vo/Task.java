package com.web.projectplanner.a04_vo;



public class Task {
	private Long taskid;
    private String text;
    private String start_date;
    private String end_date;
    private String progress;
    private Long projectid;
    private String backgroundColor;
    private String textColor;
    private String allday;
    private String urlLink;
    private String empno;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Long getTaskid() {
		return taskid;
	}
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Long getProjectid() {
		return projectid;
	}
	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getAllday() {
		return allday;
	}
	public void setAllday(String allday) {
		this.allday = allday;
	}
	public String getUrlLink() {
		return urlLink;
	}
	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Task(Long taskid, String text, String start_date, String end_date, String progress, Long projectid,
			String backgroundColor, String textColor, String allday, String urlLink) {
		super();
		this.taskid = taskid;
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.projectid = projectid;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.allday = allday;
		this.urlLink = urlLink;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}




}
