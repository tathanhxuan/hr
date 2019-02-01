package com.hr.domain.reportFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class LeaveReport implements HRReport{
	
	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();

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

	@Override
	public void serchReportById(String empId) {
		HashMap<String, Employee> ATr = new HashMap<String, Employee>();
		ATr.putAll(data.readEmployeeMap());
		if (ATr.containsKey(empId)) {
			System.out.println(ATr.get(empId));
		} else {
			System.out.println("Employee ID " + empId + " Not Found");
		}
	}

	@Override
	public void getReport() {
		System.out.println("Leave Report: \n" + data.readLeaveForm());
	}
}