package com.auditManagement.Audit.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auditManagement.Audit.Entity.Request;
import com.auditManagement.Audit.Service.RequestService;


@Controller
@RequestMapping("/req")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value="/auditdetails", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("request", new Request());
		return "index";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("request") Request request, ModelMap modelMap) {
		Request newrequest = requestService.create(request);
		modelMap.addAttribute("newrequest", newrequest);
		return "redirect:http://localhost:8999/aud/AuditCheckListQuestions";
		
	}


}