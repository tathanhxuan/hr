package com.hr.repository;

import java.util.List;

import com.hr.domain.Shift;

public interface ShiftRepository {
	public List<Shift> getAllShifts();

	public Shift getShift(int id);

	public void updateShift(Shift shift);

	public void deleteShift(Shift shift);
}
