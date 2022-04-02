package com.resume.repository;

import java.util.List;

import com.resume.model.WorkExp;

public interface IWorkExpRepository {
	
	public List<WorkExp> getWorkExpByResumeId(Long resumeId);

	public Integer saveWorkExp(WorkExp workExp);
	
	public Integer deleteWorkExp(Long workExpId);
}
