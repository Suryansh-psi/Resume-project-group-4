package com.resume.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.resume.model.Achievement;
import com.resume.service.IAchievementService;

@RestController
public class AchievementController {
	
	@Autowired
	private IAchievementService achievementService;
	
	@GetMapping("/achievement/resume/{resume_id}")
	public ResponseEntity<List<Achievement>> getAchievementByResumeId(@PathVariable Long resume_id) {
		return ResponseEntity.ok(achievementService.getAchievementByResumeId(resume_id));
	}

	@PostMapping("/achievement")
	public ResponseEntity<List<Long>> saveAchievement(@RequestBody List<Achievement> achievement) {
		return ResponseEntity.ok(achievementService.saveAchievement(achievement));
	
	}
	
	@DeleteMapping("achievement/{id}")
	public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
		achievementService.deleteAchievement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("achievement/{achievementId}")
	public ResponseEntity<Achievement> updateAchievement(@RequestBody Achievement achievement, @PathVariable Long achievementId) {
		Achievement response = achievementService.updateAchievement(achievement, achievementId);
		return ResponseEntity.ok(response);
	}


}
