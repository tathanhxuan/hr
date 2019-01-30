package com.hr.domain.HRFormCore;
import java.util.HashMap;
import com.hr.domain.Form;

//Apply Chain of Responsibility Design Pattern
public abstract class FormValidatorBase {

	//for forwarding to next validation within the chain
	protected FormValidatorBase Successor;
	protected HashMap<String, String> ErrorsResult;
	
	public abstract HashMap<String, String> HandleValidation(Form model);
	
	public FormValidatorBase getSuccessor() {
		return Successor;
	}

	public HashMap<String, String> getErrorsResult() {
		return ErrorsResult;
	}

	public void setErrorsResult(HashMap<String, String> errorsResult) {
		ErrorsResult = errorsResult;
	}

	public void setSuccessor(FormValidatorBase successor) {
		Successor = successor;
	}
}
