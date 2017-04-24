package com.pesit.eVoting.sql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.AssemblyStates;

/**
 * 
 * @author
 * 
 */
@Component
public class AssemblyStatesDAO extends BaseDao<AssemblyStates> {

	@Transactional
	public List<AssemblyStates> getAllStates(){
		
		Criteria crit = getCurrentSession().createCriteria(AssemblyStates.class);
		crit.addOrder(Order.asc("stateName"));
		
		return crit.list();
	}
}
