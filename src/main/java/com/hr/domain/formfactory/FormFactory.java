
package com.hr.domain.formfactory;
import com.hr.domain.*;

//Form Factory Design Pattern

public class FormFactory {

	public Form creatForm(FormType type,String FormCode, String EmpID, FormStatus status)
	{
		if (type == null) return null;
		
		switch (type) {
		case LEAVE:
			return new LeaveForm(FormCode,EmpID,status);
		case OVERTIME:
			return new OTForm(FormCode,EmpID,status);
		case ATTENDANT:
			return new ATForm(FormCode,EmpID,status);
		default:
			return null;
		}
	}
}
