package com.resume.repository;

import java.util.List;

import com.resume.model.WorkExp;

public interface IWorkExpRepository {
	
	public List<WorkExp> getWorkExpByWorkExpId(Long workExpId);
	
	public List<WorkExp> getWorkExpByResumeId(Long resumeId);

	public Long saveWorkExp(WorkExp workExp);
	
	public Integer deleteWorkExp(Long workExpId);
	
	public Integer updateWorkExp(WorkExp workExp, Long workExpId);
	
}
