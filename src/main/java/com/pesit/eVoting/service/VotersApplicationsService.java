package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.VotersApplicationsDto;

public interface VotersApplicationsService {
	
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto , long appliedBy); 
	
	public List<VotersApplicationsDto> getUserAppliedApplications(long Id);
	
	public String deleteUserApplication(long id);

	public List<VotersApplicationsDto> getAllPendingApplications();
	
	public void  updateApplicationStatus(long id, String comment, String status);
	
	public String editRequestElectorApplication(VotersApplicationsDto voterApplicationDto , long appliedBy);

	public String requestToDeletElector(long aadhar);
}
