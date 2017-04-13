package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.util.Date;

import com.pesit.eVoting.sql.domain.VotersApplications;

/**
 * 
 * @author 
 *
 */
public class VotersApplicationsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long addedBy;
	private long stateId;
	private long districtId;
	private long assemblyId;
	private String name;
	private String surName;
	private String dob;
	private String gender;
	private long mobile;
	private String email;
	private long aadhar;
	private String area;
	private String street;
	private String landMark;
	private String pinCode;
	private Date createdDate;
	private String appliedFor;
	
	//extras
	private String stateName;
	private String districtName;
	private String assemblyName;
	
	
	public VotersApplicationsDto() {
		
	}
	
	public VotersApplicationsDto(VotersApplications application) {
		id = application.getId();
		addedBy = application.getAddedBy();
		stateId = application.getStateId();
		districtId = application.getDistrictId();
		assemblyId = application.getAssemblyId();
		name = application.getName();
		//dob = application.getDob();
		gender = application.getGender();
		mobile = application.getMobile();
		email = application.getEmail();
		aadhar = application.getAadhar();
		area = application.getAddress();
		landMark = application.getLandMark();
		pinCode = application.getPinCode();
		createdDate = application.getCreatedDate();
	}
	
	
	@Override
	public String toString() {
		return "VotersApplicationsDto [id=" + id + ", addedBy=" + addedBy + ", stateId=" + stateId + ", districtId="
				+ districtId + ", assemblyId=" + assemblyId + ", name=" + name + ", surName=" + surName + ", dob=" + dob
				+ ", gender=" + gender + ", mobile=" + mobile + ", email=" + email + ", aadhar=" + aadhar + ", area="
				+ area + ", street=" + street + ", landMark=" + landMark + ", pinCode=" + pinCode + ", createdDate="
				+ createdDate + ", appliedFor=" + appliedFor + ", stateName=" + stateName + ", districtName="
				+ districtName + ", assemblyName=" + assemblyName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aadhar ^ (aadhar >>> 32));
		result = prime * result + (int) (addedBy ^ (addedBy >>> 32));
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + (int) (assemblyId ^ (assemblyId >>> 32));
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((landMark == null) ? 0 : landMark.hashCode());
		result = prime * result + (int) (mobile ^ (mobile >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + (int) (stateId ^ (stateId >>> 32));
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		VotersApplicationsDto other = (VotersApplicationsDto) obj;
		if (aadhar != other.aadhar)
			return false;
		if (addedBy != other.addedBy)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (assemblyId != other.assemblyId)
			return false;
		if (districtId != other.districtId)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
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
		if (landMark == null) {
			if (other.landMark != null)
				return false;
		} else if (!landMark.equals(other.landMark))
			return false;
		if (mobile != other.mobile)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		if (stateId != other.stateId)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAssemblyName() {
		return assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}

	public String getAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
	}
	

}
