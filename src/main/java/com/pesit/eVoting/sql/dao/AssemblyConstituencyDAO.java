package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.pesit.eVoting.sql.domain.AssemblyConstituency;

@Component
public class AssemblyConstituencyDAO extends BaseDao<AssemblyConstituency> {
	
	@Transactional
	public List<AssemblyConstituency> findByDistrictId(long districtId){
		
		Criteria crit = getCurrentSession().createCriteria(AssemblyConstituency.class);
		crit.add(Restrictions.eq("districtId" , districtId));
		
		return (List<AssemblyConstituency>) crit.list();
	}
}
