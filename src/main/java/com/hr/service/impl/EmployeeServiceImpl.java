package com.hr.service.impl;

import java.io.Serializable;
import java.util.Date;

import com.hr.domain.Department;
import com.hr.domain.Position;

public class EmployeeServiceImpl implements Serializable {
	String empID;
	String empName;
	Date dateOfBirth;
	String address;
	Position position;
	Department dept;
	Boolean isApprover;

	public EmployeeServiceImpl(String empID, String empName, Date dateOfBirth, String address, Position position,
			Department dept, Boolean isApprover) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.position = position;
		this.dept = dept;
		this.isApprover = isApprover;
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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Boolean getIsApprover() {
		return isApprover;
	}

	public void setIsApprover(Boolean isApprover) {
		this.isApprover = isApprover;
	}
	
	@Override
	public String toString() {
		return "[Emp ID: " + empID + ", Emp Name: " + empName.toString() + ", Is approved: " + isApprover + ", Date Of Birth: " + dateOfBirth.toString() + "]";
	}

}
