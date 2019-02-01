
package com.hr.domain.HRFormCore;
import com.hr.domain.*;

//Form Factory Design Pattern

public class FormFactory {

	@SuppressWarnings("unchecked")
	public static <T extends Form> T creatForm(FormType type, Employee emp)
	{
		if (type == null) return null;
		
		switch (type) {
		case LEAVE:
			return (T) new LeaveForm(emp);
		case OVERTIME:
			return (T) new OTForm(emp);
		case ATTENDANT:
			return (T) new ATForm(emp);
		default:
			return null;
		}
	}


}
