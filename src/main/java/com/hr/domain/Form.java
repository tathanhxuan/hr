package com.hr.domain;

import java.util.Date;

public abstract class Form {
	
	 String formCode;
	 String empID;
	 Date dateFrom;
	 Date dateTo;
	 FormStatus status;
 
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

	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public FormStatus getStatus() {
		return status;
	}
	public void setStatus(FormStatus status) {
		this.status = status;
	}

 abstract Boolean Submit();
 abstract Boolean Approve();
 abstract Boolean Update();
 
}
