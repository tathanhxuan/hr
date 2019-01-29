package com.hr.domain;

public enum ReportType {
	WEEKLY_REPORT(1), MONTHLY_REPORT(2), ANNUAL_REPORT(3);
	private int value;  
	
	private ReportType(int value){  
	this.value=value;  
	}  
}
