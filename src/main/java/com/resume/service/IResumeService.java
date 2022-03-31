package com.resume.service;

import com.resume.model.Resume;

public interface IResumeService {
	
	public boolean saveResume(Resume resume);
	
	public boolean deleteResume(Long resumeId);

}
