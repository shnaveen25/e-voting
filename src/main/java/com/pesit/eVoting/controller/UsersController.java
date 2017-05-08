package com.pesit.eVoting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;
	/*
	@Autowired
	private HttpSession session;
	*/

	@RequestMapping("/processUserRegistration")
	public ModelAndView RegisterUser(@ModelAttribute("userDto") @Valid UserDto user, BindingResult result,
			Model model) {
		//System.out.println("User from ontroller " + user);

		if (result.hasErrors())
			return new ModelAndView("register");

		// Validate user input

		String msg = userService.registerUser(user);
		if (msg == Constants.SUCCESS) {
			model.addAttribute("errMsg", "Success...!! Please Login with your Crediantials");
			return new ModelAndView("login");
		} else {
			model.addAttribute("errMsg", msg);
			return new ModelAndView("register");
		}
	}

	@RequestMapping("/processUserLogin")
	public ModelAndView userLogin(Model model , HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//System.out.println("Username : " + email + " Password : " + password);
		UserDto loggedInUser = userService.authonticateUser(email, password);
		System.out.println("LoggedInUser :"+loggedInUser);
		if (loggedInUser != null) {
			session.setAttribute("userId", loggedInUser.getId());
			session.setAttribute("userName", loggedInUser.getName());
			session.setAttribute("userEmail", loggedInUser.getEmail());
			System.out.println("UserId: "+session.getAttribute("userId"));
			System.out.println("UserName: "+session.getAttribute("userName"));
			model.addAttribute("userName", session.getAttribute("userName"));
			return new ModelAndView("usersView/userHome");
		} else {
			model.addAttribute("errMsg", "Invalide Username/Password");
			return new ModelAndView("usersView/userLogin");
		}

	}

	@RequestMapping("/userHome")
	public String showUserHome() {
		// Check Session
		return "usersView/userHome";
	}
	
	@RequestMapping("/changePassword")
	public String showChangePasswordView(){
		//chk session
		return "usersView/changePassword";
	}
	
	@RequestMapping("/processChangePassword")
	public @ResponseBody String changeUserPassword(HttpServletRequest request, HttpSession session){
		
		long id = (long) session.getAttribute("userId");
		
		if(id != 0){
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			
			return userService.changePassword(id, oldPassword, newPassword);
		} else {
			//Change ..............................
			return null;
		}
		
	}
	
	@RequestMapping("/forgotPassword")
	public @ResponseBody String forgotPassword(HttpServletRequest request){
		String email = request.getParameter("email");
		
		return userService.forgotPassword(email);
	}
}
