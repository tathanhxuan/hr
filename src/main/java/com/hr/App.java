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
    	
    	
    	
    	System.out.println("******WELCOME TO HR WORKTIME MANAGEMENT SYSTEM********");
    	System.out.println("Login:");
    	System.out.println("Username : ");
    	 Scanner scanner = new Scanner(System. in);
         String inputString = scanner. nextLine(); 
    	 
    	System.out.println("Passwords : ");
    	 String pass = scanner. nextLine();
    	
    	 System.out.println(inputString + " " + pass );
    	//check user login
    	

    	if(true) {

    	System.out.println("SYSTEM MENU:");
    	System.out.println("1.CREATE HR FORM");
    	System.out.println("2.FORM HISTORY");
    	System.out.println("3.EXIT");
    	System.out.println(" PLEASE SELECT :");
    	
    	}
    	
    	
    	
    	
//    	//FORM SUBMIT
 	FormValidationStrategy vf = new LeaveFormValidation();
//    	
       Department dept = new Department("001", "IT");
 	Employee emp = new Employee("2615",dept);
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

        f.setStatus(FormStatus.CREATED);
        f.setOwner(emp);
        
        
        f.formSubmit();

        
        
    }
}