package com.pesit.eVoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pesit.eVoting.dto.AssemblyConstituencyDto;
import com.pesit.eVoting.service.AssemblyConstituencyService;

@Controller
public class AssemblyConstituencyController {

	
	@Autowired
	private AssemblyConstituencyService assemblyConstituencyService;
	
	
	@RequestMapping("/getAssemblies")
	public @ResponseBody List<AssemblyConstituencyDto> getAssemblies(HttpServletRequest request){
		long districtId = Long.parseLong(request.getParameter("districtId"));
		//ModelAndView view = new ModelAndView("usersView/includeName");
		
		List<AssemblyConstituencyDto> assemblies = assemblyConstituencyService.getAssemblysFromDistricts(districtId);
		//System.out.println("assemblies :"+assemblies);
		
		
		return assemblies;
	}
}
