package com.pesit.eVoting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;
	
	 
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/processUserRegistration")
	public @ResponseBody String RegisterUser(@RequestBody UserDto user) {
		
		System.out.println("User from controller " + user);
		
		try{
			return  userService.registerUser(user);
		}catch (Exception e) {
			// TODO: handle exception
			return "Internal server error :"+e;
		}
		
		
	}

	@RequestMapping("/processUserLogin")
	public @ResponseBody String  userLogin() {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDto loggedInUser = userService.authonticateUser(email, password);
		System.out.println("Loged in user "+loggedInUser);
		if (loggedInUser != null) {
			session.setAttribute("userId", loggedInUser.getId());
			session.setAttribute("userName", loggedInUser.getName());
			session.setAttribute("email", loggedInUser.getEmail());
			System.out.println("stored id from session "+session.getAttribute("userId"));
			return Constants.SUCCESS;
		} else {
			return "Invalide Username/Password";
		}

	}

	@RequestMapping("/userHome")
	public String showUserHome() {
		System.out.println("userSession" +session.getAttribute("email"));
		if(session.getAttribute("email") != null)
			return "usersView/userHome";
		return "usersView/userLogin";
	}

	@RequestMapping("/changePassword")
	public String showChangePasswordView() {
		if(session.getAttribute("email") != null)
			return "usersView/changePassword";
		return "usersView/userLogin";
	}

	@RequestMapping("/processChangePassword")
	public @ResponseBody String changeUserPassword(HttpServletRequest request, HttpSession session) {

		long id = (long) session.getAttribute("userId");

		if (id != 0) {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");

			return userService.changePassword(id, oldPassword, newPassword);
		} else {
			// Change ..............................
			return null;
		}

	}

	@RequestMapping("/forgotPassword")
	public @ResponseBody String forgotPassword(HttpServletRequest request) {
		String email = request.getParameter("email");

		return userService.forgotPassword(email);
	}

	@RequestMapping("/modifyUserApplication")
	public String showModifyApplnView() {
		if(session.getAttribute("email") != null)
			return "usersView/ModifyOrDeletApplication";
		return "usersView/userLogin";
	}
}
