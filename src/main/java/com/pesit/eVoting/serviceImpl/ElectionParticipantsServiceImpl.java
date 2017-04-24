package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.ElectionDto;
import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.service.ElectionService;
import com.pesit.eVoting.sql.dao.ElectionParticipantsDAO;
import com.pesit.eVoting.sql.dao.PartyDescriptionDAO;
import com.pesit.eVoting.sql.dao.PublicVoteRecordsDAO;
import com.pesit.eVoting.sql.domain.ElectionParticipants;
import com.pesit.eVoting.sql.domain.PartyDescription;
import com.pesit.eVoting.sql.domain.PublicVoteRecords;

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
	private PublicVoteRecordsDAO publicVoteRecordsDao;

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

	@Override
	public List<ParticipantsDto> getCurrEleParicipantByState(long stateId) {
		
		List<ParticipantsDto> responseParticipants = new ArrayList<ParticipantsDto>();
		
		Date currentDate = new Date();
		 
		ElectionDto currentElection = electionService.getCurrentElection(stateId, currentDate.toString());
		
		if(currentElection != null ){
			List<ElectionParticipants> curEleParticipant = electionParticipantDao.getParticipantByEleId(currentElection.getId());
			
			for(ElectionParticipants eachParticipant : curEleParticipant){
				PartyDescription partyName = partyDescriptionDao.findById(eachParticipant.getPartyId());
				ParticipantsDto participant = new ParticipantsDto();
				participant.setName(eachParticipant.getName());
				participant.setPartyName(partyName.getPartyName());
				responseParticipants.add(participant);
			}	
		}
		
		return responseParticipants;
		
	}

	@Override
	public List<ParticipantsDto> getCurrEleParicipantByAssembly(long stateId , long assemblyId) {
		List<ParticipantsDto> responseParticipants = new ArrayList<ParticipantsDto>();

		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(); 
		String currentDate = dateFormat.format(date).toString();
		System.out.println("date is string formate :"+currentDate);
		
		ElectionDto currentElection = electionService.getCurrentElection(stateId, currentDate);
		
		if(currentElection != null ){
			List<ElectionParticipants> curEleParticipant = electionParticipantDao.getParticipantByEleIdAndAssId(currentElection.getId() , assemblyId);
			
			for(ElectionParticipants eachParticipant : curEleParticipant){
				PartyDescription partyName = partyDescriptionDao.findById(eachParticipant.getPartyId());
				ParticipantsDto participant = new ParticipantsDto();
				participant.setId(eachParticipant.getId());
				participant.setName(eachParticipant.getName());
				participant.setPartyName(partyName.getPartyName());
				responseParticipants.add(participant);
			}	
		}
		
		return responseParticipants;
	}

	@Override
	public String voteForSelectedParticipant(long participantId, ElectorDto elector) {

		ElectionParticipants participantFromDb = electionParticipantDao.getParticipantByIdAndAssId(participantId, elector.getAssemblyId());
		
		if(participantFromDb != null){
			
			
			PublicVoteRecords votingData = publicVoteRecordsDao.
					findByElectionIdAndElectorId(participantFromDb.getElectionId(), elector.getId());
			
			if(votingData == null){
				votingData = new PublicVoteRecords();
				votingData.setElectionId(participantFromDb.getElectionId());
				votingData.setElectorId(elector.getId());
				publicVoteRecordsDao.save(votingData);
				
				long recordedVote = participantFromDb.getNoOfVotes();
				System.out.println("votes from db :"+participantFromDb.getNoOfVotes());
				participantFromDb.setNoOfVotes(++recordedVote);
				System.out.println("Updated Votes : "+participantFromDb.getNoOfVotes());
				electionParticipantDao.saveOrUpdate(participantFromDb);
				
				new Thread(() -> {

					try {
						mailService.sendMailHtml(
								"E-VOTING: Your vote has been recorded", mailService.getVotiedSuccessBody(elector.getName()),
								elector.getEmail(), Constants.FROM_MAIL);
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}).start();

				
			} else{
				return "You have been already casted your vote...";
			}
			return Constants.SUCCESS;
		} else{
			return "Please vote for your registered assembly only";
		}
	}
	
	


}
