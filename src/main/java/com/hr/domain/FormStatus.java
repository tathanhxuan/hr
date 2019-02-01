package com.hr.domain;

public enum FormStatus {

	CREATED(1),
	APPROVED_1ST(2),
	APPROVED_2ND(3),
	HRACCEPTED(4),
	REFUSED(5);
	
	private int value;  
	
	private FormStatus(int value){  
	this.value=value;  
	}  

}
