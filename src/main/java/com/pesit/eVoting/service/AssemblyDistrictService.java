package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.AssemblyDistrictDto;

public interface AssemblyDistrictService {
	
	String getAssemblyDistrictById(long id);
	
	List<AssemblyDistrictDto> getDistrictsFromStates(long id);

}
