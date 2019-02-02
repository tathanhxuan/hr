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
    private ArrayList<OTReport> oTReport;
    private ArrayList<LeaveReport> leaveReport;
    
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
    private GeneralReport(Builder builder) {
    
    	this.aTReport= builder.aTReport;
    	this.oTReport = builder.oTReport;
    	this.leaveReport = builder.leaveReport;
    	
    	if(this.aTReport!=null && !this.aTReport.isEmpty()) {
    		System.out.println("Attendance Report till "+ formatter.format(date) +"\n");
    		System.out.println("Date\tEmployee ID\tEmployee Name\tTime In\tTime Out\n"+this.aTReport);	
    	}
    	if(this.oTReport!=null && !this.oTReport.isEmpty()) {
    		System.out.println("Overtime Report till "+ formatter.format(date) +"\n");
    		System.out.println("Date\tEmployee ID\tEmployee Name\tStart Time\tEnd Time\n"+this.oTReport);	
    	}
    	if(this.leaveReport!=null && !this.leaveReport.isEmpty()) {
    		System.out.println("Leave Report till "+ formatter.format(date) +"\n");
    		System.out.println("Date\tEmployee ID\tEmployee Name\tLeave Start\tLeave End\tApprove Status\tDescription\n"+this.leaveReport);	
    	}
    	
    }
     
	
	public static class Builder implements GeneralReportBuilder{
		private ArrayList<ATReport> aTReport = new ArrayList<ATReport>();
	    private ArrayList<OTReport> oTReport = new ArrayList<OTReport>();
	    private ArrayList<LeaveReport> leaveReport = new ArrayList<LeaveReport>();
	    
	    DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
	    
	    
    public Builder aTReport() {
    	ArrayList<ATForm> allATForm = data.getListATForm();
    	ArrayList<Employee> allEmployee = data.getListEmployee();
    	
    	for(ATForm atForm: allATForm) {
    		String empId = atForm.getOwner().getEmpID();
    		for(Employee emp: allEmployee) {
    			if(empId.equals(emp.getEmpID())) {
    				   				
    				ATReport a = new ATReport(atForm.getATDate(), emp.getEmpID(), emp.getEmpName(), atForm.getTimeIn(), atForm.getTimeOut());
    				  						
    			     this.aTReport.add(a);			
    			}
    		}
    	}
    	
    	
    	return this;
    }
    
    public Builder oTReport() {
    	ArrayList<OTForm> allOTForm = data.getListOTForm();
    	ArrayList<Employee> allEmployee = data.getListEmployee();
    	
    	for(OTForm otForm: allOTForm) {
    		String empId = otForm.getOwner().getEmpID();
    		for(Employee emp: allEmployee) {
    			if(empId.equals(emp.getEmpID())) {
    				   				
    				OTReport a = new OTReport(emp.getEmpID(), emp.getEmpName(), otForm.getTimeTo(), otForm.getTimeFrom(), otForm.getOTDate());
    				  						
    			     this.oTReport.add(a);			
    			}
    		}
    	}
        	
    	return this;
    }
    
    public Builder leaveReport() {
    	ArrayList<LeaveForm> allLeaveForm = data.getListLeaveForm();
    	ArrayList<Employee> allEmployee = data.getListEmployee();
    	
    	for(LeaveForm lvForm: allLeaveForm) {
    		String empId = lvForm.getOwner().getEmpID();
    		for(Employee emp: allEmployee) {
    			if(empId.equals(emp.getEmpID())) {
    				   				
    				LeaveReport a = new LeaveReport(emp.getEmpID(), emp.getEmpName(), lvForm.getDateFrom(), lvForm.getLeaveDateTo(), emp.getIsApprover().toString(), lvForm.getDescription());
    				  						
    			     this.leaveReport.add(a);			
    			}
    		}
    	}
    	return this;
    }
		
    	@Override
		public GeneralReport build() {
			
		 return new GeneralReport(this);
		}
	}
}
