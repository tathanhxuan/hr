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
	String nameApprover;
			
	public DepartmentApproverServiceImpl(String deptID, String deptName, int approvalLevel, String nameApprover) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.approvalLevel = approvalLevel;
		this.nameApprover = nameApprover;
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
	public String getNameApprover() {
		return nameApprover;
	}
	public void setNameApprover(String nameApprover) {
		this.nameApprover = nameApprover;
	}
	
	@Override
	public String toString() {
		return "[Dept ID: " + deptID + ", Dept Name: " + deptName.toString() + ", Approval Level: " + approvalLevel + ", Name Approver: " + nameApprover.toString() + "]";
	}
}
