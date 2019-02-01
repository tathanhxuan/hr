package com.hr.domain.reportIterator;

import java.util.HashMap;

import com.hr.domain.ATForm;
import com.hr.domain.OTForm;
import com.hr.domain.report.builder.GeneralReport;
import com.hr.domain.report.builder.GeneralReportBuilder;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
	//	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
	//	DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
	//	HashMap<String, OTForm> atData = data.readOTForm();
		
		GeneralReport.Builder gn = new GeneralReport.Builder();
		gn.oTReport().leaveReport().build();
			
		
		
		
	//	System.out.println(gn.toString());
		
		
	//	System.out.println(data.readOTForm());
	
	
	}
	
	
}


	

