package com.hr;

import com.hr.domain.*;
import com.hr.domain.formValidation.FormValidationStrategy;
import com.hr.domain.formValidation.LeaveFormValidation;
import com.hr.domain.formfactory.FormFactory;
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
    	
        Form f = FormFactory.creatForm(FormType.LEAVE,"L123",emp,FormStatus.CREATED,vf);
        f.formSubmit();
        
        //

    }
}
