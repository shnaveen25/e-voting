package com.pesit.eVoting.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.sql.dao.ElectionParticipantsDAO;
import com.pesit.eVoting.sql.domain.ElectionParticipants;

@Service("ElectionParticipants")
public class ElectionParticipantsServiceImpl implements ElectionParticipantsService {

	@Autowired
	private ElectionParticipantsDAO electionParticipantDao;
	
	@Override
	public void addParticipant(ParticipantsDto participant) {

		Date date = new Date();
		ElectionParticipants electionParticipant = new ElectionParticipants();
		electionParticipant.setName(participant.getName());
		electionParticipant.setPartyId(participant.getPartyId());
		electionParticipant.setParticipatingState(participant.getParticipatingState());
		electionParticipant.setEmail(participant.getEmail());
		//electionParticipant.setDob(new Date(participant.getDob()));
		electionParticipant.setGender(participant.getGender());
		electionParticipant.setPost(participant.getPost());
		electionParticipant.setParticipatingPlace(participant.getParticipatingPlace());
		electionParticipant.setEducation(participant.getEducation());
		electionParticipant.setProperty(participant.getProperty());
		electionParticipant.setPoliceRecord(participant.getPoliceRecord());
		electionParticipant.setAdhaar(participant.getAdhaar());
		electionParticipant.setAddress(participant.getAddress());
		electionParticipant.setMobile(participant.getMobile());
		//electionParticipant.setCreatedDate();
		electionParticipantDao.save(electionParticipant);
		
	}

}
