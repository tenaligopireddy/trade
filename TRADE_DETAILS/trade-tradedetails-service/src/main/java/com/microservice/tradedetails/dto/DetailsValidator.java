package com.microservice.tradedetails.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Component
public class DetailsValidator {

	public String infoValidator(Errors validation) {
		
		//Validation for create account details
		String alertMessage="<b>The Following details are mandatory :</b>\n\n";
		if(validation!=null) {
			List<FieldError> err = validation.getFieldErrors();
			for (FieldError fieldError : err) {
				if(fieldError.getField().equalsIgnoreCase("PhoneNumber")){
					alertMessage+="PhoneNumber "+fieldError.getDefaultMessage()+"\n";
				}
				else {
				alertMessage+=fieldError.getDefaultMessage()+"\n";
				}
			}
		}
		return alertMessage;
	}
}
