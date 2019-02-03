package com.hr.domain.reportFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.domain.LeaveForm;
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
	System.out.println("\n*****************OVERTIME REPORT IN "+ department.toUpperCase()+ " DEPARTMENT"+"*******************");
	System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
	for(Employee e: myNewList) {
		System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
	}
}else {
		System.out.println(department +" department does not exist");
	}
	}

	@Override
	public void serchReportById(String empId) {
		List<Employee> myNewList = new ArrayList<Employee>();	
		List<OTForm> allOTForm = data.getListOTForm();
		List<Employee> allEmployee = data.getListEmployee();
					
			for(OTForm allOT: allOTForm) {
				String thisId = allOT.getOwner().getEmpID();
				
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
		System.out.println("\n**************OVERTIME REPORT BY ID " + empId +"*********************");
		System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	   }
	}

	@Override
	public void getReport() {
		List<Employee> myNewList = new ArrayList<Employee>();	
		List<OTForm> oTForm = data.getListOTForm();
		List<Employee> allEmployee = data.getListEmployee();
					
			for(OTForm allot: oTForm) {
				String thisId = allot.getOwner().getEmpID();
				  
				 for(Employee allEmployees: allEmployee) {
					   
					   if(allEmployees.getEmpID().contains(thisId)){
						 myNewList.add(allEmployees);
				  }
				}
			}

	if(!myNewList.isEmpty()) {
		StringBuilder sb = new StringBuilder();
		System.out.println("\n**************ALL OVERTIME REPORT*********************");
		System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	   }

	}

}