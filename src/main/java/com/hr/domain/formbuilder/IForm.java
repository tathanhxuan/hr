package com.hr.domain.formbuilder;
import com.hr.domain.Form;
import com.hr.domain.FormApprover;
import com.hr.domain.approval.IApproverList;

public interface IForm {

	 public Form HRForm();
	 public IApproverList listApprover();
	 public Boolean Submit();
	 public Boolean Approve(FormApprover approvalModel); 
	 public Boolean ReSubmit();
}
