package com.hr.domain.reportFacade;

import java.util.Date;

import com.hr.domain.Department;

/** 
  facade pattern
 **/
public class ReportMaker {
private HRReport oTReport;
private HRReport leaveReport;
private HRReport aTReport;
	

public ReportMaker() {
		oTReport = new OTReport();
		leaveReport = new LeaveReport();
		aTReport = new ATReport();
	}
	
	
	//by department
	public void oTReportByDepartment(String department) {
		oTReport.reportByDepartment(department);
	}
	
	public void aTReportByDepartment(String department) {
		aTReport.reportByDepartment(department);
	}
	
	public void leaveReportByDepartment(String department) {
		leaveReport.reportByDepartment(department);
	}
	
	//by employeeid
	
	
	public void searchByEmpId(String empId) {
		aTReport.serchReportById(empId);
	}
	
	//get report
	
	public void getAttendanceReport() {
		aTReport.getReport();
	}
	
	public void getOvertimeReport() {
		oTReport.getReport();
	}
	
	public void getLeaveReport() {
		leaveReport.getReport();
	}
}
