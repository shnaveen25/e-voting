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
 * 
 * A Pojo class represents election_participants table
 * 
 * @author 
 *
 */

@Entity
@Table(name="election_participants")
public class ElectionParticipants implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="party_id")
	private long partyId;
	
	@Column(name="state_id")
	private long stateId;
	
	@Column(name="district_id")
	private long districtId;
	
	@Column(name="assembly_id")
	private long assemblyId;
	
	@Column(name="election_id")
	private long electionId;
	
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

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="post")
	private String post;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="education")
	private String education;
	
	@Column(name="property")
	private String property;
	
	@Column(name="police_record")
	private String policeRecord;
	
	@Column(name="adhaar_num")
	private long adhaar;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="no_of_votes")
	private long noOfVotes;

	@Override
	public String toString() {
		return "ElectionParticipants [id=" + id + ", partyId=" + partyId + ", stateId=" + stateId + ", districtId="
				+ districtId + ", assemblyId=" + assemblyId + ", electionId=" + electionId + ", name=" + name
				+ ", email=" + email + ", post=" + post + ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender
				+ ", education=" + education + ", property=" + property + ", policeRecord=" + policeRecord + ", adhaar="
				+ adhaar + ", address=" + address + ", createdDate=" + createdDate + ", noOfVotes=" + noOfVotes + "]";
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

	public long getElectionId() {
		return electionId;
	}

	public void setElectionId(long electionId) {
		this.electionId = electionId;
	}

	public long getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(long noOfVotes) {
		this.noOfVotes = noOfVotes;
	}
	
	
	
}
