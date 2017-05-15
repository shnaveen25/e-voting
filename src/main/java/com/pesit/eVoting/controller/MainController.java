package com.pesit.eVoting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.UserDto;


/**
 * 
 * 
 * @author 
 *
 */

@Controller
//@RequestMapping("/")
public class MainController {
	
	@Autowired
	private HttpSession session;
	
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
	
	@RequestMapping({"/logout" , "/userLogout"})
	public ModelAndView processLogout(Model model , HttpServletRequest request){
		session.removeAttribute("email");
		session.invalidate();
		if(request.getRequestURI().equals("/logout"))
			return new ModelAndView("login");
		else
			return new ModelAndView("usersView/userLogin");
	}
	
	@RequestMapping("/viewElectionResults")
	public String showElectionResults(){
		return "pastElectionResults";
		
	}
}
