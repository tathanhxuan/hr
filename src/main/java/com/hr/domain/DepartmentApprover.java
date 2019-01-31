package com.hr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.hr.domain.ApprovalCore.IApproval;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class DepartmentApprover implements Serializable {
	String deptID;
	String deptName;
	int approvalLevel;
	String nameApprover;

	public ArrayList<DepartmentApprover> getListApprover() {
		// TODO Auto-generated method stub

		// Respository
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		return da.getListDepartmentApprover();
	}

	
	public DepartmentApprover(String deptID, String deptName, int approvalLevel, String nameApprover) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.approvalLevel = approvalLevel;
		this.nameApprover = nameApprover;
	}


	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getDeptID() {
		return deptID;
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

	public DepartmentApprover(String deptID) {
		this.deptID = deptID;
	}
	
	@Override
	public String toString() {
		return "[Dept ID: " + deptID + ", Dept Name: " + deptName.toString() + ", Approval Level: " + approvalLevel + ", Name Approver: " + nameApprover.toString() + "]";
	}

}
