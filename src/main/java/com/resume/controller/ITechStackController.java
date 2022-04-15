package com.resume.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.resume.model.TechStack;


public interface ITechStackController {
	
	public ResponseEntity<List<TechStack>> getTechStack();
	
	public ResponseEntity<Long> saveTechStack(@RequestBody TechStack techStack);
	
	public ResponseEntity<Void> deleteTechStack(@PathVariable Long techStackId);
	
	public ResponseEntity<TechStack> updateTechStack(@RequestBody TechStack techStack, @PathVariable Long techStackId);
	
	
}