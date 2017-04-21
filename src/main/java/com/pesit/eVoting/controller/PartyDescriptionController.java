package com.pesit.eVoting.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.PartyDescriptionService;
import com.pesit.eVoting.sql.domain.PartyDescription;

@Controller
public class PartyDescriptionController {

	@Autowired
	private PartyDescriptionService paertyDescriptionService;

	@Autowired
	private AssemblyStatesService assemblyStatesService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addParty")
	public ModelAndView showAddParty(Model model) {
		PartyDto partyBean = new PartyDto();
		model.addAttribute("addParty", partyBean);
		return new ModelAndView("adminViews/addParty");
	}

	/**
	 * 
	 * @param addPartyDto
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/addPartyDescription")
	public ModelAndView processAddParty(@ModelAttribute("addParty") @Valid PartyDto addPartyDto, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return new ModelAndView("adminViews/addParty");

		PartyDescription partyDescription = new PartyDescription();
		partyDescription.setPartyName(addPartyDto.getPartyName());
		partyDescription.setPartyDescription(addPartyDto.getPartyDescription());
		partyDescription.setEmail(addPartyDto.getPartyEmail());
		partyDescription.setMpMembers(addPartyDto.getMpMembers());
		partyDescription.setMlaMembers(addPartyDto.getMlaMembers());

		boolean process = paertyDescriptionService.addParty(partyDescription);

		if (process) {
			model.addAttribute("message", "Party Has been added Successifully");
			return new ModelAndView("adminViews/adminHome");
		} else {
			model.addAttribute("message", "Party already added...");
			return new ModelAndView("adminViews/adminHome");
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
		ParticipantsDto participantsrDto = new ParticipantsDto();
		List<PartyDto> partyName = paertyDescriptionService.getParty();
		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		view.addObject("assemblyStateDto", assemblyStateDto);
		view.addObject("partyList", partyName);
		model.addAttribute("participant", participantsrDto);
		return view;
	}

	@RequestMapping("/viewParties")
	public ModelAndView showListOfParties(Model model) {
		ModelAndView view = new ModelAndView("adminViews/viewParties");
		List<PartyDto> parties = paertyDescriptionService.viewAllParties();
		
		if(parties.size() > 0) {
			view.addObject("listOfparties", parties);
		} else {
			model.addAttribute("errMsg", "No Parties Found to display");
		}
		return view;
	}
}
