package com.formation.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.MessageDto;

public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return MessageDto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "fromUser", "required", "L'expéditeur est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "toUser", "required", "Le destinataire est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "content", "required", "Le message est obligatoire");

		MessageDto messageDto = (MessageDto) target;
		if (!(messageDto.getToUser().isEmpty()) && !(Character.isUpperCase(messageDto.getToUser().charAt(0)))) {

			errors.rejectValue("toUser", "negativeValue", new Object[] { "'toUser'" },
					"Le nom du destinataire doit commencer par une majuscule");

		}

	}

}
