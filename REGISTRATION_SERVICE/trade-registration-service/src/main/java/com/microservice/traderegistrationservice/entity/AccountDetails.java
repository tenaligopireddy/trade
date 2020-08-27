package com.microservice.traderegistrationservice.entity;

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
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	@NotEmpty(message="Username must not be empty")
	private String  userName;
	
	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 10, message="Password must be equal or greater than 6 characters and less than 10 characters")
	private String  password;
	
	@NotEmpty(message = "Email ID cannot be empty")
	@Email(message="Email Format is not well-formed")
	private String email;
	
	@NotEmpty(message = "Address cannot be empty")
	private String  address;
	
	@NotEmpty(message = "State cannot be empty")
	private String  state;
	
	@NotEmpty(message = "Country cannot be empty")
	private String  country;
	
	@Min(10)
	private long phoneNumber;
	
	@NotEmpty(message = "Account Type cannot be empty")
	private String  accountType;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
