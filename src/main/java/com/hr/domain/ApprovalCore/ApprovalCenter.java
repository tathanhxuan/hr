package com.hr.domain.ApprovalCore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.FormStatus;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.domain.StepApprover;
import com.hr.repository.storage.DataAccessRepositoryFacade;

//Implement detail proxy pattern by client
public class ApprovalCenter implements IApproval {

	private Employee emp;

	ApprovalCenter(Employee emp) {
		this.emp = emp;
	}

	// Get list of waiting approve forms base on employee
	public ArrayList<Form> getWaitedApproveForms() {
		// TODO Auto-generated method stub

		// get step [X] approve info from [department approver] table BASE ON EMPID AND
		// DEPTID
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();

		int approvalLevel = 0;
		ArrayList<DepartmentApprover> departmentApprovers = da.getListDepartmentApprover();
		for (DepartmentApprover departmentApprover : departmentApprovers) {
			if (emp.getEmpID().equals(departmentApprover.getEmpID())
					&& emp.getDept().getDeptID().equals(departmentApprover.getDeptID())) {
				approvalLevel = departmentApprover.getApprovalLevel();
			}
		}

		// get data from FORM (OT,AT,LEAVE) table WHERE DEPTID AND step = STEP X-1

		ArrayList<OTForm> oTForms = da.getListOTForm();
		ArrayList<ATForm> aTForms = da.getListATForm();
		ArrayList<LeaveForm> leaveForms = da.getListLeaveForm();

		ArrayList<Form> allForms = new ArrayList<Form>();
		for (OTForm oTForm : oTForms) {
			if (emp.getEmpID().equals(oTForm.getOwner().getEmpID())
					&& oTForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(oTForm);
			}
		}

		for (ATForm aTForm : aTForms) {
			if (emp.getEmpID().equals(aTForm.getOwner().getEmpID())
					&& aTForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(aTForm);
			}
		}

		for (LeaveForm leaveForm : leaveForms) {
			if (emp.getEmpID().equals(leaveForm.getOwner().getEmpID())
					&& leaveForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(leaveForm);
			}
		}

		return allForms;
	}

	// approve forms base on form code
	public Boolean Approve(String formCode) {
		// TODO Auto-generated method stub
		System.out.println(formCode);
		return null;
	}

	// approve forms base on employee
	public Boolean Refuse(StepApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean SetDepartmentApprover(ArrayList<DepartmentApprover> approvers) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean ApproveAll(ArrayList<Form> forms) throws Exception {
		// TODO Auto-generated method stub
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		// implement transaction here for approve all form
		for (Form form : forms) {
			if (form instanceof OTForm) {
				OTForm oTForm = (OTForm) form;
				FormStatus formStatus = oTForm.getStatus();
				formStatus.setValue(oTForm.getStatus().getValue() + 1);
				oTForm.setStatus(formStatus);
				da.updateOTForm(oTForm);
			} else if (form instanceof ATForm) {
				ATForm aTForm = (ATForm) form;
				aTForm.setStatus(aTForm.getStatus());
				da.updateATForm(aTForm);
			} else if (form instanceof LeaveForm) {
				LeaveForm leaveForm = (LeaveForm) form;
				leaveForm.setStatus(leaveForm.getStatus());
				da.updateLeaveForm(leaveForm);
			}
		}
		System.out.println(da.readATFormMap());
		System.out.println(da.readOTFormMap());
		System.out.println(da.readLeaveFormMap());
		System.out.println("Approve All Sussessfully");

		return null;
	}

}
