package com.hr.domain;

import java.util.ArrayList;
import java.util.Date;

import com.hr.domain.formValidation.FormValidationStrategy;

public class ATForm extends Form {

	public ATForm(String formCode, Employee emp, FormStatus status,FormValidationStrategy validationStrategy) {
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
	Boolean Submit(ArrayList<StepApprover> approvers) {
		// TODO Auto-generated method stub
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
