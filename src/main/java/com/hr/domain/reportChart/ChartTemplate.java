package com.hr.domain.reportChart;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public abstract class ChartTemplate{
	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
	private int aTReportValue = data.readATForm().values().size();
	private int oTReportValue = data.readOTForm().values().size();
	private int leaveReportValue =data.readLeaveForm().values().size();
	
	public abstract int getTotalRecord();
	
	
	
	public final void getReportChart() {
		final int total = aTReportValue + oTReportValue + leaveReportValue;
		System.out.println("Report Statistics");
	    
		System.out.println("Attendance Report: "+ (((aTReportValue/total)*100.00)) + "%");
	    
		System.out.println("Overtime Report: "+ (((oTReportValue/total)*100.00)+"%"));
		
		System.out.println("Leave Report: "+ (((leaveReportValue/total)*100.00)) + "%");
		}
		
}