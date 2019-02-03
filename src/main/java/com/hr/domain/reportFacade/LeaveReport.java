package com.hr.domain.reportFacade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class LeaveReport implements HRReport {

	private String empId;
	private String empName;
	private String approveStatus;
	private Date leaveDateFrom;
	private Date leaveDateTo;
	private String description;
	private Date thisDate;
	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();

	public LeaveReport() {
	}

	public LeaveReport(Date thisDate, String empId, String empName, Date leaveDateFrom, Date leaveDateTo, String approveStatus,
			String description) {
		this.thisDate =thisDate;
		this.empId = empId;
		this.empName = empName;
		this.approveStatus = approveStatus;
		this.leaveDateFrom = leaveDateFrom;
		this.leaveDateTo = leaveDateTo;
		this.description = description;
	}

	//Leave report formatter
	public String leaveToString(){
		Date d = thisDate;
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
		
		return sd.format(thisDate)+"\t" + getEmpId() + "\t\t" + getEmpName() + "\t\t\t" + sd.format(getLeaveDateFrom()) + "\t" + sd.format(getLeaveDateTo()) + "\t"
				+ getApproveStatus() + "\t\t" + getDescription().toUpperCase() + "\n";
	}
	
	
	
	@Override
	public String toString() {
		return "LeaveReport [empId=" + empId + ", empName=" + empName + ", approveStatus=" + approveStatus
				+ ", leaveDateFrom=" + leaveDateFrom + ", leaveDateTo=" + leaveDateTo + ", description=" + description
				+ "]";
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public Date getLeaveDateFrom() {
		return leaveDateFrom;
	}

	public Date getLeaveDateTo() {
		return leaveDateTo;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public void reportByDepartment(String department) {
		List<Employee> allEmployee = data.getListEmployee();
		List<LeaveForm> allLeave = data.getListLeaveForm();
				
		List<Employee> myNewList = new ArrayList<Employee>();
			
			for(LeaveForm lvForms: allLeave) {
				String thisDepartment = lvForms.getOwner().getDepartment().getDeptName();
				
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
		System.out.println("\n****************LEAVE REPORT FOR "+department.toUpperCase()+" ****************");
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
		List<LeaveForm> allLeaveForm = data.getListLeaveForm();
		List<Employee> allEmployee = data.getListEmployee();
					
			for(LeaveForm allLv: allLeaveForm) {
				String thisId = allLv.getOwner().getEmpID();
				
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
		System.out.println("\n**************LEAVE REPORT FOR EMPLOYEE ID "+ empId.toUpperCase()+ "*********************");
		System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	   }
	
	
	}

	@Override
	public void getReport() {
		List<Employee> myNewList = new ArrayList<Employee>();	
		List<LeaveForm> allLvForm = data.getListLeaveForm();
		List<Employee> allEmployee = data.getListEmployee();
					
			for(LeaveForm allLv: allLvForm) {
				String thisId = allLv.getOwner().getEmpID();
				  
				 for(Employee allEmployees: allEmployee) {
					   
					   if(allEmployees.getEmpID().contains(thisId)){
						 myNewList.add(allEmployees);
				  }
				}
			}

	if(!myNewList.isEmpty()) {
		StringBuilder sb = new StringBuilder();
		System.out.println("\n**************ALL LEAVE REPORT*********************");
		System.out.println("Employee ID\tEmployee Name\tDepartment\n----------------------------------------------");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	   }

	}
	
}