package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.Form;

public class StepApproverServiceImpl implements Serializable {
	String aproverID;
	String approveStep;
	String approveDate;
	String comments;
	Form form;
			
	public StepApproverServiceImpl(String aproverID, String approveStep, String approveDate, String comments,
			Form form) {
		super();
		this.aproverID = aproverID;
		this.approveStep = approveStep;
		this.approveDate = approveDate;
		this.comments = comments;
		this.form = form;
	}
	public String getAproverID() {
		return aproverID;
	}
	public void setAproverID(String aproverID) {
		this.aproverID = aproverID;
	}
	public String getApproveStep() {
		return approveStep;
	}
	public void setApproveStep(String approveStep) {
		this.approveStep = approveStep;
	}
	public String getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	
	@Override
	public String toString() {
		return "[Aprover ID: " + aproverID + ", Approve Step: " + approveStep.toString() + ", Approve Date: " + approveDate.toString() + ", Comments: " + comments.toString() + "]";
	}
	
}
