package com.pesit.eVoting.service;

import com.pesit.eVoting.dto.UserDto;

public interface UserService {

	public String registerUser(UserDto user);

	public UserDto authonticateUser(String email, String password);
	
	public String changePassword(long id , String oldPassword , String newPassword);
	
	public String forgotPassword(String email);
}
