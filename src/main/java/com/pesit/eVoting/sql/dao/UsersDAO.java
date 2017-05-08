package com.pesit.eVoting.sql.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.sql.domain.Users;

/**
 * 
 * This class do the operations related to the database
 * 
 * @author
 *
 */
@Component
public class UsersDAO extends BaseDao<Users> {

	/**
	 * The service helps to check the authonticate the user
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@Transactional
	public Users findByEmailAndPassword(String email, String password) {

		Criteria crit = getCurrentSession().createCriteria(Users.class);
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("password", password));

		return (Users) crit.uniqueResult();
	}

	@Transactional
	public Users findByPassword(long id, String password) {

		Criteria crit = getCurrentSession().createCriteria(Users.class);
		crit.add(Restrictions.eq("id", id));
		crit.add(Restrictions.eq("password", password));

		return (Users) crit.uniqueResult();
	}
	
	@Transactional
	public Users findByEmail(String email) {

		Criteria crit = getCurrentSession().createCriteria(Users.class);
		
		crit.add(Restrictions.eq("email", email));

		return (Users) crit.uniqueResult();
	}
}
