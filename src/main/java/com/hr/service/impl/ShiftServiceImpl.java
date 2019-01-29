package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.Shift;

public class ShiftServiceImpl extends Shift implements Serializable {
	String ship_id;
	String out_time;
	String in_time;

	public ShiftServiceImpl(String ship_id, String out_time, String in_time) {
		super();
		this.ship_id = ship_id;
		this.out_time = out_time;
		this.in_time = in_time;
	}

	public String getShip_id() {
		return ship_id;
	}

	public void setShip_id(String ship_id) {
		this.ship_id = ship_id;
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
	
	@Override
	public String toString() {
		return "[id: " + ship_id + ", Out Time: " + out_time.toString() + ", In Time: " + in_time.toString() + "]";
	}

}
