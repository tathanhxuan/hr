package com.hr.domain;

import java.util.Date;

public class Employee {

	String empID;
	String empName;
	Date dateOfBirth;
	String address;
	Position position;
	Department dept;
	Boolean isApprover;
	
	public Boolean getIsApprover() {
		return isApprover;
	}

	public void setIsApprover(Boolean isApprover) {
		this.isApprover = isApprover;
	}

	public Employee(String empID,Department dept) {
		this.empID = empID;
		this.dept = dept;
	}

	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	public Department getDepartment() {
		return dept;
	}
	public void setDepartment(Department dept) {
		this.dept = dept;
	}
	
}
