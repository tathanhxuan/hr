package com.hr.domain;

import java.io.Serializable;
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

public class OTForm extends Form implements Serializable, IFormCode {

	public OTForm( Employee emp, FormStatus status,FormValidationStrategy validationStrategy) {
		super( emp, status,validationStrategy);
		// TODO Auto-generated constructor stub
		this.formCode = CodeInterpreter();
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
	Boolean Submit(ArrayList<DepartmentApprover> approvers) {
		// TODO Auto-generated method stub
		
		//save into DB
		return null;
	}

	@Override
	ArrayList<Form> getEmployeeForms(FormStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean SubmitNotify(Form f) {
		
		//send alert to approver
		NotifyService notifyService = new NotifyService();
		Observer email = new EmailAlert();
		Observer sms = new SMSAlert();
		notifyService.register(email);
		notifyService.register(sms);
		email.setSubject(notifyService);
		sms.setSubject(notifyService);
		
		notifyService.postMessage("Please approve this Form : " + f.getFormCode());
		
		return true;
	}

	public String CodeInterpreter() {
		// TODO Auto-generated method stub
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "OT" + this.getOwner().getEmpID() + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}

	@Override
	int getCurrentStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

}
