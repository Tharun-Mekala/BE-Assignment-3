package com.lean.task.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.task.entity.User;
import com.lean.task.service.UserService;

//User API Controller Class
@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	//API  for add user 
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user)
	{
			userService.saveUser(user);
			return "User added Successfully";
	}
	//API to get List of Consultant
	@GetMapping("/Consultantlist")
	public List<User> ConsultantList(){
		return  userService.getByRoleContainingIgnoreCase("consultant");
	}
	//API to get all Clients List
	@GetMapping("/ClientList")
	public List<User> ClientList()
	{
		return  userService.getByRoleContainingIgnoreCase("client");
	}

}
