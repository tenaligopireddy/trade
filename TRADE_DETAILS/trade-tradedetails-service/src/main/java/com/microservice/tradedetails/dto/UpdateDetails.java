package com.microservice.tradedetails.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UpdateDetails {

	@NotNull
	private Integer tradeId;
	
	@NotNull
	private String  productType;
	
	@NotNull
	private String  productBrand;
	
	@NotNull
	private String productCost;

	@NotNull
	private String  productPurchasedYear;

	@NotNull
	private String  traderEmail;
	
	@NotNull
	private Long  traderPhone;
}
