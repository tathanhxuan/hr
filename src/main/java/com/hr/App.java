package com.hr;

import java.util.Scanner;

import com.hr.domain.*;
import com.hr.domain.HRFormCore.FormFactory;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.formValidation.LeaveFormValidation;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//Employee emp = Login();

    	Employee emp = new Employee("123",new Department("123", ""));
    	
    	if(emp == null) {
        System.out.println("Invalid user ! ");
        return;
    	}
    	else {
    		LoadStaffMenu();
    	}
    	
    	
//    	//FORM SUBMIT
 	FormValidationStrategy vf = new LeaveFormValidation();
//    	
       //Department dept = new Department("001", "IT");
 	   //Employee emp = new Employee("2615",dept);
//    	
//    	
//    	//FORM CODE CREATION FORMAT
//    	// OT FORM : OT_EMPID_DATETIME
//    	// AT FORM : AT_EMPID_DATETIME
//    	// LEVAE FORM : LA_EMPID_DATETIME
//    	
//        Form f = FormFactory.creatForm(FormType.LEAVE,emp,FormStatus.CREATED,vf);
//
//        f.setStatus(FormStatus.CREATED);
//        
//        
//        f.formSubmit();

        Form f = FormFactory.creatForm(FormType.OVERTIME,emp,FormStatus.CREATED,vf);

//        f.setStatus(FormStatus.CREATED);
//        f.setOwner(emp);
//        
//        
//        f.formSubmit();

        
        
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
   }
   
}