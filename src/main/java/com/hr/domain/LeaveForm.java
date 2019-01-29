package com.hr.domain;

import java.util.ArrayList;
import java.util.Date;
import com.hr.domain.formValidation.FormValidationStrategy;

public class LeaveForm extends Form {

	String formCode;
	int formType;
	String empID;
	FormStatus status;
	Date leaveDateFrom;
	Date leaveDateTo;
	String description;

	public LeaveForm(String formCode, Employee emp, FormStatus status, FormValidationStrategy validationStrategy) {
		super(formCode, emp, status,validationStrategy);
		// TODO Auto-generated constructor stub
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
		
		//SAVE IN DB
		return null;
	}

	@Override
	ArrayList<Form> getEmployeeForms(FormStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean SubmitNotify() {
		// TODO Auto-generated method stub
		return null;
	}

}
