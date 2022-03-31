package com.resume.repository;

import com.resume.model.Resume;

public interface IResumeRepository {
	
	public Integer saveResume(Resume resume);
	
	public Integer deleteResume(Long resumeId);

}
