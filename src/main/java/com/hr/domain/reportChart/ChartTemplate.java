package com.hr.domain.reportChart;

public abstract class ChartTemplate{
	
	public abstract void getATStatistics();
	public abstract void getOTStatistics();
	public abstract void getLeaveStatistics();
	
	public final void getReportChart() {
		System.out.println("Report Statistics");
		getATStatistics();
		getOTStatistics();
		getLeaveStatistics();
	}
}