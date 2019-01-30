package com.hr.service.impl;

import java.io.Serializable;
import java.util.Date;

import com.hr.domain.FormStatus;
import com.hr.domain.LeaveForm;

public class LeaveFormServiceImpl implements Serializable {
	String formCode;
	int formType;
	String empID;
	FormStatus status;
	Date leaveDateFrom;
	Date leaveDateTo;
	String description;
	
	
	
	public LeaveFormServiceImpl(String formCode, int formType, String empID, FormStatus status, Date leaveDateFrom,
			Date leaveDateTo, String description) {
		super();
		this.formCode = formCode;
		this.formType = formType;
		this.empID = empID;
		this.status = status;
		this.leaveDateFrom = leaveDateFrom;
		this.leaveDateTo = leaveDateTo;
		this.description = description;
	}

	/*public LeaveFormServiceImpl(String formCode, int formType, String empID, FormStatus status, Date leaveDateFrom, Date leaveDateTo, String description) {
		
		formCode = this.formCode;
		formType = this.formType;
		empID = this.empID;
		status = this.status;
		leaveDateFrom = this.leaveDateFrom;
		leaveDateTo = this.leaveDateTo;
		description = this.description;
	}*/

	
	/*public LeaveFormServiceImpl(String formCode, String empID, FormStatus status, String formCode2, int formType,
			String empID2, FormStatus status2, Date leaveDateFrom, Date leaveDateTo, String description,
			String formCode3, int formType2, String empID3, FormStatus status3, Date leaveDateFrom2, Date leaveDateTo2,
			String description2) {
		super(formCode, empID, status, formCode2, formType, empID2, status2, leaveDateFrom, leaveDateTo, description);
		formCode = formCode3;
		formType = formType2;
		empID = empID3;
		status = status3;
		leaveDateFrom = leaveDateFrom2;
		leaveDateTo = leaveDateTo2;
		description = description2;
	}*/

	

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public int getFormType() {
		return formType;
	}

	public void setFormType(int formType) {
		this.formType = formType;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	

	public FormStatus getStatus() {
		return status;
	}

	public void setStatus(FormStatus status) {
		this.status = status;
	}

	public Date getLeaveDateFrom() {
		return leaveDateFrom;
	}

	public void setLeaveDateFrom(Date leaveDateFrom) {
		this.leaveDateFrom = leaveDateFrom;
	}

	public Date getLeaveDateTo() {
		return leaveDateTo;
	}

	public void setLeaveDateTo(Date leaveDateTo) {
		this.leaveDateTo = leaveDateTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "[formCode: " + formCode + ", Form Type: " + formType + ", Form Status: " + status + ", empID: " + empID.toString() + "]";
	}

}
