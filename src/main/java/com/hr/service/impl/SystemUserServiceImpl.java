package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.SystemUser;

public class SystemUserServiceImpl implements Serializable {
	String id;
	String user_name;
	String password;
	String empID;
	Boolean isApprover;
	Boolean isHR;
	
	public SystemUserServiceImpl(String id, String user_name, String password, String empID, Boolean isApprover, Boolean isHR) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.empID = empID;
		this.isApprover = isApprover;
		this.isHR = isHR;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Boolean getIsApprover() {
		return isApprover;
	}

	public void setIsApprover(Boolean isApprover) {
		this.isApprover = isApprover;
	}

	public Boolean getIsHR() {
		return isHR;
	}

	public void setIsHR(Boolean isHR) {
		this.isHR = isHR;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", User Name: " + user_name.toString() + ", empID: " + empID.toString() + "]";
	}
}
