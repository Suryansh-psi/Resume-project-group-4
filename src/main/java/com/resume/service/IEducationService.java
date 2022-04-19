package com.resume.service;

import java.util.List;

import com.resume.model.Education;

public interface IEducationService {
	
	public List<Education> getEducationByResumeId(Long resumeId);
	
	public List<Long> saveEducation(List<Education> education);
	
	public boolean deleteEducation(Long educationId);
	
	public Education updateEducation(Education education, Long educationId);
}
