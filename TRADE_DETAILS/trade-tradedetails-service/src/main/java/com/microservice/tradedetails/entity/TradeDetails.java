package com.microservice.tradedetails.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Data
public class TradeDetails {

	@Id
	@GeneratedValue
	private Integer tradeId;
	
	private String  productType;
	
	private String  productBrand;
	
	private String productCost;

	private String  productPurchasedYear;

	private String  traderEmail;
	
	private String  traderPhone;
	
	private Integer accountId;

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public String getProductPurchasedYear() {
		return productPurchasedYear;
	}

	public void setProductPurchasedYear(String productPurchasedYear) {
		this.productPurchasedYear = productPurchasedYear;
	}

	public String getTraderEmail() {
		return traderEmail;
	}

	public void setTraderEmail(String traderEmail) {
		this.traderEmail = traderEmail;
	}

	public String getTraderPhone() {
		return traderPhone;
	}

	public void setTraderPhone(String traderPhone) {
		this.traderPhone = traderPhone;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	

}
