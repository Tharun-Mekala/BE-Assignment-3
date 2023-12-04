package com.lean.task.service;

import com.lean.task.entity.Review;

//Review Service Interface
public interface ReviewService {
	//Save review Service
	Review saveReview(Review review);
	//fetching review by Sesion Id Service
	Review getBySessionId(Long Id);
}
