package com.hr.domain.reportFacade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.domain.ATForm;
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

	//Data Formatter
	public String AtToString() {
		
        Date d = getDate();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
		return (sd.format(d)+"\t"+getEmpId()+"\t\t\t"+getEmpName()+"\t\t\t"+getTimeIn()+"\t\t"+getTimeOut()+"\n");
	}
	
	
//interface methods	
	
	
	//search by department
//	public boolean found() {
//	if(!myNewList.isEmpty())
//	return true;
//		return false;
//	}
	
	
	@Override
	public String toString() {
		return "ATReport [date=" + date + ", empId=" + empId + ", empName=" + empName + ", timeIn=" + timeIn
				+ ", timeOut=" + timeOut + "]";
	}
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
		List<ATForm> myNewList = new ArrayList<ATForm>();	
		
		List<ATForm> allATForm = data.getListATForm();
	//	List<Employee> allEmployee = data.getListEmployee();
		
		for(ATForm allaT: allATForm) {
		  //  String empId = allaT.getOwner().getEmpID(); 
			//for(Employee allEmployees: allEmployee) {
		//			   if(allEmployees.getEmpID().contains(empId)){
						 myNewList.add(allaT);
						// break;
			//	  }
			//	}
			}

	if(!myNewList.isEmpty()) {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
	
		StringBuilder sb = new StringBuilder();
		System.out.println("\n**************ALL ATTENDANCE REPORT*********************");
		System.out.println("FORM CODE\t\t\tATTENDANCE DATE\t\tTIME IN\t\tTIME OUT\tSTATUS\n-----------------------------------------------------------------------------------------------");
		for(ATForm e: myNewList) {
			System.out.println(sb.append(e.getFormCode()+"\t"+ sd.format(e.getATDate())+"\t\t"+ e.getTimeIn()+"\t\t"+ e.getTimeOut()+"\t\t"+ e.getStatus()+"\n").toString().replace("[", " ").replace("]", " "));
		}
	   }

	}
}