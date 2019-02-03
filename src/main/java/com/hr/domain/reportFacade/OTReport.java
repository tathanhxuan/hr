package com.hr.domain.reportFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.domain.OTForm;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReport implements HRReport{

	private String empName;
	
	public OTReport() {
		
	}
	
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
	List<Employee> allEmployee = data.getListEmployee();
	List<OTForm> allOT = data.getListOTForm();
	
	
	List<Employee> myNewList = new ArrayList<Employee>();
		
		for(OTForm otForms: allOT) {
			String thisDepartment = otForms.getOwner().getDepartment().getDeptName();
			
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
	for(Employee e: myNewList) {
		System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
	}
}else {
		System.out.println(department +" department does not exist");
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