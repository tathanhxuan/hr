package com.hr.domain.report.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.hr.domain.Employee;
import com.hr.domain.reportChart.ChartTemplate;
import com.hr.domain.reportChart.ReportChart;
import com.hr.domain.reportFacade.ReportMaker;
import com.hr.repository.storage.DataAccessRepositoryFacade;

public class Main {

	public static void main(String[] args) throws ParseException {
		DataAccessRepositoryFacade data = new DataAccessRepositoryFacade();
//		Scanner command = new Scanner(System.in);
//		System.out.println("******REPORT********");
//		System.out.println("1.OT REPORT");
//		System.out.println("2.AT REPORT");
//		System.out.println("3.LEAVE REPORT");
//		System.out.println("4.CHART");
//		System.out.println("5.ALL REPORT");
//		System.out.println("6. SEARCH");
//		System.out.println("7.EXIT");
//		System.out.println("*******************************************************");
//		System.out.println("*.SELECT : ");
// 		
//	
//	
//		while (true) {
//			String input = command.nextLine();
//			ReportMaker rm = new ReportMaker();
//			ChartTemplate ch = new ReportChart();
			GeneralReport.Builder allReport = new GeneralReport.Builder();
//			if (input.equals("1")) {
//				rm.getOvertimeReport();
//			} else if (input.equals("2")) {
//				rm.getAttendanceReport();
//
//			} else if (input.equals("3")) {
//				rm.getLeaveReport();
//			} else if (input.equals("4")) {
//				ch.getReportChart();
//			} else if (input.equals("5")) {
//				allReport.aTReport().leaveReport().oTReport().build();
//			} else if (input.equals("6")) {
//				searchMenu();
//				break;
//			}
//
//			else if (input.equals("7")) {
//			//	LoadMenuByUserRole();
//				break;
//			} else {
//				System.out.println("Invalid Enttry, Try again");
//			}
//		}	
//	}
//	
//	
//	
//	// Search Menu
//	public static void searchMenu() throws ParseException {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("1.SEARCH BY EMPLOYEE ID");
//		System.out.println("2.SEARCH BY DEPARTMENT");
//		System.out.println("3.SEARCH BY NAME");
//		System.out.println("4.BACK TO REPORT MENU");
//		String entry = scanner.nextLine();
//		ReportMaker rm = new ReportMaker();
//		while (true) {
//			if (entry.equals("1")) {
//				 System.out.println("Enter Employee ID");
//				 String empSearchId = scanner.nextLine();
//               rm.searchByEmpId(empSearchId);
//               break;
//               
//               } else if (entry.equals("2")) {
//				System.out.println("Enter Employee Department");
//				String empSearchDepart = scanner.nextLine();
//               rm.leaveReportByDepartment(empSearchDepart);
//               rm.aTReportByDepartment(empSearchDepart);
//               rm.oTReportByDepartment(empSearchDepart);
//			} 
//			
//			else if (entry.equals("3")) {
//				//search by name
//			}
//			else if (entry.equals("4")) {
//				//LoadReportMenu();
//				break;
//			}
//			else {
//				System.out.println("Invalid Entry, Try again !");
//			}
//	}
	  
//	ArrayList<Employee> em = data.getListEmployee();
//    for(Employee all: em) {
//    	System.out.println(all.getAddress());
//    }
	
	
   allReport.leaveReport().build();	
	
	
	  }
	}
