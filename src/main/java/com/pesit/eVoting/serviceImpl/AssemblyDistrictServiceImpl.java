package com.pesit.eVoting.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.dto.AssemblyDistrictDto;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.sql.dao.AssemblyDistrictDAO;
import com.pesit.eVoting.sql.domain.AssemblyDistrict;

/**
 * 
 * @author
 *
 */
@Service("AssemblyDistrictService")
public class AssemblyDistrictServiceImpl implements AssemblyDistrictService {

	@Autowired
	private AssemblyDistrictDAO assemblyDistrictDao;
	
	/**
	 * 
	 * This service method returns the list of districts for a state which has been selected by user
	 * 
	 * @param stateId
	 * @author
	 * @return
	 * 
	 */
	@Override	
	public List<AssemblyDistrictDto> getDistrictsFromStates(long stateId) {
		List<AssemblyDistrictDto> responseDistricts = new ArrayList<AssemblyDistrictDto>();
		
		List<AssemblyDistrict> districtsFormDb = assemblyDistrictDao.findByStateId(stateId);
		
		for(AssemblyDistrict indudivalDistricts : districtsFormDb){
			AssemblyDistrictDto district = new AssemblyDistrictDto();
			district.setId(indudivalDistricts.getId());
			district.setStateId(indudivalDistricts.getStateId());
			district.setDistrictName(indudivalDistricts.getDistrictName());
			
			responseDistricts.add(district);
		}
		
		return responseDistricts;
	}

}
