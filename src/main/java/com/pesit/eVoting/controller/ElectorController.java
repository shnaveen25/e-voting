package com.pesit.eVoting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pesit.eVoting.constants.Constants;
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
}
