package com.pesit.eVoting.sql.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="election")
public class Election implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="state_id")
	private long stateId;
	
	@Column(name="election_for")
	private String electionFor;
	
	@Column(name="status")
	private String status;
	
	@Column(name="election_date")
	private String electionDate;
	
	@Column(name="created_date")
	private Timestamp createdDate;

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

	@Override
	public String toString() {
		return "Election [id=" + id + ", stateId=" + stateId + ", electionFor=" + electionFor + ", status=" + status
				+ ", electionDate=" + electionDate + ", createdDate=" + createdDate + "]";
	}
	
	
	
}
