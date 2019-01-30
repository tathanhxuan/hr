
package com.hr.domain.HRFormCore;
import com.hr.domain.*;

//Form Factory Design Pattern

public class FormFactory {

	public static Form creatForm(FormType type, Employee emp, FormStatus status,FormValidationStrategy vf)
	{
		if (type == null) return null;
		
		switch (type) {
		case LEAVE:
			return new LeaveForm(emp,status,vf);
		case OVERTIME:
			return new OTForm(emp,status,vf);
		case ATTENDANT:
			return new ATForm(emp,status,vf);
		default:
			return null;
		}
	}


}
