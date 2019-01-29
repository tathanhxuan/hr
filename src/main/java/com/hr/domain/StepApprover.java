package com.hr.domain;

public class StepApprover {

	Form form;
	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}
	
	String aproverID;
	String approveStep;
	String approveDate;
	String comments;
	
	public StepApprover(String aproverID,String approveStep,String approveDate,String comments) {
		this.aproverID=aproverID;
		this.approveStep=approveStep;
		this.approveDate=approveDate;
		this.comments=comments;
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
	
}
