package com.microservice.tradedetails.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tradedetails.dto.DetailsValidator;
import com.microservice.tradedetails.dto.ServiceResponse;
import com.microservice.tradedetails.dto.UpdateDetails;
import com.microservice.tradedetails.entity.TradeDetails;
import com.microservice.tradedetails.service.impl.AccountService;

@RequestMapping("/trade")
@RestController
public class CreateTradeDetailsController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private DetailsValidator detailsValidator;
	
	private String message;
	
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
			path="/create-tradedetails")
	public Object createTradeAccount(@Valid @RequestBody TradeDetails tradeDetails,Errors validation) throws Exception {
		
		/* Validation for Account details */
		if(validation.hasErrors()) {
				message = detailsValidator.infoValidator(validation);
			}
		/* Save Account details if no errors in account details */
		else {
			message = accountService.saveUserDetails(tradeDetails);
		}
		return message;
	}
	
	@PutMapping(
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			path="/update-tradedetails/{id}")
	public Object updateTradeDetails(@PathVariable Integer id,  @RequestBody TradeDetails updateDetails) {
		
		if(updateDetails!=null) {
			Object message = accountService.updateTradeDetails(id,updateDetails);
			return message;
		}
		return null;
	}
	
	@PostMapping("/display-tradedetails/{accountId}")
	public Object getTradeDetails(@PathVariable Integer accountId){
		
		return accountService.getDetails(accountId);	
	}
	
}
