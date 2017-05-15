package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.PartyDto;

public interface PartyDescriptionService {
	

	/**
	 * 
	 * The Service method to add the party<br>
	 * <b>Flow : </b><br>
	 * * Admin clicks for a add party <br>
	 * * Admin Enters Party Name, pArty Email, Party Description details <br>
	 * * Then Clicks Add Button<br>
	 * 
	 * <b>Flow : </b><br>
	 * * Accepts the entered input<br>
	 * * Checks Weather the Party has been exist<br>
	 * * If party already exists then return back to client with error message<br>
	 * * if party not exists save the party to related database. 
	 * 
	 * @author
	 * @param PartyDto
	 * @return
	 * 
	 * 
	 */
	public String addParty(PartyDto addPartyDto);
	
	public List<PartyDto> getParty();
	
	public List<PartyDto> viewAllParties();
	
	public List<PartyDto> getNoParticipantParties(long assId , long electionId);
}
