package com.resume.service;

import java.util.List;

import com.resume.model.Resume;

public interface IResumeService {
	
	public List<Resume> getResumeByUserId(Long user_id);
	
	public Long saveResume(Resume resume);
	
	public boolean deleteResume(Long resumeId);

}
