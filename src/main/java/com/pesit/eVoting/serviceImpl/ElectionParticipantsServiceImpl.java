package com.pesit.eVoting.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.sql.dao.ElectionParticipantsDAO;
import com.pesit.eVoting.sql.dao.PartyDescriptionDAO;
import com.pesit.eVoting.sql.domain.ElectionParticipants;
import com.pesit.eVoting.sql.domain.PartyDescription;

@Service("ElectionParticipants")
public class ElectionParticipantsServiceImpl implements ElectionParticipantsService {

	@Autowired
	private ElectionParticipantsDAO electionParticipantDao;
	
	@Autowired
	private PartyDescriptionDAO partyDescriptionDao;
	
	@Override
	public void addParticipant(ParticipantsDto participant) {

		//Timestamp currentDate = new Timestamp(new Date().getTime());
		ElectionParticipants electionParticipant = new ElectionParticipants();
		electionParticipant.setName(participant.getName());
		electionParticipant.setPartyId(participant.getPartyId());
		electionParticipant.setStateId(participant.getStateId());
		electionParticipant.setDistrictId(participant.getStateId());
		electionParticipant.setAssemblyId(participant.getAssemblyId());
		electionParticipant.setEmail(participant.getEmail());
		//electionParticipant.setDob(new Date(participant.getDob()));
		electionParticipant.setGender(participant.getGender());
		electionParticipant.setPost(participant.getPost());
		electionParticipant.setEducation(participant.getEducation());
		electionParticipant.setProperty(participant.getProperty());
		electionParticipant.setPoliceRecord(participant.getPoliceRecord());
		electionParticipant.setAdhaar(participant.getAdhaar());
		electionParticipant.setAddress(participant.getAddress());
		electionParticipant.setMobile(participant.getMobile());
		//electionParticipant.setCreatedDate(currentDate);
		electionParticipantDao.save(electionParticipant);
		
	}

	@Override
	public List<ParticipantsDto> getAllParticipants() {
		List<ParticipantsDto> responseParticipantsData = new ArrayList<ParticipantsDto>();
		List<ElectionParticipants> participantsFromDb = electionParticipantDao.findAll();
		
		for(ElectionParticipants indudivalParticipant : participantsFromDb) {
			PartyDescription partyName = partyDescriptionDao.findById(indudivalParticipant.getPartyId());
			
			ParticipantsDto participant = new ParticipantsDto();
			participant.setName(indudivalParticipant.getName());
			participant.setPartyName(partyName.getPartyName());
			participant.setEmail(indudivalParticipant.getEmail());
			participant.setAdhaar(indudivalParticipant.getAdhaar());
			participant.setPost(indudivalParticipant.getPost());
			
			responseParticipantsData.add(participant);
		}
		return responseParticipantsData;
	}

}
