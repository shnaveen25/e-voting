package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.ElectionParticipants;

@Component
public class ElectionParticipantsDAO extends BaseDao<ElectionParticipants>{

	@Transactional
	public List<ElectionParticipants> getParticipantByEleId(long electionId){
		
		Criteria crit = getCurrentSession().createCriteria(ElectionParticipants.class);
		crit.add(Restrictions.eq("electionId", electionId));
		
		return crit.list();
	}
	
	@Transactional
	public List<ElectionParticipants> getParticipantByEleIdAndAssId(long electionId , long assemblyId){
		
		Criteria crit = getCurrentSession().createCriteria(ElectionParticipants.class);
		crit.add(Restrictions.eq("electionId", electionId));
		crit.add(Restrictions.eq("assemblyId", assemblyId));
		
		return crit.list();
	}
	
	@Transactional
	public ElectionParticipants getParticipantByIdAndAssId(long participantId , long assemblyId){
		
		Criteria crit = getCurrentSession().createCriteria(ElectionParticipants.class);
		crit.add(Restrictions.eq("id", participantId));
		crit.add(Restrictions.eq("assemblyId", assemblyId));
		
		return (ElectionParticipants) crit.uniqueResult();
	}
	
	/*@Transactional
	public ElectionParticipants getNoOfVotes(long participantId){
		
		Criteria crit = getCurrentSession().createCriteria(ElectionParticipants.class);
		crit.add(Restrictions.eq("noOfVites", participantId));
		
		return  (ElectionParticipants) crit.uniqueResult();
	}*/
}
