package com.lean.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lean.task.entity.Review;

//Review Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
	//Query for fetching review by Session Id
	Review findBySessionId(Long Id);
}
