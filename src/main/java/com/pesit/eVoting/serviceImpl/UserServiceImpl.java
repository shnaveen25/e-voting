package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.util.Date;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.Util.PasswordUtil;
import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.UserService;
import com.pesit.eVoting.sql.dao.UsersDAO;
import com.pesit.eVoting.sql.domain.Users;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDAO userDao;

	@Autowired
	private MailService mailService;

	@Override
	@Transactional
	public String registerUser(UserDto user) {

		Timestamp currentDate = new Timestamp(new Date().getTime());
		Users userDetail = new Users();
		userDetail.setName(user.getName());
		userDetail.setEmail(user.getEmail());
		userDetail.setPassword(user.getPassword());
		userDetail.setMobile(user.getMobile());
		userDetail.setCreatedDate(currentDate);
		try {
			userDao.save(userDetail);
		} catch (Exception e) {
			return e.getMessage();
		}
		return Constants.SUCCESS;
	}

	@Override
	public UserDto authonticateUser(String email, String password) {

		UserDto user = new UserDto();
		Users isExistingUser = userDao.findByEmailAndPassword(email, password);

		if (isExistingUser != null) {
			user.setId(isExistingUser.getId());
			user.setName(isExistingUser.getName());
			user.setPassword(isExistingUser.getPassword());
			return user;
		}
		return null;
	}

	@Override
	@Transactional
	public String changePassword(long id, String oldPassword, String newPassword) {

		Users isExistingUser = userDao.findByPassword(id, oldPassword);

		if (isExistingUser != null) {
			isExistingUser.setPassword(newPassword);
			userDao.saveOrUpdate(isExistingUser);
			return Constants.SUCCESS;
		} else {
			return "Password mis-match..!!Please Try again";
		}
	}

	@Override
	@Transactional
	public String forgotPassword(String email) {

		Users isExistingUser = userDao.findByEmail(email);
		String randomPassword = PasswordUtil.randomAplhaNumGen(6);

		if (isExistingUser != null) {
			isExistingUser.setPassword(randomPassword);
			userDao.saveOrUpdate(isExistingUser);

			new Thread(() -> {
				try {
					mailService.sendMailHtml("E-VOTING: New Password",
							mailService.getResetPasswordBody(isExistingUser.getName(), randomPassword),
							isExistingUser.getEmail(), Constants.FROM_MAIL);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();

			return "New password has been sent to your email.. Thank you";

		} else {
			return "Invalide Email";
		}
	}
}
