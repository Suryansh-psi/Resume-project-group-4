package com.resume.service;

import java.util.List;

import com.resume.model.Resume;

public interface IResumeService {
	
	public Resume getAllDetailsByResumeId(Long resume_id);
	
	public List<Resume> getResumeByUserIdForManager(Long user_id, Long managerId);
	
	public List<Resume> getResumeByUserId(Long user_id);
	
	public Long saveResume(Resume resume);
	
	public boolean deleteResume(Long resumeId);
	
	public Resume updateResume(Resume resume, Long resumeId);
	
	public Resume updateAboutSection(Resume resume, Long resumeId);
	
	public Resume updateSkills(Resume resume, Long resumeId);
	
	public Resume updateAchievement(Resume resume, Long resumeId);
	
	public Resume updateMembershhip(Resume resume, Long resumeId);
	
	public Resume updateShare(Long resumeId);
	
	
//	public Integer updateResume(Resume resume, Long resumeId);
//	
//	public Integer updateAboutSection(Resume resume, Long resumeId);
//	
//	public Integer updateSkills(Resume resume, Long resumeId);

}
