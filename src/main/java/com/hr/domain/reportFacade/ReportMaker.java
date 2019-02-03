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
	public void searchByDepartment(String department) {
		
		oTReport.reportByDepartment(department);
		aTReport.reportByDepartment(department);
		//leaveReport.reportByDepartment(department);
	   		
	}
	
	//by employeeid
	
	public void searchByEmpId(String empId) {
		
		aTReport.serchReportById(empId);
		
		oTReport.serchReportById(empId);
		
		leaveReport.serchReportById(empId);
	}
	
	//get each report
	
	public void getAttendanceReport() {
		aTReport.getReport();
	}
	
	public void getOvertimeReport() {
		oTReport.getReport();
	}
	
	public void getLeaveReport() {
		leaveReport.getReport();
	}
	//get all report
	public void getAllReport() {
		aTReport.getReport();
		oTReport.getReport();
		leaveReport.getReport();
	}
}
