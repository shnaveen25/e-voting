package com.pesit.eVoting.service;

import java.util.List;

import com.pesit.eVoting.dto.AssemblyConstituencyDto;

public interface AssemblyConstituencyService {
	
	List<AssemblyConstituencyDto> getAssemblysFromDistricts(long districtId);
}
