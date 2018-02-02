package com.smartsecurity.model;

public class Department {
	private String departmentId;
	private String departmentName;
	private String departmentLogo;
	
	
	public String getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDepartmentLogo() {
		return departmentLogo;
	}
	
	
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDepartmentLogo(String departmentIcon) {
		this.departmentLogo = departmentIcon;
	}
	
}
