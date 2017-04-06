package com.pesit.eVoting.serviceImpl;

import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.VotersApplicationsService;

@Service("VotersApplications")
public class VotersApplicationsServiceImpl implements VotersApplicationsService {

	@Override
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto) {
		
		return Constants.SUCCESS;
	}

}
