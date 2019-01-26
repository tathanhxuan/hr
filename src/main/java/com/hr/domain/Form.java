package com.hr.domain;

public abstract class Form {
	
 String formCode;
 String empID;
 FormStatus status;
 
 abstract Boolean Submit();
 abstract Boolean Approve();
 abstract Boolean Update();
 
}
