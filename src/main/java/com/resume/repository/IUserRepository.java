package com.resume.repository;

import java.util.List;
import java.util.Optional;

import com.resume.model.User;

public interface IUserRepository {
	
	public List<User> getUsers();
	
	public Optional<User> getUserById(Long user_id);
	
	public Integer addUser(User user);
	
	public Integer deleteUser(Long userId);

}
