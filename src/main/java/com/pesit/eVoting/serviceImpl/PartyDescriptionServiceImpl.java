package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.service.PartyDescriptionService;
import com.pesit.eVoting.sql.dao.ElectionParticipantsDAO;
import com.pesit.eVoting.sql.dao.PartyDescriptionDAO;
import com.pesit.eVoting.sql.domain.ElectionParticipants;
import com.pesit.eVoting.sql.domain.PartyDescription;

/**
 * 
 * @author
 *
 */

@Service("PartyDescriptionService")
public class PartyDescriptionServiceImpl implements PartyDescriptionService {

	@Autowired
	private PartyDescriptionDAO partyDescriptionDao;
	
	@Autowired
	private ElectionParticipantsDAO electionParticipantDao;

	@Override
	@Transactional
	public String addParty(PartyDto addPartyDto) {

		PartyDescription partyDescription = partyDescriptionDao.findByPartyName(addPartyDto.getPartyName().toLowerCase());

		if (partyDescription == null) {

			PartyDescription isEmailExist = partyDescriptionDao.findByEmail(addPartyDto.getPartyEmail());
			if (isEmailExist != null) {
				return "Email already registered with us...!!";
			}

			partyDescription = new PartyDescription();
			partyDescription.setPartyName(addPartyDto.getPartyName().toLowerCase());
			partyDescription.setPartyDescription(addPartyDto.getPartyDescription());
			partyDescription.setEmail(addPartyDto.getPartyEmail());
			partyDescription.setMpMembers(addPartyDto.getMpMembers());
			partyDescription.setMlaMembers(addPartyDto.getMlaMembers());

			partyDescriptionDao.save(partyDescription);
			return Constants.SUCCESS;
		}
		return "Party already added";
	} // End Method addParty()

	@Override
	public List<PartyDto> getParty() {
		List<PartyDto> responsePartyData = new ArrayList<PartyDto>();
		List<PartyDescription> partyFromDb = partyDescriptionDao.getPartyName();

		for (PartyDescription indudivalParty : partyFromDb) {
			// System.out.println("Indudival Parties from getParty() of
			// PartyDescriptionServiceImpl: "+ indudivalParty);
			PartyDto partyList = new PartyDto();
			partyList.setPartyName(indudivalParty.getPartyName());
			partyList.setId(indudivalParty.getId());
			responsePartyData.add(partyList);
		}

		return responsePartyData;
	}

	@Override
	@Transactional
	public List<PartyDto> viewAllParties() {
		List<PartyDto> responsePartyData = new ArrayList<PartyDto>();
		List<PartyDescription> partiesFromDb = partyDescriptionDao.findAll();
		// System.out.println("Orginal List of partied : "+partiesFromDb);
		for (PartyDescription indudivalParty : partiesFromDb) {

			Timestamp currentDate = new Timestamp(new Date().getTime());
			PartyDto party = new PartyDto();
			party.setPartyName(indudivalParty.getPartyName());
			party.setPartyEmail(indudivalParty.getEmail());
			party.setPartyDescription(indudivalParty.getPartyDescription());
			party.setId(indudivalParty.getId());
			party.setMpMembers(indudivalParty.getMpMembers());
			party.setMlaMembers(indudivalParty.getMlaMembers());
			party.setCreatedDate(currentDate);

			responsePartyData.add(party);
		}
		// System.out.println("List of Parties from DB : "+responsePartyData);
		return responsePartyData;
	}

	@Override
	@Transactional
	public List<PartyDto> getNoParticipantParties(long assId , long electionId) {
		List<PartyDto> responsePartyData = new ArrayList<PartyDto>();
		
		List<ElectionParticipants> participantFromAssembly = electionParticipantDao.getParticipantByEleIdAndAssId(electionId, assId);
		
		List<PartyDescription> partiesFromDb = partyDescriptionDao.findAll();
		
		if(participantFromAssembly != null){
			for(int i = 0 ; i < partiesFromDb.size() ; i++){
				int count = 0;
				for(int j = 0 ; j < participantFromAssembly.size() ; j++){
					if(partiesFromDb.get(i).getId() == participantFromAssembly.get(j).getPartyId()){
						count++;
					}
				}
				if(count == 0){
					PartyDto party = new PartyDto(partiesFromDb.get(i));
					System.out.println("when null"+party);
					responsePartyData.add(party);
				}
			}
		} else{
			for(PartyDescription indudivalParty : partiesFromDb){
				PartyDto party = new PartyDto(indudivalParty);
				System.out.println(party);
				responsePartyData.add(party);
			}
		}
		System.out.println("Responsable party :"+responsePartyData);
		System.out.println("Size :"+responsePartyData.size());
		return responsePartyData;
	}
}
