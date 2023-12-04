package com.lean.task.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.lean.task.entity.Review;
import com.lean.task.repository.ReviewRepository;
import com.lean.task.service.ReviewService;
//Service Class to implement review Serivce
@Service
public class ReviewServiceImpl implements ReviewService{
	private ReviewRepository reviewrepository;
	
	
	public ReviewServiceImpl(ReviewRepository reviewrepository) {
		super();
		this.reviewrepository = reviewrepository;
	}

	@Override
	public Review saveReview(Review review) {
		// TODO Auto-generated method stub
		return reviewrepository.save(review);
	}

	@Override
	public Review getBySessionId(Long Id) {
		return reviewrepository.findBySessionId(Id);
	}

}
