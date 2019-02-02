package com.hr.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormLog {
	
	 String formCode;
	 String empID;
	 String action;
	 String actionDate;
	 String remark;
	 
	 public FormLog(String formCode,String empID, String action,String remark) {
		 this.formCode=formCode;
		 this.empID=empID;
		 this.action=action;
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	     Calendar cal = Calendar.getInstance();
		 this.actionDate=dateFormat.format(cal.getTime());
		 this.remark=remark;
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
		
		// Implement save to db
	   public boolean SaveLog() {
			return true;
	  }
}
