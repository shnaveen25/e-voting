/**
 * 
 */
package com.pesit.eVoting.sql.domain;

import java.io.Serializable;
import java.sql.Timestamp;

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
public class PartyDescription implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Timestamp createdDate;

	@Override
	public String toString() {
		return "PartyDescription [id=" + id + ", partyName=" + partyName + ", partyDescription=" + partyDescription
				+ ", mpMembers=" + mpMembers + ", mlaMembers=" + mlaMembers + ", email=" + email + ", createdDate="
				+ createdDate + "]";
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}

