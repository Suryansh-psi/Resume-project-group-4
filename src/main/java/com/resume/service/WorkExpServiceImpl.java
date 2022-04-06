package com.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.exceptionHandler.ResumeNotFoundException;
import com.resume.exceptionHandler.WorkExpNotFoundException;
import com.resume.model.WorkExp;
import com.resume.repository.IWorkExpRepository;

@Service
public class WorkExpServiceImpl implements IWorkExpService {
	
	@Autowired
	private IWorkExpRepository workExpRepository;
	
	@Override
	public List<WorkExp> getWorkExpByResumeId(Long resumeId) {
		List<WorkExp> workExp = workExpRepository.getWorkExpByResumeId(resumeId);
		if(workExp.isEmpty()) {
			throw new WorkExpNotFoundException("WorkExp with resume ID : " + resumeId + "Not Found");
		}
		return workExp;
	}

	@Override
	public List<Long> saveWorkExp(List<WorkExp> workExp) {
//		Long result = workExpRepository.saveWorkExp(workExp);
//		return result;
//		return (result != null && result > 0);
		
		List<Long> arr = new ArrayList<>();
		int size = workExp.size();
		for(int i=0; i<size; i++ ) {
			arr.add(workExpRepository.saveWorkExp(workExp.get(i)));
		}
		return arr;
	}

	@Override
	public boolean deleteWorkExp(Long workExpId) {
		Integer result = workExpRepository.deleteWorkExp(workExpId);
		return (result > 0);
	}

	@Override
	public WorkExp updateWorkExp(WorkExp workExp, Long workExpId) {
		WorkExp workExpResponse = null;
		int result = workExpRepository.updateWorkExp(workExp, workExpId);
		if(result == 0) {
			throw new WorkExpNotFoundException("No such Id exists");
		}
		else if(result > 0) {
			workExpResponse = workExpRepository.getWorkExpByWorkExpId(workExpId).get(result - 1);
		}
		return workExpResponse;
	}
	
//	@Override
//	public List<WorkExp> updateWorkExp(List<WorkExp> workExp, Long resume_id) {
//		List<Long> arr = new ArrayList<>();
//		
//		int size = workExp.size();
//		for(int i=0; i<size; i++) {
//			Long workExpId = workExp.get(i).getWorkExpId();
//			arr.add(workExpId);
//		}
//		
//		List<WorkExp> ListFromDb = workExpRepository.getWorkExpByResumeId(resume_id);
//		int size2 = ListFromDb.size();
//		
//		int diff = size - size2;
//		
//		if(diff > 0) {
//			for(int i=diff; i>0; i--) {
//				workExpRepository.saveWorkExp(workExp.get(size-i));
//			}
//		}
//		
//		for(int i=0; i<size; i++) {
//			System.out.println(workExp.get(i)+ "  " + arr.get(i));
//			Integer temp = workExpRepository.updateWorkExp(workExp.get(i), arr.get(i));
//			System.out.println(temp);
//		}
//		
//		List<WorkExp> response = workExpRepository.getWorkExpByResumeId(resume_id);
//		return response;
//	}

	

}
