package com.resume.repository;

import com.resume.model.WorkExp;

public interface IWorkExpRepository {

	public Integer saveWorkExp(WorkExp workExp);
	
	public Integer deleteWorkExp(Long workExpId);
}
