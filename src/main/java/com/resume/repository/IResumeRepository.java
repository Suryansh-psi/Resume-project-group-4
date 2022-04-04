package com.resume.repository;

import java.util.List;

import com.resume.model.Resume;

public interface IResumeRepository {
	
	public List<Resume> getResumeByResumeId(Long resume_id);
	
	public List<Resume> getResumeByUserId(Long resume_id);
	
	public Long saveResume(Resume resume);
	
	public Integer deleteResume(Long resumeId);
	
	public Integer updateResume(Resume resume, Long resumeId);
	
	public Integer updateAboutSection(Resume resume, Long resumeId);
	
	public Integer updateSkills(Resume resume, Long resumeId);
}
