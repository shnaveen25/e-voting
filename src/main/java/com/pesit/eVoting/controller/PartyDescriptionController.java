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
import com.pesit.eVoting.dto.ParticipantsDto;
import com.pesit.eVoting.dto.PartyDto;
import com.pesit.eVoting.service.PartyDescriptionService;
import com.pesit.eVoting.sql.domain.PartyDescription;

@Controller
public class PartyDescriptionController {

	@Autowired
	private PartyDescriptionService paertyDescriptionService;

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
		partyDescription.setEmail("sh.naveen16@gmail.com");
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
	@RequestMapping("/addParticipantSelectParty")
	public ModelAndView showSelectPartyView(Model model) {
		ModelAndView view = new ModelAndView("adminViews/memberDesc2");
		ParticipantsDto participantsrDto = new ParticipantsDto();
		List<PartyDto> partyName = paertyDescriptionService.getParty();
		if (partyName.size() > 0)
			view.addObject("partyList", partyName);
		model.addAttribute("participant", participantsrDto);
		return view;
	}

	
	/**
	 * 
	 * @return
	 */
	/*
	@RequestMapping("/addParticipantDetails")
	public ModelAndView showAddPaericipantView(@ModelAttribute("addParticipantDetails") @Valid PartyDto selectedParty,
			BindingResult result, Model model) {
		System.out.println("Selected party list form PartyDescriptionController : "+selectedParty);
		if(result.hasErrors())
			return new ModelAndView("adminViews/memberDesc");
		
		ParticipantsDto participantsrDto = new ParticipantsDto();
		participantsrDto.setPartyId(selectedParty.getId());
		
		model.addAttribute("participantsrDto" , participantsrDto);
		
		return new ModelAndView("adminViews/memberDesc2");
	}
	*/
}
