package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.AssemblyDistrict;

@Component
public class AssemblyDistrictDAO extends BaseDao<AssemblyDistrict> {
	
	@Transactional
	public List<AssemblyDistrict> findByStateId(long stateId){
		
		Criteria crit = getCurrentSession().createCriteria(AssemblyDistrict.class);
		crit.add(Restrictions.eq("stateId" , stateId));
		crit.addOrder(Order.asc("districtName"));
		return crit.list();
	}

}
