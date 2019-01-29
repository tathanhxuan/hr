package com.hr.repository;

import java.util.HashMap;

import com.hr.domain.User;
import com.hr.domain.Approval;
import com.hr.domain.Form;
import com.hr.domain.History;
import com.hr.domain.Report;

public interface DataAccessRepository {

	public HashMap<String, UserRepository> readUserMap();
	
	public HashMap<String, SystemUserRepository> readSystemUserMap();
	
	public HashMap<String, AttendanceRepository> readAttendanceMap();
	
	public HashMap<String, ShiftRepository> readShiftMap();
	
	public HashMap<String, OvertimeRepository> readOvertimeMap();
	
	public HashMap<String, EmployeeGroupRepository> readEmployeeGroupMap();
	
	public HashMap<String, LeaveFormRepository> readLeaveFormMap();

	public HashMap<String, ApprovalRepository> readApprovalMap();

	public HashMap<String, FormRepository> readFormMap();

	public HashMap<String, HistoryRepository> readHistoryMap();

	public HashMap<String, ReportRepository> readReportMap();

	public void saveNewUser(User user);

	public void saveNewApproval(Approval approval);

	public void saveNewForm(Form form);

	public void saveNewHistory(History history);

	public void saveNewReport(Report report);

}
