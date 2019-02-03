package com.hr.domain.reportFacade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.domain.LeaveForm;
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

	public LeaveReport(Date thisDate, String empId, String empName, Date leaveDateFrom, Date leaveDateTo,
			String approveStatus, String description) {
		this.thisDate = thisDate;
		this.empId = empId;
		this.empName = empName;
		this.approveStatus = approveStatus;
		this.leaveDateFrom = leaveDateFrom;
		this.leaveDateTo = leaveDateTo;
		this.description = description;
	}

	// Leave report formatter
	public String leaveToString() {
		Date d = thisDate;
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");

		return sd.format(thisDate) + "\t" + getEmpId() + "\t\t" + getEmpName() + "\t\t\t"
				+ sd.format(getLeaveDateFrom()) + "\t" + sd.format(getLeaveDateTo()) + "\t" + getApproveStatus()
				+ "\t\t" + getDescription().toUpperCase() + "\n";
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
		List<LeaveForm> myNewList = new ArrayList<LeaveForm>();
		List<LeaveForm> allATForm = data.getListLeaveForm();

		for (LeaveForm departments : allATForm) {
			String thisDepartment = departments.getOwner().getDepartment().getDeptName();

			if (thisDepartment.contains(department) && department != null && department != "") {
				myNewList.add(departments);
			}
		}

		if (!myNewList.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			System.out.println("\n**************LEAVE REPORT BY DEPARTMENT*********************");
			System.out.println(
					"FORM CODE\t\t\tSTART DATE\tEND DATE\tLEAVE STATUS\n-----------------------------------------------------------------------------\n");
			for (LeaveForm e : myNewList) {

				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getLeaveDateFrom()) + "\t"
								+ sd.format(e.getLeaveDateTo()) + "\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");

			}
		} else {
			System.out.println(department + " not found in Leave Report");
		}
	}

	// search by id
	@Override
	public void serchReportById(String empId) {
		List<LeaveForm> myNewList = new ArrayList<LeaveForm>();
		List<LeaveForm> allATForm = data.getListLeaveForm();

		for (LeaveForm allAt : allATForm) {
			String thisId = allAt.getOwner().getEmpID();

			if (thisId.contains(empId) && empId != null && empId != "") {
				myNewList.add(allAt);

			}
		}
		if (!myNewList.isEmpty()) {
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			StringBuilder sb = new StringBuilder();
			System.out.println("\n**************LEAVE REPORT FOR EMPLOYEE ID " + empId + " *********************");
			System.out.println(
					"FORM CODE\t\t\tSTART DATE\tEND DATE\tLEAVE STATUS\n-----------------------------------------------------------------------------\n");

			for (LeaveForm e : myNewList) {
				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getLeaveDateFrom()) + "\t"
								+ sd.format(e.getLeaveDateTo()) + "\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");

			}
		} else {
			System.out.println("Employee Id: " + empId + " has no Leave Report");
		}
	}

	@Override
	public void getReport() {
		List<LeaveForm> myNewList = new ArrayList<LeaveForm>();
		List<LeaveForm> allLvForm = data.getListLeaveForm();
		// List<Employee> allEmployee = data.getListEmployee();
		for (LeaveForm allLv : allLvForm) {
			myNewList.add(allLv);
		}

		if (!myNewList.isEmpty()) {
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			StringBuilder sb = new StringBuilder();
			System.out.println("\n**************ALL LEAVE REPORT*********************");
			System.out.println(
					"FORM CODE\t\t\tSTART DATE\tEND DATE\tLEAVE STATUS\n-----------------------------------------------------------------------------\n");
			for (LeaveForm e : myNewList) {
				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getLeaveDateFrom()) + "\t"
								+ sd.format(e.getLeaveDateTo()) + "\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");
			}
		} else {
			System.out.println("No Leave reord found");
		}

	}

}