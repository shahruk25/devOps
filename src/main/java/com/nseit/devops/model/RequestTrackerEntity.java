package com.nseit.devops.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "RequestTracker")
@Validated
public class RequestTrackerEntity implements Serializable {

	private static final long serialVersionUID = -2931649067090251075L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String reqFrm;
    
    @NotBlank
    private String reqDesc;

//    @NotBlank
    @Enumerated(EnumType.ORDINAL)
    private RequestStatus status = RequestStatus.PENDING;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqFrm() {
		return reqFrm;
	}

	public void setReqFrm(String reqFrm) {
		this.reqFrm = reqFrm;
	}

	public String getReqDesc() {
		return reqDesc;
	}

	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestTrackerEntity [id=" + id + ", reqFrm=" + reqFrm + ", reqDesc=" + reqDesc + ", status=" + status
				+ "]";
	}
	
	
    
}