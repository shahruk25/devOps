package com.nseit.devops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nseit.devops.model.RequestTrackerEntity;

public interface ReqRepo extends JpaRepository<RequestTrackerEntity, Long> {


}
