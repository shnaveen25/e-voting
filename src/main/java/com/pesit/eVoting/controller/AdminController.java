package com.pesit.eVoting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.service.AdminService;

/**
 * A Controller class to perform operation 
 * related to table admin
 * 
 * @author 
 *
 */

@Controller
//@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/processLogin")
	public @ResponseBody String processAdminLogin() {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!adminService.loginAdmin(email , password).equals(Constants.LOGIN_FAILED)) {
			session.setAttribute("email", email);
			session.setAttribute("role", Constants.ADMIN);
			return Constants.SUCCESS;
		} else {
			return  "Invalide Username/Password";
		}
	
	}
	
	@RequestMapping("/adminHome")
	public String showAdminHome(){
		if(session.getAttribute("email") != null && session.getAttribute("role").equals(Constants.ADMIN))
			return "adminViews/adminHome";
		else
			return "login";
	}
	
	@RequestMapping("/getPastElectionView")
	public String showPastElectionView(){
		if(session.getAttribute("email") != null && session.getAttribute("role").equals(Constants.ADMIN))
			return "adminViews/pastElections";
		else
			return "login";
	}
	
	@RequestMapping("/getAllVoters")
	public String showVotersViewPage(){
		if(session.getAttribute("email") != null && session.getAttribute("role").equals(Constants.ADMIN))
			return "adminViews/registeredVoters";
		else
			return "login";
	}
	
	@RequestMapping("/addParty")
	public String showAddParty() {
		if(session.getAttribute("email") != null && session.getAttribute("role").equals(Constants.ADMIN))
			return "adminViews/addParty";
		else
			return "login";
	}
	
	@RequestMapping("/addParticipantView")
	public String showAddParticipantView(){
			return "adminViews/addParticipant";
		
	}
}
