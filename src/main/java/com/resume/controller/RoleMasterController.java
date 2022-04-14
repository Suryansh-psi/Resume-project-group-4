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

import com.resume.model.Resume;
import com.resume.model.RoleMaster;
import com.resume.service.IRoleMasterService;

@RestController
public class RoleMasterController implements IRoleMasterController{
	@Autowired
	private IRoleMasterService roleMasterService;

	@GetMapping("/role")
	public ResponseEntity<List<RoleMaster>> getRoleMaster() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(roleMasterService.getAllRole());
	}

	@PostMapping("/role")
	public ResponseEntity<Void> saveRoleMaster(@RequestBody RoleMaster roleMaster) {
		// TODO Auto-generated method stub
		ResponseEntity response;
		boolean status = roleMasterService.saveRoleMaster(roleMaster);
		if(status) {
			response = ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return response;
	}
	
	@DeleteMapping("role/{role_id}")
	public ResponseEntity<Void> deleteRoleMaster(@PathVariable Long role_id) {
		roleMasterService.deleteRoleMaster(role_id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

	@PutMapping("/role/{role_id}")
	public ResponseEntity<RoleMaster> updateRoleMaster(@RequestBody RoleMaster roleMaster, @PathVariable Long role_id) {
		RoleMaster response = roleMasterService.updateRoleMaster(roleMaster, role_id);
		return ResponseEntity.ok(response);
	}
}
