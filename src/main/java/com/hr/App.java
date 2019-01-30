package com.hr;

import com.hr.domain.*;
import com.hr.domain.HRFormCore.FormCodeGeneration;
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
    	
    	//FORM SUBMIT
    	FormValidationStrategy vf = new LeaveFormValidation();
    	
        Department dept = new Department("001", "IT");
    	Employee emp = new Employee("2615",dept);
    	
    	
    	//FORM CODE CREATION FORMAT
    	// OT FORM : OT_EMPID_DATETIME
    	// AT FORM : AT_EMPID_DATETIME
    	// LEVAE FORM : LA_EMPID_DATETIME
    	
        Form f = FormFactory.creatForm(FormType.LEAVE,emp,FormStatus.CREATED,vf);

        f.setStatus(FormStatus.CREATED);
        
        
       // f.formSubmit();
        
        FormCodeGeneration t = new FormCodeGeneration();
        System.out.println(t.GenerateLeaveCode("001", "2456"));
        
    }
}