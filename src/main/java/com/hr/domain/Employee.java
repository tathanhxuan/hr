package com.hr.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	private String empID;
	private String empName;
	private Date dateOfBirth;
	private String address;
	private Position position;
	private Department dept;
	private Boolean isApprover;
	Boolean isHR;
	
	public Boolean getIsHR() {
		return isHR;
	}

	public void setIsHR(Boolean isHR) {
		this.isHR = isHR;
	}

	public Boolean getIsApprover() {
		return isApprover;
	}
		
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
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
	
	@Override
	public String toString() {
		return "[empID: " + empID + ", empName: " + empName.toString() + ", Dept: " + dept.getDeptName().toString() + "]";
	}
	
}
