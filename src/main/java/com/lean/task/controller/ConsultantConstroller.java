package com.lean.task.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lean.task.entity.Review;
import com.lean.task.entity.Session;
import com.lean.task.service.ReviewService;
import com.lean.task.service.SessionServices;

//Consultant API Controller Class
@RestController
public class ConsultantConstroller {

	private SessionServices sessionService;
	private ReviewService reviewService;
	public ConsultantConstroller(SessionServices sessionService,ReviewService reviewService) {
		super();
		this.sessionService = sessionService;
		this.reviewService = reviewService;
	}
	
	//API to All Sessions of Consultant 
	@GetMapping("/consultant/getAllSessions/{consultantId}")
	public List<Session> getAllConsultantSession(@PathVariable Long consultantId)
	{
		return sessionService.getAllConsultantSession(consultantId);
	}
	
	//API for Consultant to Submit feedback
	@PostMapping("/consultent/submitFeedback")
	public String feedback(@RequestBody Review review)
	{
		reviewService.saveReview(review);
		return "Feedback Submitted Sucessfully";
	}
	
	//API for Consultant tp upload Document List
	@PostMapping("/consultant/uploadDocumentList")
	public String uploadDocumentList(@RequestParam("Id") Long id,
            @RequestParam("documentList") String documentlist)
	{
		Session session=null;
		try {
		session=sessionService.getById(id);
		}
		catch(Exception e)
		{
			return "There is no Session with Id "+id+"";
		}
		if(session==null)
			return "please book session first";
		session.setDocumentsList(documentlist);
		sessionService.saveSession(session);
		return "list of document required for session successfully updated.";
	}
	
	//API for Consultant to get All Documents uploaded by Client
	@GetMapping("/consultant/getAllDocument/{sessionId}")
	public List<String> getAllDocuments(@PathVariable Long sessionId)
	{
		Session session=sessionService.getById(sessionId);
		return session.getDocuments();
	}
	
}
