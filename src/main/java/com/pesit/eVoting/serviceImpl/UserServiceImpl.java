package com.pesit.eVoting.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.service.UserService;
import com.pesit.eVoting.sql.dao.UsersDAO;
import com.pesit.eVoting.sql.domain.Users;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDAO userDao;

	@Override
	public String registerUser(UserDto user) {
		System.out.println("Uesr "+user);
		Users userDetail = new Users();
		userDetail.setName(user.getName());
		userDetail.setEmail(user.getEmail());
		userDetail.setPassword(user.getPassword());
		userDetail.setMobile(user.getMobile());
		// userDetail.setCreatedDate(createdDate);
		try {
			userDao.save(userDetail);
		} catch (Exception e) {
			return e.getMessage();
		}
		return Constants.SUCCESS;
	}
}