package com.ic.ee.core.web.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ic.ee.core.web.exception.NoResultsReturnedException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	private static final Logger logger = Logger.getLogger(GlobalControllerExceptionHandler.class);

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(NoResultsReturnedException.class)
	public void handleNoResultsReturned() {
		logger.warn("NoResultsReturnedException thrown and handled as " + HttpStatus.NO_CONTENT.value());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public void handleEmptyResultDataAccess() {
		logger.warn("EmptyResultDataAccessException thrown and handled as " + HttpStatus.NOT_FOUND.value());
	}

}