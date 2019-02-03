package com.hr.domain.reportFacade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATReport implements HRReport {
	private Date date;
	private String empId;
	private String empName;
	private String timeIn;
	private String timeOut;
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
    List<Employee> myNewList = new ArrayList<Employee>();
    
    
    //getters
	public Date getDate() {
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

   
	public ATReport() {
		
	}
	
	
	public ATReport(Date date, String empId, String empName, String timeIn, String timeOut) {
		
		this.date = date;
		this.empId = empId;
		this.empName = empName;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	
	@Override
	public String toString() {
		

		return getDate()+"\t"+getEmpId()+"\t"+getEmpName()+"\t"+getTimeIn()+"\t"+getTimeOut()+"\n";
	}

//interface methods	
	
	
	//search by department
	public boolean found() {
	if(!myNewList.isEmpty())
	return true;
		return false;
	}
	
	
	
	
	@Override
	public void reportByDepartment(String department) {
		List<Department> departmentList = data.getListDepartment();
		List<Employee> allEmployee = data.getListEmployee();
				
		for(Department departments: departmentList) {
			String thisDepartment = departments.getDeptName();
			
			if(thisDepartment.contains(department) && department !=null && department!="") {
			    
			    for(Employee allEmployees: allEmployee) {
				  if(allEmployees.getDept().getDeptName().equals(thisDepartment)){
					 myNewList.add(allEmployees);
					  // System.out.println(allEmployees);
				  }
			  }
			}
		}

if(!myNewList.isEmpty()) {
	StringBuilder sb = new StringBuilder();
	System.out.println("Attendance Report");
	for(Employee e: myNewList) {
		System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
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