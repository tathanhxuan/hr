package com.hr.domain;
import java.util.Date;
import com.hr.domain.approval.IApproverList;

public abstract class Form {
	
	 String formCode;
	 String empID;
	 FormStatus status;
	 
	 public Form(String formCode,String empID, FormStatus status) {
		 this.formCode = formCode;
		 this.empID = empID;
		 this.status = status;
	 }
	 
	 public String getFormCode() {
		return formCode;
	}
	 
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public abstract Date getDateFrom();

	public FormStatus getStatus() {
		return status;
	}
	public void setStatus(FormStatus status) {
		this.status = status;
	}

 abstract Boolean Submit(IApproverList approverList);
 
 abstract Boolean Approve(FormApprover approvalModel);
 
 abstract Boolean ReSubmit();
 
}
