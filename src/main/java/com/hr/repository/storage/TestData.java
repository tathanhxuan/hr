package com.hr.repository.storage;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.FormApprover;
import com.hr.domain.FormLog;
import com.hr.domain.FormStatus;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.domain.SystemUser;
import com.hr.domain.User;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.repository.Auth;
import com.hr.repository.DataAccessRepository;
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

public class TestData implements Serializable {

	public static void main(String[] args) {
		TestData td = new TestData();

		td.systemUserData();
		td.employeesData();
		td.leaveFormsData();		 
		td.aTFormsData();
		td.oTFormsData();
		td.departmentApproversData();
		td.formApproversData();
		td.formLogsData();
		// td.userData();
		// td.attendanceData();
		// td.shiftData();
		// td.overtimeData();

		// td.employeeGroupsData();
		//td.aTFormsData();
		//td.oTFormsData();
		//td.employeesData();
		// td.stepApproversData();
		//td.departmentsData();
		//td.formStatusData();

		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		System.out.println(da.readDepartmentApproverMap());

		// System.out.println(da.readUserMap());
		//System.out.println(da.readSystemUserMap());
		// System.out.println(da.readAttendanceMap());
		// System.out.println(da.readShiftMap());
		// System.out.println(da.readOvertimeMap());

		// System.out.println(da.readEmployeeGroupMap());
		//System.out.println(da.readLeaveFormMap());
		// System.out.println(da.readLeaveFormServiceImplMap());
		
		/*Date date1 = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
		Date date2 = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
		
		LeaveFormServiceImpl leaveForm = new LeaveFormServiceImpl("F004", 1, "101", "Submited", date1, date1, "Des 1");
		
		da.saveNewLeaveForm(leaveForm);

		System.out.println(da.readLeaveFormServiceImplMap());*/
		
		//System.out.println(da.readATFormMap());
		//System.out.println(da.readATForm());

		//System.out.println(da.readOTFormMap());

		//System.out.println(da.readOTFormMap());

		System.out.println(da.readLeaveFormMap());
		//System.out.println(da.readOTForm());
		
		//System.out.println(da.readOTFormMap());
		// System.out.println(da.readOTFormServiceImplMap());
		
		/*Department dept1 = new Department("11", "IT");
		Employee em1 = new Employee("101", dept1);
		FormValidationStrategy fvs1 = new FormValidationStrategy() {

			@Override
			public HashMap<String, String> Validate(Form Model) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		OTFormServiceImpl oTForm1 = new OTFormServiceImpl("OT004", em1, FormStatus.CREATED, fvs1);
		da.saveNewOTForm(oTForm1);
		
		HashMap<String, OTForm> oTForm = da.readOTForm();		
		
		for ( Map.Entry<String, OTForm> entry : oTForm.entrySet()) {
		    String key = entry.getKey();
		    System.out.println("Key: "+ key);
		    System.out.println("Value: "+ oTForm.get(key));
		}*/
		
		//System.out.println(da.readOTFormServiceImplMap());	
		/*DepartmentApproverServiceImpl dep = new DepartmentApproverServiceImpl("D006", "IT", 1, "Son");
		da.saveNewDepartmentApprover(dep);*/
		//System.out.println(da.readDepartmentApproverServiceImplMap());
		//da.removeDepartmentApprover("D002");
		//System.out.println(da.readDepartmentApproverServiceImplMap());
		
		
		/*System.out.println(da.readEmployeeServiceImplMap());
		Date date3 = new GregorianCalendar(1980, Calendar.MAY, 11).getTime();
		EmployeeServiceImpl emp3 = new EmployeeServiceImpl("101", "Azee", date3, "Nigeria", null, null, true);
		da.updateEmployee(emp3);*/
		
		//System.out.println(da.readEmployeeServiceImplMap());
		//System.out.println(da.readStepApproverServiceImplMap());
		//System.out.println(da.readFormApproverMap());
		//System.out.println(da.readDepartmentMap());
		//System.out.println(da.readFormStatusMap());
		System.out.println(da.readFormLogMap());
		//System.out.println(da.readEmployeeMap());
		//System.out.println(da.readSystemUserMap());
		System.out.println("Test data is created successfully!");
	}

