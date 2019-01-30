package com.hr.domain.ApprovalCore;

import java.util.ArrayList;

import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

public interface IApproval {
	
	public ArrayList<Form> getWaitedApproveForms() throws Exception;;
	
	public Boolean Approve(StepApprover approvalModel) throws Exception;;
	
}
