package com.hr.domain.reportFacade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Department;
import com.hr.domain.Employee;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReport implements HRReport {

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

//OT formatter
	public String OtToString() {

		Date d = getDate();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");

		return sd.format(d) + "\t" + getEmpID() + "\t\t" + getEmpName() + "\t\t\t\t" + getStart_time() + "\t\t"
				+ getEnd_time() + "\n";
	}

	@Override
	public String toString() {
		return "OTReport [empName=" + empName + ", end_time=" + end_time + ", start_time=" + start_time + ", date="
				+ date + ", empID=" + empID + "]";
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
		List<OTForm> myNewList = new ArrayList<OTForm>();
		List<OTForm> allATForm = data.getListOTForm();
		// List<Employee> allEmployee = data.getListEmployee();

		for (OTForm departments : allATForm) {
			String thisDepartment = departments.getOwner().getDepartment().getDeptName();

			if (thisDepartment.contains(department) && department != null && department != "") {
				myNewList.add(departments);
			}
		}

		if (!myNewList.isEmpty()) {
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			StringBuilder sb = new StringBuilder();
			System.out.println("\n**********************OVERTIME REPORT FOR DEPARTMENT " + department.toUpperCase()
					+ " ****************************");

			System.out.println(
					"FORM CODE\t\t\tOVERTIME DATE\t\tSTART TIME\tEND TIME\tOVERTIME STATUS\n----------------------------------------------------------------------------------------------------------------\n");
			for (OTForm e : myNewList) {
				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getOTDate()) + "\t\t" + e.getDateFrom() + "\t\t"
								+ e.getTimeTo() + "\t\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");
			}
		} else {
			System.out.println(department + " has no overtime record");
		}

	}

	// search by id
	@Override
	public void serchReportById(String empId) {
		List<OTForm> myNewList = new ArrayList<OTForm>();
		List<OTForm> allATForm = data.getListOTForm();

		for (OTForm allAt : allATForm) {
			String thisId = allAt.getOwner().getEmpID();
			if (thisId.contains(empId) && empId != null && empId != "") {
				myNewList.add(allAt);

			}
		}
		if (!myNewList.isEmpty()) {

			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			StringBuilder sb = new StringBuilder();
			System.out.println("\n**********************OVERTIME REPORT FOR EMPLOYEE ID " + empId
					+ " ****************************");
			System.out.println(
					"FORM CODE\t\t\tOVERTIME DATE\t\tSTART TIME\tEND TIME\tOVERTIME STATUS\n----------------------------------------------------------------------------------------------------------------\n");
			for (OTForm e : myNewList) {
				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getOTDate()) + "\t\t" + e.getDateFrom() + "\t\t"
								+ e.getTimeTo() + "\t\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");
			}
		} else {
			System.out.println("no overtime record found");
		}
	}

	@Override
	public void getReport() {
		List<OTForm> myNewList = new ArrayList<OTForm>();
		List<OTForm> oTForm = data.getListOTForm();
		// List<Employee> allEmployee = data.getListEmployee();

		for (OTForm allot : oTForm) {
			myNewList.add(allot);
		}

		if (!myNewList.isEmpty()) {
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
			StringBuilder sb = new StringBuilder();
			System.out.println("\n**********************ALL OVERTIME REPORT****************************");
			System.out.println(
					"FORM CODE\t\t\tOVERTIME DATE\t\tSTART TIME\tEND TIME\tOVERTIME STATUS\n----------------------------------------------------------------------------------------------------------------\n");
			for (OTForm e : myNewList) {
				System.out.println(sb
						.append(e.getFormCode() + "\t" + sd.format(e.getOTDate()) + "\t\t" + e.getDateFrom() + "\t\t"
								+ e.getTimeTo() + "\t\t" + e.getStatus())
						.toString().replace("[", " ").replace("]", " "));
				sb.append("\n");
			}
		} else {
			System.out.println("no overtime record found");
		}

	}

}