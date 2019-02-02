package com.hr.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class FormLog implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String formCode;
	String empID;
	String action;
	String actionDate;
	String remark;

	public FormLog(String formCode, String empID, String action, String remark) {
		this.formCode = formCode;
		this.empID = empID;
		this.action = action;

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		this.actionDate = dateFormat.format(cal.getTime());
		this.remark = remark;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean SaveLog() {
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		da.saveNewFormLog(this);
		return true;
	}
	
	public FormLog getFormLogByFormCode(String formCode) {
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		return da.getFormLogByFormCode(formCode);
	}

	@Override
	public String toString() {
		return "[Form Code: " + formCode.toString() + ", Action: " + action.toString() + ", Date: "
				+ actionDate.toString() + ", Remark: " + remark.toString() + "]";
	}

}
