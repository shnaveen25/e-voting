package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.Elector;

@Component
public class ElectorDAO extends BaseDao<Elector>{
	

	@Transactional
	public Elector findByAadharNumber(long aadhar){
		
		Criteria crit = getCurrentSession().createCriteria(Elector.class);
		crit.add(Restrictions.eq("aadhar", aadhar));
		
		return (Elector) crit.uniqueResult();
	}
	
	@Transactional
	public Elector findByElectorIdAndPassord(String electorId , String password){
		
		Criteria crit = getCurrentSession().createCriteria(Elector.class);
		crit.add(Restrictions.eq("electorId", electorId));
		crit.add(Restrictions.eq("password", password));
		
		return (Elector) crit.uniqueResult();
	}
	
	@Transactional
	public Elector findByEmail(String email){
		
		Criteria crit = getCurrentSession().createCriteria(Elector.class);
		crit.add(Restrictions.eq("email", email));
		
		return (Elector) crit.uniqueResult();
	}
	
	@Transactional
	public List<Elector> findAllElectorByAssId(long assId){
		
		Criteria crit = getCurrentSession().createCriteria(Elector.class);
		crit.add(Restrictions.eq("assemblyId", assId));
		
		return (List<Elector>) crit.list();
	}
}
