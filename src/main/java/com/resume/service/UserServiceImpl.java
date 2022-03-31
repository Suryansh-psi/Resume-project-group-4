package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.User;
import com.resume.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.getUsers();
		return user;
	}

	@Override
	public List<User> getUserById(Long user_id) {
		List<User> user = userRepository.getUserById(user_id);
		return user;
	}

	@Override
	public boolean saveUser(User user) {
		Integer result = userRepository.addUser(user);
		if(result != null && result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(Long userId) {
		Integer result = userRepository.deleteUser(userId);
		return (result > 0);
	};
	
	

}
