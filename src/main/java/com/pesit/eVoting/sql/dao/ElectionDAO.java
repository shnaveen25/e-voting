package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.sql.domain.Election;

@Component
public class ElectionDAO extends BaseDao<Election> {

	@Transactional
	public List<Election> findByUpcomingElection(){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("status" , Constants.UPCOMING_ELECTION));
		
		return crit.list();
	}
	
	@Transactional
	public List<Election> findByUpComingOrOnGoingElection(){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		Criterion cond1 = Restrictions.eq("status" , Constants.UPCOMING_ELECTION);
		Criterion cond2 = Restrictions.eq("status" , Constants.ON_GOING);
		Criterion cond3 = Restrictions.eq("status" , Constants.PAUSED);
		
		crit.add(Restrictions.or(cond1, cond2, cond3));
		
		return crit.list();
	}
	
	@Transactional
	public List<Election> findPastElection(){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("status" , Constants.FINISHED));
		
		return crit.list();
	}
	
	@Transactional
	public List<Election> findByStateUpcomingElection(long id, String date){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("stateId" , id));
		crit.add(Restrictions.eq("status" , Constants.UPCOMING_ELECTION));
		crit.add(Restrictions.ge("electionDate" ,date));
		
		return crit.list();
	}
	
	@Transactional
	public Election findByCurrentElection(long stateId , String date){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("stateId" , stateId));
		crit.add(Restrictions.eq("status" ,  Constants.ON_GOING));
		
		return (Election) crit.uniqueResult();
	}

}
