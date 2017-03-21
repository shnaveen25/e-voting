package com.pesit.eVoting.sql.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * A Pojo class represents election_participants table
 * 
 * @author 
 *
 */

@Entity
@Table(name="election_participants")
public class ElectionParticipants {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="party_id")
	private String partyId;
	
	@Column(name="name")
	private String name;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getParticipatingPlace() {
		return participatingPlace;
	}

	public void setParticipatingPlace(String participatingPlace) {
		this.participatingPlace = participatingPlace;
	}

	public String getParticipatingState() {
		return participatingState;
	}

	public void setParticipatingState(String participatingState) {
		this.participatingState = participatingState;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPoliceRecord() {
		return policeRecord;
	}

	public void setPoliceRecord(String policeRecord) {
		this.policeRecord = policeRecord;
	}

	public String getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((adhaar == null) ? 0 : adhaar.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((participatingPlace == null) ? 0 : participatingPlace.hashCode());
		result = prime * result + ((participatingState == null) ? 0 : participatingState.hashCode());
		result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
		result = prime * result + ((policeRecord == null) ? 0 : policeRecord.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
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
		ElectionParticipants other = (ElectionParticipants) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adhaar == null) {
			if (other.adhaar != null)
				return false;
		} else if (!adhaar.equals(other.adhaar))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (participatingPlace == null) {
			if (other.participatingPlace != null)
				return false;
		} else if (!participatingPlace.equals(other.participatingPlace))
			return false;
		if (participatingState == null) {
			if (other.participatingState != null)
				return false;
		} else if (!participatingState.equals(other.participatingState))
			return false;
		if (partyId == null) {
			if (other.partyId != null)
				return false;
		} else if (!partyId.equals(other.partyId))
			return false;
		if (policeRecord == null) {
			if (other.policeRecord != null)
				return false;
		} else if (!policeRecord.equals(other.policeRecord))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElectionParticipants [id=" + id + ", partyId=" + partyId + ", name=" + name + ", email=" + email
				+ ", post=" + post + ", participatingPlace=" + participatingPlace + ", participatingState="
				+ participatingState + ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender + ", education="
				+ education + ", property=" + property + ", policeRecord=" + policeRecord + ", adhaar=" + adhaar
				+ ", address=" + address + ", createdDate=" + createdDate + "]";
	}

	@Column(name="email")
	private String email;
	
	@Column(name="post")
	private String post;
	
	@Column(name="participating_place")
	private String participatingPlace;
	
	@Column(name="participating_state")
	private String participatingState;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="education")
	private String education;
	
	@Column(name="property")
	private String property;
	
	@Column(name="police_record")
	private String policeRecord;
	
	@Column(name="adhaar_num")
	private String adhaar;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_date")
	private Date createdDate;

}