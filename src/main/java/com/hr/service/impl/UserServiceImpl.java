package com.hr.service.impl;

import java.io.Serializable;

import com.hr.domain.User;
import com.hr.repository.Auth;

public class UserServiceImpl extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	int group_id;
	String email;
	String address;
	String nick_name;
	String name;
	String mobile;
	Auth authorization;

	public UserServiceImpl(String id, int group_id, String email, String address, String nick_name, String name,
			String mobile, Auth authorization) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.email = email;
		this.address = address;
		this.nick_name = nick_name;
		this.name = name;
		this.mobile = mobile;
		this.authorization = authorization;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Auth getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Auth authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", Name" + name.toString() + ", Role: " + authorization.toString() + "]";
	}
}
