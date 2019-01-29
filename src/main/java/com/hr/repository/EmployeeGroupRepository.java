package com.hr.repository;

import java.util.List;

import com.hr.domain.EmployeeGroup;

public interface EmployeeGroupRepository {
	public List<EmployeeGroup> getAllEmployeeGroups();

	public EmployeeGroup getEmployeeGroup(int id);

	public void updateEmployeeGroup(EmployeeGroup employeeGroup);

	public void deleteEmployeeGroup(EmployeeGroup employeeGroup);
}
