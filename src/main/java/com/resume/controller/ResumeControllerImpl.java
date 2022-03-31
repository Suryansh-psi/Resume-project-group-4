package com.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.model.Resume;
import com.resume.service.IResumeService;

@RestController
public class ResumeControllerImpl implements IResumeController{
	
	@Autowired
	private IResumeService resumeService;

	@PostMapping("/resume")
	public ResponseEntity<Void> saveResume(@RequestBody Resume resume) {
		ResponseEntity response;
		boolean status = resumeService.saveResume(resume);
		if(status) {
			response = ResponseEntity.status(HttpStatus.CREATED).build();
		}
		else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
	}
	
	@DeleteMapping("resume/{id}")
	public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
		resumeService.deleteResume(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
