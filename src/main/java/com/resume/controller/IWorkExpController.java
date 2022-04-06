package com.resume.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.resume.model.WorkExp;

public interface IWorkExpController {
	
	public ResponseEntity<List<Long>> saveWorkExp(@RequestBody List<WorkExp> workExp);

}
