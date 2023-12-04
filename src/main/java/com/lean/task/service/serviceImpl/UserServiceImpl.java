package com.lean.task.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lean.task.entity.User;
import com.lean.task.repository.UserRepository;
import com.lean.task.service.UserService;

//User Service Implementation for User Service function
@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(Long Id) {
		return userRepository.findById(Id).get();
	}

	@Override
	public List<User> getByRoleContainingIgnoreCase(String role) {
		return userRepository.findByRoleContainingIgnoreCase(role);
	}

}
