package com.hr.repository;

import java.util.List;

import com.hr.domain.Form;

public interface FormRepository {
	public List<Form> getAllForms();

	public Form getForm(int id);

	public void updateForm(Form form);

	public void deleteForm(Form form);
}
