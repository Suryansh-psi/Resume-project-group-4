package com.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.model.User;
import com.resume.service.IUserService;

@RestController
public class UserControllerImpl implements IUserController {
	
	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getUser(@PathVariable Long user_id){
		
		return ResponseEntity.ok(userService.getUserById(user_id));
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> saveUser(@RequestBody User user) {
		
		ResponseEntity response;
		boolean status = userService.saveUser(user);
		if(status) {
			response = ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return response;
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
}
