package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.AssemblyConstituencyDto;
import com.pesit.eVoting.dto.AssemblyDistrictDto;
import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.dto.UserDto;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.UserService;
import com.pesit.eVoting.service.VotersApplicationsService;

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
	@Autowired
	private AssemblyStatesService assemblyStatesService;

	@Autowired
	private AssemblyDistrictService assemblyDistrictSerivce;

	@Autowired
	private AssemblyConstituencyService assemblyConstituencyService;
	
	@Autowired
	private VotersApplicationsService voterApplicationService;

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

	@RequestMapping("/includeName")
	public ModelAndView showIncludeNameView(Model model) {
		ModelAndView view = new ModelAndView("usersView/includeName");

		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		view.addObject("assemblyStateDto", assemblyStateDto);

		return view;
	}

	@RequestMapping("/getDistricts")
	public @ResponseBody List<AssemblyDistrictDto> getDistricts(HttpServletRequest request, Model model) {
		long stateId = Long.parseLong(request.getParameter("stateId"));
		// System.out.println("StateID : "+stateId);
		ModelAndView view = new ModelAndView("usersView/includeName");
		VotersApplicationsDto voterApplicationDto = new VotersApplicationsDto();

		List<AssemblyDistrictDto> districts = assemblyDistrictSerivce.getDistrictsFromStates(stateId);
		// System.out.println("Districts :"+districts);

		view.addObject("assemblyDistrictsDto", districts);
		view.addObject("voterApplicationDto", voterApplicationDto);

		return districts;
	}

	@RequestMapping("/getAssemblies")
	public @ResponseBody List<AssemblyConstituencyDto> getAssemblies(HttpServletRequest request){
		long districtId = Long.parseLong(request.getParameter("districtId"));
		//ModelAndView view = new ModelAndView("usersView/includeName");
		
		List<AssemblyConstituencyDto> assemblies = assemblyConstituencyService.getAssemblysFromDistricts(districtId);
		//System.out.println("assemblies :"+assemblies);
		
		
		return assemblies;
	}

	@RequestMapping("/registerVoterApplication")
	public ModelAndView addVoterApplication(@ModelAttribute("voterApplicationDto") 
			VotersApplicationsDto votersApplicationsDto, Model model, HttpSession session){
		System.out.println("voterApplicationDto : "+votersApplicationsDto);
		
		long appliedBy = (long) session.getAttribute("userId");
		
		ModelAndView view = new ModelAndView("usersView/userHome");
		
		String msg = voterApplicationService.registerForVoterApplication(votersApplicationsDto , appliedBy);
		
		model.addAttribute("message", msg);
		
		return view;
	}
	
	@RequestMapping({"/getUserApplications"})
	public ModelAndView getUserApplications(HttpSession session , Model model,
			@RequestParam(value="id" , required = false) Long id) {
		
		System.out.println("Getting application lists "+session.getAttribute("userId"));
		long userId = (long) session.getAttribute("userId");
		
		List<VotersApplicationsDto>  applicationList= voterApplicationService.getUserAppliedApplications(userId);		
		ModelAndView view = new ModelAndView("usersView/userApplications");
		view.addObject("applicationList", applicationList);
		
		if(id != null){
			for(VotersApplicationsDto indudivalApplication : applicationList){
				if(indudivalApplication.getId() == id)
					view.addObject("ApplicationDetails", indudivalApplication);
			}
		}
		
		model.addAttribute("applicationType", "pendng");
			//System.out.println("Applicatons......"+applicationList);
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
