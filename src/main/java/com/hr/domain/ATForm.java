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
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATForm extends Form implements IFormCode {

	public ATForm( Employee emp, FormStatus status,FormValidationStrategy validationStrategy) {
		super(emp, status,validationStrategy);
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
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		for (DepartmentApprover approver: approvers) {
			Employee emp = this.getOwner();
			String formCode = CodeInterpreter();
			FormValidationStrategy fvs = this.validationStrategy;
			// Save into AT_FORM			
			ATForm aTForm = new ATForm(emp, FormStatus.CREATED, fvs);
			da.saveNewATForm(aTForm);
			
			// Save into Form Approver
			FormApprover formApprover = new FormApprover(formCode, approver.getApprovalLevel(), approver.getEmpID());
			da.saveNewFormApprover(formApprover);
		}
		//System.out.println(da.readATForm());
		//System.out.println(da.getListATForm());
		//System.out.println(da.readFormApproverMap());		
		return true;
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
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "AT" + this.getOwner().getEmpID() + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}


	@Override
	int getCurrentStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

}
