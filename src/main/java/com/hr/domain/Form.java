package com.hr.domain;
import java.util.ArrayList;
import java.util.Date;
import com.hr.domain.formValidation.FormValidationStrategy;

public abstract class Form implements Cloneable{
	
	 String formCode;
	 Employee owner;
	 FormStatus status;
	 FormValidationStrategy validationStrategy;
	 
	 public Form(String formCode,Employee owner, FormStatus status,FormValidationStrategy validationStrategy) {
		
		 this.formCode = formCode;
		 this.owner = owner;
		 this.status = status;
		 this.validationStrategy = validationStrategy;
	 }
	 
	 public String getFormCode() {
		return formCode;
	}
	 
	public void setFormCode(String formCode) {
		this.formCode = formCode;
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
			SubmitNotify();
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
					SubmitNotify();
					return true;
				 }
				
				return false;
	}
	
	
	 abstract Boolean Submit(ArrayList<StepApprover> approvers);
	 
	 abstract Boolean SubmitNotify();
	 
	 abstract Boolean Approve(StepApprover approvalModel);
	 
	 abstract Boolean ReSubmit();
	 
	 abstract ArrayList<Form> getEmployeeForms(FormStatus status);
	 
}
