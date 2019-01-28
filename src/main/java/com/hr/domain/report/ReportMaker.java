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
	
	public void makeOTReport() {
		oTReport.makeReport();
	}
	
	public void makeATReport() {
		aTReport.makeReport();
	}
	
	public void makeLeaveReport() {
		leaveReport.makeReport();
	}
}
