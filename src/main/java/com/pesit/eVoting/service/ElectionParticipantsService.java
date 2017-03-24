package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.ParticipantsDto;

public interface ElectionParticipantsService {
	
	public void addParticipant(ParticipantsDto participant);
	
	public List<ParticipantsDto> getAllParticipants();
	
}
