package com.hr.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.HRFormCore.IFormCode;

public class LeaveForm extends Form implements IFormCode {

	Date leaveDateFrom;
	Date leaveDateTo;
	String description;

	public LeaveForm( Employee emp, FormStatus status, FormValidationStrategy validationStrategy) {
		super(emp, status,validationStrategy);
		// TODO Auto-generated constructor stub
	    this.formCode = CodeInterpreter();
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
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
		// update form
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

	public String CodeInterpreter() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "LA" + this.getOwner().empID + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}

}