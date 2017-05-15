package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.service.ElectorService;
import com.pesit.eVoting.service.VotersApplicationsService;

@Controller
public class ElectorController {

	@Autowired
	private ElectorService electorService;

	@Autowired
	private VotersApplicationsService voterApplicationService;

	@RequestMapping("/acceptVoterApplication")
	public @ResponseBody String addVoter(@RequestParam(value = "applicationId", required = false) Long applicationId,
			@RequestParam(value = "comment", required = false) String comment, HttpServletResponse response) {

		String msg = electorService.registerVoter(applicationId);

		if (msg.equals(Constants.SUCCESS)) {
			System.out.println(msg);
			voterApplicationService.updateApplicationStatus(applicationId, comment, "accepted");
		}

		return msg;
	}

	@RequestMapping("/getElectorNewPassword")
	public @ResponseBody String forgotElectorPassword(HttpServletRequest request) {

		String email = request.getParameter("email");

		return electorService.changeElectorPassword(email);

	}

	@RequestMapping("/showElectorsForAssembly")
	public @ResponseBody List<ElectorDto> showElectoesfromAss(HttpServletRequest request) {

		long assId = Long.parseLong(request.getParameter("assId"));

		return electorService.getAllElectorsOfAss(assId);
	}

	@RequestMapping("/activeOrInavtiveElector")
	public @ResponseBody String activeOrInactiveElector(HttpServletRequest request) {

		long id = Long.parseLong(request.getParameter("id"));

		return electorService.activeOrInactiveElector(id);
	}

	@RequestMapping("/generateOTP")
	public @ResponseBody String generateOTP(HttpServletRequest requset, HttpSession session) {

		String electorId = requset.getParameter("electorId");

		String OTP = electorService.getOTP(electorId);

		if (OTP != null) {
			session.setAttribute("OTP", OTP);
			session.setAttribute("electorId", electorId);
			return Constants.SUCCESS;
		}

		return "Invalid ElectorId..";

	}

	@RequestMapping("/getElectorProfile")
	public ModelAndView getElectorProfile(HttpServletRequest requset, HttpSession session) {

		ModelAndView view = new ModelAndView("usersView/ModifyOrDeletApplication");
		
		String electorId = requset.getParameter("electorId");
		String password = requset.getParameter("password");
		
		ElectorDto electorProfile = electorService.authonticateActiveElector(electorId, password);
		System.out.println(electorProfile);
		if(electorProfile != null){
			view.addObject("electorProfile", electorProfile);
		}
		
		return view;
	

	}
}
