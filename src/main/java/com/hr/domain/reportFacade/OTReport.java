package com.hr.domain.reportFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReport implements HRReport{

	private String empName;
	public OTReport(String empID, String empName, String end_time, String start_time, Date date) {
	
		this.empName = empName;
		this.end_time = end_time;
		this.start_time = start_time;
		this.date = date;
		this.empID = empID;
	}


	private String end_time;
	private String start_time;
	private Date date;
	
	
	
	
	
	@Override
	public String toString() {
		return getDate()+"\t"+getEmpID()+"\t"+ getEmpName()+"\t"+ getStart_time()+"\t"+getEnd_time();
	}


	private String empID;
	public String getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEnd_time() {
		return end_time;
	}

	public String getStart_time() {
		return start_time;
	}

	public Date getDate() {
		return date;
	}

		
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
		HashMap<String, Employee> oTr = new HashMap<String, Employee>();
		oTr.putAll(data.readEmployeeMap());
		if (oTr.containsKey(empId)) {
			System.out.println(oTr.get(empId));
		} else {
			System.out.println("Employee ID " + empId + " Not Found");
		}
	}

	@Override
	public void getReport() {
		System.out.println("Overtime Report: \n" + data.readOTForm());
	}

}