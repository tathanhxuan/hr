package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.EmployeeGroup;

public class EmployeeGroupServiceImpl extends EmployeeGroup implements Serializable {
	String group_id;
	String description;
	String name;

	public EmployeeGroupServiceImpl(String group_id, String description, String name) {
		super();
		this.group_id = group_id;
		this.description = description;
		this.name = name;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[group_id: " + group_id + ", Description: " + description.toString() + ", Name: " + name.toString() + "]";
	}
}
