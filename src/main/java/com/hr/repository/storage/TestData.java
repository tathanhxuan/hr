package com.hr.repository.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.hr.domain.User;
import com.hr.repository.Auth;
import com.hr.repository.DataAccessRepository;
import com.hr.service.impl.UserServiceImpl;

public class TestData {
	@SuppressWarnings("serial")
	List<UserServiceImpl> allUsers = new ArrayList<UserServiceImpl>() {

		{
			/*add(new UserServiceImpl(, 1, "taxuanus@gmail.com", "Ha Noi", "Xuan", "Thanh Xuan Ta", "0984968899",  Auth.USER));
			add(new UserServiceImpl("102", 2, "tta@mum.edu", "Sai Gon", "Thai", "Huu Thai Ho", "0984968891",  Auth.ADMIN));
			add(new UserServiceImpl("103", 3, "azeez@mum.edu", "Nigeria", "Azeez", "Azeez Alka", "0984968890",  Auth.BOTH));*/
			add(new UserServiceImpl(1, "0984968899", "taxuanus@gmail.com", "Ha Noi", "101",  "Xuan", "Thanh Xuan Ta", "Male", "2013-07-24", "Active", "Full-time", "10",   Auth.USER));
			add(new UserServiceImpl(2, "0984968890", "tta@mum.edu", "Sai Gon", "102",  "Thai", "Huu Thai Ho", "Male", "1982-07-24", "Active", "Full-time", "10",   Auth.ADMIN));
			add(new UserServiceImpl(3, "0984968896", "azeez@mum.edu", "Nigeria", "103",  "Azeez", "Azeez Alka", "Male", "1989-04-24", "Active", "Full-time", "10",   Auth.ADMIN));

			
			
		}
	};

	public static void main(String[] args) {
		TestData td = new TestData();
		td.userData();
		/*td.bookData();
		td.libraryMemberData();
		td.userData();
		td.authorData();
		td.addressData();*/
		
		DataAccessRepository da = new DataAccessRepositoryFacade();
		System.out.println(da.readUserMap());
	}
	
	//create users
	public void userData() {
		DataAccessRepositoryFacade.loadUserMap(allUsers);
	}

}
