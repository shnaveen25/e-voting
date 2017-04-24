package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.sql.Timestamp;

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
	private long electionId;
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
	private Timestamp createdDate;
	private String partyName;
	private long onOfVotes;
	
	@Override
	public String toString() {
		return "ParticipantsDto [id=" + id + ", partyId=" + partyId + ", stateId=" + stateId + ", districtId="
				+ districtId + ", assemblyId=" + assemblyId + ", electionId=" + electionId + ", name=" + name
				+ ", email=" + email + ", post=" + post + ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender
				+ ", education=" + education + ", property=" + property + ", policeRecord=" + policeRecord + ", adhaar="
				+ adhaar + ", address=" + address + ", createdDate=" + createdDate + ", partyName=" + partyName + "]";
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
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
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

	public long getElectionId() {
		return electionId;
	}

	public void setElectionId(long electionId) {
		this.electionId = electionId;
	}

	public long getOnOfVotes() {
		return onOfVotes;
	}

	public void setOnOfVotes(long onOfVotes) {
		this.onOfVotes = onOfVotes;
	}	
	
	
}
