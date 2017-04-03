package com.pesit.eVoting.service;

import com.pesit.eVoting.dto.UserDto;

public interface UserService {

	public String registerUser(UserDto user);

	public String authonticateUser(String email, String password);
}
