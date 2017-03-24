package com.pesit.eVoting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.PartyDto;
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
	
	@RequestMapping("/processLogin")
	public ModelAndView processAdminLogin(Model model) {
		
		System.out.println("Inside processAdminLogin() of AdminController");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Username : "+email+" Password : "+password);
		
		if(!adminService.loginAdmin(email , password).equals(Constants.LOGIN_FAILED)) {
			return  new ModelAndView("adminViews/adminHome");
		} else {
			model.addAttribute("errMsg","Invalide Username/Password");
			return  new ModelAndView("login");
		}
	
	}
	
	@RequestMapping("/adminHome")
	public String showAdminHome(){
		return "adminViews/adminHome";
	}
	
	@RequestMapping("/logout")
	public ModelAndView processLogout(Model model){
		model.addAttribute("errMsg", "Thank you..!! Visit Again");
		return new ModelAndView("login");
	}
}
