package com.pesit.eVoting.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.sql.dao.AssemblyStatesDAO;
import com.pesit.eVoting.sql.domain.AssemblyStates;

@Service("AssemblyStatesService")
public class AssemblyStatesServiceImpl implements AssemblyStatesService {

	
	@Autowired
	private AssemblyStatesDAO assemblyStatesDao;
	
	@Override
	public List<AssemblyStatesDto> getAllStates() {
		
		List<AssemblyStatesDto> responseStates = new ArrayList<AssemblyStatesDto>();
		
		List<AssemblyStates> statesFormDb = assemblyStatesDao.getAllStates();
		
		for(AssemblyStates indudivalState : statesFormDb) {
			AssemblyStatesDto states = new AssemblyStatesDto();
			states.setId(indudivalState.getId());
			states.setStateName(indudivalState.getStateName());
			
			responseStates.add(states);
		}
		return responseStates;
	}

}
