package com.hr.domain.report;

import java.util.Date;

import com.hr.domain.Department;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReport implements HRReport{

	@Override
	public void reportByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		da.getListDepartmentApprover();
		da.getListOTForm();
		da.readOTForm();
	}

	@Override
	public void reportByDepartment(String department) {
		// TODO Auto-generated method
		
	}

	

}
