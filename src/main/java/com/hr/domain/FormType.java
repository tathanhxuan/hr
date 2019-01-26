package com.hr.domain;

public enum FormType {
	LEAVE(1), OVERTIME(2),ATTENDANT(2);
	private int value;  
	
	private FormType(int value){  
	this.value=value;  
	}  
}
