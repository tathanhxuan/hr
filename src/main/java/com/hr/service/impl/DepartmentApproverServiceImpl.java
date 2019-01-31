package com.hr.service.impl;

import java.io.Serializable;

public class DepartmentApproverServiceImpl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String deptID;
	String deptName;
	int approvalLevel;
	String empID;
			
	public DepartmentApproverServiceImpl(String deptID, String deptName, int approvalLevel, String empID) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.approvalLevel = approvalLevel;
		this.empID = empID;
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
	public int getApprovalLevel() {
		return approvalLevel;
	}
	public void setApprovalLevel(int approvalLevel) {
		this.approvalLevel = approvalLevel;
	}
	
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	@Override
	public String toString() {
		return "[Dept ID: " + deptID + ", Dept Name: " + deptName.toString() + ", Approval Level: " + approvalLevel + ", Emp ID: " + empID.toString() + "]";
	}
}
