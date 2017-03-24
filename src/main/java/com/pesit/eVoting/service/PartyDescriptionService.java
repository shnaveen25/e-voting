package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.sql.domain.PartyDescription;

public interface PartyDescriptionService {
	
	public boolean addParty(PartyDescription addPartyBean);
	
	public List<PartyDto> getParty();
	
	public List<PartyDto> viewAllParties();
}
