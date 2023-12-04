package com.lean.task.service;

import java.util.List;

import com.lean.task.entity.User;

//User Serivce Interface
public interface UserService {
	User saveUser(User user);
	User getById(Long Id);
	List<User> getByRoleContainingIgnoreCase(String role);
}
