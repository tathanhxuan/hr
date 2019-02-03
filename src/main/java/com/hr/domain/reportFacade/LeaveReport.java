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

public class LeaveReport implements HRReport {

	private String empId;
	private String empName;
	private String approveStatus;
	private Date leaveDateFrom;
	private Date leaveDateTo;
	private String description;
	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();

	public LeaveReport() {
	}

	public LeaveReport(String empId, String empName, Date leaveDateFrom, Date leaveDateTo, String approveStatus,
			String description) {
		this.empId = empId;
		this.empName = empName;
		this.approveStatus = approveStatus;
		this.leaveDateFrom = leaveDateFrom;
		this.leaveDateTo = leaveDateTo;
		this.description = description;
	}

	@Override
	public String toString() {
		return getEmpId() + "\t" + getEmpName() + "\t" + getLeaveDateFrom() + "\t" + getLeaveDateTo() + "\t"
				+ getApproveStatus() + "\t" + getDescription() + "\n";
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
		System.out.println("\n****************LEAVE REPORT****************");
		for(Employee e: myNewList) {
			System.out.println(sb.append(e).toString().replace("[", " ").replace("]", " "));
		}
	}else {
			System.out.println(department +" department does not exist");
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
		System.out.println("Leave Report: \n" + data.readLeaveForm());
	}
}