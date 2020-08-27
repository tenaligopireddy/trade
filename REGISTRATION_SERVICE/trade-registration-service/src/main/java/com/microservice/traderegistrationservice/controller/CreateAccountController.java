package com.microservice.traderegistrationservice.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.traderegistrationservice.dto.DetailsValidator;
import com.microservice.traderegistrationservice.dto.ServiceResponse;
import com.microservice.traderegistrationservice.entity.AccountDetails;
import com.microservice.traderegistrationservice.repository.TradeDetailsServiceProxy;
import com.microservice.traderegistrationservice.service.impl.AccountService;

@RequestMapping("/trade")
@RestController
public class CreateAccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TradeDetailsServiceProxy tradeDetailsProxy;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private DetailsValidator detailsValidator;

	
	private Logger log = LoggerFactory.getLogger(getClass());

	@PostMapping(
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			path="/create-account")
	public ResponseEntity<ServiceResponse> createTradeAccount(@Valid @RequestBody AccountDetails requestDetails,Errors validation) throws Exception {
		
		/* Validation for Account details */
		if(validation.hasErrors()) {
				serviceResponse = detailsValidator.infoValidator(validation);
			}
		/* Save Account details if no errors in account details */
		else {
			ServiceResponse responseStatus = accountService.saveUserDetails(requestDetails);
			if(responseStatus.getBody()!=null) {
				return ResponseEntity.
						status(HttpStatus.CREATED).
						body(responseStatus);
			}
			else
				return ResponseEntity.
						status(HttpStatus.ALREADY_REPORTED).
						body(responseStatus);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse);
	}
	
	@PostMapping(
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			path="/login-account")
	public ServiceResponse loginAccount(@RequestBody AccountDetails loginDetails) {
		
		if(!loginDetails.getEmail().isEmpty() && !loginDetails.getPassword().isEmpty() 
				&& !(loginDetails.getAccountId()==null)) {
			
			if(accountService.checkUser(loginDetails)) {
			 	Object response = tradeDetailsProxy.getTradeDetails(loginDetails.getAccountId());
			 	serviceResponse.setBody(response);
			}
			else {
				
			}
		}
		else {
			
		}
		return serviceResponse;
			
	}
	
}
