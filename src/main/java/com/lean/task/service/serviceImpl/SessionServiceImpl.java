package com.lean.task.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lean.task.entity.Session;
import com.lean.task.repository.SessionRepository;
import com.lean.task.service.SessionServices;

//Session Service Functions Implementation
@Service
public class SessionServiceImpl implements SessionServices {
	private SessionRepository sessionRepository;
	
	public SessionServiceImpl(SessionRepository sessionRepository) {
		super();
		this.sessionRepository = sessionRepository;
	}

	@Override
	public Session saveSession(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public List<Session> getAllClientSession(Long Id) {
		return sessionRepository.findByClientId(Id);
	}

	@Override
	public List<Session> getAllConsultantSession(Long Id) {
		return sessionRepository.findByConsultantId(Id);
	}

	@Override
	public Session getById(Long Id) {
		return sessionRepository.findById(Id).get();
	}

	@Override
	public Session getByIdAndClientId(Long Id, Long clientId) {
		return sessionRepository.findByIdAndClientId(Id, clientId);
	}
	
	
	
	

}
