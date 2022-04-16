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

import com.resume.model.ProjectMaster;
import com.resume.service.IProjectMasterService;

@RestController
public class ProjectMasterController {
	@Autowired
	private IProjectMasterService projectMasterService;
	
	@GetMapping("/project")
	public ResponseEntity<List<ProjectMaster>> getProjectMaster() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(projectMasterService.getAllProject());
	}

	@PostMapping("/project")
	public ResponseEntity<Long> saveProjectMaster(@RequestBody ProjectMaster projectMaster) {
		// TODO Auto-generated method stub	
		return ResponseEntity.ok(projectMasterService.saveProjectMaster(projectMaster));
	}
	

	@PutMapping("/project/{project_id}")
	public ResponseEntity<ProjectMaster> updateProjectMaster(@RequestBody ProjectMaster projectMaster, @PathVariable Long project_id) {
		ProjectMaster response = projectMasterService.updateProjectMaster(projectMaster, project_id);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/project/{project_id}")
	public ResponseEntity<Void> deleteProjectMaster(@PathVariable Long project_id) {
		projectMasterService.deleteProjectMaster(project_id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
