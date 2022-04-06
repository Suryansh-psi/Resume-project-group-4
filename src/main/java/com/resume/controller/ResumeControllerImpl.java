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
	
	@GetMapping("resume/alldetails/{resume_id}")
	public ResponseEntity<Resume> getAllDetailsByResumeId(@PathVariable Long resume_id) {
		Resume resume = resumeService.getAllDetailsByResumeId(resume_id);
		return ResponseEntity.ok(resume);
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
	
	@PutMapping("/resume/{resumeId}")
	public ResponseEntity<Resume> updateResume(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateResume(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/about/{resumeId}")
	public ResponseEntity<Resume> updateAboutSection(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateAboutSection(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/skills/{resumeId}")
	public ResponseEntity<Resume> updateSkills(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateSkills(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	

}