	@SuppressWarnings("serial")
	List<UserServiceImpl> allUsers = new ArrayList<UserServiceImpl>() {

		{
			add(new UserServiceImpl(1, "0984968894", "taxuanus@gmail.com", "Ha Noi", "101", "Xuan", "Thanh Xuan Ta",
					"Male", "2013-07-24", "Active", "Full-time", "10", Auth.USER));
			add(new UserServiceImpl(2, "0984968890", "tta@mum.edu", "Sai Gon", "102", "Thai", "Huu Thai Ho", "Male",
					"1982-07-24", "Active", "Full-time", "10", Auth.ADMIN));
			add(new UserServiceImpl(3, "0984968896", "azeez@mum.edu", "Nigeria", "103", "Azeez", "Azeez Alka", "Male",
					"1989-04-24", "Active", "Full-time", "10", Auth.ADMIN));

		}
	};

	// create users
	public void userData() {
		DataAccessRepositoryFacade.loadUserMap(allUsers);
	}

	/*@SuppressWarnings("serial")
	List<SystemUserServiceImpl> allSystemUsers = new ArrayList<SystemUserServiceImpl>() {

		{
			add(new SystemUserServiceImpl("11", "admin", "123", "1"));
			add(new SystemUserServiceImpl("22", "supervisor", "12345", "2"));
		}
	};*/
	
	@SuppressWarnings("serial")
	List<SystemUser> allSystemUsers = new ArrayList<SystemUser>() {

		{
			add(new SystemUser("1", "admin", "123", "102", true, true));
			add(new SystemUser("5", "manager1", "123", "105", true, true));
			add(new SystemUser("6", "manager2", "123", "106", true, true));
			add(new SystemUser("7", "manager3", "123", "107", true, true));
			
			add(new SystemUser("2", "thai", "12345", "101", false, false));
			
			add(new SystemUser("3", "azee", "456", "103", true, false));
			add(new SystemUser("4", "bee", "4567", "104", false, true));
		}
	};

	// create system users
	public void systemUserData() {
		DataAccessRepositoryFacade.loadSystemUserMap(allSystemUsers);
	}

	@SuppressWarnings("serial")
	List<AttendanceServiceImpl> allAttendances = new ArrayList<AttendanceServiceImpl>() {

		{
			add(new AttendanceServiceImpl("1", "101", "1", "18:00", "9:00", "27-01-2019", "approved"));
			add(new AttendanceServiceImpl("2", "102", "2", "18:00", "10:00", "28-01-2019", "pending"));

		}
	};

	// create attendances
	public void attendanceData() {
		DataAccessRepositoryFacade.loadAttendancesMap(allAttendances);
	}

	@SuppressWarnings("serial")
	List<ShiftServiceImpl> allShifts = new ArrayList<ShiftServiceImpl>() {

		{
			add(new ShiftServiceImpl("1", "18:00", "9:00"));
			add(new ShiftServiceImpl("2", "18:00", "10:00"));

		}
	};

	// create shifts
	public void shiftData() {
		DataAccessRepositoryFacade.loadShiftsMap(allShifts);
	}

	@SuppressWarnings("serial")
	List<OvertimeServiceImpl> allOvertimes = new ArrayList<OvertimeServiceImpl>() {

		{
			add(new OvertimeServiceImpl("101", "11", "21:00", "20:00", "10", "21-01-2019"));
			add(new OvertimeServiceImpl("102", "12", "22:00", "19:00", "10", "22-01-2019"));

		}
	};

	// create shifts
	public void overtimeData() {
		DataAccessRepositoryFacade.loadOvertimesMap(allOvertimes);
	}

	@SuppressWarnings("serial")
	List<EmployeeGroupServiceImpl> allEmployeeGroups = new ArrayList<EmployeeGroupServiceImpl>() {

		{
			add(new EmployeeGroupServiceImpl("1", "Dev 1", "Group 1"));
			add(new EmployeeGroupServiceImpl("2", "Dev 2", "Group 2"));

		}
	};

