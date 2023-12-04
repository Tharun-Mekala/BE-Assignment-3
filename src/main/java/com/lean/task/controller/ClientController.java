package com.lean.task.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lean.task.entity.Review;
import com.lean.task.entity.Session;
import com.lean.task.service.ReviewService;
import com.lean.task.service.SessionServices;
import com.lean.task.service.UserService;

//Client API Controller Class
@RestController
public class ClientController {
	
	private SessionServices sessionService;
	private ReviewService reviewService;
	private UserService userService;
	
	public ClientController(SessionServices sessionService,ReviewService reviewService,UserService userService) {
		super();
		this.sessionService = sessionService;
		this.reviewService = reviewService;
		this.userService= userService;
	}

	//API to BookSession
	@PostMapping("/client/bookSession")
	public String bookSession(@RequestBody Session session)
	{	
		Date minDate=Date.valueOf(LocalDate.now());
		Time minTime=Time.valueOf(LocalTime.of(9, 0));
		Time maxTime=Time.valueOf(LocalTime.of(18, 0));
		if(!userService.getById(session.getConsultantId()).getRole().equalsIgnoreCase("Consultant"))
			return "please chose a valid Consultant Id";
		if(session.getDate().compareTo(minDate)<0)
			return "Please Choose Valid Date";
		if(session.getTime().compareTo(minTime)<0||session.getTime().compareTo(maxTime)>0)
			return "Please Choose valid Time between 9:00 to 18:00";
		sessionService.saveSession(session);
		return "Session booked Successfully";
	}
	
	//API to fetch all Sessions of Client
	@GetMapping("/client/getAllSession/{clientId}")
	public List<Session> getAllSession(@PathVariable Long clientId)
	{
		return sessionService.getAllClientSession(clientId);
	}
	
	//API to fetch Review of Client
	@GetMapping("/client/getReview/{sessionId}")
	public Review getReview(@PathVariable Long sessionId)
	{
		return reviewService.getBySessionId(sessionId);
	}
	
	//API to fetch Document List
	@GetMapping("/client/getDocumentsList/{sessionId}")
	public String getDocumentsList(@PathVariable Long sessionId)
	{
		Session session=sessionService.getById(sessionId);
		return session.getDocumentsList();
	}
	
	//API to Client for uploading Documents required for session
	@PostMapping("/client/uploadDocuments/{sessionId}/{clientId}")
	public String uploadDocuments(@PathVariable Long clientId,@PathVariable Long sessionId,@RequestParam("Files") MultipartFile[] documents)
	{
		Session session=sessionService.getByIdAndClientId(sessionId, clientId);
		if(session==null)
			return "There is no session with this id and clientId";
		for(MultipartFile file:documents)
		{
			session.addDocument(file.getOriginalFilename());
			try {
        		File filePath=new ClassPathResource("static/Documents").getFile();
        		Path path=Paths.get(filePath.getAbsolutePath()+File.separator+file.getOriginalFilename());
        		Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
        	}
        	catch(Exception e)
        	{
        		return "Documents Uploaded Failed";
        	}
		}
		return "Documents Uploaded Sucessfully";
	}
}
