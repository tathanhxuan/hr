package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.Attendance;

public class AttendanceServiceImpl extends Attendance implements Serializable {
	String id;
	String empID;
	String shift_id;
	String out_time;
	String in_time;
	String date;
	String status;

	public AttendanceServiceImpl(String id, String empID, String shift_id, String out_time, String in_time, String date,
			String status) {
		super();
		this.id = id;
		this.empID = empID;
		this.shift_id = shift_id;
		this.out_time = out_time;
		this.in_time = in_time;
		this.date = date;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getShift_id() {
		return shift_id;
	}

	public void setShift_id(String shift_id) {
		this.shift_id = shift_id;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "[id: " + id + ", Emp ID: " + empID.toString() + ", status: " + status.toString() + "]";
	}

}
