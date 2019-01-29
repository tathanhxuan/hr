package com.hr.repository;

import java.util.List;

import com.hr.domain.Overtime;

public interface OvertimeRepository {
	public List<Overtime> getAllOvertimes();

	public Overtime getOvertime(int id);

	public void updateOvertime(Overtime overtime);

	public void deleteOvertime(Overtime overtime);
}
