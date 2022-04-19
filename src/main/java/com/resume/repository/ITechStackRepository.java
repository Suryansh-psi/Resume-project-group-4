package com.resume.repository;


import java.util.List;
import java.util.Optional;

import com.resume.model.TechStack;

public interface ITechStackRepository {
	
	public List<TechStack> getAllTechStack();
	
	public Optional<TechStack> getTechStackById(Long techStackId);
	
	public Long saveTechStack(TechStack techStack);
	
	public Integer deleteTechStack(Long techStackId);
	
	public Integer updateTechStack(TechStack techStack, Long techStackId);
}