package com.pesit.eVoting.sql.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="public_vote_records")
public class PublicVoteRecords implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="election_id")
	private long electionId;
	
	@Column(name="elector_id")
	private long electorId;

	@Override
	public String toString() {
		return "PublicVoteRecords [id=" + id + ", electionId=" + electionId + ", electorId=" + electorId + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getElectionId() {
		return electionId;
	}

	public void setElectionId(long electionId) {
		this.electionId = electionId;
	}

	public long getElectorId() {
		return electorId;
	}

	public void setElectorId(long electorId) {
		this.electorId = electorId;
	}
	
	
	
}
