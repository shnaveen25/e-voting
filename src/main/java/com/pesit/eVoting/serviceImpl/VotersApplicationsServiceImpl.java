package com.pesit.eVoting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.VotersApplicationsService;
import com.pesit.eVoting.sql.dao.VotersApplicationsDAO;
import com.pesit.eVoting.sql.domain.VotersApplications;

@Service("VotersApplications")
public class VotersApplicationsServiceImpl implements VotersApplicationsService {

	@Autowired
	private VotersApplicationsDAO voterApplicationDao;
	
	@Override
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto) {
		
		VotersApplications isApplicationExists = voterApplicationDao.findByAadhar(voterApplicationDto.getAadhar());
		
		if(isApplicationExists == null) {	
			isApplicationExists = new VotersApplications();
			isApplicationExists.setStateId(voterApplicationDto.getStateId());
			isApplicationExists.setDistrictId(voterApplicationDto.getDistrictId());
			isApplicationExists.setAssemblyId(voterApplicationDto.getAssemblyId());
			isApplicationExists.setName(voterApplicationDto.getName()+" "+voterApplicationDto.getSurName());
			//isApplicationExists.setDob(voterApplicationDto.getDob());
			isApplicationExists.setGender(voterApplicationDto.getGender());
			isApplicationExists.setMobile(voterApplicationDto.getMobile());
			isApplicationExists.setEmail(voterApplicationDto.getEmail());
			isApplicationExists.setAadhar(voterApplicationDto.getAadhar());
			isApplicationExists.setAddress(voterApplicationDto.getArea()+" , "+voterApplicationDto.getStreet());
			isApplicationExists.setLandMark(voterApplicationDto.getLandMark());
			isApplicationExists.setPinCode(voterApplicationDto.getPinCode());
			isApplicationExists.setApplicationStatus("pending");
			//isApplicationExists.setAddedBy(addedBy);
			//isApplicationExists.setCreatedDate(createdDate);
			
			voterApplicationDao.save(isApplicationExists);
			
			return Constants.SUCCESS;
		} else {
			return "Application Already exists...!!";
		}
	}

}
