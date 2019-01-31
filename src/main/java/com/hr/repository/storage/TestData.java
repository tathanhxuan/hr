package com.hr.repository.storage;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hr.domain.Department;
import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.FormApprover;
import com.hr.domain.FormStatus;
import com.hr.domain.OTForm;
import com.hr.domain.User;
import com.hr.domain.HRFormCore.FormValidationStrategy;
import com.hr.repository.Auth;
import com.hr.repository.DataAccessRepository;
import com.hr.service.impl.ATFormServiceImpl;
import com.hr.service.impl.AttendanceServiceImpl;
import com.hr.service.impl.DepartmentApproverServiceImpl;
import com.hr.service.impl.EmployeeGroupServiceImpl;
import com.hr.service.impl.EmployeeServiceImpl;
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

		// td.userData();
		// td.systemUserData();
		// td.attendanceData();
		// td.shiftData();
		// td.overtimeData();

		// td.employeeGroupsData();
		// td.leaveFormsData();		 
		// td.aTFormsData();
		 td.oTFormsData();
		td.departmentApproversData();
		// td.employeesData();
		// td.stepApproversData();
		//td.formApproversData();

		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();

		// System.out.println(da.readUserMap());
		// System.out.println(da.readSystemUserMap());
		// System.out.println(da.readAttendanceMap());
		// System.out.println(da.readShiftMap());
		// System.out.println(da.readOvertimeMap());

		// System.out.println(da.readEmployeeGroupMap());
		// System.out.println(da.readLeaveFormMap());
		// System.out.println(da.readLeaveFormServiceImplMap());
		
		/*Date date1 = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
		Date date2 = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
		
		LeaveFormServiceImpl leaveForm = new LeaveFormServiceImpl("F004", 1, "101", "Submited", date1, date1, "Des 1");
		
		da.saveNewLeaveForm(leaveForm);

		System.out.println(da.readLeaveFormServiceImplMap());*/
		
		// System.out.println(da.readATFormMap());
		// System.out.println(da.readATForm());
		// System.out.println(da.readOTFormMap());
		System.out.println(da.readOTForm());
		
		// System.out.println(da.readOTFormMap());
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
		System.out.println(da.readDepartmentApproverMap());
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

	@SuppressWarnings("serial")
	List<SystemUserServiceImpl> allSystemUsers = new ArrayList<SystemUserServiceImpl>() {

		{
			add(new SystemUserServiceImpl("11", "admin", "123", "1"));
			add(new SystemUserServiceImpl("22", "supervisor", "12345", "2"));
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
	List<LeaveFormServiceImpl> allLeaveForms = new ArrayList<LeaveFormServiceImpl>() {

		{

			Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
			Date date2 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

			add(new LeaveFormServiceImpl("F001", 1, "101", FormStatus.APPROVED, date1, date1, "Des 1"));
			add(new LeaveFormServiceImpl("F002", 1, "102", FormStatus.REFUSED, date2, date2, "Des 2"));

		}
	};

	// create leave_forms
	public void leaveFormsData() {
		DataAccessRepositoryFacade.loadLeaveFormsMap(allLeaveForms);
	}

	@SuppressWarnings("serial")
	List<OTFormServiceImpl> allOTForms = new ArrayList<OTFormServiceImpl>() {

		{

			Department dept1 = new Department("11", "IT");
			Employee em1 = new Employee("101", dept1);
			FormValidationStrategy fvs1 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			Department dept2 = new Department("22", "HR");
			Employee em2 = new Employee("102", dept2);
			FormValidationStrategy fvs2 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};

			add(new OTFormServiceImpl("OT001", em1, FormStatus.APPROVED, fvs1));
			add(new OTFormServiceImpl("OT002", em2, FormStatus.APPROVED, fvs2));

		}
	};

	// create ot_forms
	public void oTFormsData() {
		DataAccessRepositoryFacade.loadOTFormsMap(allOTForms);
	}
	
	@SuppressWarnings("serial")
	List<ATFormServiceImpl> allATForms = new ArrayList<ATFormServiceImpl>() {

		{

			Department dept1 = new Department("11", "IT");
			Employee em1 = new Employee("101", dept1);
			FormValidationStrategy fvs1 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			Department dept2 = new Department("22", "HR");
			Employee em2 = new Employee("102", dept2);
			FormValidationStrategy fvs2 = new FormValidationStrategy() {

				@Override
				public HashMap<String, String> Validate(Form Model) {
					// TODO Auto-generated method stub
					return null;
				}
			};

			add(new ATFormServiceImpl("AT003", em1, FormStatus.APPROVED, fvs1));
			add(new ATFormServiceImpl("AT004", em2, FormStatus.APPROVED, fvs2));

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
			add(new DepartmentApprover("D001", "IT", 1, "Thai"));
			add(new DepartmentApprover("D002", "IT", 2, "Xuan"));
			add(new DepartmentApprover("D003", "IT", 3, "Azeez"));
		}
	};

	// create department approver
	public void departmentApproversData() {
		DataAccessRepositoryFacade.loadDepartmentApproversMap(allDepartmentApprovers);
	}
	
	@SuppressWarnings("serial")
	List<EmployeeServiceImpl> allEmployees = new ArrayList<EmployeeServiceImpl>() {

		{			
			Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
			Date date2 = new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime();
			add(new EmployeeServiceImpl("101", "Azee", date1, "Nigeria", null, null, true));
			add(new EmployeeServiceImpl("102", "Thai", date2, "Ha Noi", null, null, true));
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
			add(new FormApprover("OT01", 1, "Xuan"));
			add(new FormApprover("OT02", 3, "Thai"));
			//add(new FormApprover("102", "Approve Step2", "Approve Date2", "comments2", null));
		}
	};

	// create Employees
	public void formApproversData() {
		DataAccessRepositoryFacade.loadFormApproversMap(allFormApprovers);
	}

}
