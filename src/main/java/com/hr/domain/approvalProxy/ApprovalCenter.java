package com.hr.domain.approvalProxy;

import java.util.ArrayList;

import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

public class ApprovalCenter implements IApproval {

	private Employee emp;
	
	ApprovalCenter(Employee emp){
		this.emp = emp;
	}

	public ArrayList<Form> getWaitedApproveForms() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean Approve(StepApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
