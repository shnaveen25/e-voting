package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.dto.ParticipantsDto;

public interface ElectionParticipantsService {
	
	public void addParticipant(ParticipantsDto participant);
	
	public List<ParticipantsDto> getAllParticipants();
	
	public List<ParticipantsDto> getCurrEleParicipantByState(long stateId);
	
	public List<ParticipantsDto> getCurrEleParicipantByAssembly(long stateId , long assemblyId);
	
	public String voteForSelectedParticipant(long participantId , ElectorDto elector);
	
}
