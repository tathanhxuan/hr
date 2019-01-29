package com.hr.domain.approval;

import java.util.ArrayList;

import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

public interface IApproval {
	
	public ArrayList<StepApprover> getListApprover();
	public ArrayList<Form> getWaitedApproveForms(Employee emp);
	
}
