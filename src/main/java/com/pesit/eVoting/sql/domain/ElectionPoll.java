package com.pesit.eVoting.sql.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="election_poll")
public class ElectionPoll implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="election_id")
	private long electionId;
	
	@Column(name="participant_id")
	private long participantid;
	
	@Column(name="	no_of_votes")
	private long votes;

	@Override
	public String toString() {
		return "ElectionPoll [id=" + id + ", electionId=" + electionId + ", participantid=" + participantid + ", votes="
				+ votes + "]";
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

	public long getParticipantid() {
		return participantid;
	}

	public void setParticipantid(long participantid) {
		this.participantid = participantid;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}
	
	
}
