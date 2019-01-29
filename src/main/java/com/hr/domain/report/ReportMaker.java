package com.hr.domain.report;
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
	
	public void oTReportByDate(String startDate, String endDate) {
		oTReport.reportByDate(startDate, endDate);
		//
	}
	
	public void aTReportByDate(String startDate, String endDate) {
		aTReport.reportByDate(startDate, endDate);
	}
	
	public void leaveReportByDate(String startDate, String endDate) {
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
