package com.hr.domain;

import java.io.Serializable;

public class SystemUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String user_name;
	String password;
	String empID;
	Boolean isApprover;
	Boolean isHR;
   
	
	public SystemUser(String id, String user_name, String password, String empID, Boolean isApprover, Boolean isHR) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.empID = empID;
		this.isApprover = isApprover;
		this.isHR = isHR;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", User Name: " + user_name.toString() + ", Is Approver: " + isApprover + ", Is HR: " + isHR + ", empID: " + empID.toString() + "]";
	}

}
