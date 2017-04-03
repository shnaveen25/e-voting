package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.AssemblyDistrictDto;

public interface AssemblyDistrictService {
	
	List<AssemblyDistrictDto> getDistrictsFromStates(long id);

}
