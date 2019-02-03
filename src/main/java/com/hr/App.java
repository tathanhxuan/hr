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
		Login();
	}

	public static void Login() throws Exception {
		Employee emp = null;

		System.out.println("-----------SYSTEM LOGIN-------------:");
		System.out.println("Username : ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Passwords : ");
		String pass = scanner.nextLine();

		// verify user
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		SystemUser user = da.getSystemUserByUserName(username);

		if (user == null || !user.getPassword().equals(pass)) {

			System.out.println("Invalid username or passwords ");
			Login();
		}

		String empID = user.getEmpID();

		loginUser = da.getEmployeeById(empID);
		

		userRole =loginUser.getIsApprover() ? "APPROVER" : "STAFF";
	
		LoadMenuByUserRole();
	}

	public static void LoadStaffMenu() throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("******WELCOME TO HR WORKTIME MANAGEMENT SYSTEM********");
		System.out.println("HELLO : " + loginUser.getEmpName() + "(ID: + "+loginUser.getEmpID()+")");
		System.out.println("----------------------");
		System.out.println("1.OT FORM");
		System.out.println("----------------------");
		System.out.println("2.AT FORM");
		System.out.println("----------------------");
		System.out.println("3.LEAVE FORM");
		System.out.println("----------------------");
		System.out.println("4.FORM REFUSE");
		System.out.println("----------------------");
		System.out.println("5.FORM HISTORY");
		System.out.println("----------------------");
		System.out.println("6.EXIT");
		System.out.println("----------------------");
		System.out.println("*.SELECT : ");

		String keyID = scanner.nextLine();
		StaffMenuAction(keyID);

	}

	public static void LoadApproverMenu() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("******WELCOME TO HR WORKTIME MANAGEMENT SYSTEM********");
		System.out.println("HELLO : " + loginUser.getEmpName() + "(ID: + "+loginUser.getEmpID()+")");
		System.out.println("----------------------");
		System.out.println("1.OT FORM");
		System.out.println("----------------------");
		System.out.println("2.AT FORM");
		System.out.println("----------------------");
		System.out.println("3.LEAVE FORM");
		System.out.println("----------------------");
		System.out.println("4.FORM REFUSE");
		System.out.println("----------------------");
		System.out.println("5.FORM HISTORY");
		System.out.println("----------------------");
		System.out.println("6.FORM APPROVAL");
		System.out.println("----------------------");
		System.out.println("7.REPORT");
		System.out.println("----------------------");
		System.out.println("8.EXIT");
		System.out.println("----------------------");
		System.out.println("*.SELECT : ");

		String keyID = scanner.nextLine();
		try {
			ApproverMenuAction(keyID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LoadReportMenu() throws Exception {

		Scanner command = new Scanner(System.in);
		System.out.println("******REPORT********");
		System.out.println("1.OT REPORT");
		System.out.println("----------------------");
		System.out.println("2.AT REPORT");
		System.out.println("----------------------");
		System.out.println("3.LEAVE REPORT");
		System.out.println("----------------------");
		System.out.println("4.CHART");
		System.out.println("----------------------");
		System.out.println("5.ALL REPORT");
		System.out.println("----------------------");
		System.out.println("6. SEARCH");
		System.out.println("----------------------");
		System.out.println("7.EXIT");
		System.out.println("----------------------");
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
	public static void CreateLeaveForm() throws Exception {

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
	public static void CreateOTForm() throws Exception {

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

	// CREATE AT FORM
	public static void CreateATForm() throws Exception {
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

	public static void LoadMenuByUserRole() throws Exception {
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

	public static void StaffMenuAction(String functionID) throws Exception {

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
			GetRefusedForms();
			break;
		case "5":
			ReportMaker rm = new ReportMaker();
			rm.searchByEmpId(loginUser.getEmpID());
			FormHistoryQuery();
			break;
			
		case "6":

			loginUser = null;
			Login();

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
			GetRefusedForms();
			break;
		case "5":
			ReportMaker rm = new ReportMaker();
			rm.searchByEmpId(loginUser.getEmpID());
			FormHistoryQuery();
			break;
		case "6":
			GetWaitedApproveForms();
			break;
		case "7":
			LoadReportMenu();
			break;
			
		case "8":
			loginUser = null;
			Login();
			break;
		default:
			break;
		}
	}

	public static void GetWaitedApproveForms() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************GET WAITED APPROVE FORMS***************");

		ApprovalProxy approvecenter = new ApprovalProxy(loginUser);
		ArrayList<Form> listForms = approvecenter.getWaitedApproveForms();
 
		if (listForms.isEmpty()) {
			System.out.println("****************WAITED APPROVE FORMS IS EMPTY**********");
			LoadMenuByUserRole();
		} else {
			for (Form listForm : listForms) {
				//System.out.println(listForm);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        //System.out.println(dt1.format(date));
				if (listForm instanceof OTForm) {
					OTForm oTForm = (OTForm) listForm;
					System.out.println(
							"Form Code: " + oTForm.getFormCode() + ",\t" + 
							"Emp Name: " +	oTForm.getOwner().getEmpName().toString() + ",\t" + 
							"OT Date: " + dateFormat.format(oTForm.getOTDate()) + ",\t" +
							"Time From: " + oTForm.getTimeFrom().toString() + ",\t" +
							"Time To: "	+ oTForm.getTimeTo().toString() + ",\t" +
							"Status: " + oTForm.getStatus().toString());
				} else if (listForm instanceof ATForm) {
					ATForm aTForm = (ATForm) listForm;
					System.out.println(
							"Form Code: " + aTForm.getFormCode() + ",\t" + 
							"Emp Name: " + aTForm.getOwner().getEmpName().toString() +  ",\t" +
							"AT Date: "	+ dateFormat.format(aTForm.getATDate()) + ",\t" + 
							"Time In: "	+aTForm.getTimeIn().toString() + ",\t" + 
							"Time Out: "	+ aTForm.getTimeOut().toString() + ",\t" + 
							"Status: "+ aTForm.getStatus().toString());
				} else if (listForm instanceof LeaveForm) {
					LeaveForm leaveForm = (LeaveForm) listForm;
					System.out.println(
							"Form Code: " + leaveForm.getFormCode() + ",\t" + 
							"Emp Name: " + leaveForm.getOwner().getEmpName().toString() + ",\t" + 
							"Leave Date From: " + dateFormat.format(leaveForm.getLeaveDateFrom()) + ",\t" + 
							"Leave Date To: "+ dateFormat.format(leaveForm.getLeaveDateTo()) + ",\t" + 
							"Status: " + leaveForm.getStatus().toString());
				}

				
			}
			// System.out.println(listForms);
			System.out.println("*******************************************************");
			System.out.println("Press 'A = Approve All'");
			System.out.println("Press 'O = Approve Only One'");
			System.out.println("Press 'R = Refuse'");
			System.out.println("Press other key to return Menu");
			String command = scanner.nextLine();

			if (command.equals("A") || command.equals("a")) {
				approvecenter.ApproveAll(listForms);
				GetWaitedApproveForms();
			} else if (command.equals("O") || command.equals("o")) {
				System.out.println("Please input form code:");
				String formCode = scanner.nextLine();
				approvecenter.Approve(formCode);
				GetWaitedApproveForms();
			} else if (command.equals("R") || command.equals("r")) {
				System.out.println("Please input form code:");
				String formCode = scanner.nextLine();
				System.out.println("Please input remark:");
				String remark = scanner.nextLine();
				approvecenter.Refuse(formCode, remark);
				GetWaitedApproveForms();
			} else {
				LoadMenuByUserRole();
			}
		}
	}

	public static void FormHistoryQuery() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("------FORM HISTORY QUERY-------");
		System.out.println("Input FORM CODE : ");
		String Code = scanner.nextLine();
		
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		ArrayList<FormLog> lst = da.getListFormLogByFormCode(Code);
		
		System.out.println("------------------FORM ACTION HISTORY---------------------------");
		for(FormLog item : lst) {
		
			System.out.println(item.toString());
			System.out.println("------------------------------------");
		}
		
		LoadMenuByUserRole();
	}
	
	// Search Menu
	public static void searchMenu() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.SEARCH BY EMPLOYEE ID");
		System.out.println("2.SEARCH BY DEPARTMENT");
		System.out.println("3.BACK TO REPORT MENU");
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
				rm.searchByDepartment(empSearchDepart);
			}
			else if (entry.equals("3")) {
				LoadReportMenu();
				break;
			} else {
				System.out.println("Invalid Entry, Try again !");
			}
		}
	}

	public static void GetRefusedForms() throws Exception {
		System.out.println("****************GET REFUSED FORMS**********************");
		ApprovalProxy approvecenter = new ApprovalProxy(loginUser);
		ArrayList<Form> listRefusedForms = approvecenter.getRefusedForms();
		if (listRefusedForms.isEmpty()) {
			System.out.println("****************REFUSED FORMS IS EMPTY*****************");
		} else {
			for (Form listRefusedForm : listRefusedForms) {
				//System.out.println(listRefusedForms);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        //System.out.println(dt1.format(date));
				if (listRefusedForm instanceof OTForm) {
					OTForm oTForm = (OTForm) listRefusedForm;
					System.out.println(
							"Form Code: " + oTForm.getFormCode() + ",\t" + 
							"Emp Name: " +	oTForm.getOwner().getEmpName().toString() + ",\t" + 
							"OT Date: " + dateFormat.format(oTForm.getOTDate()) + ",\t" +
							"Time From: " + oTForm.getTimeFrom().toString() + ",\t" +
							"Time To: "	+ oTForm.getTimeTo().toString() + ",\t" +
							"Status: " + oTForm.getStatus().toString());
				} else if (listRefusedForm instanceof ATForm) {
					ATForm aTForm = (ATForm) listRefusedForm;
					System.out.println(
							"Form Code: " + aTForm.getFormCode() + ",\t" + 
							"Emp Name: " + aTForm.getOwner().getEmpName().toString() +  ",\t" +
							"AT Date: "	+ dateFormat.format(aTForm.getATDate()) + ",\t" + 
							"Time In: "	+aTForm.getTimeIn().toString() + ",\t" + 
							"Time Out: "	+ aTForm.getTimeOut().toString() + ",\t" + 
							"Status: "+ aTForm.getStatus().toString());
				} else if (listRefusedForm instanceof LeaveForm) {
					LeaveForm leaveForm = (LeaveForm) listRefusedForm;
					System.out.println(
							"Form Code: " + leaveForm.getFormCode() + ",\t" + 
							"Emp Name: " + leaveForm.getOwner().getEmpName().toString() + ",\t" + 
							"Leave Date From: " + dateFormat.format(leaveForm.getLeaveDateFrom()) + ",\t" + 
							"Leave Date To: "+ dateFormat.format(leaveForm.getLeaveDateTo()) + ",\t" + 
							"Status: " + leaveForm.getStatus().toString());
				}
			}
		}
		LoadMenuByUserRole();
		// Scanner scanner = new Scanner(System.in);
	}

}
