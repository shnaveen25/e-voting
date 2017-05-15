package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.dto.ElectionDto;
import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectionService;
import com.pesit.eVoting.service.PartyDescriptionService;

@Controller
public class PartyDescriptionController {

	@Autowired
	private PartyDescriptionService paertyDescriptionService;

	@Autowired
	private AssemblyStatesService assemblyStatesService;
	
	@Autowired
	private ElectionService electionService;

	/**
	 * A Service API to save party details
	 * 
	 * @param addPartyDto
	 * @return
	 */
	@RequestMapping("/addPartyDescription")
	public @ResponseBody String saveParty(@RequestBody PartyDto addPartyDto) {
		System.out.println("Data for adding party : "+addPartyDto);
		try{
			return paertyDescriptionService.addParty(addPartyDto);
		}catch (Exception e) {
			return "Internal server error "+e;
		}
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAddParticipantView")
	public ModelAndView showSelectPartyView(Model model) {
		
		ModelAndView view = new ModelAndView("adminViews/addParticipant");
		
		List<PartyDto> partyName = paertyDescriptionService.getParty();
		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		List<ElectionDto> elections = electionService.getUpcomingElections();
		
		view.addObject("assemblyStateDto", assemblyStateDto);
		view.addObject("partyList", partyName);
		view.addObject("election" , elections);
		
		return view;
		
	}

	@RequestMapping({"/viewParties" , "/showAllParties"})
	public ModelAndView showListOfParties(Model model, HttpServletRequest request) {
		ModelAndView view = null;
		System.out.println(request.getRequestURI());
		if(request.getRequestURI().equals("/showAllParties")) 
			view = new ModelAndView("viewParties");
		else
			view = new ModelAndView("adminViews/viewParties");
	
		List<PartyDto> parties = paertyDescriptionService.viewAllParties();
		
		if(parties.size() > 0) {
			view.addObject("listOfparties", parties);
		} else {
			model.addAttribute("errMsg", "No Parties Found to display");
		}
		return view;
	}
	
	/**
	 * 
	 * The service API which returns the list of parties for which 
	 * the participant hasn't been added for the selected assembly
	 * 
	 * @author 
	 */
	@RequestMapping("/getPartyWithNoParticipant")
	public @ResponseBody List<PartyDto> getPartys(HttpServletRequest request){
		
		long assemblyId = Long.parseLong(request.getParameter("assemblyId"));
		long electionId = Long.parseLong(request.getParameter("electionId"));
		
		try{
			return paertyDescriptionService.getNoParticipantParties(assemblyId , electionId);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
