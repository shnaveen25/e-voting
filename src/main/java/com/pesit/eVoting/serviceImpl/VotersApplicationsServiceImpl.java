package com.pesit.eVoting.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.VotersApplicationsService;
import com.pesit.eVoting.sql.dao.VotersApplicationsDAO;
import com.pesit.eVoting.sql.domain.AssemblyDistrict;
import com.pesit.eVoting.sql.domain.AssemblyStates;
import com.pesit.eVoting.sql.domain.VotersApplications;

@Service("VotersApplications")
public class VotersApplicationsServiceImpl implements VotersApplicationsService {

	@Autowired
	private VotersApplicationsDAO voterApplicationDao;

	@Autowired
	private AssemblyStatesService assemblyStateService;

	@Autowired
	private AssemblyDistrictService assemblyDistrictService;

	@Autowired
	private AssemblyConstituencyService assemblyConstituencyService;

	@Override
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto, long appliedBy) {

		VotersApplications isApplicationExists = voterApplicationDao.findByAadhar(voterApplicationDto.getAadhar());

		if (isApplicationExists == null) {
			isApplicationExists = new VotersApplications();
			isApplicationExists.setStateId(voterApplicationDto.getStateId());
			isApplicationExists.setDistrictId(voterApplicationDto.getDistrictId());
			isApplicationExists.setAssemblyId(voterApplicationDto.getAssemblyId());
			isApplicationExists.setName(voterApplicationDto.getName() + " " + voterApplicationDto.getSurName());
			// isApplicationExists.setDob(voterApplicationDto.getDob());
			isApplicationExists.setGender(voterApplicationDto.getGender());
			isApplicationExists.setMobile(voterApplicationDto.getMobile());
			isApplicationExists.setEmail(voterApplicationDto.getEmail());
			isApplicationExists.setAadhar(voterApplicationDto.getAadhar());
			isApplicationExists.setAddress(voterApplicationDto.getArea() + " , " + voterApplicationDto.getStreet());
			isApplicationExists.setLandMark(voterApplicationDto.getLandMark());
			isApplicationExists.setPinCode(voterApplicationDto.getPinCode());
			isApplicationExists.setApplicationStatus("pending");
			isApplicationExists.setAddedBy(appliedBy);
			// isApplicationExists.setCreatedDate(createdDate);

			voterApplicationDao.save(isApplicationExists);

			return Constants.SUCCESS;
		} else {
			return "Application Already exists...!!";
		}
	}

	@Override
	public List<VotersApplicationsDto> getUserAppliedApplications(long id) {

		List<VotersApplicationsDto> responseUserApplications = new ArrayList<VotersApplicationsDto>();

		List<VotersApplications> userApplicationsFromDb = voterApplicationDao.findByUserId(id);

		if (userApplicationsFromDb != null) {
			for (VotersApplications indudivalApplication : userApplicationsFromDb) {
				String stateName = assemblyStateService.getAssemblyStatesById(indudivalApplication.getStateId());
				String districtName = assemblyDistrictService.getAssemblyDistrictById(indudivalApplication.getDistrictId());
				String assemblyName = assemblyConstituencyService.getAssemblysById(indudivalApplication.getAssemblyId());
				// AssemblyDistrict district
				VotersApplicationsDto application = new VotersApplicationsDto(indudivalApplication);
				application.setStateName(stateName);
				application.setDistrictName(districtName);
				application.setAssemblyName(assemblyName);
				
				responseUserApplications.add(application);
			}
		}

		return responseUserApplications;
	}

}
