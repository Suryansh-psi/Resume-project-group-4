package com.resume.service;

import com.resume.model.WorkExp;

public interface IWorkExpService {
	
	public boolean saveWorkExp(WorkExp workExp);
	
	public boolean deleteWorkExp(Long workExpId);

}
