package com.resume.repository;

import java.util.List;

import com.resume.model.Resume;

public interface IResumeRepository {
	
	public List<Resume> getResumeByUserId(Long user_id);
	
	public Long saveResume(Resume resume);
	
	public Integer deleteResume(Long resumeId);

}
