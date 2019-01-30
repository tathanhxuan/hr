package com.hr.domain.formValidation;

import java.util.HashMap;

import com.hr.domain.Form;
import com.hr.domain.HRFormCore.FormValidationStrategy;

//Apply CoR design pattern for  validation chaining
public class LeaveFormValidation extends FormValidationStrategy{

	@Override
	public HashMap<String, String> Validate(Form model) {
		
		// TODO Auto-generated method stub
		DateFromRequiredValidator dateFromRequiredValidator = new DateFromRequiredValidator();
		
		DateToRequiredValidator dateToRequiredValidator = new DateToRequiredValidator();
		
	    dateFromRequiredValidator.setSuccessor(dateToRequiredValidator);
	
	    //continue validation in chain
	    return dateFromRequiredValidator.HandleValidation(model);
		
	}

}
