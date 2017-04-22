package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.ElectionDto;

public interface ElectionService {

	public String addUpcomingElection(String electionFor , long stateId, String electionDate);
	
	public List<ElectionDto> getUpcomingElections();
	
	public List<ElectionDto> getUpcomingElectionForState(long id);
	
	public ElectionDto getElectionById(long id); 
}
