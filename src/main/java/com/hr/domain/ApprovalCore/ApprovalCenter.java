package com.hr.domain.ApprovalCore;

import java.util.ArrayList;

import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

//Implement detail proxy pattern by client
public class ApprovalCenter implements IApproval {

	private Employee emp;
	ApprovalCenter(Employee emp){
		this.emp = emp;
	}

	//Get list of waiting approve forms base on employee
	public ArrayList<Form> getWaitedApproveForms() {
		// TODO Auto-generated method stub
		return null;
	}

	//approve forms base on employee
	public Boolean Approve(StepApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	//approve forms base on employee
	public Boolean Refuse(StepApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean SetDepartmentApprover(ArrayList<DepartmentApprover> approvers) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean ApproveAll(ArrayList<Form> forms, StepApprover approvalModel) throws Exception {
		// TODO Auto-generated method stub
		
		//implement transaction here for approve all form
		return null;
	}
	
}
