package com.hr.domain.reportChart;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ReportChart extends ChartTemplate {
	/*
	 * Template pattern
	 */

	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();

	double aTR = data.readATForm().size();
	double oTR = data.readOTForm().size();
	double lTR = data.readLeaveForm().size();

	@Override
	public void getATStatistics() {
		System.out.println("Attendance Statistics: " + Math.round(((aTR / (aTR + oTR + lTR)) * 100.00)) + "%");
	}

	@Override
	public void getOTStatistics() {

		System.out.println("Overtime Statistics: " + Math.round(((oTR / (aTR + oTR + lTR)) * 100.00)) + "%");
	}

	@Override
	public void getLeaveStatistics() {
		System.out.println("Leave Statistics: " + Math.round(((lTR / (aTR + oTR + lTR)) * 100.00)) + "%");

	}

}
