package com.pesit.eVoting.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.dto.AssemblyConstituencyDto;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.sql.dao.AssemblyConstituencyDAO;
import com.pesit.eVoting.sql.domain.AssemblyConstituency;

@Service("AssemblyConstituencyService")
public class AssemblyConstituencyServiceImpl implements AssemblyConstituencyService {

	@Autowired
	private AssemblyConstituencyDAO assemblyConstituencyDAO;
	
	/**
	 * 
	 * @param districtId
	 */
	@Override
	public List<AssemblyConstituencyDto> getAssemblysFromDistricts(long districtId) {
		List<AssemblyConstituencyDto> responseAssemblies = new ArrayList<AssemblyConstituencyDto>();
		
		List<AssemblyConstituency> assembliesFroDb = assemblyConstituencyDAO.findByDistrictId(districtId);
		
		for(AssemblyConstituency indudivalAssembly : assembliesFroDb){
			AssemblyConstituencyDto assembly = new AssemblyConstituencyDto();
			assembly.setId(indudivalAssembly.getId());
			assembly.setdistrictId(indudivalAssembly.getDistrictId());
			assembly.setAssembly(indudivalAssembly.getAssembly());
			
			responseAssemblies.add(assembly);
		}
		
		return responseAssemblies;
	}

	@Override
	public String getAssemblysById(long id) {
		
		AssemblyConstituency assembliesFroDb = assemblyConstituencyDAO.findById(id);
		
		return assembliesFroDb.getAssembly();
		
	}

}
