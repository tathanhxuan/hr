package com.hr.domain;

import java.io.Serializable;

public class FormApprover implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String formCode;
	int approvalLevel;
	String nameApprover;

	public FormApprover(String formCode, int approvalLevel, String nameApprover) {
		super();
		this.formCode = formCode;
		this.approvalLevel = approvalLevel;
		this.nameApprover = nameApprover;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public int getApprovalLevel() {
		return approvalLevel;
	}

	public void setApprovalLevel(int approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getNameApprover() {
		return nameApprover;
	}

	public void setNameApprover(String nameApprover) {
		this.nameApprover = nameApprover;
	}

	@Override
	public String toString() {
		return "[formCode: " + formCode + ", Approval Level: " + approvalLevel + ", nameApprover: " + nameApprover.toString() + "]";
	}
	
}
