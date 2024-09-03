package com.web.projectplanner.a04_vo;


public class User {
	private String empno;
    private String email;
	private String name;
    private String password;
    private String role;
    private String dname;
    private String projectStatus;
    
	
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String empno, String email, String name, String password, String role) {
		super();
		this.empno = empno;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User(String name, String email, String empno, String role) {
		super();
		this.name = name;
		this.email = email;
		this.empno = empno;
		this.role = role;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	


}