	// create employee_groups
	public void employeeGroupsData() {
		DataAccessRepositoryFacade.loadEmployeeGroupsMap(allEmployeeGroups);
	}

	@SuppressWarnings("serial")
	List<LeaveForm> allLeaveForms = new ArrayList<LeaveForm>() {

		{

			Department dept1 = new Department("D001", "IT");
			Employee em1 = new Employee("101", dept1);
			em1.setEmpName("Emp1");
			Date date1 = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
			Date date2 = new GregorianCalendar(2018, Calendar.FEBRUARY, 12).getTime();
			
			Department dept2 = new Department("D002", "HR");
			Employee em2 = new Employee("102", dept2);
			em2.setEmpName("Emp2");
			Date date3 = new GregorianCalendar(2018, Calendar.FEBRUARY, 16).getTime();
			Date date4 = new GregorianCalendar(2018, Calendar.FEBRUARY, 17).getTime();

			//add(new LeaveForm(em1, date1, date2));
			//add(new LeaveForm(em2, date3, date4));
			LeaveForm leaveForm1 = new LeaveForm(em1);
			leaveForm1.setLeaveDateFrom(date1);
			leaveForm1.setLeaveDateTo(date2);
			leaveForm1.setOwner(em1);
			leaveForm1.setDescription("Request Approved");
			leaveForm1.setStatus(FormStatus.CREATED);
			add(leaveForm1);
			
			LeaveForm leaveForm2 = new LeaveForm(em2);
			leaveForm2.setLeaveDateFrom(date3);
			leaveForm2.setLeaveDateTo(date4);
			leaveForm2.setOwner(em2);
			leaveForm2.setDescription("Request Approved");
			leaveForm2.setStatus(FormStatus.CREATED);
			add(leaveForm2);
			//add(new LeaveForm("F001", 1, "101", FormStatus.APPROVED_1ST, date1, date1, "Des 1"));
			//add(new LeaveForm("F002", 1, "102", FormStatus.APPROVED_2ND, date2, date2, "Des 2"));

		}
	};

	// create leave_forms
	public void leaveFormsData() {
		DataAccessRepositoryFacade.loadLeaveFormsMap(allLeaveForms);
	}

	@SuppressWarnings("serial")
	List<OTForm> allOTForms = new ArrayList<OTForm>() {

		{

			Department dept1 = new Department("D001", "IT");
			Employee em1 = new Employee("101", dept1);
			em1.setEmpName("Emp1");
			FormValidationStrategy fvs1 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			Department dept2 = new Department("D002", "HR");
			Employee em2 = new Employee("102", dept2);
			em2.setEmpName("Emp2");
			FormValidationStrategy fvs2 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
			Date date2 = new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime();
			
			OTForm aTForm1 = new OTForm(em1);
			aTForm1.setOTDate(date1);
			aTForm1.setTimeFrom("20:20");
			aTForm1.setTimeTo("21:10");
			aTForm1.setOwner(em1);
			
			OTForm aTForm2 = new OTForm(em2);
			aTForm2.setOTDate(date2);
			aTForm2.setTimeFrom("19:20");
			aTForm2.setTimeTo("21:10");
			aTForm2.setOwner(em2);

			//add(new OTForm(em1, date1,  "19:00", "21:00"));
			//add(new OTForm(em2, date2,  "20:00", "22:00"));
			add(aTForm1);
			add(aTForm2);
			//add(new OTForm("OT002", em2, FormStatus.APPROVED_2ND, fvs2));

		}
	};

	// create ot_forms
	public void oTFormsData() {
		DataAccessRepositoryFacade.loadOTFormsMap(allOTForms);
	}
	
