package com.ic.ee.core.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Link expired")
public class DownloadLinkExpiredException extends Exception {

}
