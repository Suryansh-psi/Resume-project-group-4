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
	public Long saveResume(Resume resume) {
		Long result = resumeRepository.saveResume(resume);
		return result;
	}

	@Override
	public boolean deleteResume(Long resumeId) {
		Integer result = resumeRepository.deleteResume(resumeId);
		return (result > 0);
	}

	@Override
	public Resume updateResume(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateResume(resume, resumeId);
		if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
//		return result;
	}

	@Override
	public Resume updateAboutSection(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateAboutSection(resume, resumeId);
		if(result > 0) {
//			System.out.println("------------" + resumeRepository.getResumeByUserId(resumeId).get(result) + "----------");
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
//		return result;
	}

	@Override
	public Resume updateSkills(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateSkills(resume, resumeId);
		if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
//		return result;
	}

	
	
	

}
