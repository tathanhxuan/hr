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
	
	@Override
	public String toString() {
		return "[id: " + id + ", Name" + name.toString() + ", Role: " + authorization.toString() + "]";
	}
}
