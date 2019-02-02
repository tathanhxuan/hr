package com.hr.domain.reportFacade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATReport implements HRReport {
	private String date;
	private String empId;
	private String empName;
	private String timeIn;
	private String timeOut;
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
    //getters
	public String getDate() {
		return date;
	}
	public String getEmpId() {
		return empId;
	}


	public String getEmpName() {
		return empName;
	}


	public String getTimeIn() {
		return timeIn;
	}


	public String getTimeOut() {
		return timeOut;
	}

   public ATReport(String date, String empId, String empName, String timeIn, String timeOut) {
		super();
		this.date = date;
		this.empId = empId;
		this.empName = empName;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	
	@Override
	public String toString() {
		
		System.out.println("Attendance Report till "+ formatter.format(today) +"\n");
		System.out.println("Date\tEmployee ID\tEmployee Name\tTime In\tTime Out\n");
		return getDate()+"\t"+getEmpId()+"\t"+getEmpName()+"\t"+getTimeIn()+"\t"+getTimeOut()+"\n";
	}

//interface methods	
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
		System.out.println("Attendance Report: \n" + data.readATForm());
	}

}