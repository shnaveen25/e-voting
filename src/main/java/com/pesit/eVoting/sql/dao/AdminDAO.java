package com.pesit.eVoting.sql.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.Admin;

/**
 * This class do the operations related to the database
 * 
 * @author 
 *
 */
@Component
public class AdminDAO extends BaseDao<Admin> {

	@Transactional
	public Admin findByEmailAndPassword(String email , String password) {
		
		Criteria crit = getCurrentSession().createCriteria(Admin.class);
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("password", password));
		
		return (Admin) crit.uniqueResult();
	}

}
