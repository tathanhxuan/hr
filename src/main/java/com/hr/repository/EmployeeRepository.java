package com.hr.repository;

import java.util.List;

import com.hr.domain.Employee;

public interface EmployeeRepository {
	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Employee employee);
}
