package com.hr.domain;
import java.util.ArrayList;

import com.hr.domain.approval.IApproval;

public class DepartmentApprover implements IApproval {
	String deptID;
	
	public DepartmentApprover(String deptID) {
		this.deptID = deptID;
	}

	public ArrayList<StepApprover> getListApprover() {
		// TODO Auto-generated method stub
		
		//respository 
		return null;
	}

	public ArrayList<Form> getWaitedApproveForms(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
