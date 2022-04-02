package com.resume.service;

import java.util.List;

import com.resume.model.WorkExp;

public interface IWorkExpService {
	
	public List<WorkExp> getWorkExpByResumeId(Long resumeId);
	
	public boolean saveWorkExp(WorkExp workExp);
	
	public boolean deleteWorkExp(Long workExpId);

}
