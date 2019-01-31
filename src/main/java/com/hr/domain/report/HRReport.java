package com.hr.domain.report;

import java.util.Date;

public interface HRReport {
 
	public void reportByDate(Date startDate, Date endDate);
	public void reportByDepartment(String department);
	
	
}
