package com.resume.repository;

import java.util.List;

import com.resume.model.User;

public interface IUserRepository {
	
	public List<User> getUsers();
	
	public List<User> getUserById(Long user_id);
	
	public Integer addUser(User user);
	
	public Integer deleteUser(Long userId);

}
