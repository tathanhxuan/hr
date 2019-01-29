package com.hr.domain;

import java.util.ArrayList;
import java.util.Date;

import com.hr.domain.approval.IApproval;
import com.hr.domain.formValidation.FormValidationStrategy;

public class OTForm extends Form {

	public OTForm(String formCode, Employee emp, FormStatus status,FormValidationStrategy validationStrategy) {
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
