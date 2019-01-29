package com.hr.repository.storage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Approval;
import com.hr.domain.Form;
import com.hr.domain.History;
import com.hr.domain.Report;
import com.hr.domain.User;
import com.hr.repository.ApprovalRepository;
import com.hr.repository.AttendanceRepository;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.EmployeeGroupRepository;
import com.hr.repository.FormRepository;
import com.hr.repository.HistoryRepository;
import com.hr.repository.LeaveFormRepository;
import com.hr.repository.OvertimeRepository;
import com.hr.repository.ReportRepository;
import com.hr.repository.ShiftRepository;
import com.hr.repository.SystemUserRepository;
import com.hr.repository.UserRepository;
import com.hr.service.impl.AttendanceServiceImpl;
import com.hr.service.impl.EmployeeGroupServiceImpl;
import com.hr.service.impl.LeaveFormServiceImpl;
import com.hr.service.impl.OvertimeServiceImpl;
import com.hr.service.impl.ShiftServiceImpl;
import com.hr.service.impl.SystemUserServiceImpl;
import com.hr.service.impl.UserServiceImpl;

//import model.dataaccess.DataAccessFacade.StorageType;
//import model.domain.LibraryMember;

//import model.dataaccess.DataAccessFacade.StorageType;

//import model.dataaccess.DataAccessFacade.StorageType;

public class DataAccessRepositoryFacade implements DataAccessRepository {

	enum StorageType {
		USERS, SYSTEM_USER, ATTENDANCES, EMPLOYEE_GROUP, EMPLOYEE_TYPE, LEAVE_ENTITLEMENT, OVERTIME, SHIFT, LEAVE_FORM;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "//src//main//java//com//hr//repository//storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	@SuppressWarnings("unchecked")
	public HashMap<String, UserRepository> readUserMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, UserRepository>) readFromStorage(StorageType.USERS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, SystemUserRepository> readSystemUserMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, SystemUserRepository>) readFromStorage(StorageType.SYSTEM_USER);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, AttendanceRepository> readAttendanceMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, AttendanceRepository>) readFromStorage(StorageType.ATTENDANCES);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, ShiftRepository> readShiftMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, ShiftRepository>) readFromStorage(StorageType.SHIFT);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, OvertimeRepository> readOvertimeMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, OvertimeRepository>) readFromStorage(StorageType.OVERTIME);
	}
	
	@Override
	public HashMap<String, EmployeeGroupRepository> readEmployeeGroupMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, EmployeeGroupRepository>) readFromStorage(StorageType.EMPLOYEE_GROUP);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, LeaveFormRepository> readLeaveFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, LeaveFormRepository>) readFromStorage(StorageType.LEAVE_FORM);
	}

	public HashMap<String, ApprovalRepository> readApprovalMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, FormRepository> readFormMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, HistoryRepository> readHistoryMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, ReportRepository> readReportMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNewUser(User user) {
		// TODO Auto-generated method stub

	}

	public void saveNewApproval(Approval approval) {
		// TODO Auto-generated method stub

	}

	public void saveNewForm(Form form) {
		// TODO Auto-generated method stub

	}

	public void saveNewHistory(History history) {
		// TODO Auto-generated method stub

	}

	public void saveNewReport(Report report) {
		// TODO Auto-generated method stub

	}

	static void loadUserMap(List<UserServiceImpl> allUsers) {
		HashMap<String, UserServiceImpl> users = new HashMap<String, UserServiceImpl>();
		allUsers.forEach(user -> users.put(user.getEmpID(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void loadSystemUserMap(List<SystemUserServiceImpl> allSystemUsers) {
		HashMap<String, SystemUserServiceImpl> systemUsers = new HashMap<String, SystemUserServiceImpl>();
		allSystemUsers.forEach(sUser -> systemUsers.put(sUser.getId(), sUser));
		saveToStorage(StorageType.SYSTEM_USER, systemUsers);
	}

	static void loadAttendancesMap(List<AttendanceServiceImpl> allAttendances) {
		HashMap<String, AttendanceServiceImpl> attendances = new HashMap<String, AttendanceServiceImpl>();
		allAttendances.forEach(attendance -> attendances.put(attendance.getId(), attendance));
		saveToStorage(StorageType.ATTENDANCES, attendances);
	}

	static void loadShiftsMap(List<ShiftServiceImpl> allShifts) {
		HashMap<String, ShiftServiceImpl> shifts = new HashMap<String, ShiftServiceImpl>();
		allShifts.forEach(shift -> shifts.put(shift.getShip_id(), shift));
		saveToStorage(StorageType.SHIFT, shifts);
	}

	static void loadOvertimesMap(List<OvertimeServiceImpl> allOvertimes) {
		HashMap<String, OvertimeServiceImpl> overtimes = new HashMap<String, OvertimeServiceImpl>();
		allOvertimes.forEach(overtime -> overtimes.put(overtime.getEmpID(), overtime));
		saveToStorage(StorageType.OVERTIME, overtimes);
	}

	static void loadEmployeeGroupsMap(List<EmployeeGroupServiceImpl> allEmployeeGroups) {
		HashMap<String, EmployeeGroupServiceImpl> employeeGroups = new HashMap<String, EmployeeGroupServiceImpl>();
		allEmployeeGroups.forEach(employeeGroup -> employeeGroups.put(employeeGroup.getGroup_id(), employeeGroup));
		saveToStorage(StorageType.EMPLOYEE_GROUP, employeeGroups);
	}
	
	static void loadLeaveFormsMap(List<LeaveFormServiceImpl> allLeaveForms) {
		HashMap<String, LeaveFormServiceImpl> empLeaveForms = new HashMap<String, LeaveFormServiceImpl>();
		allLeaveForms.forEach(empLeaveForm -> empLeaveForms.put(empLeaveForm.getFormCode(), empLeaveForm));
		saveToStorage(StorageType.LEAVE_FORM, empLeaveForms);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	

	

}
