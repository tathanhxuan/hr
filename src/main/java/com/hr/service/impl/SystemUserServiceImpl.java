package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.SystemUser;

public class SystemUserServiceImpl extends SystemUser implements Serializable {
	String id;
	String user_name;
	String password;
	String security_level;
	
	public SystemUserServiceImpl(String id, String user_name, String password, String security_level) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.security_level = security_level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurity_level() {
		return security_level;
	}

	public void setSecurity_level(String security_level) {
		this.security_level = security_level;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", User Name: " + user_name.toString() + ", security_level: " + security_level.toString() + "]";
	}
}
