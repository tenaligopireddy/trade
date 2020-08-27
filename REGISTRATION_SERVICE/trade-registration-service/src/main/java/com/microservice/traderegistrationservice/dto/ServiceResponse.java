package com.microservice.traderegistrationservice.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ServiceResponse<T> {

	private T body;
	
	private String message;
	
	private T results;

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResults() {
		return results;
	}

	public void setResults(T results) {
		this.results = results;
	}
	
}
