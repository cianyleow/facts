package com.ic.ee.core.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "No markers for this assignment.")
public class NoMarkersException extends Exception {

}
