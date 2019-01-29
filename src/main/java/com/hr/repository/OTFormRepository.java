package com.hr.repository;

import java.util.List;

import com.hr.domain.OTForm;

public interface OTFormRepository {
	public List<OTForm> getAllOTForms();

	public OTForm getOTForm(int id);

	public void updateOTForm(OTForm leaveForm);

	public void deleteOTForm(OTForm leaveForm);
}
