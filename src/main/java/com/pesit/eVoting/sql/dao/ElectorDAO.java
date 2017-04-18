package com.pesit.eVoting.sql.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.Admin;
import com.pesit.eVoting.sql.domain.Elector;

@Component
public class ElectorDAO extends BaseDao<Elector>{
	

	@Transactional
	public Elector findByAadharNumber(long aadhar){
		Criteria crit = getCurrentSession().createCriteria(Elector.class);
		crit.add(Restrictions.eq("aadhar", aadhar));
		
		return (Elector) crit.uniqueResult();
	}
}
