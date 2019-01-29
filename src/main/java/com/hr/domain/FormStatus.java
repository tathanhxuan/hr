package com.hr.domain;

public enum FormStatus {

	CREATED(1), APPROVED(2),REFUSED(3);
	private int value;  
	
	private FormStatus(int value){  
	this.value=value;  
	}  

}
