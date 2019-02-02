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

import com.hr.repository.storage.DataAccessRepositoryFacade;


public class OTForm extends Form implements Serializable, IFormCode {

	Date OTDate;
	String timeFrom;
	String timeTo;
	
	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public Date getOTDate() {
		return OTDate;
	}

	public void setOTDate(Date oTDate) {
		OTDate = oTDate;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	
	public OTForm( Employee emp) {
		super( emp);
		// TODO Auto-generated constructor stub
		this.formCode = CodeInterpreter();
//		this.OTDate = OtDate;
//		this.timeFrom=timeFrom;
//		this.timeTo=timeTo;
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
		
		da.saveNewOTForm(this);
		
		for (DepartmentApprover approver: approvers) {		
			// Save into Form Approver
			FormApprover formApprover = new FormApprover(formCode, approver.getApprovalLevel(), approver.getEmpID());
			da.saveNewFormApprover(formApprover);
		}
		//System.out.println(da.readOTForm());
		//System.out.println(da.getListOTForm());
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
		// TODO Auto-generated method stub
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "OT" + this.getOwner().getEmpID() + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}

	@Override
	int getCurrentStatus() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		
		return "Form Code: " + this.getFormCode() +"\t"+ "Time From: " + this.timeFrom.toString()+ "\t" + "Time To: " + this.timeTo.toString()+"\n";
		//return "[Form Code: " + this.getFormCode() +  "]";
	}

}
