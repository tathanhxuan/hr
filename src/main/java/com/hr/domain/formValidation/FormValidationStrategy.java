package com.hr.domain.formValidation;
import java.util.HashMap;
import com.hr.domain.Form;

//apply Strategy Design Pattern
public abstract class FormValidationStrategy {
   public abstract HashMap<String, String> Validate(Form Model);
}

