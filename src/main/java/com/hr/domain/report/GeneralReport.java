package com.hr.domain.report;

public class GeneralReport {
	private ATReport aTReport;
    private OTReport oTReport;
    private LeaveReport leaveReport;
	
	
    private GeneralReport(Builder builder) {
    	this.aTReport= builder.aTReport;
    	this.oTReport = builder.oTReport;
    	this.leaveReport = builder.leaveReport;
    }
	
	public static class Builder implements GeneralReportBuilder{
    private ATReport aTReport;
    private OTReport oTReport;
    private LeaveReport leaveReport;
    
    public Builder aTReport(ATReport aTReport) {
    	this.aTReport = aTReport;
    	return this;
    }
    
    public Builder oTReport(OTReport oTReport) {
    	this.oTReport = oTReport;
    	return this;
    }
    
    public Builder leaveReport(LeaveReport leaveReport) {
    	this.leaveReport = leaveReport;
    	return this;
    }
			
		@Override
		public GeneralReport build() {
		 return new GeneralReport(this);
		}
	}
}
