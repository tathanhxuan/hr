package com.hr.domain.ApprovalCore;

import java.util.ArrayList;

import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.StepApprover;

//Apply Proxy Design Pattern
public class ApprovalProxy implements IApproval {

	private Employee emp;
    private IApproval approveCenter ; 
    private Boolean isHR;
    
    public ApprovalProxy(Employee emp) throws Exception{
    	
    	if (emp.getIsApprover()==true) {
    		this.emp = emp;
    		approveCenter = new ApprovalCenter(emp) ;
    	}		
    }

	public ArrayList<Form> getWaitedApproveForms() throws Exception {
		
		if (emp.getIsApprover()) {
			// TODO Auto-generated method stub
			return approveCenter.getWaitedApproveForms();
		}
		else {
			throw new Exception("rm command is not allowed for non-admin users.");
		}
		
	}

	public Boolean Approve(StepApprover approvalModel)  throws Exception {
		// TODO Auto-generated method stub
		if (emp.getIsApprover()) {
			// TODO Auto-generated method stub
			return approveCenter.Approve(approvalModel);
			}
			else {
				throw new Exception("rm command is not allowed for non-admin users.");
			}
	
	}

	public Boolean Refuse(StepApprover approvalModel) throws Exception {
		// TODO Auto-generated method stub
		if (emp.getIsApprover()) {
			// TODO Auto-generated method stub
			return approveCenter.Refuse(approvalModel);
			}
			else {
				throw new Exception("rm command is not allowed for non-admin users.");
			}
	}

	public Boolean SetDepartmentApprover(ArrayList<DepartmentApprover> approvers)throws Exception {
		// TODO Auto-generated method stub
				if (emp.getIsHR()) {
					// TODO Auto-generated method stub
					return approveCenter.SetDepartmentApprover(approvers);
					}
					else {
						throw new Exception("rm command is not allowed for non-admin users.");
					}
	}

	public Boolean ApproveAll(ArrayList<Form> forms) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
