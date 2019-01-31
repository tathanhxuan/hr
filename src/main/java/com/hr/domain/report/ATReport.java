package com.hr.domain.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hr.domain.Department;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATReport implements HRReport {
	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();

	@Override
	public void reportByDate(Date startDate, Date endDate) {
		if (startDate.before(endDate)) {
			return;
		}
		data.readATForm();
	}

	@Override
	public void reportByDepartment(String department) {
		List<Department> departmentList = new ArrayList<Department>();
		departmentList.addAll(data.getListDepartment());
		
		for (Department dept : departmentList) {
			if (department.equals(dept.getDeptName())) {
				System.out.println(departmentList);
			} 
		}
		
	}
}

