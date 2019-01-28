package com.hr.domain;

public abstract class LeaveEntitlement {
	String id;
	String level_description;
	String usual;
	String annual;
	String medical;
	String half_day;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel_description() {
		return level_description;
	}

	public void setLevel_description(String level_description) {
		this.level_description = level_description;
	}

	public String getUsual() {
		return usual;
	}

	public void setUsual(String usual) {
		this.usual = usual;
	}

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getHalf_day() {
		return half_day;
	}

	public void setHalf_day(String half_day) {
		this.half_day = half_day;
	}

}
