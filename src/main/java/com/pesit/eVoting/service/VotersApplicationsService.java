package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.VotersApplicationsDto;

public interface VotersApplicationsService {
	
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto , long appliedBy); 
	
	public List<VotersApplicationsDto> getUserAppliedApplications(long Id);
}
