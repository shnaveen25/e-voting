package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.util.Date;

public class ElectorDto implements Serializable {
	
	private long id;
	private long applicationid;
	private String electorId;
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
	@Override
	public String toString() {
		return "ElectorDto [id=" + id + ", electorId=" + electorId + ", stateId=" + stateId + ", districtId="
				+ districtId + ", assemblyId=" + assemblyId + ", name=" + name + ", surName=" + surName + ", dob=" + dob
				+ ", gender=" + gender + ", mobile=" + mobile + ", email=" + email + ", aadhar=" + aadhar + ", area="
				+ area + ", street=" + street + ", landMark=" + landMark + ", pinCode=" + pinCode + ", createdDate="
				+ createdDate + "]";
	}
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
	public long getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(long applicationid) {
		this.applicationid = applicationid;
	}
	
	
	
	
}
