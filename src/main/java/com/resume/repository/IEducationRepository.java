package com.resume.repository;

import java.util.List;

import com.resume.model.Education;

public interface IEducationRepository {
	
	public List<Education> getEducationByEducationId(Long educationId);
	
	public List<Education> getEducationByResumeId(Long resumeId);

	public Long saveEducation(Education education);
	
	public Integer deleteEducation(Long educationId);
	
	public Integer deleteEducationByResumeId(Long resume_id);
	
	public Integer updateEducation(Education education, Long educationId);

}
