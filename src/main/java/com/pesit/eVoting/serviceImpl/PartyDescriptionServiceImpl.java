package com.pesit.eVoting.serviceImpl;

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
	
	List<PartyDto> responsePartyData = new ArrayList<PartyDto>();

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
		
		List<PartyDescription> partyFromDb = partyDescriptionDao.getPartyName();
		
		for(PartyDescription indudivalParty : partyFromDb){
			System.out.println("Indudival Parties from getParty() of PartyDescriptionServiceImpl: "+ indudivalParty);
			PartyDto partyList = new PartyDto();
			partyList.setPartyName(indudivalParty.getPartyName());
			partyList.setId(indudivalParty.getId());
			responsePartyData.add(partyList);
		}
		
		return responsePartyData;
	}
}
