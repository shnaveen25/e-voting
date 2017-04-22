package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.ElectionDto;
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.service.ElectionService;
import com.pesit.eVoting.sql.dao.ElectionParticipantsDAO;
import com.pesit.eVoting.sql.dao.PartyDescriptionDAO;
import com.pesit.eVoting.sql.domain.Election;
import com.pesit.eVoting.sql.domain.ElectionParticipants;
import com.pesit.eVoting.sql.domain.PartyDescription;

@Service("ElectionParticipants")
public class ElectionParticipantsServiceImpl implements ElectionParticipantsService {

	@Autowired
	private ElectionParticipantsDAO electionParticipantDao;

	@Autowired
	private PartyDescriptionDAO partyDescriptionDao;

	@Autowired
	private AssemblyStatesService assemblyStateService;

	@Autowired
	private AssemblyDistrictService assemblyDistricte;

	@Autowired
	private AssemblyConstituencyService assemblyConstituency;
	
	@Autowired
	private ElectionService electionService;

	@Autowired
	private MailService mailService;

	@Override
	public void addParticipant(ParticipantsDto participant) {

		Timestamp currentDate = new Timestamp(new Date().getTime());
		ElectionParticipants electionParticipant = new ElectionParticipants();
		electionParticipant.setName(participant.getName());
		electionParticipant.setPartyId(participant.getPartyId());
		electionParticipant.setStateId(participant.getStateId());
		electionParticipant.setDistrictId(participant.getDistrictId());
		electionParticipant.setAssemblyId(participant.getAssemblyId());
		electionParticipant.setElectionId(participant.getElectionId());
		electionParticipant.setEmail(participant.getEmail());
		electionParticipant.setDob(participant.getDob());
		electionParticipant.setGender(participant.getGender());
		electionParticipant.setPost(participant.getPost());
		electionParticipant.setEducation(participant.getEducation());
		electionParticipant.setProperty(participant.getProperty());
		electionParticipant.setPoliceRecord(participant.getPoliceRecord());
		electionParticipant.setAdhaar(participant.getAdhaar());
		electionParticipant.setAddress(participant.getAddress());
		electionParticipant.setMobile(participant.getMobile());
		electionParticipant.setCreatedDate(currentDate);
		electionParticipantDao.save(electionParticipant);

		String state = assemblyStateService.getAssemblyStatesById(participant.getStateId());
		String district = assemblyDistricte.getAssemblyDistrictById(participant.getDistrictId());
		String assembly = assemblyConstituency.getAssemblysById(participant.getAssemblyId());
		ElectionDto election = electionService.getElectionById(participant.getElectionId());
		
		new Thread(() -> {

			try {
				mailService.sendMailHtml(
						"E-VOTING: Application Status", mailService.getParticipantRegisteredMail(participant.getName(),
								state, district, assembly, participant.getPost(), election.getElectionDate()),
						participant.getEmail(), Constants.FROM_MAIL);
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}).start();

	}

	@Override
	public List<ParticipantsDto> getAllParticipants() {
		List<ParticipantsDto> responseParticipantsData = new ArrayList<ParticipantsDto>();
		List<ElectionParticipants> participantsFromDb = electionParticipantDao.findAll();

		for (ElectionParticipants indudivalParticipant : participantsFromDb) {
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
