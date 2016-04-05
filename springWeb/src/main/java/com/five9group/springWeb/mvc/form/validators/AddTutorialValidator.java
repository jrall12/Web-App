package com.five9group.springWeb.mvc.form.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.five9group.springWeb.domain.Tutorial;

@Component
public class AddTutorialValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return Tutorial.class.equals(paramClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tutorialTitle", "tutorialTitle.required");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tutorialAuthor", "tutorialAuthor.required");

		
	}

}
