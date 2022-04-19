package com.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.model.Education;
import com.resume.service.IEducationService;


@RestController
public class EducationController {
	
	@Autowired
	private IEducationService educationService;
	
	@GetMapping("/edu/resume/{resumeId}")
	public ResponseEntity<List<Education>> getEducationByResumeId(@PathVariable Long resumeId) {
		return ResponseEntity.ok(educationService.getEducationByResumeId(resumeId));
	}

	@PostMapping("/edu")
	public ResponseEntity<List<Long>> saveEducation(@RequestBody List<Education> education) {
		return ResponseEntity.ok(educationService.saveEducation(education));
	}
	
	@DeleteMapping("edu/{id}")
	public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
		educationService.deleteEducation(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("edu/{educationId}")
	public ResponseEntity<Education> updateEducation(@RequestBody Education education, @PathVariable Long educationId) {
		Education response = educationService.updateEducation(education, educationId);
		return ResponseEntity.ok(response);
	}
}
