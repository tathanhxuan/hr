package com.hr.repository.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.hr.domain.User;
import com.hr.repository.Auth;
import com.hr.repository.DataAccessRepository;
import com.hr.service.impl.AttendanceServiceImpl;
import com.hr.service.impl.OvertimeServiceImpl;
import com.hr.service.impl.ShiftServiceImpl;
import com.hr.service.impl.SystemUserServiceImpl;
import com.hr.service.impl.UserServiceImpl;

public class TestData {

	public static void main(String[] args) {
		TestData td = new TestData();
		td.userData();
		td.systemUserData();
		td.attendanceData();
		td.shiftData();
		td.overtimeData();

		
		DataAccessRepository da = new DataAccessRepositoryFacade();
		System.out.println(da.readUserMap());
		System.out.println(da.readSystemUserMap());
		System.out.println(da.readAttendanceMap());
		System.out.println(da.readShiftMap());
		System.out.println(da.readOvertimeMap());
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

}
