package com.hr.repository.storage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.FormApprover;
import com.hr.domain.FormLog;
import com.hr.domain.FormStatus;
import com.hr.domain.History;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.domain.Report;
import com.hr.domain.StepApprover;
import com.hr.domain.SystemUser;
import com.hr.domain.User;
import com.hr.repository.ATFormRepository;
import com.hr.repository.AttendanceRepository;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.DepartmentApproverRepository;
import com.hr.repository.EmployeeGroupRepository;
import com.hr.repository.FormRepository;
import com.hr.repository.HistoryRepository;
import com.hr.repository.LeaveFormRepository;
import com.hr.repository.OTFormRepository;
import com.hr.repository.OvertimeRepository;
import com.hr.repository.ReportRepository;
import com.hr.repository.ShiftRepository;
import com.hr.repository.SystemUserRepository;
import com.hr.repository.UserRepository;
import com.hr.service.impl.ATFormServiceImpl;
import com.hr.service.impl.AttendanceServiceImpl;
import com.hr.service.impl.DepartmentApproverServiceImpl;
import com.hr.service.impl.EmployeeGroupServiceImpl;
import com.hr.service.impl.EmployeeServiceImpl;
import com.hr.service.impl.FormStatusServiceImpl;
import com.hr.service.impl.LeaveFormServiceImpl;
import com.hr.service.impl.OTFormServiceImpl;
import com.hr.service.impl.OvertimeServiceImpl;
import com.hr.service.impl.ShiftServiceImpl;
import com.hr.service.impl.StepApproverServiceImpl;
import com.hr.service.impl.SystemUserServiceImpl;
import com.hr.service.impl.UserServiceImpl;

public class DataAccessRepositoryFacade implements DataAccessRepository {

