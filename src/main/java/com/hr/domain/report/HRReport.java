package com.hr.domain.report;

public interface HRReport {
 
	public void reportByDate(String startDate, String endDate);
	public void reportByDepartment(Department department);

}
