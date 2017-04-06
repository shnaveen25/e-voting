package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.AssemblyConstituencyDto;

public interface AssemblyConstituencyService {
	
	String getAssemblysById(long id);
	
	List<AssemblyConstituencyDto> getAssemblysFromDistricts(long districtId);
}