	@SuppressWarnings("serial")
	List<ATForm> allATForms = new ArrayList<ATForm>() {

		{

			Department dept1 = new Department("D001", "IT");
			Employee em1 = new Employee("101", dept1);
			em1.setEmpName("Emp1");
			FormValidationStrategy fvs1 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			Department dept2 = new Department("D002", "HR");
			Employee em2 = new Employee("102", dept2);
			em2.setEmpName("Emp2");
			FormValidationStrategy fvs2 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
			Date date2 = new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime();
			//add(new ATForm(em1, date1, "20:20", "21:10"));
			//add(new ATForm(em2, date2, "19:20", "20:10"));
			ATForm aTForm1 = new ATForm(em1);
			aTForm1.setATDate(date1);
			aTForm1.setTimeIn("20:20");
			aTForm1.setTimeOut("21:10");
			aTForm1.setOwner(em1);
			aTForm1.setATDate(date1);
			
			ATForm aTForm2 = new ATForm(em2);
			aTForm2.setATDate(date1);
			aTForm2.setTimeIn("19:20");
			aTForm2.setTimeOut("21:10");
			aTForm2.setOwner(em2);
			aTForm2.setATDate(date1);
			
			add(aTForm1);
			add(aTForm2);
			//add(new ATForm("AT003", em1, FormStatus.APPROVED_1ST, fvs1));
			//add(new ATForm("AT004", em2, FormStatus.APPROVED_2ND, fvs2));

		}
	};

	// create at_forms
	public void aTFormsData() {
		DataAccessRepositoryFacade.loadATFormsMap(allATForms);
	}
	
	/*@SuppressWarnings("serial")
	List<DepartmentApproverServiceImpl> allDepartmentApprovers = new ArrayList<DepartmentApproverServiceImpl>() {

		{			
			add(new DepartmentApproverServiceImpl("D001", "IT", 1, "Thai"));
			add(new DepartmentApproverServiceImpl("D002", "IT", 2, "Xuan"));
			add(new DepartmentApproverServiceImpl("D003", "IT", 3, "Azeez"));
		}
	};

	// create department approver
	public void departmentApproversData() {
		DataAccessRepositoryFacade.loadDepartmentApproversMap(allDepartmentApprovers);
	}*/
	
	@SuppressWarnings("serial")
	List<DepartmentApprover> allDepartmentApprovers = new ArrayList<DepartmentApprover>() {

		{			
			
			//add(new DepartmentApprover("D002", "HR", 2, "102", "Thai"));
			
			add(new DepartmentApprover("1", "D001", "IT", 2, "105", "Manager1"));
			add(new DepartmentApprover("2", "D001", "IT", 3, "106", "Manager2"));
			add(new DepartmentApprover("3", "D001", "IT", 4, "107", "Manager3"));
			add(new DepartmentApprover("4", "D003", "Admin", 3, "103", "Azeez"));
			add(new DepartmentApprover("5", "D004", "Sale", 4, "104", "Bee"));
		}
	};

	// create department approver
	public void departmentApproversData() {
		DataAccessRepositoryFacade.loadDepartmentApproversMap(allDepartmentApprovers);
	}
	
	@SuppressWarnings("serial")
	List<Employee> allEmployees = new ArrayList<Employee>() {

		{			
			Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
			
			Department dept1 = new Department("D001", "IT");
			Employee em1 = new Employee("101", dept1);
			em1.setEmpName("Ho Huu Thai");
			em1.setAddress("100 Noth Street");
			em1.setDateOfBirth(date1);
			em1.setIsApprover(true);
			add(em1);
			
			
			
			Date date2 = new GregorianCalendar(1982, Calendar.FEBRUARY, 12).getTime();
			Department dept2 = new Department("D002", "HR");
			Employee em2 = new Employee("102", dept2);
			em2.setEmpName("Emp2");
			em2.setAddress("200 Noth Street");
			em2.setDateOfBirth(date2);
			em2.setIsApprover(true);
			add(em2);
			
			Date date3 = new GregorianCalendar(1985, Calendar.MARCH, 13).getTime();
			Department dept3 = new Department("D003", "Admin");
			Employee em3 = new Employee("103", dept3);
			em3.setEmpName("Emp3");
			em3.setAddress("300 Noth Street");
			em3.setDateOfBirth(date3);
			em3.setIsApprover(false);
			add(em3);
			
			Date date4 = new GregorianCalendar(1989, Calendar.APRIL, 14).getTime();
			Department dept4 = new Department("D004", "Sale");
			Employee em4 = new Employee("104", dept4);
			em4.setEmpName("Emp4");
			em4.setAddress("400 Noth Street");
			em4.setDateOfBirth(date4);
			em4.setIsApprover(true);
			add(em4);
			
			Department dept5 = new Department("D001", "IT");
			Employee em5 = new Employee("105", dept5);
			em5.setEmpName("Manager1");
			em5.setAddress("100 Noth Street");
			em5.setDateOfBirth(date1);
			em5.setIsApprover(true);
			add(em5);
			
			Department dept6 = new Department("D001", "IT");
			Employee em6 = new Employee("106", dept6);
			em6.setEmpName("Manager2");
			em6.setAddress("100 Noth Street");
			em6.setDateOfBirth(date1);
			em6.setIsApprover(true);
			add(em6);
			
			Department dept7 = new Department("D001", "IT");
			Employee em7 = new Employee("107", dept7);
			em7.setEmpName("Manager3");
			em7.setAddress("100 Noth Street");
			em7.setDateOfBirth(date1);
			em7.setIsApprover(true);
			add(em7);
			
			
			//add(new Employee("101", "Azee", date1, "Nigeria", null, null, true));
			
			//add(new Employee("102", "Thai", date2, "Ha Noi", null, null, true));
		}
	};

