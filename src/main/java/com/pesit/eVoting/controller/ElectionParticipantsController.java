package com.pesit.eVoting.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.ParticipantsDto;

@Controller
public class ElectionParticipantsController {

	@RequestMapping("/addParticipant")
	public ModelAndView addParticipant(@ModelAttribute("participant") @Valid ParticipantsDto participantDto,
			Model model, BindingResult result) {
		System.out.println("The Entered participant details : " + participantDto);

		if (result.hasErrors())
			return new ModelAndView("adminView/memberDesc2");
		model.addAttribute("message", "participant Has been added");
		return new ModelAndView("adminViews/adminHome");
	}

}
