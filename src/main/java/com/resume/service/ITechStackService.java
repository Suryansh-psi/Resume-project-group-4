package com.resume.service;
import java.util.List;

import com.resume.model.TechStack;


public interface ITechStackService {
	
	public List<TechStack> getAllTechStack();
	
	public Long saveTechStack(TechStack techStack);
	
	public boolean deleteTechStack(Long techStackId);
	
	public TechStack updateTechStack(TechStack techStack, Long techStackId);

}