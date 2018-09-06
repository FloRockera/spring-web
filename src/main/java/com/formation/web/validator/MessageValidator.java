package com.formation.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.formation.entity.Message;

public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Message.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

	}

}
