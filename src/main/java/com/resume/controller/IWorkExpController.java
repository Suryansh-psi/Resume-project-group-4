package com.resume.controller;

import org.springframework.http.ResponseEntity;

import com.resume.model.WorkExp;

public interface IWorkExpController {
	
	public ResponseEntity<Long> saveWorkExp(WorkExp workExp);

}
