package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 
 *
 */
public class ParticipantsDto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private long id;
	private long partyId;
	private long stateId;
	private long districtId;
	private long assemblyId;
	private String name;
	private String email;
	private String post;
	private long mobile;
	private String dob;
	private String gender;
	private String education;
	private String property;
	private String policeRecord;
	private long adhaar;
	private String address;
	private Date createdDate;
	private String partyName;
	
	@Override
	public String toString() {
		return "ParticipantsDto [id=" + id + ", partyId=" + partyId + ", stateId=" + stateId + ", districtId="
				+ districtId + ", assemblyId=" + assemblyId + ", name=" + name + ", email=" + email + ", post=" + post
				+ ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender + ", education=" + education
				+ ", property=" + property + ", policeRecord=" + policeRecord + ", adhaar=" + adhaar + ", address="
				+ address + ", createdDate=" + createdDate + ", partyName=" + partyName + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPartyId() {
		return partyId;
	}
	public void setPartyId(long partyId) {
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

	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
		System.out.println("Mobile : "+mobile);
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
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
	public long getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(long adhaar) {
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
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(long assemblyId) {
		this.assemblyId = assemblyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (adhaar ^ (adhaar >>> 32));
		result = prime * result + (int) (assemblyId ^ (assemblyId >>> 32));
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (mobile ^ (mobile >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (partyId ^ (partyId >>> 32));
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + ((policeRecord == null) ? 0 : policeRecord.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + (int) (stateId ^ (stateId >>> 32));
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
		ParticipantsDto other = (ParticipantsDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adhaar != other.adhaar)
			return false;
		if (assemblyId != other.assemblyId)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (districtId != other.districtId)
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
		if (mobile != other.mobile)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (partyId != other.partyId)
			return false;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
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
		if (stateId != other.stateId)
			return false;
		return true;
	}
	
	
	
}
