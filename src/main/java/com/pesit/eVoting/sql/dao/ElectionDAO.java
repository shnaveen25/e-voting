package com.pesit.eVoting.sql.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
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
		
		return (List<Election>) crit.list();
	}
	
	@Transactional
	public List<Election> findByStateUpcomingElection(long id){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("stateId" , id));
		crit.add(Restrictions.eq("status" , Constants.UPCOMING_ELECTION));
		
		return (List<Election>) crit.list();
	}
	
	@Transactional
	public Election findByCurrentElection(long stateId , String date){
		
		Criteria crit = getCurrentSession().createCriteria(Election.class);
		
		crit.add(Restrictions.eq("stateId" , stateId));
		crit.add(Restrictions.eq("electionDate" , date));
		
		return (Election) crit.uniqueResult();
	}
}
