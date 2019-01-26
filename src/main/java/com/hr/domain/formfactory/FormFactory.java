
package com.hr.domain.formfactory;
import com.hr.domain.*;

//Form Factory Design Pattern

public class FormFactory {

	public Form creatForm(FormType type)
	{
		if (type == null) return null;
		
		switch (type) {
		case LEAVE:
			return new LeaveForm();
		case OVERTIME:
			return new OTForm();
		case ATTENDANT:
			return new ATForm();
		default:
			return null;
		}
	}
}
