package com.hr.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.hr.domain.ApprovalCore.IApprovalVisitor;
import com.hr.domain.ApprovalCore.IFormApproval;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.HRFormCore.IFormCode;
import com.hr.domain.Notify.EmailAlert;
import com.hr.domain.Notify.NotifyService;
import com.hr.domain.Notify.Observer;
import com.hr.domain.Notify.SMSAlert;

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

	public String CodeInterpreter() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "LA" + this.getOwner().getEmpID() + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}
	

	public void accept(IApprovalVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	int getCurrentStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	ArrayList<Form> getEmployeeForms(FormStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean SubmitNotify(Form f) {
		// TODO Auto-generated method stub
		
		//send alert to approver
		NotifyService notifyService = new NotifyService();
		Observer email = new EmailAlert();
		Observer sms = new SMSAlert();
		notifyService.register(email);
		notifyService.register(sms);
		email.setSubject(notifyService);
		sms.setSubject(notifyService);
		
		notifyService.postMessage("Please approve this Form : " + f.getFormCode());
		
		return null;
	}

	@Override
	Boolean ReSubmit() {
		// update form when form was refused
		return null;
	}

	@Override
	Boolean Submit(ArrayList<DepartmentApprover> approvers) {
		// TODO Auto-generated method stub
		
		//SAVE IN DB
		
	    //write log  - commnad pattern for writing log
		
		return null;
	}

	
}