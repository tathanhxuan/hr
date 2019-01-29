package com.hr.domain.report;

import com.hr.domain.Department;

public interface HRReport {
 
	public void reportByDate(String startDate, String endDate);
	public void reportByDepartment(Department department);

}
