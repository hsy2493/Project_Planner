package com.web.projectplanner.a04_vo;

public class Todo {
	private Long todoid;
    private Long taskid;
    private String empno;
    private String text;
    private String start_date;
    private String end_date;
    private String status;
    private long projectId;
    private String review_status;
    private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReview_status() {
		return review_status;
	}
	public void setReview_status(String review_status) {
		this.review_status = review_status;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public Long getTodoid() {
		return todoid;
	}
	public void setTodoid(Long todoid) {
		this.todoid = todoid;
	}
	public Long getTaskid() {
		return taskid;
	}
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Todo(Long todoid, Long taskid, String empno, String text, String start_date, String end_date, String status,
			long projectId) {
		super();
		this.todoid = todoid;
		this.taskid = taskid;
		this.empno = empno;
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
		this.projectId = projectId;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
