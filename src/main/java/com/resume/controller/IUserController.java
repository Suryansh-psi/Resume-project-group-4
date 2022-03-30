package com.resume.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.resume.model.User;

public interface IUserController {
	
	public ResponseEntity<List<User>> getUser();
	
	public ResponseEntity<Void> saveUser(User user);

}
