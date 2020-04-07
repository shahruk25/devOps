package com.nseit.devops.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nseit.devops.exception.RecordNotFoundException;
import com.nseit.devops.model.RequestTrackerEntity;
import com.nseit.devops.service.ReqService;

@Controller
@RequestMapping(path = "/req")
public class ReqController {
	
	@Autowired
	private ReqService reqService;
	
	@GetMapping("/list")
	public String getAllReq(Model model) {
		List<RequestTrackerEntity> list = reqService.getAllReq();
		model.addAttribute("reqs", list);
		return "requestTracker/reqList";
	}
	
	@GetMapping(path = {"/edit", "/edit/{id}"})
	public String editReqyId(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
		if (id.isPresent()) {
			RequestTrackerEntity entity = reqService.getReqById(id.get());
			model.addAttribute("req", entity);
		} else {
			model.addAttribute("req", new RequestTrackerEntity());
		}
		return "requestTracker/plcReq";
	}
	
	@PostMapping(path = "/create")
	public String createOrUpdate(Model model,RequestTrackerEntity entity) throws RecordNotFoundException {
		if (entity.getId() != null ) {
			RequestTrackerEntity dbEntity = reqService.getReqById(entity.getId());
			dbEntity.setStatus(entity.getStatus());
			reqService.createOrUpdate(dbEntity);
		}else {
			reqService.createOrUpdate(entity);
		}
		List<RequestTrackerEntity> list = reqService.getAllReq();
		model.addAttribute("reqs", list);
		return "requestTracker/reqList";
	}
	
}
