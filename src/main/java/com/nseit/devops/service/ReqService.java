package com.nseit.devops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nseit.devops.model.RequestTrackerEntity;
import com.nseit.devops.repo.ReqRepo;

@Service
public class ReqService {
	
	@Autowired
	private ReqRepo reqRepo;

	public List<RequestTrackerEntity> getAllReq() {
		return reqRepo.findAll();
	}

	public RequestTrackerEntity getReqById(Long id) {
		return reqRepo.findById(id).get();
	}

	public RequestTrackerEntity createOrUpdate(RequestTrackerEntity entity) {
		return reqRepo.save(entity);
	}
	
}
