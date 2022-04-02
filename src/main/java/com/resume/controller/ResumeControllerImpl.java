package com.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/resume/user/{user_id}")
	public ResponseEntity<List<Resume>> getResumeByUserId(@PathVariable Long user_id) {
		return ResponseEntity.ok(resumeService.getResumeByUserId(user_id));
	}

	@PostMapping("/resume")
	public ResponseEntity<Long> saveResume(@RequestBody Resume resume) {
		return ResponseEntity.ok(resumeService.saveResume(resume));
	}
	
	@DeleteMapping("resume/{id}")
	public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
		resumeService.deleteResume(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
