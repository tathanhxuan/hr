package com.hr.domain.report.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    		System.out.println("ATTENDANCE REPORT TILL "+ formatter.format(date)+"\t");
    		System.out.println("Date\t\tEmployee ID\t\tEmployee Name\t\tTime In\t\tTime Out\n-----------------------------------------------------------------------------------------");
    		
    		StringBuilder sb = new StringBuilder();
    		for(ATReport e: this.aTReport) {
    			System.out.println(sb.append(e.AtToString()).toString().replace("[", " ").replace("]", " "));
    		}
    
    	}
    	if(this.oTReport!=null && !this.oTReport.isEmpty()) {
    		System.out.println("OVERTIME REPORT TILL "+ formatter.format(date) +"\n");
    		System.out.println("Date\t\tEmployee ID\tEmployee Name\t\t\tStart Time\tEnd Time\n------------------------------------------------------------------------------------------");
    		
    		StringBuilder sb = new StringBuilder();
    		for(OTReport e: this.oTReport) {
    			System.out.println(sb.append(e.OtToString()).toString().replace("[", " ").replace("]", " "));
    		}
    	}
    	if(this.leaveReport!=null && !this.leaveReport.isEmpty()) {
    		System.out.println("\nLEAVE REPORT TILL "+ formatter.format(date) +"\n");
    		System.out.println("Date\t\tEmployee ID\tEmployee Name\t\tLeave Start\tLeave End\tApprove Status\tDescription\n----------------"
    				+ "---------------------------------------------------------------------------------------------------");	
    		
    		StringBuilder sb = new StringBuilder();
    		for(LeaveReport e: this.leaveReport) {
    			System.out.println(sb.append(e.leaveToString()).toString().replace("[", " ").replace("]", " "));
    		}
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
    	Date date1 = new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime();
    	ArrayList<LeaveForm> allLeaveForm = data.getListLeaveForm();
    	ArrayList<Employee> allEmployee = data.getListEmployee();
    	
    	for(LeaveForm lvForm: allLeaveForm) {
    		String empId = lvForm.getOwner().getEmpID();
    		for(Employee emp: allEmployee) {
    			if(empId.equals(emp.getEmpID())) {
    				String empid = emp.getEmpID();
    				//if(empId==null)
    				//	empid="null";
    				String empname = emp.getEmpName();
    				//if(empname == null)
    			//		empname = "null";
    				Date dateFrom = lvForm.getDateFrom();
    			//	if(dateFrom == null)
    					dateFrom = date1;
    				Date dateTo = lvForm.getLeaveDateTo();
    		//		if(dateTo == null)
    			//		dateTo = date1;
    				
    				String formCode = lvForm.getFormCode();
    			//	for(DepartmentApprover fm: data.getListDepartmentApprover()) {   				
    				     //lvForm.getFormCode()   //to navigate
    					LeaveReport a = new LeaveReport(lvForm.getLeaveDateTo(), empid, empname, dateFrom, dateTo, lvForm.getStatus().toString() , lvForm.getDescription());
    				  						
    			     this.leaveReport.add(a);
    			//	}
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
