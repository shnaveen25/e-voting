package com.pesit.eVoting.sql.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.Election;
import com.pesit.eVoting.sql.domain.PublicVoteRecords;

@Component
public class PublicVoteRecordsDAO extends BaseDao<PublicVoteRecords> {

	@Transactional
	public PublicVoteRecords findByElectionIdAndElectorId(long electionId , long electorId){
		
		Criteria crit = getCurrentSession().createCriteria(PublicVoteRecords.class);
		
		crit.add(Restrictions.eq("electionId" , electionId));
		crit.add(Restrictions.eq("electorId" , electorId));
		
		return (PublicVoteRecords) crit.uniqueResult();
	}
}
