package com.hr.domain;

public abstract class SystemUser {
	String user_name;
	String password;
	String security_level;

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

}
