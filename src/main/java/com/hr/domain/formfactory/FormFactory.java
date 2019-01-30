
package com.hr.domain.formfactory;
import com.hr.domain.*;
import com.hr.domain.formValidation.FormValidationStrategy;

//Form Factory Design Pattern

public class FormFactory {

	public static Form creatForm(FormType type,String FormCode, Employee emp, FormStatus status,FormValidationStrategy vf)
	{
		if (type == null) return null;
		
		switch (type) {
		case LEAVE:
			return new LeaveForm(FormCode,emp,status,vf);
		case OVERTIME:
			return new OTForm(FormCode,emp,status,vf);
		case ATTENDANT:
			return new ATForm(FormCode,emp,status,vf);
		default:
			return null;
		}
	}


}
