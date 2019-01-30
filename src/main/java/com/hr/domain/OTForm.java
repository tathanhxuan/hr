package com.hr.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.HRFormCore.IFormCode;

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
	Boolean Submit(ArrayList<StepApprover> approvers) {
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
	Boolean SubmitNotify() {
		// TODO Auto-generated method stub
		return null;
	}

	public String CodeInterpreter() {
		// TODO Auto-generated method stub
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "OT" + this.getOwner().empID + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}

}
