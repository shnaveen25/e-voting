package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pesit.eVoting.dto.AssemblyDistrictDto;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.service.AssemblyDistrictService;

@Controller
public class AssemblyDistrictController {
	
	@Autowired
	private AssemblyDistrictService assemblyDistrictSerivce;
	
	@RequestMapping("/getDistricts")
	public @ResponseBody List<AssemblyDistrictDto> getDistricts(HttpServletRequest request, Model model) {
		long stateId = Long.parseLong(request.getParameter("stateId"));
		// System.out.println("StateID : "+stateId);
		ModelAndView view = new ModelAndView("usersView/includeName");
		VotersApplicationsDto voterApplicationDto = new VotersApplicationsDto();

		List<AssemblyDistrictDto> districts = assemblyDistrictSerivce.getDistrictsFromStates(stateId);
		// System.out.println("Districts :"+districts);

		view.addObject("assemblyDistrictsDto", districts);
		view.addObject("voterApplicationDto", voterApplicationDto);

		return districts;
	}
}
