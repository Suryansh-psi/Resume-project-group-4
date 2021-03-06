package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.exceptionHandler.ResumeNotFoundException;
import com.resume.model.Education;
import com.resume.model.Resume;
import com.resume.model.WorkExp;
import com.resume.repository.IEducationRepository;
import com.resume.repository.IResumeRepository;
import com.resume.repository.IWorkExpRepository;

@Service
public class ResumeServiceImpl implements IResumeService{
	
	@Autowired
	private IResumeRepository resumeRepository;
	
	@Autowired
	private IWorkExpRepository workExpRepository;
	
	@Autowired
	private IEducationRepository educationRepository;
	
	@Override
	public List<Resume> getResumeByUserId(Long user_id) {
		List<Resume> resume = resumeRepository.getResumeByUserId(user_id);
		if(resume.isEmpty()) {
			throw new ResumeNotFoundException("Resume with ID : " + user_id + "Not Found");
		}
		
		return resume;
	}
	
	@Override
	public List<Resume> getResumeByUserIdForManager(Long user_id, Long managerId) {
		List<Resume> resume = resumeRepository.getResumeByUserIdForManager(user_id, managerId);
		if(resume.isEmpty()) {
			throw new ResumeNotFoundException("Resume with ID : " + user_id + "Not Found");
		}
		
		return resume;
	}

	@Override
	public Long saveResume(Resume resume) {
		Long result = resumeRepository.saveResume(resume);
		return result;
	}

	@Override
	public boolean deleteResume(Long resumeId) {
		Integer result = workExpRepository.deleteWorkExpByResumeId(resumeId);
		result = educationRepository.deleteEducationByResumeId(resumeId);
//		if (result > 0) {
			
			result = resumeRepository.deleteResume(resumeId);
//		}
		
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
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	@Override
	public Resume updateSkills(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateSkills(resume, resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
//		return result;
	}

	@Override
	public Resume getAllDetailsByResumeId(Long resume_id) {
		List<Resume> resume = resumeRepository.getResumeByResumeId(resume_id);
		List<WorkExp> workExpList = workExpRepository.getWorkExpByResumeId(resume_id);
		List<Education> eduList = educationRepository.getEducationByResumeId(resume_id);
		Resume response = resume.get(0);
		
		response.setWorkExps(workExpList);
		response.setEducations(eduList);
		return response;
	}

	@Override
	public Resume updateAchievement(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateAchievement(resume, resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	@Override
	public Resume updateMembershhip(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateMembershhip(resume, resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	@Override
	public Resume updateShare(Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateShare(resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	@Override
	public Resume updateStatusToApprove(Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateStatusToApprove(resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	@Override
	public Resume updateComment(Resume resume, Long resumeId) {
		Resume resumeResponse = null;
		int result = resumeRepository.updateComment(resume, resumeId);
		if(result == 0) {
			throw new ResumeNotFoundException("No such Resume exists");
		}
		else if(result > 0) {
			resumeResponse = resumeRepository.getResumeByResumeId(resumeId).get(result - 1);
		}
		return resumeResponse;
	}

	

	
	
	

}
