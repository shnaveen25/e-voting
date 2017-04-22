package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author
 *
 */

public class PartyDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	@NotEmpty
	private String partyName;
	
	private String partyDescription;
	
	private String mpMembers;
	
	private String mlaMembers;
	
	private String partyEmail;
	
	private Timestamp createdDate;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		PartyDto other = (PartyDto) obj;
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
	
	@Override
	public String toString() {
		return "PartyDto [id=" + id + ", partyName=" + partyName + ", partyDescription=" + partyDescription
				+ ", mpMembers=" + mpMembers + ", mlaMembers=" + mlaMembers + ", partyEmail=" + partyEmail
				+ ", createdDate=" + createdDate + "]";
	}

	public String getPartyEmail() {
		return partyEmail;
	}

	public void setPartyEmail(String partyEmail) {
		this.partyEmail = partyEmail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
