package com.microservice.traderegistrationservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.microservice.traderegistrationservice.dto.ServiceResponse;
import com.microservice.traderegistrationservice.entity.AccountDetails;
import com.microservice.traderegistrationservice.repository.CreateAccountJpaRepository;
import com.microservice.traderegistrationservice.repository.LoginAccountJpaRepository;


@Component
public class AccountService {

	@Autowired
	private CreateAccountJpaRepository createAccountJpaRepository;
	
	@Autowired
	private LoginAccountJpaRepository loginAccountJpaRepository;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	public ServiceResponse saveUserDetails(AccountDetails userDetails) throws Exception {
		
		try {
			Optional<AccountDetails> accountDetails = createAccountJpaRepository.findByEmailIgnoreCase(userDetails.getEmail());
			if(!accountDetails.isPresent()) {
				AccountDetails savedEntity = createAccountJpaRepository.save(userDetails);
				if(savedEntity!=null) {
					serviceResponse.setBody("Your Trade Account Successfully Created with Account Id : "+savedEntity.getAccountId());
					serviceResponse.setMessage("Use your Account Id,Email,Password to login");
					serviceResponse.setResults("Success");
				}
			}
			else {
				serviceResponse.setBody("Account already exists");
				serviceResponse.setMessage("Email Id which was given had already Exists. Try another one");
				serviceResponse.setResults("Failed");
			}
	 
		}
		catch (Exception e) {
			new RuntimeException(e.getLocalizedMessage(), e.getCause());
		}
		return serviceResponse;
			
	}
	
	public boolean checkUser(AccountDetails loginCredentials) {
		
		try {
		AccountDetails details = loginAccountJpaRepository.
				findByEmailIgnoreCaseAndPasswordIgnoreCaseAndAccountId
				(loginCredentials.getEmail(),loginCredentials.getPassword(),loginCredentials.getAccountId());
					if(details!=null) {
						return true;
					}	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
}
