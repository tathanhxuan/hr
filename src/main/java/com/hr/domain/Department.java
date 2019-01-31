package com.hr.domain;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String deptID;
	String deptName;

	public Department(String deptID, String deptName) {
		this.deptID = deptID;
		this.deptName = deptName;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "[deptID: " + deptID + ", deptName: " + deptName + "]";
	}
}
