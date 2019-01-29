package com.hr.service.impl;

import java.io.Serializable;
import java.util.Date;

import com.hr.domain.User;
import com.hr.repository.Auth;

public class UserServiceImpl extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int group_id;
	String mobile;
	String email;
	String address;
	String empID;
	String nick_name;
	String name;
	String gender;
	String date_of_birth;
	String status;
	String type;
	String attendance_count;
	Auth authorization;

	public UserServiceImpl(int group_id, String mobile, String email, String address, String empID, String nick_name,
			String name, String gender, String date_of_birth, String status, String type, String attendance_count,
			Auth authorization) {
		super();
		this.group_id = group_id;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.empID = empID;
		this.nick_name = nick_name;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.status = status;
		this.type = type;
		this.attendance_count = attendance_count;
		this.authorization = authorization;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttendance_count() {
		return attendance_count;
	}

	public void setAttendance_count(String attendance_count) {
		this.attendance_count = attendance_count;
	}

	public Auth getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Auth authorization) {
		this.authorization = authorization;
	}

	

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	@Override
	public String toString() {
		return "[id: " + empID + ", Name: " + name.toString() + ", Role: " + authorization.toString() + "]";
	}
}
