package com.hr;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.hr.domain.report.ATReport;
import com.hr.domain.report.ReportMaker;
import com.hr.domain.report.builder.GeneralReport;
import com.hr.domain.report.builder.GeneralReport.Builder;
import com.hr.domain.reportChart.ChartTemplate;
import com.hr.domain.reportIterator.ATReportIterator;
import com.hr.domain.reportIterator.LeaveReportIterator;
import com.hr.domain.reportIterator.OTReportIterator;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.storage.DataAccessRepositoryFacade;
/**
 * Hello world!
 *
 */
public class App 
{
	
	public static Employee loginUser;
	public static String userRole;
	
    @SuppressWarnings("null")
	public static void main( String[] args ) throws Exception
    {
    	
    	Login();
    	LoadMenuByUserRole();
    	
//    	ApprovalProxy approvecenter = new ApprovalProxy(loginUser);
//    	 approvecenter.getWaitedApproveForms();
//    	 
//    	 
//    	 StepApprover s = new StepApprover(;
//    	 s.setForm(form);
//    	 
//    	 
//    	 approvecenter.ap
    }

    public static Employee Login() {
    	Employee emp =null;
    	
    	System.out.println("-----------SYSTEM LOGIN-------------:");
    	System.out.println("Username : ");
    	Scanner scanner = new Scanner(System. in);
        String username = scanner. nextLine(); 
    	System.out.println("Passwords : ");
    	String pass = scanner. nextLine();
    	
    	//verify user
    	
    	//Employee emp = Login();
    	loginUser = new Employee("101",new Department("D01", ""));
    	userRole = "APPROVER";
    	
    	return emp;
    }
    
    public static void LoadStaffMenu() throws ParseException {
    	
    	Scanner scanner = new Scanner(System. in);
       
        
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
    	
    	String keyID = scanner. nextLine(); 
    	StaffMenuAction(keyID);
    	
    }
    
    public static void LoadApproverMenu() throws ParseException {
    	
    	Scanner scanner = new Scanner(System. in);
    	
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
    	
    	String keyID = scanner. nextLine(); 
    	ApproverMenuAction(keyID);
    }
   
    public static void LoadReportMenu() {
   	
   	System.out.println("******REPORT********");
    System.out.println("1.OT REPORT");
   	System.out.println("2.AT REPORT");
   	System.out.println("3.LEAVE REPORT");
   	System.out.println("4.CHART");
   	System.out.println("5.EXIT");
   	System.out.println("*******************************************************");
   	System.out.println("*.SELECT : ");
   }
   
    // CREATE LEAVE FORM
    public static void CreateLeaveForm() throws ParseException {
    	
    	Scanner scanner = new Scanner(System. in);
    	
    	System.out.println("******LEAVE REGISTRAR********");
    	System.out.println("Leave From Date (mm/dd/yyyy):");
    	String datefrom = scanner. nextLine(); 
    	System.out.println("Leave From To (mm/dd/yyyy):");
    	String dateto = scanner. nextLine(); 
    	System.out.println("Reason:");
    	String reason = scanner. nextLine();
    	
    	System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
    	String command = scanner. nextLine();
    	
    	
    	if(command.equals("S") ||command.equals("s")) {

        	FormValidationStrategy vf = new LeaveFormValidation();
        	LeaveForm f = (LeaveForm) FormFactory.creatForm(FormType.LEAVE, loginUser);
        	f.setValidationStrategy(vf);
        	
        	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        	
        	Date dafrom = format.parse(datefrom);
        	Date dato = format.parse(dateto);
        	
        	f.setLeaveDateFrom(dafrom );
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
    	
    	Scanner scanner = new Scanner(System. in);
    	
    	System.out.println("******OT REGISTRAR********");
    	System.out.println("OT Date (mm/dd/yyyy):");
    	String otdate = scanner. nextLine(); 
    	System.out.println("Time from (hh:mm):");
    	String timefrom = scanner. nextLine(); 
    	System.out.println("Time to (hh:mm):");
    	String timeto = scanner. nextLine(); 
    	System.out.println("Reason:");
    	String reason = scanner. nextLine();
    	
    	System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
    	String command = scanner. nextLine();
    	
    	
    	if(command.equals("S") ||command.equals("s")) {

        	FormValidationStrategy vf = new LeaveFormValidation();
        	OTForm f = (OTForm) FormFactory.creatForm(FormType.OVERTIME, loginUser);
        	f.setValidationStrategy(vf);
        	
        	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        	
        	Date otDate = format.parse(otdate);
        
        	
        	f.setOTDate(otDate);;
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
 	
 	Scanner scanner = new Scanner(System. in);
 	
 	System.out.println("******AT REGISTRAR********");
 	System.out.println("Attendance Date (mm/dd/yyyy):");
 	String atdate = scanner. nextLine(); 
 	System.out.println("Time In (hh:mm):");
 	String timefrom = scanner. nextLine(); 
 	System.out.println("Time Out (hh:mm):");
 	String timeto = scanner. nextLine(); 
 	System.out.println("Reason:");
 	String reason = scanner. nextLine();
 	
 	System.out.println("Press 'S=SUBMIT' | 'C=CANCEL'':");
 	String command = scanner. nextLine();
 	
 	
 	if(command.equals("S") ||command.equals("s")) {

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
    
    
public static void ApproverMenuAction(String functionID) throws ParseException {
    	
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
			
		default:
			break;
		}
    }


}

