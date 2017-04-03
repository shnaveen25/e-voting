package com.pesit.eVoting.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.sql.domain.Users;

/**
 * 
 * 
 * @author 
 *
 */

@Controller
//@RequestMapping("/")
public class MainController {
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping({"/login"})
	public String showLoginView(){
		return "login";
	}
	
	@RequestMapping("/userLogin")
	public String showUserLoginView(){
		return "usersView/userLogin";
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegisterView(Model model){
		UserDto userDto = new UserDto();
		model.addAttribute("userDto", userDto);
		return new ModelAndView("register");
	}
	
	@RequestMapping("/showPresentElections")
	public String showPresentElectionsView(){
		return "presentElections";
	}
	
	@RequestMapping("/showPastElections")
	public String showPastElectionsView(){
		return "pastElections";
	}
	
	@RequestMapping("/showFutureElections")
	public String showFutureElectionsView() {
		return "futureElections";
	}
}