	// create Employees
	public void employeesData() {
		DataAccessRepositoryFacade.loadEmployeesMap(allEmployees);
	}
	
	
	@SuppressWarnings("serial")
	List<StepApproverServiceImpl> allStepApprovers = new ArrayList<StepApproverServiceImpl>() {

		{
			add(new StepApproverServiceImpl("101", "Approve Step", "Approve Date", "comments", null));
			add(new StepApproverServiceImpl("102", "Approve Step2", "Approve Date2", "comments2", null));
		}
	};

	// create Employees
	public void stepApproversData() {
		DataAccessRepositoryFacade.loadStepApproversMap(allStepApprovers);
	}
	
	@SuppressWarnings("serial")
	List<FormApprover> allFormApprovers = new ArrayList<FormApprover>() {

		{
			add(new FormApprover("OT10222_20190202_213925", 1, "Xuan"));
			add(new FormApprover("AT10222_20190202_162536", 3, "Thai"));
			//add(new FormApprover("102", "Approve Step2", "Approve Date2", "comments2", null));
		}
	};

	// create Employees
	public void formApproversData() {
		DataAccessRepositoryFacade.loadFormApproversMap(allFormApprovers);
	}
	
	@SuppressWarnings("serial")
	List<Department> allDepartments = new ArrayList<Department>() {

		{
			add(new Department("D001", "IT"));
			add(new Department("D002", "HR"));
			add(new Department("D003", "Admin"));
			add(new Department("D004", "Sale"));
		}
	};

	// create Employees
	public void departmentsData() {
		DataAccessRepositoryFacade.loadDepartmentsMap(allDepartments);
	}
	
	@SuppressWarnings("serial")
	List<FormStatusServiceImpl> allFormStatus = new ArrayList<FormStatusServiceImpl>() {

		{
			add(new FormStatusServiceImpl("1", "CREATED"));
			add(new FormStatusServiceImpl("2", "APPROVED_1ST"));
			add(new FormStatusServiceImpl("3", "APPROVED_2ND"));
			add(new FormStatusServiceImpl("4", "HRACCEPTED"));
			add(new FormStatusServiceImpl("5", "HRACCEPTED"));
			
		}
	};

	// create Employees
	public void formStatusData() {
		DataAccessRepositoryFacade.loadFormStatusMap(allFormStatus);
	}
	
	@SuppressWarnings("serial")
	List<FormLog> allFormLogs = new ArrayList<FormLog>() {

		{
			//Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
			//Date date2 = new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime();
			add(new FormLog("AT10222_20190202_162536", "101", "CREATED", "Created AT form"));
			add(new FormLog("OT10222_20190202_213925", "102", "APPROVED_1ST", "Created OT form"));								
			
		}
	};

	// create Employees
	public void formLogsData() {
		DataAccessRepositoryFacade.loadFormLogsMap(allFormLogs);
	}

}
