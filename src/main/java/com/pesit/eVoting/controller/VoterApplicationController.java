package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public ModelAndView addVoterApplication(
			@ModelAttribute("voterApplicationDto") @Valid VotersApplicationsDto votersApplicationsDto, 
			BindingResult result ,Model model,
			HttpSession session) {
		
		if(result.hasErrors()){
			System.out.println("VoterAppln : " +votersApplicationsDto);
			return new ModelAndView("usersView/includeName");
		}
		System.out.println("voterApplicationDto : " + votersApplicationsDto);

		long appliedBy = (long) session.getAttribute("userId");

		ModelAndView view = new ModelAndView("usersView/userHome");

		String msg = voterApplicationService.registerForVoterApplication(votersApplicationsDto, appliedBy);

		model.addAttribute("message", msg);

		return view;
	}

	@RequestMapping({ "/getUserApplications", "/editUserApplication" })
	public ModelAndView getUserApplications(HttpSession session, Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id) {

		ModelAndView view = null;
		String requestedFor = request.getRequestURI();

		// System.out.println("Getting application lists
		// "+session.getAttribute("userId"));
		long userId = (long) session.getAttribute("userId");

		List<VotersApplicationsDto> applicationList = voterApplicationService.getUserAppliedApplications(userId);

		if (requestedFor.contains("editUserApplication")) {
			VotersApplicationsDto voterApplicationDto = new VotersApplicationsDto();
			view = new ModelAndView("usersView/includeName");
			view.addObject("voterApplicationDto", voterApplicationDto);
		} else {
			view = new ModelAndView("usersView/userApplications");
		}

		view.addObject("applicationList", applicationList);

		if (id != null) {
			for (VotersApplicationsDto indudivalApplication : applicationList) {
				if (indudivalApplication.getId() == id)
					view.addObject("ApplicationDetails", indudivalApplication);
			}

		}

		model.addAttribute("applicationType", "pendng");
		return view;
	}

	@RequestMapping("/deleteUserApplication")
	public ModelAndView deleteUserApplication(HttpSession session, Model model,
			@RequestParam(value = "id", required = false) Long id) {

		ModelAndView view = new ModelAndView("usersView/userHome");

		String msg = voterApplicationService.deleteUserApplication(id);
		model.addAttribute("message", msg);

		return view;

	}

	@RequestMapping("viewUserApplications")
	public ModelAndView getAllPendingApplication(HttpSession session, Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView view = new ModelAndView("adminViews/userApplications");

		List<VotersApplicationsDto> applicationList = voterApplicationService.getAllPendingApplications();
		view.addObject("applicationList", applicationList);

		if (id != null) {
			for (VotersApplicationsDto indudivalApplication : applicationList) {
				if (indudivalApplication.getId() == id)
					view.addObject("ApplicationDetails", indudivalApplication);
			}

		}
		return view;
	}

	@RequestMapping("/rejectVoterApplication")
	public String voterApplicationRejected(@RequestParam(value = "applicationId", required = false) Long applicationId,
			@RequestParam(value = "comment", required = false) String comment) {
		//System.out.println("Rejected Application : "+applicationId);
		
		voterApplicationService.updateApplicationStatus(applicationId, comment , "rejected");
		return "forward:/viewUserApplications";

	}
}
