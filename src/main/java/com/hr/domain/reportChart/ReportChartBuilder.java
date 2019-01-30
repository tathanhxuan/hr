package com.hr.domain.reportChart;

import com.hr.domain.report.ATReport;
import com.hr.domain.report.GeneralReport;
import com.hr.domain.report.LeaveReport;
import com.hr.domain.report.OTReport;

/* using builder with tempplate pattern
 * 
 */
public class ReportChartBuilder extends ReportChart{
private ATReport aTReport;
private OTReport oTReport;
private LeaveReport leaveReport;

//Building report with General report builder
GeneralReport gn = new GeneralReport.Builder()
.aTReport(aTReport)
.oTReport(oTReport)
.leaveReport(leaveReport)
.build();


public ReportChartBuilder() {
	
	
}

	
	
	@Override
	public void getChart() {
		
		
	}
}