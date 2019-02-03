package com.hr.domain.reportFacade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.domain.LeaveForm;
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
//	public boolean found() {
//	if(!myNewList.isEmpty())
//	return true;
//		return false;
//	}
	
	
	@Override
	public void reportByDepartment(String department) {
		List<Employee> myNewList = new ArrayList<Employee>();
		List<ATForm> allATForm = data.getListATForm();
		List<Employee> allEmployee = data.getListEmployee();
				
		for(ATForm departments: allATForm) {
			String thisDepartment = departments.getOwner().getDepartment().getDeptName();
			
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
	System.out.println("\n**************ATTENDANCE REPORT*********************");
	System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
	for(Employee e: myNewList) {
		System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
	}
   }
}
		
//search by id
	@Override
	public void serchReportById(String empId) {
	List<Employee> myNewList = new ArrayList<Employee>();
	List<ATForm> allATForm = data.getListATForm();
	List<Employee> allEmployee = data.getListEmployee();
				
		for(ATForm allAt: allATForm) {
			String thisId = allAt.getOwner().getEmpID();
			
			if(thisId.contains(empId) && empId !=null && empId!="") {
			    
			    for(Employee allEmployees: allEmployee) {
				  if(allEmployees.getEmpID().equals(thisId)){
					 myNewList.add(allEmployees);
					  // System.out.println(allEmployees);
				  }
			  }
			}
		}

if(!myNewList.isEmpty()) {
	StringBuilder sb = new StringBuilder();
	System.out.println("\n**************ATTENDANCE REPORT*********************");
	System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
	for(Employee e: myNewList) {
		System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
	}
   }	
}

	@Override
	public void getReport() {
		List<Employee> myNewList = new ArrayList<Employee>();	
		List<ATForm> allATForm = data.getListATForm();
		List<Employee> allEmployee = data.getListEmployee();
					
			for(ATForm allaT: allATForm) {
				String thisId = allaT.getOwner().getEmpID();
				  
				 for(Employee allEmployees: allEmployee) {
					   
					   if(allEmployees.getEmpID().contains(thisId)){
						 myNewList.add(allEmployees);
				  }
				}
			}

	if(!myNewList.isEmpty()) {
		StringBuilder sb = new StringBuilder();
		System.out.println("\n**************ALL ATTENDANCE REPORT*********************");
		System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	   }

	}
}