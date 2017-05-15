package com.pesit.eVoting.service;

import java.io.Serializable;
import java.util.List;

import com.pesit.eVoting.dto.ElectorDto;

public interface ElectorService extends Serializable {
	
	public String registerVoter(long id);
	
	public ElectorDto authonticateActiveElector(String electorId , String password);
	
	public String changeElectorPassword(String email);
	
	public List<ElectorDto> getAllElectorsOfAss(long assId);
	
	public String activeOrInactiveElector(long id);

	public String getOTP(String electorId);
	
	public ElectorDto getElectorProfileByEleId(String electorId);

}
