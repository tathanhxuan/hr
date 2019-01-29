package com.hr.domain.report;

import java.util.Date;

import com.hr.domain.Department;

public interface HRReport {
 
	public void reportByDate(Date startDate, Date endDate);
	public void reportByDepartment(Department department);

}
