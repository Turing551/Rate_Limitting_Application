package com.techmojo.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)

public class RateCheckException extends RuntimeException {
	public RateCheckException(String message) {
		super(message);
	}
}