package com.hr;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import com.hr.domain.*;
import com.hr.domain.ApprovalCore.ApprovalProxy;
import com.hr.domain.HRFormCore.FormFactory;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.formValidation.LeaveFormValidation;
import com.hr.domain.report.builder.GeneralReport;
import com.hr.domain.report.builder.GeneralReport.Builder;
import com.hr.domain.reportChart.ChartTemplate;
import com.hr.domain.reportChart.ReportChart;
import com.hr.domain.reportFacade.ReportMaker;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.storage.DataAccessRepositoryFacade;

/**
 * Hello world!
 *
 */
public class App {

	public static Employee loginUser;
	public static String userRole;

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {

		//Login();
		//LoadMenuByUserRole();
		GetWaitedApproveForms();
		
	}

	public static Employee Login() {
		Employee emp = null;

		System.out.println("-----------SYSTEM LOGIN-------------:");
		System.out.println("Username : ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Passwords : ");
		String pass = scanner.nextLine();

		// verify user

		// Employee emp = Login();
		loginUser = new Employee("101", new Department("D01", ""));
		userRole = "APPROVER";

		return emp;
	}

	public static void LoadStaffMenu() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("******WELCOME TO HR WORKTIME MANAGEMENT SYSTEM********");
		System.out.println("1.OT FORM");
		System.out.println("2.AT FORM");
		System.out.println("3.LEAVE FORM");
		System.out.println("4.FORM REFUSE");
		System.out.println("5.FORM SEARCH");
		System.out.println("6.EXIT");
		System.out.println("*******************************************************");
		System.out.println("*.SELECT : ");

