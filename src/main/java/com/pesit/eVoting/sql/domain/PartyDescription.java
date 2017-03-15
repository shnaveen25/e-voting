/**
 * 
 */
package com.pesit.eVoting.sql.domain;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A POJO class represents party_description table
 * 
 * @author
 *
 */

@Entity
@Table(name="party_description")
public class PartyDescription {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="party_name" )
	private String partyName;
	
	@Column(name="party_description")
	private String partyDescription;
	
	@Column(name="mp_members")
	private String mpMembers;
	
	@Column(name="mla_members")
	private String mlaMembers;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	private Date createdDate;

	@Override
	public String toString() {
		return "PartyDescription [id=" + id + ", partyName=" + partyName + ", partyDescription=" + partyDescription
				+ ", mpMembers=" + mpMembers + ", mlaMembers=" + mlaMembers + ", email=" + email + ", createdDate="
				+ createdDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mlaMembers == null) ? 0 : mlaMembers.hashCode());
		result = prime * result + ((mpMembers == null) ? 0 : mpMembers.hashCode());
		result = prime * result + ((partyDescription == null) ? 0 : partyDescription.hashCode());
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartyDescription other = (PartyDescription) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (mlaMembers == null) {
			if (other.mlaMembers != null)
				return false;
		} else if (!mlaMembers.equals(other.mlaMembers))
			return false;
		if (mpMembers == null) {
			if (other.mpMembers != null)
				return false;
		} else if (!mpMembers.equals(other.mpMembers))
			return false;
		if (partyDescription == null) {
			if (other.partyDescription != null)
				return false;
		} else if (!partyDescription.equals(other.partyDescription))
			return false;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyDescription() {
		return partyDescription;
	}

	public void setPartyDescription(String partyDescription) {
		this.partyDescription = partyDescription;
	}

	public String getMpMembers() {
		return mpMembers;
	}

	public void setMpMembers(String mpMembers) {
		this.mpMembers = mpMembers;
	}

	public String getMlaMembers() {
		return mlaMembers;
	}

	public void setMlaMembers(String mlaMembers) {
		this.mlaMembers = mlaMembers;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}

