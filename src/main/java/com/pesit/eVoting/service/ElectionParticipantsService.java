package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.dto.ParticipantsDto;

public interface ElectionParticipantsService {
	
	public String addParticipant(ParticipantsDto participant);
	
	public List<ParticipantsDto> getAllParticipants();
	
	public List<ParticipantsDto> getCurrEleParicipantByState(long stateId);
	
	public List<ParticipantsDto> getCurrEleParicipantByAssembly(long stateId , long assemblyId);
	
	public String voteForSelectedParticipant(long participantId , ElectorDto elector);
	
	public List<ParticipantsDto> getNoOfVotes(long eleId , long stateId);
	
}
