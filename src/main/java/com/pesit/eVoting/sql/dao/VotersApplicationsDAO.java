package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.VotersApplications;

@Component
public class VotersApplicationsDAO extends BaseDao<VotersApplications>{

	@Transactional
	public VotersApplications findByAadhar(long aadhar){
		
		Criteria criteria = getCurrentSession().createCriteria(VotersApplications.class);
		criteria.add(Restrictions.eq("aadhar", aadhar));
		
		return (VotersApplications)criteria.uniqueResult();
		
	}
	
	@Transactional
	public List<VotersApplications> findByUserId(long id) {
		
		Criteria criteria = getCurrentSession().createCriteria(VotersApplications.class);
		criteria.add(Restrictions.eq("addedBy", id));
		
		return (List<VotersApplications>)criteria.list();
	}
	
	@Transactional
	public List<VotersApplications> findPendingApplications() {
		
		Criteria criteria = getCurrentSession().createCriteria(VotersApplications.class);
		criteria.add(Restrictions.eq("applicationStatus", "pending"));
		
		return (List<VotersApplications>)criteria.list();
	}
}
