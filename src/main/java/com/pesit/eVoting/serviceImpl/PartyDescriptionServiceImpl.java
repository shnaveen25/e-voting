package com.pesit.eVoting.serviceImpl;

//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.service.PartyDescriptionService;
import com.pesit.eVoting.sql.dao.PartyDescriptionDAO;
import com.pesit.eVoting.sql.domain.PartyDescription;

/**
 * 
 * @author 
 *
 */

@Service("PartyDescriptionService")
public class PartyDescriptionServiceImpl implements PartyDescriptionService{
	
	@Autowired
	private PartyDescriptionDAO partyDescriptionDao;

	@Override
	public boolean addParty(PartyDescription addPartyBean) {
	
		PartyDescription existingParty = partyDescriptionDao.findByPartyName(addPartyBean.getPartyName());
		
		if(existingParty == null){
			partyDescriptionDao.save(addPartyBean);
			return true;
		}
		return false;
	} //End Method addParty()

	@Override
	public List<PartyDto> getParty() {
		List<PartyDto> responsePartyData = new ArrayList<PartyDto>();
		List<PartyDescription> partyFromDb = partyDescriptionDao.getPartyName();
		
		for(PartyDescription indudivalParty : partyFromDb){
			//System.out.println("Indudival Parties from getParty() of PartyDescriptionServiceImpl: "+ indudivalParty);
			PartyDto partyList = new PartyDto();
			partyList.setPartyName(indudivalParty.getPartyName());
			partyList.setId(indudivalParty.getId());
			responsePartyData.add(partyList);
		}
		
		return responsePartyData;
	}

	@Override
	public List<PartyDto> viewAllParties() {
		List<PartyDto> responsePartyData = new ArrayList<PartyDto>();
		List<PartyDescription> partiesFromDb = partyDescriptionDao.findAll();
		System.out.println("Orginal List of partied : "+partiesFromDb);
		for(PartyDescription indudivalParty  : partiesFromDb){
			
			//Timestamp currentDate = new Timestamp(new Date().getTime());
			PartyDto party = new PartyDto();
			party.setPartyName(indudivalParty.getPartyName());
			party.setPartyEmail(indudivalParty.getEmail());
			party.setPartyDescription(indudivalParty.getPartyDescription());
			party.setId(indudivalParty.getId());
			party.setMpMembers(indudivalParty.getMpMembers());
			party.setMlaMembers(indudivalParty.getMlaMembers());
			//party.setCreatedDate(currentDate);
			
			responsePartyData.add(party);
		}
		System.out.println("List of Parties from DB : "+responsePartyData);
		return responsePartyData;
	}
}
