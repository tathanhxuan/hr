package com.hr.domain.report.builder;

import java.util.Scanner;

import com.hr.domain.reportChart.ChartTemplate;
import com.hr.domain.reportChart.ReportChart;
import com.hr.domain.reportFacade.ReportMaker;

public class Main {

	public static void main(String[] args) {

		Scanner command = new Scanner(System.in);
		System.out.println("******REPORT********");
		System.out.println("1.OT REPORT");
		System.out.println("2.AT REPORT");
		System.out.println("3.LEAVE REPORT");
		System.out.println("4.CHART");
		System.out.println("5.ALL REPORT");
		System.out.println("6.EXIT");
		System.out.println("*******************************************************");
		System.out.println("*.SELECT : ");
 while (true) {
			String input = command.nextLine();
			ReportMaker rm = new ReportMaker();
			ChartTemplate ch = new ReportChart();
			GeneralReport.Builder allReport = new GeneralReport.Builder();
			if (input.equals("1")) {
				rm.getOvertimeReport();
				 rm.searchByEmpId("101");
			} else if (input.equals("2")) {
				rm.getAttendanceReport();

			} else if (input.equals("3")) {
				rm.getLeaveReport();
			} else if (input.equals("4")) {
				ch.getReportChart();
			}

			else if (input.equals("5")) {
				allReport.aTReport().leaveReport().oTReport().build();
			} else if (input.equals("6")) {
				System.out.println("Load main");
				break;
			} else {
				System.out.println("Invalid Enttry, Try again");
			}
		}
	}
}
