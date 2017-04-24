package com.pesit.eVoting.service;

import java.io.Serializable;

import com.pesit.eVoting.dto.ElectorDto;

public interface ElectorService extends Serializable {
	
	public String registerVoter(long id);
	
	public ElectorDto authonticateActiveElector(String electorId , String password);

}
