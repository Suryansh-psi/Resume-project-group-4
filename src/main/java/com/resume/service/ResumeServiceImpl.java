package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.Resume;
import com.resume.repository.IResumeRepository;

@Service
public class ResumeServiceImpl implements IResumeService{
	
	@Autowired
	private IResumeRepository resumeRepository;
	
	@Override
	public List<Resume> getResumeByUserId(Long user_id) {
		List<Resume> resume = resumeRepository.getResumeByUserId(user_id);
		return resume;
	}

	@Override
	public boolean saveResume(Resume resume) {
		Integer result = resumeRepository.saveResume(resume);
		return (result != null && result > 0);
	}

	@Override
	public boolean deleteResume(Long resumeId) {
		Integer result = resumeRepository.deleteResume(resumeId);
		return (result > 0);
	}

	
	
	

}
