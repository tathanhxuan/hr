package com.hr.domain.reportChart;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ReportCollection extends DataAccessRepositoryFacade {

	private Object atReport;
	private Object otReport;
	private Object leaveReport;
	private Object allReport[] = new Object[] {
			atReport,
			otReport,
			leaveReport };
	
	public ReportCollection() {}

	public Object getATReport() {
		//
		allReport[0] = null;
		return null;
	}

	public Object getOTReport() {
		//
		allReport[1] = null;
		return null;
	}

	public Object getLeaveReport() {
		//
		allReport[2] = null;
		return null;
	}
}
