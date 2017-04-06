package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.AssemblyStatesDto;

public interface AssemblyStatesService {
	
	String getAssemblyStatesById(long id);
	
	List<AssemblyStatesDto> getAllStates();

}
