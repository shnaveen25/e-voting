package com.pesit.eVoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.AssemblyStatesDto;
import com.pesit.eVoting.service.AssemblyStatesService;

@Controller
public class AssemblyStatesController {

	@Autowired
	private AssemblyStatesService assemblyStatesService;
	
	@RequestMapping("/includeName")
	public ModelAndView showIncludeNameView(Model model) {
		ModelAndView view = new ModelAndView("usersView/includeName");

		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		view.addObject("assemblyStateDto", assemblyStateDto);

		return view;
	}
	
	@RequestMapping("/addFutureElections")
	public ModelAndView showFutureElectionView(){
		ModelAndView view = new ModelAndView("adminViews/election");
		
		List<AssemblyStatesDto> assemblyStateDto = assemblyStatesService.getAllStates();
		view.addObject("assemblyStateDto", assemblyStateDto);
		
		return view;
	}
}
