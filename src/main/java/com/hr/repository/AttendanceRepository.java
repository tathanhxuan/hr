package com.hr.repository;

import java.util.List;

import com.hr.domain.Attendance;

public interface AttendanceRepository {
	public List<Attendance> getAllAttendances();

	public Attendance getAttendance(int id);

	public void updateUser(Attendance attendance);

	public void deleteUser(Attendance attendance);
}
