package com.lean.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lean.task.entity.User;

//User Repository
public interface UserRepository extends JpaRepository<User,Long>{
	//Query to fetch List of User by Role 
	List<User> findByRoleContainingIgnoreCase(String role);
}
