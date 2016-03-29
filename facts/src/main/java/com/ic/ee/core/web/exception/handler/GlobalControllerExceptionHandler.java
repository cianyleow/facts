package com.ic.ee.core.web.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(NoResultsReturnedException.class)
	public void handleNoResultsReturned() {
		// errr
	}

	@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
	@ExceptionHandler(TooManyResultsReturnedException.class)
	public void handleTooManyResultsReturned() {
		// errr
	}

}