	enum StorageType {
		USERS, SYSTEM_USER, ATTENDANCES, EMPLOYEE_GROUP, EMPLOYEE_TYPE, LEAVE_ENTITLEMENT, OVERTIME, SHIFT, LEAVE_FORM,
		OT_FORM, AT_FORM, DEPARTMENT_APPROVER, EMPLOYEE, STEP_APPROVER, FORM_APPROVER, DEPARTMENT, FORM_STATUS, FORM_LOG;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "//src//main//java//com//hr//repository//storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	/*@SuppressWarnings("unchecked")
	public HashMap<String, UserRepository> readUserMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, UserRepository>) readFromStorage(StorageType.USERS);
	}*/
	
	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, User>) readFromStorage(StorageType.USERS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, SystemUser> readSystemUserMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, SystemUser>) readFromStorage(StorageType.SYSTEM_USER);
	}

	/*@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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
	}*/
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LeaveForm> readLeaveFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, LeaveForm>) readFromStorage(StorageType.LEAVE_FORM);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LeaveForm> readLeaveForm() {
		// TODO Auto-generated method stub
		return (HashMap<String, LeaveForm>) readFromStorage(StorageType.LEAVE_FORM);
	}
	
	/*@SuppressWarnings("unchecked")
	public HashMap<String, LeaveFormServiceImpl> readLeaveFormServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, LeaveFormServiceImpl>) readFromStorage(StorageType.LEAVE_FORM);
	}*/

	/*@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, OTFormRepository> readOTFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, OTFormRepository>) readFromStorage(StorageType.OT_FORM);
	}*/
	
	@SuppressWarnings("unchecked")
	public HashMap<String, OTForm> readOTFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, OTForm>) readFromStorage(StorageType.OT_FORM);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, OTForm> readOTForm() {
		// TODO Auto-generated method stub
		return (HashMap<String, OTForm>) readFromStorage(StorageType.OT_FORM);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Employee> readEmployeeMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, Employee>) readFromStorage(StorageType.EMPLOYEE);
	}
	
	
			
	@SuppressWarnings("unchecked")
	public HashMap<String, OTFormServiceImpl> readOTFormServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, OTFormServiceImpl>) readFromStorage(StorageType.OT_FORM);
	}	
	
	/*@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, ATFormRepository> readATFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, ATFormRepository>) readFromStorage(StorageType.AT_FORM);
	}*/
		
	@SuppressWarnings("unchecked")
	public HashMap<String, ATForm> readATFormMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, ATForm>) readFromStorage(StorageType.AT_FORM);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, ATForm> readATForm() {
		// TODO Auto-generated method stub
		return (HashMap<String, ATForm>) readFromStorage(StorageType.AT_FORM);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, ATFormServiceImpl> readATFormServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, ATFormServiceImpl>) readFromStorage(StorageType.AT_FORM);
	}
	
	/*@SuppressWarnings("unchecked")
	public HashMap<String, DepartmentApproverRepository> readDepartmentApproverMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, DepartmentApproverRepository>) readFromStorage(StorageType.DEPARTMENT_APPROVER);
	}*/
	
	/*@SuppressWarnings("unchecked")
	public HashMap<String, DepartmentApproverServiceImpl> readDepartmentApproverServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, DepartmentApproverServiceImpl>) readFromStorage(StorageType.DEPARTMENT_APPROVER);
	}*/
	
	@SuppressWarnings("unchecked")
	public HashMap<String, DepartmentApprover> readDepartmentApproverMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, DepartmentApprover>) readFromStorage(StorageType.DEPARTMENT_APPROVER);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Department> readDepartmentMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, Department>) readFromStorage(StorageType.DEPARTMENT);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, FormLog> readFormLogMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, FormLog>) readFromStorage(StorageType.FORM_LOG);
	}
	
	public ArrayList<DepartmentApprover> getListDepartmentApprover() {
		HashMap<String, DepartmentApprover> departmentApproversMap = readDepartmentApproverMap();
		Collection<DepartmentApprover> values = departmentApproversMap.values();
		ArrayList<DepartmentApprover> listDepartmentApprovers = new ArrayList<DepartmentApprover>(values);
		return listDepartmentApprovers;
	}
	
	public ArrayList<Department> getListDepartment() {
		HashMap<String, Department> departmentsMap = readDepartmentMap();
		Collection<Department> values = departmentsMap.values();
		ArrayList<Department> listDepartments = new ArrayList<Department>(values);
		return listDepartments;
	}
	
	public ArrayList<Employee> getListEmployee() {
		HashMap<String, Employee> employeesMap = readEmployeeMap();
		Collection<Employee> values = employeesMap.values();
		ArrayList<Employee> listEmployees = new ArrayList<Employee>(values);
		return listEmployees;
	}
	
	public ArrayList<OTForm> getListOTForm() {
		HashMap<String, OTForm> oTFormsMap = readOTFormMap();
		Collection<OTForm> values = oTFormsMap.values();
		ArrayList<OTForm> listOTForms = new ArrayList<OTForm>(values);
		return listOTForms;
	}
	
	public ArrayList<ATForm> getListATForm() {
		HashMap<String, ATForm> aTFormsMap = readATFormMap();
		Collection<ATForm> values = aTFormsMap.values();
		ArrayList<ATForm> listATForms = new ArrayList<ATForm>(values);
		return listATForms;
	}
	
	public ArrayList<LeaveForm> getListLeaveForm() {
		HashMap<String, LeaveForm> leaveFormsMap = readLeaveFormMap();
		Collection<LeaveForm> values = leaveFormsMap.values();
		ArrayList<LeaveForm> listLeaveForms = new ArrayList<LeaveForm>(values);
		return listLeaveForms;
	}
	
	public ArrayList<SystemUser> getListSystemUser() {
		HashMap<String, SystemUser> systemUserMap = readSystemUserMap();
		Collection<SystemUser> values = systemUserMap.values();
		ArrayList<SystemUser> listSystemUsers = new ArrayList<SystemUser>(values);
		return listSystemUsers;
	}
	
	public ArrayList<FormStatusServiceImpl> getListFormStatus() {
		HashMap<String, FormStatusServiceImpl> formStatusMap = readFormStatusMap();
		Collection<FormStatusServiceImpl> values = formStatusMap.values();
		ArrayList<FormStatusServiceImpl> listFormStatus = new ArrayList<FormStatusServiceImpl>(values);
		return listFormStatus;
	}
	
	public FormLog getFormLogByFormCode(String formCode) {
		HashMap<String, FormLog> formLogMaps = readFormLogMap();
		FormLog formLog = formLogMaps.get(formCode);
		return formLog;
	}
	
	public SystemUser getSystemUserByUserName(String user_name) {
		ArrayList<SystemUser> listSystemUsers = getListSystemUser();
		for (SystemUser systemUser: listSystemUsers) {
			if (systemUser.getUser_name().equals(user_name)) {
				return systemUser;
			}
		}
		return null;
	}
	
	public FormStatusServiceImpl getFromStatusByValue(String statusId) {
		ArrayList<FormStatusServiceImpl> listFormStatus = getListFormStatus();
		for (FormStatusServiceImpl formStatus: listFormStatus) {
			if (formStatus.getStatusID() == statusId) {
				return formStatus;
			}
		}
		return null;		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, EmployeeServiceImpl> readEmployeeServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, EmployeeServiceImpl>) readFromStorage(StorageType.EMPLOYEE);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, StepApproverServiceImpl> readStepApproverServiceImplMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, StepApproverServiceImpl>) readFromStorage(StorageType.STEP_APPROVER);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, StepApprover> readStepApproverMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, StepApprover>) readFromStorage(StorageType.STEP_APPROVER);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, FormApprover> readFormApproverMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, FormApprover>) readFromStorage(StorageType.FORM_APPROVER);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, FormStatusServiceImpl> readFormStatusMap() {
		// TODO Auto-generated method stub
		return (HashMap<String, FormStatusServiceImpl>) readFromStorage(StorageType.FORM_STATUS);
	}
	
	/*public HashMap<String, DepartmentApproverRepository> readApprovalMap() {
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
	}*/
	
	
	/*
	public void saveNewUser(User user) {
		// TODO Auto-generated method stub
		HashMap<String, User> users = readUserMap();
		String street = address.getStreet();
		users.put(street, address);
		saveToStorage(StorageType.USERS, users);

	}

	public void saveNewApproval(DepartmentApproverRepository approval) {
		// TODO Auto-generated method stub

	}

	public void saveNewApproval(DepartmentApprover approval) {
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

	}*/
	
	public void saveNewOTFormServiceImpl(OTFormServiceImpl oTForm) {
		// TODO Auto-generated method stub
		HashMap<String, OTFormServiceImpl> oTForms = readOTFormServiceImplMap();
		String formCode = oTForm.getFormCode();
		oTForms.put(formCode, oTForm);
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
	
	public void saveNewOTForm(OTForm oTForm) {
		// TODO Auto-generated method stub
		HashMap<String, OTForm> oTForms = readOTFormMap();
		String formCode = oTForm.getFormCode();
		oTForms.put(formCode, oTForm);
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
			
	public void saveNewATForm(ATForm aTForm) {
		// TODO Auto-generated method stub
		HashMap<String, ATForm> aTForms = readATFormMap();
		String formCode = aTForm.getFormCode();
		aTForms.put(formCode, aTForm);
		saveToStorage(StorageType.AT_FORM, aTForms);
	}
				
	public void saveNewLeaveForm(LeaveForm leaveForm) {
		// TODO Auto-generated method stub
		HashMap<String, LeaveForm> leaveForms = readLeaveFormMap();
		String formCode = leaveForm.getFormCode();
		leaveForms.put(formCode, leaveForm);
		saveToStorage(StorageType.LEAVE_FORM, leaveForms);
	}
				
	public void saveNewDepartmentApprover(DepartmentApprover departmentApprover) {
		// TODO Auto-generated method stub
		HashMap<String, DepartmentApprover> departmentApprovers = readDepartmentApproverMap();
		String deptID = departmentApprover.getDeptID();
		departmentApprovers.put(deptID, departmentApprover);
		saveToStorage(StorageType.DEPARTMENT_APPROVER, departmentApprovers);
	}
	
	public void saveNewDepartment(Department department) {
		// TODO Auto-generated method stub
		HashMap<String, Department> departments = readDepartmentMap();
		String deptID = department.getDeptID();
		departments.put(deptID, department);
		saveToStorage(StorageType.DEPARTMENT, departments);
	}
	
	
	/*public void saveNewEmployee(EmployeeServiceImpl employee) {
		// TODO Auto-generated method stub
		HashMap<String, EmployeeServiceImpl> employees = readEmployeeServiceImplMap();
		String empID = employee.getEmpID();
		employees.put(empID, employee);
		saveToStorage(StorageType.EMPLOYEE, employees);
	}*/
	
	public void saveNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		HashMap<String, Employee> employees = readEmployeeMap();
		String empID = employee.getEmpID();
		employees.put(empID, employee);
		saveToStorage(StorageType.EMPLOYEE, employees);
	}
	
	/*public void saveNewStepApprover(StepApproverServiceImpl stepApprover) {
		// TODO Auto-generated method stub
		HashMap<String, StepApproverServiceImpl> stepApprovers = readStepApproverServiceImplMap();
		String aproverID = stepApprover.getAproverID();
		stepApprovers.put(aproverID, stepApprover);
		saveToStorage(StorageType.STEP_APPROVER, stepApprovers);
	}*/
	
	public void saveNewStepApprover(StepApprover stepApprover) {
		// TODO Auto-generated method stub
		HashMap<String, StepApprover> stepApprovers = readStepApproverMap();
		String aproverID = stepApprover.getAproverID();
		stepApprovers.put(aproverID, stepApprover);
		saveToStorage(StorageType.STEP_APPROVER, stepApprovers);
	}
	
	public void saveNewFormApprover(FormApprover formApprover) {
		// TODO Auto-generated method stub
		HashMap<String, FormApprover> formApprovers = readFormApproverMap();
		String formCode = formApprover.getFormCode();
		formApprovers.put(formCode, formApprover);
		saveToStorage(StorageType.FORM_APPROVER, formApprovers);
	}
	
	public void saveNewSystemUser(SystemUser systemUser) {
		// TODO Auto-generated method stub
		HashMap<String, SystemUser> systemUsers = readSystemUserMap();
		String id = systemUser.getId();
		systemUsers.put(id, systemUser);
		saveToStorage(StorageType.SYSTEM_USER, systemUsers);
	}
	
	public void saveNewFormLog(FormLog formLog) {
		// TODO Auto-generated method stub
		HashMap<String, FormLog> formLogs = readFormLogMap();
		String formCode = formLog.getFormCode();
		formLogs.put(formCode, formLog);
		saveToStorage(StorageType.FORM_LOG, formLogs);
	}
	
	public void removeOTForm(String formCode) {
		HashMap<String, OTFormServiceImpl> oTForms = readOTFormServiceImplMap();
		oTForms.remove(formCode);		
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
	
	public void removeATForm(String formCode) {
		HashMap<String, ATFormServiceImpl> aTForms = readATFormServiceImplMap();
		aTForms.remove(formCode);		
		saveToStorage(StorageType.AT_FORM, aTForms);
	}
	
	public void removeLeaveForm(String formCode) {
		HashMap<String, LeaveForm> leaveForms = readLeaveFormMap();
		leaveForms.remove(formCode);		
		saveToStorage(StorageType.LEAVE_FORM, leaveForms);
	}
	
	public void removeDepartmentApprover(String deptID) {
		HashMap<String, DepartmentApprover> departmentApprovers = readDepartmentApproverMap();
		departmentApprovers.remove(deptID);		
		saveToStorage(StorageType.DEPARTMENT_APPROVER, departmentApprovers);
	}
	
	public void removeDepartment(String deptID) {
		HashMap<String, Department> departments = readDepartmentMap();
		departments.remove(deptID);		
		saveToStorage(StorageType.DEPARTMENT, departments);
	}
	
	public void removeEmployee(String empID) {
		HashMap<String, EmployeeServiceImpl> employees = readEmployeeServiceImplMap();
		employees.remove(empID);		
		saveToStorage(StorageType.EMPLOYEE, employees);
	}
	
	public void removeStepApprover(String aproverID) {
		// TODO Auto-generated method stub
		HashMap<String, StepApproverServiceImpl> stepApprovers = readStepApproverServiceImplMap();
		stepApprovers.remove(aproverID);
		saveToStorage(StorageType.STEP_APPROVER, stepApprovers);
	}
	
	public void removeFormApprover(String formCode) {
		// TODO Auto-generated method stub
		HashMap<String, FormApprover> formApprovers = readFormApproverMap();
		formApprovers.remove(formCode);
		saveToStorage(StorageType.FORM_APPROVER, formApprovers);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void removeSystemUser(SystemUser id) {
		// TODO Auto-generated method stub
		HashMap<String, SystemUser> systemUsers = readSystemUserMap();
		systemUsers.remove(id);
		saveToStorage(StorageType.SYSTEM_USER, systemUsers);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void removeFormLog(FormLog formCode) {
		// TODO Auto-generated method stub
		HashMap<String, FormLog> formLogs = readFormLogMap();
		formLogs.remove(formCode);
		saveToStorage(StorageType.FORM_LOG, formLogs);
	}
	
	public void updateOTForm(OTForm oTForm) {
		// TODO Auto-generated method stub
		HashMap<String, OTForm> oTForms = readOTFormMap();
		String formCode = oTForm.getFormCode();
		oTForms.replace(formCode, oTForm);
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
		
	public void updateATForm(ATForm aTForm) {
		// TODO Auto-generated method stub
		HashMap<String, ATForm> aTForms = readATFormMap();
		String formCode = aTForm.getFormCode();
		aTForms.replace(formCode, aTForm);
		saveToStorage(StorageType.AT_FORM, aTForms);
	}
	
	public void updateLeaveForm(LeaveForm leaveForm) {
		// TODO Auto-generated method stub
		HashMap<String, LeaveForm> leaveForms = readLeaveFormMap();
		String formCode = leaveForm.getFormCode();
		leaveForms.replace(formCode, leaveForm);
		saveToStorage(StorageType.LEAVE_FORM, leaveForms);
	}
	
	public void updateDepartmentApprover(DepartmentApprover departmentApprover) {
		// TODO Auto-generated method stub
		HashMap<String, DepartmentApprover> departmentApprovers = readDepartmentApproverMap();
		String deptID = departmentApprover.getDeptID();
		departmentApprovers.replace(deptID, departmentApprover);
		saveToStorage(StorageType.DEPARTMENT_APPROVER, departmentApprovers);
	}
	
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		HashMap<String, Department> departments = readDepartmentMap();
		String deptID = department.getDeptID();
		departments.replace(deptID, department);
		saveToStorage(StorageType.DEPARTMENT, departments);
	}
		
	public void updateEmployee(Employee employee) {
		HashMap<String, Employee> employees = readEmployeeMap();
		String empID = employee.getEmpID();
		employees.replace(empID, employee);
		saveToStorage(StorageType.EMPLOYEE, employees);
	}
	
	public void updateStepApprover(StepApprover stepApprover) {
		// TODO Auto-generated method stub
		HashMap<String, StepApprover> stepApprovers = readStepApproverMap();
		String aproverID = stepApprover.getAproverID();
		stepApprovers.replace(aproverID, stepApprover);
		saveToStorage(StorageType.STEP_APPROVER, stepApprovers);
	}
	
	public void updateFormApprover(FormApprover formApprover) {
		// TODO Auto-generated method stub
		HashMap<String, FormApprover> formApprovers = readFormApproverMap();
		String formCode = formApprover.getFormCode();
		formApprovers.replace(formCode, formApprover);
		saveToStorage(StorageType.FORM_APPROVER, formApprovers);
	}
	
	public void updateSystemUser(SystemUser systemUser) {
		// TODO Auto-generated method stub
		HashMap<String, SystemUser> systemUsers = readSystemUserMap();
		String id = systemUser.getId();
		systemUsers.replace(id, systemUser);
		saveToStorage(StorageType.SYSTEM_USER, systemUsers);
	}
		
	static void loadUserMap(List<UserServiceImpl> allUsers) {
		HashMap<String, UserServiceImpl> users = new HashMap<String, UserServiceImpl>();
		allUsers.forEach(user -> users.put(user.getEmpID(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void loadSystemUserMap(List<SystemUser> allSystemUsers) {
		HashMap<String, SystemUser> systemUsers = new HashMap<String, SystemUser>();
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

	/*static void loadLeaveFormsMap(List<LeaveFormServiceImpl> allLeaveForms) {
		HashMap<String, LeaveFormServiceImpl> leaveForms = new HashMap<String, LeaveFormServiceImpl>();
		allLeaveForms.forEach(leaveForm -> leaveForms.put(leaveForm.getFormCode(), leaveForm));
		saveToStorage(StorageType.LEAVE_FORM, leaveForms);
	}*/
	
	static void loadLeaveFormsMap(List<LeaveForm> allLeaveForms) {
		HashMap<String, LeaveForm> leaveForms = new HashMap<String, LeaveForm>();
		allLeaveForms.forEach(leaveForm -> leaveForms.put(leaveForm.getFormCode(), leaveForm));
		saveToStorage(StorageType.LEAVE_FORM, leaveForms);
	}

	/*static void loadOTFormsMap(List<OTFormServiceImpl> allOTForms) {
		HashMap<String, OTFormServiceImpl> oTForms = new HashMap<String, OTFormServiceImpl>();
		allOTForms.forEach(oTForm -> oTForms.put(oTForm.getFormCode(), oTForm));
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
*/	
	static void loadOTFormsMap(List<OTForm> allOTForms) {
		HashMap<String, OTForm> oTForms = new HashMap<String, OTForm>();
		allOTForms.forEach(oTForm -> oTForms.put(oTForm.getFormCode(), oTForm));
		saveToStorage(StorageType.OT_FORM, oTForms);
	}
	
	/*static void loadATFormsMap(List<ATFormServiceImpl> allATForms) {
		HashMap<String, ATFormServiceImpl> aTForms = new HashMap<String, ATFormServiceImpl>();
		allATForms.forEach(aTForm -> aTForms.put(aTForm.getFormCode(), aTForm));
		saveToStorage(StorageType.AT_FORM, aTForms);
	}*/
	
	static void loadATFormsMap(List<ATForm> allATForms) {
		HashMap<String, ATForm> aTForms = new HashMap<String, ATForm>();
		allATForms.forEach(aTForm -> aTForms.put(aTForm.getFormCode(), aTForm));
		saveToStorage(StorageType.AT_FORM, aTForms);
	}
	
	/*static void loadDepartmentApproversMap(List<DepartmentApproverServiceImpl> allDepartmentApprovers) {
		HashMap<String, DepartmentApproverServiceImpl> departmentApprovers = new HashMap<String, DepartmentApproverServiceImpl>();
		allDepartmentApprovers.forEach(departmentApprover -> departmentApprovers.put(departmentApprover.getDeptID(), departmentApprover));
		saveToStorage(StorageType.DEPARTMENT_APPROVER, departmentApprovers);
	}*/
	
	static void loadDepartmentApproversMap(List<DepartmentApprover> allDepartmentApprovers) {
		HashMap<String, DepartmentApprover> departmentApprovers = new HashMap<String, DepartmentApprover>();
		allDepartmentApprovers.forEach(departmentApprover -> departmentApprovers.put(departmentApprover.getDeptID(), departmentApprover));
		saveToStorage(StorageType.DEPARTMENT_APPROVER, departmentApprovers);
	}
	
	static void loadEmployeesMap(List<EmployeeServiceImpl> allEmployees) {
		HashMap<String, EmployeeServiceImpl> employees = new HashMap<String, EmployeeServiceImpl>();
		allEmployees.forEach(employee -> employees.put(employee.getEmpID(), employee));
		saveToStorage(StorageType.EMPLOYEE, employees);
	}
	
	static void loadStepApproversMap(List<StepApproverServiceImpl> allStepApprovers) {
		HashMap<String, StepApproverServiceImpl> stepApprovers = new HashMap<String, StepApproverServiceImpl>();
		allStepApprovers.forEach(stepApprover -> stepApprovers.put(stepApprover.getAproverID(), stepApprover));
		saveToStorage(StorageType.STEP_APPROVER, stepApprovers);
	}
	
	static void loadFormApproversMap(List<FormApprover> allFormApprovers) {
		HashMap<String, FormApprover> formApprovers = new HashMap<String, FormApprover>();
		allFormApprovers.forEach(formApprover -> formApprovers.put(formApprover.getFormCode(), formApprover));
		saveToStorage(StorageType.FORM_APPROVER, formApprovers);
	}
	
	static void loadDepartmentsMap(List<Department> allDepartments) {
		HashMap<String, Department> departments = new HashMap<String, Department>();
		allDepartments.forEach(department -> departments.put(department.getDeptID(), department));
		saveToStorage(StorageType.DEPARTMENT, departments);
	}
	
	static void loadFormStatusMap(List<FormStatusServiceImpl> allFormStatus) {
		HashMap<String, FormStatusServiceImpl> formStatuss = new HashMap<String, FormStatusServiceImpl>();
		allFormStatus.forEach(formStatus -> formStatuss.put(formStatus.getStatusID(), formStatus));
		saveToStorage(StorageType.FORM_STATUS, formStatuss);
	}
	
	/*static void loadFormStatusMap(List<FormStatus> allFormStatus) {
		HashMap<String, FormStatus> formStatuss = new HashMap<String, FormStatus>();
		allFormStatus.forEach(formStatus -> formStatuss.put(formStatus.getValue()), formStatus));
		saveToStorage(StorageType.FORM_STATUS, formStatuss);
	}*/
	
	static void loadFormLogsMap(List<FormLog> allFormLogs) {
		HashMap<String, FormLog> formLogs = new HashMap<String, FormLog>();
		allFormLogs.forEach(formLog -> formLogs.put(formLog.getFormCode(), formLog));
		saveToStorage(StorageType.FORM_LOG, formLogs);
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
