package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.Employee;
import com.hr.domain.FormStatus;
import com.hr.domain.formValidation.FormValidationStrategy;

public class OTFormServiceImpl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String formCode;
	Employee owner;
	FormStatus status;
	FormValidationStrategy validationStrategy;

	public OTFormServiceImpl(String formCode, Employee owner, FormStatus status,
			FormValidationStrategy validationStrategy) {
		super();
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

	@Override
	public String toString() {
		return "[Form Code: " + formCode + ", Owner: " + owner.toString() + ", status: " + status.toString() + "]";
	}

}
