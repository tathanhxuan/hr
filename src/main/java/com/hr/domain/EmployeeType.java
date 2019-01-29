package com.hr.domain;

public abstract class EmployeeType {
	String type_id;
	String type_description;
	String name;

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_description() {
		return type_description;
	}

	public void setType_description(String type_description) {
		this.type_description = type_description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
