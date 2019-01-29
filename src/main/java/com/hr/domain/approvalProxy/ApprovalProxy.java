package com.hr.domain.approvalProxy;

import java.util.ArrayList;

import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

//Apply Proxy Design Pattern
public class ApprovalProxy implements IApproval {

	private Employee emp;
    private IApproval approveCenter ; 
    
    public ApprovalProxy(Employee emp){
    	
    	if (emp.getIsApprover()==true) {
    		this.emp = emp;
    		approveCenter = new ApprovalCenter(emp);
    	}
    	
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
