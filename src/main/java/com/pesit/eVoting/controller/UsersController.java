package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AssemblyStatesService assemblyStatesService;

	@RequestMapping("/processUserRegistration")
	public ModelAndView RegisterUser(@ModelAttribute("userDto") @Valid UserDto user, BindingResult result,
			Model model) {
		System.out.println("User from ontroller " +user);
		
		if(result.hasErrors())
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
	public ModelAndView userLogin(Model model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Username : "+email+" Password : "+password);
		
		if(userService.authonticateUser(email , password).equals(Constants.SUCCESS)) {
			//Store User in session
			return  new ModelAndView("usersView/userHome");
		} else {
			model.addAttribute("errMsg","Invalide Username/Password");
			return  new ModelAndView("usersView/userLogin");
		}
	
	}
	
	@RequestMapping("/userHome")
	public String showUserHome(){
		//Check Session
		return "usersView/userHome";
	}
	
	@RequestMapping("/includeName")
	public ModelAndView showIncludeNameView(Model model){
		ModelAndView view = new ModelAndView("usersView/includeName");
		
		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		view.addObject("assemblyStateDto", assemblyStateDto);
		
		return view;
	}
}
