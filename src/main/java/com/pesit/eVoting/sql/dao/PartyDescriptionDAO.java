package com.pesit.eVoting.sql.dao;

import java.util.List;import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.sql.domain.PartyDescription;

@Component
public class PartyDescriptionDAO extends BaseDao<PartyDescription>{

	@Transactional
	public PartyDescription findByPartyName(String partyName) {
		
		Criteria crit = getCurrentSession().createCriteria(PartyDescription.class);
		crit.add(Restrictions.eq("partyName" , partyName));
		
		return (PartyDescription) crit.uniqueResult();
	}
	
	@Transactional
	public List<PartyDescription> getPartyName(){
		
		Criteria crit = getCurrentSession().createCriteria(PartyDescription.class);
		return (List<PartyDescription>) crit.list();
	}
}
