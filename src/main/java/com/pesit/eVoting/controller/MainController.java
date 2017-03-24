package com.pesit.eVoting.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/login")
	public String showLoginView(){
		System.out.println("Forwording to login");
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegisterView(){
		return "register";
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
