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

import com.resume.model.WorkExp;
import com.resume.service.IWorkExpService;

@RestController
public class WorkExpControllerImpl implements IWorkExpController{
	
	@Autowired
	private IWorkExpService workExpService;
	
	@GetMapping("/workexp/resume/{resumeId}")
	public ResponseEntity<List<WorkExp>> getWorkExpByResumeId(@PathVariable Long resumeId) {
		return ResponseEntity.ok(workExpService.getWorkExpByResumeId(resumeId));
	}

	@PostMapping("/workexp")
	public ResponseEntity<List<Long>> saveWorkExp(@RequestBody List<WorkExp> workExp) {
//		ResponseEntity response;
//		Long status = workExpService.saveWorkExp(workExp);
//		if(status) {
//			response = ResponseEntity.status(HttpStatus.CREATED).build();
//		} else {
//			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
//		return response;
		return ResponseEntity.ok(workExpService.saveWorkExp(workExp));
	}
	
	@DeleteMapping("workexp/{id}")
	public ResponseEntity<Void> deleteWorkExpe(@PathVariable Long id) {
		workExpService.deleteWorkExp(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("workexp/{workExpId}")
	public ResponseEntity<WorkExp> updateWorkExp(@RequestBody WorkExp workExp, @PathVariable Long workExpId) {
		WorkExp response = workExpService.updateWorkExp(workExp, workExpId);
		return ResponseEntity.ok(response);
	}
	
//	@PutMapping("workexp/update/{resume_id}")
//	public ResponseEntity<List<WorkExp>> updateWorkExp(@RequestBody List<WorkExp> workExp, @PathVariable Long resume_id) {
//		List<WorkExp> response = workExpService.updateWorkExp(workExp, resume_id);
//		return ResponseEntity.ok(response);
//	}
	
}
