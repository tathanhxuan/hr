package com.hr.repository;

import java.util.List;

import com.hr.domain.ATForm;

public interface ATFormRepository {
	public List<ATForm> getAllATForms();

	public ATForm getATForm(int id);

	public void updateATForm(ATForm aTForm);

	public void deleteATForm(ATForm aTForm);
}
