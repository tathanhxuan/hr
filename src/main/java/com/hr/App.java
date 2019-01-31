package com.hr;

import java.util.Scanner;

import com.hr.domain.*;
import com.hr.domain.HRFormCore.FormFactory;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.domain.formValidation.LeaveFormValidation;
import com.hr.domain.report.ATReport;
import com.hr.domain.report.GeneralReport;
import com.hr.domain.report.GeneralReport.Builder;
import com.hr.domain.report.ReportMaker;
import com.hr.domain.reportChart.ATReportIterator;
import com.hr.domain.reportChart.ChartTemplate;
import com.hr.domain.reportChart.LeaveReportIterator;
import com.hr.domain.reportChart.OTReportIterator;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.storage.DataAccessRepositoryFacade;
/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("null")
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
    	
    	
    	
    	

     /*
    	Form f = FormFactory.creatForm(FormType.OVERTIME,emp,FormStatus.CREATED,vf);

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

        
        
    */
    	
    	//i want to get data from
    	DataAccessRepositoryFacade dt = new DataAccessRepositoryFacade();
    //	int counter = 0;
    	//for(int a: dt.readLeaveForm().values().size())
   	System.out.println(dt.readATForm().values().size());
    
   	
   	ReportMaker Rm = new ReportMaker();
    //	Department stDepartment=null;
    //	stDepartment.setDeptName("IT");
    	
    //	Rm.oTReportByDepartment("HR");
    //	ChartTemplate ch=null;
    //	ch.getReportChart();
    	
   	OTReportIterator ot = new OTReportIterator();
   	ot.getReportChart();
   	
   	
   	ATReportIterator at = new ATReportIterator();
   	at.getReportChart();
   	
   	
   	LeaveReportIterator st = new LeaveReportIterator();
   	st.getReportChart();
       	
    }
}