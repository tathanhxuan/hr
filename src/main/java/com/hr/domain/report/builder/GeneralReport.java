package com.hr.domain.report.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import com.hr.domain.ATForm;
import com.hr.domain.Employee;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.domain.reportFacade.ATReport;
import com.hr.domain.reportFacade.LeaveReport;
import com.hr.domain.reportFacade.OTReport;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class GeneralReport {
	private ArrayList<ATReport> aTReport;
    private HashMap<String, OTForm> oTReport;
    private HashMap<String, LeaveForm> leaveReport;
    
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
    private GeneralReport(Builder builder) {
    
    	this.aTReport= builder.aTReport;
    	this.oTReport = builder.oTReport;
    	this.leaveReport = builder.leaveReport;
    	
    	if(this.aTReport!=null) {
    		System.out.println("Attendance Report till "+ formatter.format(date) +"\n"+ this.aTReport+"\n");	
    	}
    	if(this.oTReport!=null) {
    		System.out.println("Overtime Report till "+ formatter.format(date) +"\n"+ this.oTReport+"\n");	
    	}
    	if(this.leaveReport!=null) {
    		System.out.println("Leave Report till "+ formatter.format(date) +"\n"+ this.leaveReport+"\n");	
    	}
    	
    }
     
	
	public static class Builder implements GeneralReportBuilder{
		private ArrayList<ATReport> aTReport;
	    private HashMap<String, OTForm> oTReport;
	    private HashMap<String, LeaveForm> leaveReport;
	    
	    DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
	    
	    
	    
    public Builder aTReport() {
    	ArrayList<ATForm> allATForm = data.getListATForm();
    	ArrayList<Employee> allEmployee = data.getListEmployee();
    	
    	for(ATForm atForm: allATForm) {
    		String empId = atForm.getOwner().getEmpID();
    		for(Employee emp: allEmployee) {
    			if(empId.equals(emp.getEmpID())) {
    				this.aTReport.add(new ATReport());			
    			}
    		}
    	}
    	
    	
    	return this;
    }
    
    public Builder oTReport() {
    	   	
    		this.oTReport = data.readOTForm();
    	    	
    	return this;
    }
    
    public Builder leaveReport() {
    	this.leaveReport = data.readLeaveForm();
    	return this;
    }
		
    	@Override
		public GeneralReport build() {
			
		 return new GeneralReport(this);
		}
	}
}
