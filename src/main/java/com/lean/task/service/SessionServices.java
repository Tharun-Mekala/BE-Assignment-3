package com.lean.task.service;

import java.util.List;

import com.lean.task.entity.Session;

//Session Service
public interface SessionServices {
	Session saveSession(Session session);
	List<Session> getAllClientSession(Long Id);
	List<Session> getAllConsultantSession(Long Id);
	Session getById(Long Id);
	Session getByIdAndClientId(Long Id,Long clientId);
}
