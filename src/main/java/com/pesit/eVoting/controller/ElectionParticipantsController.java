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

import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.service.ElectionParticipantsService;
import com.pesit.eVoting.service.ElectorService;

@Controller
public class ElectionParticipantsController {

	@Autowired
	private ElectionParticipantsService electionParticipantService;

	@Autowired
	private ElectorService electorService;
	
	/**
	 * 
	 * The API to add the participant.
	 * 
	 * @author 
	 * @param participantDto
	 * @return
	 */
	@RequestMapping("/addParticipant")
	public @ResponseBody String addParticipant(@RequestBody ParticipantsDto participantDto) {

		//System.out.println("The Entered participant details : " + participantDto);
		try{
			return electionParticipantService.addParticipant(participantDto);
		}catch (Exception e) {
			return "Internal server error while performing operation "+e;
		}
		
		
	}

	@RequestMapping("/viewParticipants")
	public ModelAndView showParticipants(Model model) {
		ModelAndView view = new ModelAndView("adminViews/viewParticipants");
		List<ParticipantsDto> participant = electionParticipantService.getAllParticipants();
		System.out.println("List of Participants : " + participant);
		if (participant.size() > 0) {
			view.addObject("listOfParticipants", participant);
		} else {
			model.addAttribute("errMsg", "No Participant Found to display");
		}
		return view;
	}

	@RequestMapping("/getElectionParticipants")
	public @ResponseBody List<ParticipantsDto> showCurrentEleParticipants(HttpServletRequest request, Model model) {

		// ModelAndView view = new ModelAndView("currentElections");
		long stateId = Long.parseLong(request.getParameter("stateId"));
		long assemblyId = Long.parseLong(request.getParameter("assemblyId"));

		List<ParticipantsDto> participantsDto = electionParticipantService.getCurrEleParicipantByAssembly(stateId,
				assemblyId);
		model.addAttribute("participantsDto", participantsDto);
		// view.addObject("participantsDto", participantsDto);

		return participantsDto;
	}

	@RequestMapping("/voteForParticipant")
	public @ResponseBody String voteForParticipant(HttpServletRequest request, Model model) {
		
		long participantId = Long.parseLong(request.getParameter("participantId"));
		String electorId = request.getParameter("electorId");
		String password = request.getParameter("password");
		
		System.out.println("participant Id "+participantId);

		ElectorDto authorizedElector = electorService.authonticateActiveElector(electorId, password);

		if (authorizedElector != null) {
			return electionParticipantService.voteForSelectedParticipant(participantId, authorizedElector);
			/*System.out.println("Voting result :"+msg);
			view.addObject("msg", msg);*/
			
		} else {
			/*view.addObject("msg", "You have been Inactivated..!! Please contact admin..");*/
			return "You have been Inactivated..!! Please contact admin..";
		}
//		return view;
	}
	
	@RequestMapping("/getElectionResults")
	public @ResponseBody List<ParticipantsDto> showElectionResults(HttpServletRequest request){
		
		long eleId = Long.parseLong(request.getParameter("eleId"));
		long asmbId = Long.parseLong(request.getParameter("asmbId"));
		
		System.out.println("User has been requseted for eleId : "+eleId+" AssId : "+asmbId);
		
		
		return electionParticipantService.getNoOfVotes(eleId, asmbId);
	}

}
