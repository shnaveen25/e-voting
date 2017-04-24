package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.ElectionDto;
import com.pesit.eVoting.service.ElectionService;

/**
 * 
 * @author
 *
 */

@Controller
public class ElectionController {

	@Autowired
	private ElectionService electionService;
	

	@RequestMapping("/addElection")
	public @ResponseBody String addElection(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("electionFor") String electionFor, @RequestParam("stateId") long stateId,
			@RequestParam("electionDate") String electionDate) {

		System.out.println("Adding Election");
		System.out.println("Details : " + electionFor + stateId + electionDate);

		return electionService.addUpcomingElection(electionFor, stateId, electionDate);
		/*
		 * String msg = electionService.addUpcomingElection(electionFor,
		 * stateId, electionDate);
		 * 
		 * if(msg.equals(Constants.SUCCESS)){ try { PrintWriter pw =
		 * response.getWriter(); pw.println(msg); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 * 
		 * return "";
		 */

	}

	@RequestMapping("/getElectionDate")
	public @ResponseBody List<ElectionDto> getElections(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView("usersView/includeName");
		long stateId = Long.parseLong(request.getParameter("stateId")); 
		
		List<ElectionDto> electionDto = electionService.getUpcomingElectionForState(stateId);
		
		return electionDto;
		
		
		
	}
}
