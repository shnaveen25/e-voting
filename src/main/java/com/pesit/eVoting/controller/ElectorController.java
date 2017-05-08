package com.pesit.eVoting.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String addVoter(@RequestParam(value = "applicationId", required = false) Long applicationId,
			@RequestParam(value = "comment", required = false) String comment , HttpServletResponse response){
				
		String msg = electorService.registerVoter(applicationId);
		
		if(msg.equals(Constants.SUCCESS)){
			voterApplicationService.updateApplicationStatus(applicationId, comment, "accepted");
		}
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/viewUserApplications";
	}
	
	@RequestMapping("/getElectorNewPassword")
	public @ResponseBody String forgotElectorPassword(HttpServletRequest request){
		
		String email = request.getParameter("email");
		
		return electorService.changeElectorPassword(email);
		
	}
	
	@RequestMapping("/showElectorsForAssembly")
	public @ResponseBody List<ElectorDto> showElectoesfromAss(HttpServletRequest request) {
		
		long assId = Long.parseLong(request.getParameter("assId"));
		
		return electorService.getAllElectorsOfAss(assId);	
	}
	
	@RequestMapping("/activeOrInavtiveElector")
	public @ResponseBody String activeOrInactiveElector(HttpServletRequest request){
		
		long id = Long.parseLong(request.getParameter("id"));
		
		return electorService.activeOrInactiveElector(id);
	}
}
