package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.pesit.eVoting.sql.domain.Election;

public class ElectionDto implements Serializable {

	private long id;
	private long stateId;
	private String electionFor;
	private String status;
	private String electionDate;
	private Timestamp createdDate;
	
	
	public ElectionDto(Election ele) {
		
		id = ele.getId();
		stateId = ele.getStateId();
		electionFor= ele.getElectionFor();
		status = ele.getStatus();
		electionDate = ele.getElectionDate();
		createdDate = ele.getCreatedDate();
		
	}
	
	@Override
	public String toString() {
		return "ElectionDto [id=" + id + ", stateId=" + stateId + ", electionFor=" + electionFor + ", status=" + status
				+ ", electionDate=" + electionDate + ", createdDate=" + createdDate + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public String getElectionFor() {
		return electionFor;
	}
	public void setElectionFor(String electionFor) {
		this.electionFor = electionFor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getElectionDate() {
		return electionDate;
	}
	public void setElectionDate(String electionDate) {
		this.electionDate = electionDate;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
	


}
