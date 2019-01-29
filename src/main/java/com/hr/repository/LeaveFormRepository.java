package com.hr.repository;

import java.util.List;

import com.hr.domain.LeaveForm;

public interface LeaveFormRepository {
	public List<LeaveForm> getAllLeaveForms();

	public LeaveForm getLeaveForm(int id);

	public void updateLeaveForm(LeaveForm leaveForm);

	public void deleteLeaveForm(LeaveForm leaveForm);
}
