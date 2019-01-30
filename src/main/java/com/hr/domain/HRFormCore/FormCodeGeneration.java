package com.hr.domain.HRFormCore;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormCodeGeneration {

	public String GenerateOTCode(String depID,String empID) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		return "OT" + depID + empID + "_"+ timeStamp ;
		
	}
	
	public String GenerateATCode(String depID,String empID) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "AT" + depID + empID + "_" + timeStamp ;
	}
	
	public String GenerateLeaveCode(String depID,String empID) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "LA" + depID + empID + "_"+ timeStamp ;
	}
	
}
