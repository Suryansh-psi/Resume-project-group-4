package com.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.Education;
import com.resume.repository.IEducationRepository;

@Service
public class EducationServiceImpl implements IEducationService {
	
	@Autowired
	private IEducationRepository educationRepository;

	@Override
	public List<Education> getEducationByResumeId(Long resumeId) {
		List<Education> education = educationRepository.getEducationByResumeId(resumeId);
		// exceptions		
		return education;
	}

	@Override
	public List<Long> saveEducation(List<Education> education) {
		List<Long> arr = new ArrayList<>();
		int size = education.size();
		for(int i=0; i<size; i++ ) {
			arr.add(educationRepository.saveEducation(education.get(i)));
		}
		return arr;
	}

	@Override
	public boolean deleteEducation(Long educationId) {
		Integer result = educationRepository.deleteEducation(educationId);
		return (result > 0);
	}

	@Override
	public Education updateEducation(Education education, Long educationId) {
		Education educationResponse = null;
		int result = educationRepository.updateEducation(education, educationId);
//		if(result == 0) {
//			throw new WorkExpNotFoundException("No such Id exists");
//		}
//		else if(result > 0) {
		educationResponse = educationRepository.getEducationByEducationId(educationId).get(result - 1);
//		}
		return educationResponse;
	}

}
