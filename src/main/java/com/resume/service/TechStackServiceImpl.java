package com.resume.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.TechStack;
import com.resume.repository.ITechStackRepository;

@Service
public class TechStackServiceImpl implements ITechStackService {
	
	@Autowired
	private ITechStackRepository techStackRepository;

	@Override
	public List<TechStack> getAllTechStack() {
		List<TechStack> techStackList = techStackRepository.getAllTechStack();
		return techStackList;
	}

	@Override
	public Long saveTechStack(TechStack techStack) {
		Long result = techStackRepository.saveTechStack(techStack);
		return result;
	}

	@Override
	public boolean deleteTechStack(Long techStackId) {
		Integer result = techStackRepository.deleteTechStack(techStackId);
		return (result > 0);
	}

	@Override
	public TechStack updateTechStack(TechStack techStack, Long techStackId) {
		TechStack techStackResponse = null;
		int result = techStackRepository.updateTechStack(techStack, techStackId);
		
		if(result > 0) {
			techStackResponse = techStackRepository.getTechStackById(techStackId).get();
		}
		return techStackResponse;
	}

}