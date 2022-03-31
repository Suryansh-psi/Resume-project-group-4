package com.resume.service;

import java.util.List;

import com.resume.model.User;


public interface IUserService {
	
	public List<User> getAllUsers();
	
	public List<User> getUserById(Long user_id);
	
	public boolean saveUser(User user);
	
	public boolean deleteUser(Long userId);

}
