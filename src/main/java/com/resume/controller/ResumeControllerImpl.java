package com.resume.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Resume;
import com.resume.model.WorkExp;
import com.resume.service.IResumeService;
import com.resume.service.IWorkExpService;

@RestController
public class ResumeControllerImpl implements IResumeController{
	
	@Autowired
	private IResumeService resumeService;
	
	@Autowired
	private IWorkExpService workExpService;
	
	@GetMapping("/resume/user/{user_id}")
	public ResponseEntity<List<Resume>> getResumeByUserId(@PathVariable Long user_id) {
		return ResponseEntity.ok(resumeService.getResumeByUserId(user_id));
	}
	
	@GetMapping("resume/alldetails/{resume_id}")
	public ResponseEntity<Resume> getAllDetailsByResumeId(@PathVariable Long resume_id) {
		Resume resume = resumeService.getAllDetailsByResumeId(resume_id);
		return ResponseEntity.ok(resume);
	}
	@PostMapping("/resume")
	public ResponseEntity<Long> saveResume(@RequestBody Resume resume) {
//		if(!file.isEmpty()) {
//			try {
//				resume.setImage(file.getBytes());
//			}
//			catch(IOException e){
//				e.printStackTrace();
//				
//			}
//		} 
		return ResponseEntity.ok(resumeService.saveResume(resume));
	}
	
	@DeleteMapping("resume/{id}")
	public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
		resumeService.deleteResume(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/resume/{resumeId}")
	public ResponseEntity<Resume> updateResume(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateResume(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/about/{resumeId}")
	public ResponseEntity<Resume> updateAboutSection(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateAboutSection(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/skills/{resumeId}")
	public ResponseEntity<Resume> updateSkills(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateSkills(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/achievement/{resumeId}")
	public ResponseEntity<Resume> updateAchievement(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateAchievement(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resume/membership/{resumeId}")
	public ResponseEntity<Resume> updateMembership(@RequestBody Resume resume, @PathVariable Long resumeId) {
		Resume response = resumeService.updateMembershhip(resume, resumeId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/resume/clone/{resumeId}")
	public ResponseEntity<Long> cloneResume(@PathVariable Long resumeId) {
		Resume res = resumeService.getAllDetailsByResumeId(resumeId);
		List<WorkExp> res2 = res.getWorkExps();
		res.setName(res.getName() + "Clone");
		Long id = resumeService.saveResume(res);
		resumeService.updateAboutSection(res, id);
		resumeService.updateSkills(res, id);
		for(int i=0; i<res2.size(); i++) {
			res2.get(i).setResumeId(id);
		}
		List<Long> ids = workExpService.saveWorkExp(res2);
		return ResponseEntity.ok(id);
	}
	
	

}
