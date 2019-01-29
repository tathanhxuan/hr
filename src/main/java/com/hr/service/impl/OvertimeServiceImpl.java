package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.Overtime;

public class OvertimeServiceImpl extends Overtime implements Serializable {
	String empID;
	String ot_code;
	String end_time;
	String start_time;
	String ot_rate;
	String date;

	public OvertimeServiceImpl(String empID, String ot_code, String end_time, String start_time, String ot_rate,
			String date) {
		super();
		this.empID = empID;
		this.ot_code = ot_code;
		this.end_time = end_time;
		this.start_time = start_time;
		this.ot_rate = ot_rate;
		this.date = date;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getOt_code() {
		return ot_code;
	}

	public void setOt_code(String ot_code) {
		this.ot_code = ot_code;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getOt_rate() {
		return ot_rate;
	}

	public void setOt_rate(String ot_rate) {
		this.ot_rate = ot_rate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "[id: " + empID + ", Start Time: " + start_time.toString() + ", End Time: " + end_time.toString() + "]";
	}

}
