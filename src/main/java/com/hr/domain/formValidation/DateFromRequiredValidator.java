package com.hr.domain.formValidation;

import java.util.Date;
import java.util.HashMap;

import com.hr.domain.Form;

public class DateFromRequiredValidator extends FormValidatorBase {

	@Override
	public HashMap<String, String> HandleValidation(Form model) {
		
		Date mindate = new Date( Long.MIN_VALUE );
		
		if (model.getDateFrom() == mindate)
        {
            ErrorsResult.put("DateFrom", "Date from field is required");

            return ErrorsResult;
        }
		
        if (Successor != null)

            return Successor.HandleValidation(model);

        return ErrorsResult;
	}

}
