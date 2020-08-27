package com.microservice.traderegistrationservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Component
public class DetailsValidator {
	
	@Autowired
	private ServiceResponse serviceResponse;

	public ServiceResponse infoValidator(Errors validation) {
		
		List<Object> list = new ArrayList<>();
		//Validation for create account details
		String alertMessage="";
		if(validation!=null) {
			List<FieldError> err = validation.getFieldErrors();
			for (FieldError fieldError : err) {
				if(fieldError.getField().equalsIgnoreCase("PhoneNumber")){
					alertMessage="PhoneNumber "+fieldError.getDefaultMessage();
				}
				else {
				alertMessage=fieldError.getDefaultMessage();
				}
				list.add(alertMessage);
			}
			serviceResponse.setBody(list);
			serviceResponse.setMessage("Account not created please try Again");
			serviceResponse.setResults("Failed");
		}
		 
		 return serviceResponse;
	}
}
