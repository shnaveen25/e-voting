package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.VotersApplicationsService;

/**
 * 
 * @author
 *
 */

@Controller
public class VoterApplicationController {
	
	@Autowired
	private VotersApplicationsService voterApplicationService;

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
