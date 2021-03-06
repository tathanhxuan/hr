package com.hr.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

import com.hr.domain.ApprovalCore.IApproval;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class DepartmentApprover implements Serializable {
	String id;
	String deptID;
	String deptName;
	int approvalLevel;

	String nameApprover;
	String empID;

	public ArrayList<DepartmentApprover> getListApprover() {
		// TODO Auto-generated method stub

		// Respository
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		return da.getListDepartmentApprover();
	}

	
	public DepartmentApprover(String id, String deptID, String deptName, int approvalLevel, String empID, String nameApprover) {
		super();
		//this.id = CodeInterpreter();
		this.id = id;
		this.deptID = deptID;
		this.deptName = deptName;
		this.approvalLevel = approvalLevel;
		this.empID = empID;
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


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
	}


	public DepartmentApprover(String deptID) {
		this.deptID = deptID;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String CodeInterpreter() {
		// TODO Auto-generated method stub

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "DA" + "_" + timeStamp;
	}
	
	@Override
	public String toString() {
		return "[Dept ID: " + deptID + ", Dept Name: " + deptName.toString() + ", Approval Level: " + approvalLevel + ", Approver Name: " + nameApprover + ", empID: " + empID.toString() + "]";
	}

}
