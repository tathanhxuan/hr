package com.hr.domain.formValidation;

import java.util.HashMap;

import com.hr.domain.Form;

public class FormValidationContext {

	private FormValidationStrategy formValidationStrategy; 
	
	public  FormValidationContext(FormValidationStrategy formValidationStrategy){  
		this.formValidationStrategy = formValidationStrategy  ;
     }  
	
	public HashMap<String, String> Validate(Form model)
	{
		return formValidationStrategy.Validate(model);
	}
	
}
