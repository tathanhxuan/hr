package com.hr.domain.ApprovalCore;

import java.util.ArrayList;

import com.hr.domain.DepartmentApprover;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

public interface IApproval {
	
	public ArrayList<Form> getWaitedApproveForms() throws Exception;;
	
	public Boolean Approve(StepApprover approvalModel) throws Exception;
	
	public Boolean ApproveAll(ArrayList<Form> forms, StepApprover approvalModel) throws Exception;
	
	public Boolean Refuse(StepApprover approvalModel) throws Exception;
	
	public Boolean SetDepartmentApprover(ArrayList<DepartmentApprover> approvers) throws Exception;
	
	
}
