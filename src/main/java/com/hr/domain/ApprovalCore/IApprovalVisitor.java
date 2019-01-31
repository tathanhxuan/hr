package com.hr.domain.ApprovalCore;

import com.hr.domain.ATForm;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;

public interface IApprovalVisitor {

	  public void visit(ATForm form); // Visit OT APPROVE
	  public void visit(OTForm form); // Visit AT APPROVE
	  public void visit(LeaveForm form);  // Visit LEAVE APPROVE
	  
	  
}
	
