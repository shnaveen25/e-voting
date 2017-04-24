package com.pesit.eVoting.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String email;
	private String password;
	private String cpassword;
	private long mobile;
	private Timestamp createdDate;
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpassword="
				+ cpassword + ", mobile=" + mobile + ", createdDate=" + createdDate + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("name " +name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("Email " +email);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("Password" +password);
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
		System.out.println("mobile " +mobile);
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	
	
}
