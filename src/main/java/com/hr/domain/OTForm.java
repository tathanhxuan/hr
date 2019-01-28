package com.hr.domain;

import java.util.Date;

import com.hr.domain.approval.IApproverList;

public class OTForm extends Form {

	public OTForm(String formCode, String empID, FormStatus status) {
		super(formCode, empID, status);
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
	Boolean Approve(FormApprover approvalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Boolean Submit(IApproverList approverList) {
		// TODO Auto-generated method stub
		return null;
	}

}
