package com.lean.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//Review table
@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long sessionId;
	private String feedback;
	
	//NoArgs Constructor
	public Review() {
		super();
	}
	
	//AllArgs Constructor
	public Review(Long id, Long sessionId, String feedback) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.feedback = feedback;
	}
	
	//Getters and Setters
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
