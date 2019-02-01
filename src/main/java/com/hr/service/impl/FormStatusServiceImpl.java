package com.hr.service.impl;

import java.io.Serializable;

public class FormStatusServiceImpl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String statusID;
	String statusName;
	public String getStatusID() {
		return statusID;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public FormStatusServiceImpl(String statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "[statusID: " + statusID + statusName.toString() + "]";
	}
}
