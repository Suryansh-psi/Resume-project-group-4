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

import com.resume.model.SkillMaster;
import com.resume.service.ISkillMasterService;

@RestController
public class SkillMasterController {
	
	@Autowired
	private ISkillMasterService skillMasterService;
	
	@GetMapping("/skills")
	public ResponseEntity<List<SkillMaster>> getSkillMaster() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(skillMasterService.getAllSkills());
	}

	@PostMapping("/skills")
	public ResponseEntity<Long> saveSkillMaster(@RequestBody SkillMaster skillMaster) {
		// TODO Auto-generated method stub
		
		return ResponseEntity.ok(skillMasterService.saveSkills(skillMaster));
	}
	
	@DeleteMapping("skills/{skillId}")
	public ResponseEntity<Void> deleteSkillMaster(@PathVariable Long skillId) {
		skillMasterService.deleteSkillMaster(skillId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

	@PutMapping("/skills/{skillId}")
	public ResponseEntity<SkillMaster> updateSkillMaster(@RequestBody SkillMaster skillMaster, @PathVariable Long skillId) {
		SkillMaster response = skillMasterService.updateSkillMaster(skillMaster, skillId);
		return ResponseEntity.ok(response);
	}

}
