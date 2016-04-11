package com.ic.ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.service.api.SubmissionService;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

}
