package com.example.auditseverity.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.auditseverity.entity.AuditDetail;
import com.example.auditseverity.entity.AuditResponse;
import com.example.auditseverity.service.AuditResponseService;
import com.example.auditseverity.service.BenchmarkServiceClient;

@Controller
public class AuditSeverityController {
	
	@Autowired
	private BenchmarkServiceClient benchmark;
	
	@Autowired
	private AuditResponseService reponseservice;
	
	@GetMapping("/result")
	public String result(ModelMap modelMap) {
		HashMap<String,Integer> benchmarkdetails;
		benchmarkdetails=benchmark.findAll();
		modelMap.put("AuditResponse", new AuditResponse());
		ArrayList<AuditDetail> res= reponseservice.getAll();
		AuditDetail det=res.get(res.size()-1);
		String a[]= {det.getQ1(),det.getQ2(),det.getQ3(),det.getQ4(),det.getQ5()};
		int count=0;
		for(int i=0;i<=4;i++) {
			if(a[i].equals("no")) {
				count++;
			}
		}
		String status="";
		String duration="";
		if(count>benchmarkdetails.get(det.getAuditType())){
			modelMap.addAttribute("Status", "Red");
			status="Red";
			if(det.getAuditType().equals("SOX")) {
				modelMap.addAttribute("Duration", "1 Week");
				duration="1 Week";
			}
			else {
				modelMap.addAttribute("Duration", "2 Week");
				duration="2 Week";
			}
		}
		else {
			modelMap.addAttribute("Status", "Green");
			status="Green";
			modelMap.addAttribute("Duration", "No action needed");
			duration="No action needed";
		}
		AuditResponse resp=new AuditResponse();
		resp.setProjectExecutionStatus(status);
		resp.setRemedialActionDuration(duration);
		reponseservice.create(resp);
		return "test";
	}
		
	}
	
	


