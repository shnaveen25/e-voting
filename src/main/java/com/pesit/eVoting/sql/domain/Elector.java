package com.pesit.eVoting.sql.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="elector")
public class Elector implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="application_id")
	private long applicationid;
	
	@Column(name="elector_id")
	private String electorId;
	
	@Column(name="state_id")
	private long stateId;
	
	@Column(name="district_id")
	private long districtId;
	
	@Column(name="assembly_id")
	private long assemblyId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="aadhar")
	private long aadhar;
	
	@Column(name="address")
	private String address;
	
	@Column(name="land_mark")
	private String landMark;
	
	@Column(name="pin_code")
	private String pinCode;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getElectorId() {
		return electorId;
	}

	public void setElectorId(String electorId) {
		this.electorId = electorId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public long getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(long applicationid) {
		this.applicationid = applicationid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Elector [id=" + id + ", electorId=" + electorId + ", stateId=" + stateId + ", districtId=" + districtId
				+ ", assemblyId=" + assemblyId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", mobile="
				+ mobile + ", email=" + email + ", aadhar=" + aadhar + ", address=" + address + ", landMark=" + landMark
				+ ", pinCode=" + pinCode + ", createdDate=" + createdDate + "]";
	}
	
	

}
