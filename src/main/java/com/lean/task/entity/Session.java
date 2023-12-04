package com.lean.task.entity;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

// Session table
@Entity
public class Session {
	@Id
	@GeneratedValue
	private Long id;
	
	private Date date;
	private Time time;
	private Long clientId;
	private Long consultantId;
	private String documentsList;
	private List<String> documents;

	//NoArgs Constructor
	public Session() {
		super();
	}
	
	//AllArgs Constructor
	public Session(Long id, Date date, Time time, Long clientId, Long consultantId, String documentsList,
			List<String> documents) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.clientId = clientId;
		this.consultantId = consultantId;
		this.documentsList = documentsList;
		this.documents = documents;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Long getConsultantId() {
		return consultantId;
	}
	public void setConsultantId(Long consultantId) {
		this.consultantId = consultantId;
	}
	public String getDocumentsList() {
		return documentsList;
	}
	public void setDocumentsList(String documentsList) {
		this.documentsList = documentsList;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	public void addDocument(String doc)
	{
		if(this.documents==null)
			documents=new ArrayList<String>();
		this.documents.add(doc);
	}
	
}
