package com.hr.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.hr.domain.HRFormCore.FormValidationStrategy;

public abstract class Form implements Serializable, Cloneable{
	
	 String formCode;
	 Employee owner;
	 FormStatus status;
	 FormValidationStrategy validationStrategy;
	
	 String description;
	
 	public Form(Employee owner) {
		// this.formCode = formCode;
		 this.owner = owner;
		 this.status = FormStatus.CREATED;
	
	 }
	 
	 public String getFormCode() {
		return formCode;
	}
	 
 	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	
	 public String getDescription() {
			return description;
	 }

	 public void setDescription(String description) {
			this.description = description;
	 }
		
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	public abstract Date getDateFrom();

	public FormStatus getStatus() {
		return status;
	}
	public void setStatus(FormStatus status) {
		this.status = status;
	}
	
    public FormValidationStrategy getValidationStrategy() {
		return validationStrategy;
	}

	public void setValidationStrategy(FormValidationStrategy validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	
	//Apply prototype pattern
	public Object clone() {
	   Object clone = null;
	      
	  try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }

	
	//Template Method design pattern
	public final Boolean formSubmit() {
		
		//validate form
		if (validationStrategy.Validate(this) !=null )
			return false;
		
		// get approver List
		DepartmentApprover approvers = new DepartmentApprover(owner.getDepartment().getDeptID());
		
		if(Submit(approvers.getListApprover()))
		 {
			SubmitNotify(this);
			return true;
		 }
		
		return false;
	}

	public final Boolean formReSubmit() {
		        //validate form
				if (validationStrategy.Validate(this) !=null )
					return false;
				
				if(ReSubmit())
				 {
					SubmitNotify(this);
					return true;
				 }
				
				return false;
	}

	 abstract Boolean Submit(ArrayList<DepartmentApprover> approvers);
	 
	 abstract Boolean SubmitNotify(Form f);
	 	 
	 abstract Boolean ReSubmit();
	 
	 abstract ArrayList<Form> getEmployeeForms(FormStatus status);

	 
	 abstract int getCurrentStatus();

	 	 	 	

}