		String keyID = scanner.nextLine();
		StaffMenuAction(keyID);

	}

	public static void LoadApproverMenu() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("******WELCOME TO HR WORKTIME MANAGEMENT SYSTEM********");
		System.out.println("1.OT FORM");
		System.out.println("2.AT FORM");
		System.out.println("3.LEAVE FORM");
		System.out.println("4.FORM REFUSE");
		System.out.println("5.FORM SEARCH");
		System.out.println("6.FORM APPROVAL");
		System.out.println("7.REPORT");
		System.out.println("8.EXIT");
		System.out.println("*******************************************************");
		System.out.println("*.SELECT : ");

		String keyID = scanner.nextLine();
		try {
			ApproverMenuAction(keyID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LoadReportMenu() throws ParseException {

		Scanner command = new Scanner(System.in);
		System.out.println("******REPORT********");
		System.out.println("1.OT REPORT");
		System.out.println("2.AT REPORT");
		System.out.println("3.LEAVE REPORT");
		System.out.println("4.CHART");
		System.out.println("5.ALL REPORT");
		System.out.println("6. SEARCH");
		System.out.println("7.EXIT");
		System.out.println("*******************************************************");
		System.out.println("*.SELECT : ");

		while (true) {
			String input = command.nextLine();
			ReportMaker rm = new ReportMaker();
			ChartTemplate ch = new ReportChart();
			GeneralReport.Builder allReport = new GeneralReport.Builder();
			if (input.equals("1")) {
				rm.getOvertimeReport();
			} else if (input.equals("2")) {
				rm.getAttendanceReport();

			} else if (input.equals("3")) {
				rm.getLeaveReport();
			} else if (input.equals("4")) {
				ch.getReportChart();
			} else if (input.equals("5")) {
				allReport.aTReport().leaveReport().oTReport().build();
			} else if (input.equals("6")) {
				searchMenu();
				break;
			}

			else if (input.equals("7")) {
				LoadMenuByUserRole();
				break;
			} else {
				System.out.println("Invalid Enttry, Try again");
			}
		}

	}

	// CREATE LEAVE FORM
	public static void CreateLeaveForm() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******LEAVE REGISTRAR********");
		System.out.println("Leave From Date (mm/dd/yyyy):");
		String datefrom = scanner.nextLine();
		System.out.println("Leave From To (mm/dd/yyyy):");
		String dateto = scanner.nextLine();
		System.out.println("Reason:");
		String reason = scanner.nextLine();

		System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
		String command = scanner.nextLine();

		if (command.equals("S") || command.equals("s")) {

			FormValidationStrategy vf = new LeaveFormValidation();
			LeaveForm f = (LeaveForm) FormFactory.creatForm(FormType.LEAVE, loginUser);
			f.setValidationStrategy(vf);

			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			Date dafrom = format.parse(datefrom);
			Date dato = format.parse(dateto);

			f.setLeaveDateFrom(dafrom);
			f.setLeaveDateTo(dato);
			f.setDescription(reason);

			if (f.formSubmit()) {

				System.out.println("FORM SUBMIT SUCCESSFULL");
				LoadMenuByUserRole();
			}
		}

	}

	// CREATE OT FORM
	public static void CreateOTForm() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******OT REGISTRAR********");
		System.out.println("OT Date (mm/dd/yyyy):");
		String otdate = scanner.nextLine();
		System.out.println("Time from (hh:mm):");
		String timefrom = scanner.nextLine();
		System.out.println("Time to (hh:mm):");
		String timeto = scanner.nextLine();
		System.out.println("Reason:");
		String reason = scanner.nextLine();

		System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
		String command = scanner.nextLine();

		if (command.equals("S") || command.equals("s")) {

			FormValidationStrategy vf = new LeaveFormValidation();
			OTForm f = (OTForm) FormFactory.creatForm(FormType.OVERTIME, loginUser);
			f.setValidationStrategy(vf);

			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			Date otDate = format.parse(otdate);

			f.setOTDate(otDate);
			;
			f.setTimeFrom(timefrom);
			f.setTimeTo(timeto);
			f.setDescription(reason);

			if (f.formSubmit()) {

				System.out.println("FORM SUBMIT SUCCESSFULL");
				LoadMenuByUserRole();
			}
		}

	}

	public static void CreateATForm() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******AT REGISTRAR********");
		System.out.println("Attendance Date (mm/dd/yyyy):");
		String atdate = scanner.nextLine();
		System.out.println("Time In (hh:mm):");
		String timefrom = scanner.nextLine();
		System.out.println("Time Out (hh:mm):");
		String timeto = scanner.nextLine();
		System.out.println("Reason:");
		String reason = scanner.nextLine();

		System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
		String command = scanner.nextLine();

		if (command.equals("S") || command.equals("s")) {

			FormValidationStrategy vf = new LeaveFormValidation();
			ATForm f = (ATForm) FormFactory.creatForm(FormType.ATTENDANT, loginUser);
			f.setValidationStrategy(vf);

			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			Date otDate = format.parse(atdate);

			f.setATDate(otDate);
			f.setTimeIn(timefrom);
			f.setTimeOut(timeto);
			f.setDescription(reason);

			if (f.formSubmit()) {

				System.out.println("FORM SUBMIT SUCCESSFULL");
				LoadMenuByUserRole();
			}
		}

	}

	public static void LoadMenuByUserRole() throws ParseException {
		switch (userRole) {
		case "STAFF":
			LoadStaffMenu();
			break;

		case "APPROVER":
			LoadApproverMenu();

		case "HR":

		default:
			break;
		}
	}

	public static void StaffMenuAction(String functionID) throws ParseException {

		switch (functionID) {
		case "1":
			CreateOTForm();
			break;

		case "2":
			CreateATForm();
			break;

		case "3":
			CreateLeaveForm();
			break;
		default:
			break;
		}
	}

	public static void ApproverMenuAction(String functionID) throws Exception {

		switch (functionID) {
		case "1":
			CreateOTForm();
			break;

		case "2":
			CreateATForm();
			break;

		case "3":
			CreateLeaveForm();
			break;

		case "4":

		case "5":

		case "6":
			GetWaitedApproveForms();
			break;
		default:
			break;
		}
	}


	

	
	public static void GetWaitedApproveForms() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************GET WAITED APPROVE FORMS***************");
		loginUser = new Employee("102", new Department("D002", "IT"));
		loginUser.setIsApprover(true);
		loginUser.setEmpName("Xuan");
		ApprovalProxy approvecenter = new ApprovalProxy(loginUser);
    	ArrayList<Form> listForms = approvecenter.getWaitedApproveForms();
    	for (Form listForm: listForms) {
    		System.out.println(listForm);
    	}
    	//System.out.println(listForms);
    	System.out.println("*******************************************************");
    	System.out.println("Press 'A = Approve All' | 'O = Approve Only One' | 'R = Refuse'':");
		String command = scanner.nextLine();

		if (command.equals("A") || command.equals("a")) {
			approvecenter.ApproveAll(listForms);
		} else if (command.equals("O") || command.equals("o")) {
			System.out.println("Please input form code:");
			String formCode = scanner.nextLine();
			approvecenter.Approve(formCode);
		} else if (command.equals("R") || command.equals("r")) {
			System.out.println("Please input form code:");
			String formCode = scanner.nextLine();
			approvecenter.Refuse(formCode);
		}
		else {
			System.out.println("Exit System");
		}
	}
	
	//Search Menu
	public static void searchMenu() throws ParseException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.SEARCH BY EMPLOYEE ID");
		System.out.println("2.SEARCH BY DEPARTMENT");
		System.out.println("3.SEARCH BY NAME");
		System.out.println("4.BACK TO REPORT MENU");
		String entry = scanner.nextLine();
		ReportMaker rm = new ReportMaker();
		while (true) {
			if (entry.equals("1")) {
				System.out.println("Enter Employee ID");
				String empSearchId = scanner.nextLine();
               rm.searchByEmpId(empSearchId);
			} else if (entry.equals("2")) {
				System.out.println("Enter Employee Department");
				String empSearchDepart = scanner.nextLine();
               rm.leaveReportByDepartment(empSearchDepart);
               rm.aTReportByDepartment(empSearchDepart);
               rm.oTReportByDepartment(empSearchDepart);
			} 
			
			else if (entry.equals("3")) {
				//search by name
			}
			else if (entry.equals("4")) {
				LoadReportMenu();
				break;
			}
			else {
				System.out.println("Invalid Entry, Try again !");
			}
		}
	}

}
