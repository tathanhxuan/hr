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
	
    @SuppressWarnings("null")
	public static void main( String[] args ) throws IOException, ParseException
    {
    	
    	//Employee emp = Login();
    
    	loginUser = new Employee("101",new Department("D01", ""));
    	
    	//Login();
    	CreateLeaveForm(); 
       	
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
    	
    	return emp;
    }
    
    public static void LoadStaffMenu() {
    	
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
    }
    
    public static void LoadApproverMenu() {
    	
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
   	
   	//code here
   }
   
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
        		if( true) {
          			LoadApproverMenu();
            		}
           		else LoadStaffMenu();
        	}
    	}
    	else {
    		System.out.println("ARE YOU SURE TO CANCEL? (Y/N):");
    		String exit = scanner. nextLine();
    		
    		if((exit.equals("y") || exit.equals("Y")) && loginUser.getIsApprover()) {
  			LoadApproverMenu();
    		}
   		else LoadStaffMenu();
   	}

    }
    
}