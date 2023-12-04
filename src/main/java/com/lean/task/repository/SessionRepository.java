package com.lean.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lean.task.entity.Session;

//Session Repository
public interface SessionRepository extends JpaRepository<Session, Long>{
	//Query to fetch List of session by Client ID
	List<Session> findByClientId(Long Id);
	//Query to fetch List Session by Consultant ID
	List<Session> findByConsultantId(Long Id);
	//Query to Fetch Session by Id and Client ID
	Session findByIdAndClientId(Long Id,Long clientId);

}
