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

import com.resume.model.TechStack;
import com.resume.service.ITechStackService;

@RestController
public class TechStackControllerImpl implements ITechStackController {
	
	@Autowired
	private ITechStackService techStackServiceImpl;
	
	@GetMapping("/techstack")
	public ResponseEntity<List<TechStack>> getTechStack() {
		return ResponseEntity.ok(techStackServiceImpl.getAllTechStack());
	}
	
	@PostMapping("/techstack")
	public ResponseEntity<Long> saveTechStack(@RequestBody TechStack techStack) {
		return ResponseEntity.ok(techStackServiceImpl.saveTechStack(techStack));
	}
	
	@DeleteMapping("techstack/{techStackId}")
	public ResponseEntity<Void> deleteTechStack(@PathVariable Long techStackId) {
		techStackServiceImpl.deleteTechStack(techStackId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/techstack/{techStackId}")
	public ResponseEntity<TechStack> updateTechStack(@RequestBody TechStack techStack, @PathVariable Long techStackId) {
		TechStack response = techStackServiceImpl.updateTechStack(techStack, techStackId);
		return ResponseEntity.ok(techStack);
	}

}