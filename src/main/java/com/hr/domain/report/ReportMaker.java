package com.hr.domain.report;

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
	
	public void oTReportByDate(Date startDate, Date endDate) {
		oTReport.reportByDate(startDate, endDate);
		//
	}
	
	public void aTReportByDate(Date startDate, Date endDate) {
		aTReport.reportByDate(startDate, endDate);
	}
	
	public void leaveReportByDate(Date startDate, Date endDate) {
		leaveReport.reportByDate(startDate, endDate);
	}
	
	//Generate report by department
	
	public void oTReportByDepartment(Department department) {
		oTReport.reportByDepartment(department);
	}
	
	public void aTReportByDepartment(Department department) {
		aTReport.reportByDepartment(department);
	}
	
	public void leaveReportByDepartment(Department department) {
		leaveReport.reportByDepartment(department);
	}
}
