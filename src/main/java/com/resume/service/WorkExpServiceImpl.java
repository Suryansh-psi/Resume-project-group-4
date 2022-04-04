package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.WorkExp;
import com.resume.repository.IWorkExpRepository;

@Service
public class WorkExpServiceImpl implements IWorkExpService {
	
	@Autowired
	private IWorkExpRepository workExpRepository;
	
	@Override
	public List<WorkExp> getWorkExpByResumeId(Long resumeId) {
		List<WorkExp> workExp = workExpRepository.getWorkExpByResumeId(resumeId);
		return workExp;
	}

	@Override
	public Long saveWorkExp(WorkExp workExp) {
		Long result = workExpRepository.saveWorkExp(workExp);
		return result;
//		return (result != null && result > 0);
	}

	@Override
	public boolean deleteWorkExp(Long workExpId) {
		Integer result = workExpRepository.deleteWorkExp(workExpId);
		return (result > 0);
	}

	

}
