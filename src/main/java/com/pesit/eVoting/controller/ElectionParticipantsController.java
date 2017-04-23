package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.service.ElectionParticipantsService;

@Controller
public class ElectionParticipantsController {
	
	@Autowired
	private ElectionParticipantsService electionParticipantService;

	@RequestMapping("/addParticipant")
	public ModelAndView addParticipant(@ModelAttribute("participant") @Valid ParticipantsDto participantDto,
			Model model, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("adminView/memberDesc2");
		
		System.out.println("The Entered participant details : " + participantDto);
		electionParticipantService.addParticipant(participantDto);
		model.addAttribute("message", "participant Has been added");
		return new ModelAndView("adminViews/adminHome");
	}
	
	@RequestMapping("/viewParticipants")
	public ModelAndView showParticipants(Model model) {
		ModelAndView view = new ModelAndView("adminViews/viewParticipants");
		List<ParticipantsDto> participant = electionParticipantService.getAllParticipants();
		System.out.println("List of Participants : "+participant );
		if(participant.size() > 0) {
			view.addObject("listOfParticipants", participant);
		} else {
			model.addAttribute("errMsg", "No Participant Found to display");
		}
		return view;
	}
	
	@RequestMapping("/getElectionParticipants")
	public @ResponseBody List<ParticipantsDto> showCurrentEleParticipants(HttpServletRequest request){
		
		ModelAndView view = new ModelAndView("currentElections");
		long stateId = Long.parseLong(request.getParameter("stateId"));
		long assemblyId = Long.parseLong(request.getParameter("assemblyId"));
		
		List<ParticipantsDto> participantsDto = electionParticipantService.getCurrEleParicipantByAssembly(stateId, assemblyId);
		
		view.addObject("participantsDto", participantsDto);
		
		return participantsDto;		
	}

}
