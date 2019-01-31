package com.hr.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.HRFormCore.IFormCode;
import com.hr.repository.storage.DataAccessRepositoryFacade;

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
		
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		for (DepartmentApprover approver: approvers) {
			Employee emp = this.getOwner();
			String formCode = CodeInterpreter();
			FormValidationStrategy fvs = this.validationStrategy;
			// Save into OT_FORM			
			OTForm oTForm = new OTForm(emp, FormStatus.CREATED, fvs);
			da.saveNewOTForm(oTForm);
			
			// Save into Form Approver
			FormApprover formApprover = new FormApprover(formCode, approver.getApprovalLevel(), approver.getNameApprover());
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
	Boolean SubmitNotify() {
		// TODO Auto-generated method stub
		return null;
	}

	public String CodeInterpreter() {
		// TODO Auto-generated method stub
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "OT" + this.getOwner().empID + this.getOwner().getDepartment().getDeptID() + "_"+ timeStamp ;
	}
	
	/*@Override
	public String toString() {
		return "[formCode: " + this.formCode  + "]";
	}*/

}
