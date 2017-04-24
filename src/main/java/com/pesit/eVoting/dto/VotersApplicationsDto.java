package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Null;

import com.pesit.eVoting.sql.domain.VotersApplications;

/**
 * 
 * @author 
 *
 */
public class VotersApplicationsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private long id;
	@Null
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
	private Timestamp createdDate;
	private String appliedFor;
	private String applicationStatus;
	
	//extras
	@Null
	private String stateName;
	@Null
	private String districtName;
	@Null
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
		applicationStatus = application.getApplicationStatus();
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		System.out.println("id" +id);
	}
	public long getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(long addedBy) {
		System.out.println("addedBy"+addedBy);
		this.addedBy = addedBy;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
		System.out.println("statId"+stateId);
	}
	public long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
		System.out.println("distId"+districtId);
		
	}
	public long getAssemblyId() {
		return assemblyId;
	}
	public void setAssemblyId(long assemblyId) {
		this.assemblyId = assemblyId;
		System.out.println("assId"+assemblyId);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {	
		this.name = name;
		System.out.println("name"+name);
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
		System.out.println("surname"+surName);
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
		System.out.println("dob"+dob);
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
		System.out.println("gender"+gender);
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
		System.out.println("mobile"+mobile);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("email"+email);
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
		System.out.println("adhar"+aadhar);
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
		System.out.println("area"+area);
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
		System.out.println("Street"+street);
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
		System.out.println("landMark"+landMark);
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
		System.out.println("poncode"+pinCode);
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
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
		System.out.println("appliedfro"+appliedFor);
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	

}
