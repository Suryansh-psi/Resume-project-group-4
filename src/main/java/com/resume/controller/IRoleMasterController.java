package com.resume.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.resume.model.RoleMaster;

public interface IRoleMasterController {
	public ResponseEntity<List<RoleMaster>> getRoleMaster();
	public ResponseEntity<Void> saveRoleMaster(RoleMaster roleMaster);

}
