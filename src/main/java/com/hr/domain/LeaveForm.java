package com.hr.domain;

import java.util.ArrayList;
import java.util.Date;
import com.hr.domain.formValidation.FormValidationStrategy;

public abstract class LeaveForm extends Form {

	String formCode;
	int formType;
	String empID;
	FormStatus status;
	Date leaveDateFrom;
	Date leaveDateTo;
	String description;

	public LeaveForm(String formCode, String empID, FormStatus status, String formCode2, int formType, String empID2,
			FormStatus status2, Date leaveDateFrom, Date leaveDateTo, String description) {
		super(formCode, empID, status);
		formCode = formCode2;
		this.formType = formType;
		empID = empID2;
		status = status2;
		this.leaveDateFrom = leaveDateFrom;
		this.leaveDateTo = leaveDateTo;
		this.description = description;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public int getFormType() {
		return formType;
	}

	public void setFormType(int formType) {
		this.formType = formType;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public FormStatus getStatus() {
		return status;
	}

	public void setStatus(FormStatus status) {
		this.status = status;
	}

	public Date getLeaveDateFrom() {
		return leaveDateFrom;
	}

	public void setLeaveDateFrom(Date leaveDateFrom) {
		this.leaveDateFrom = leaveDateFrom;
	}

	public Date getLeaveDateTo() {
		return leaveDateTo;
	}

	public void setLeaveDateTo(Date leaveDateTo) {
		this.leaveDateTo = leaveDateTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LeaveForm(String formCode, Employee emp, FormStatus status, FormValidationStrategy validationStrategy) {
		super(formCode, emp, status,validationStrategy);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Date getDateFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean ReSubmit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean Approve(StepApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean Submit(ArrayList<StepApprover> approvers) {
		// TODO Auto-generated method stub
		return null;
	}

}
