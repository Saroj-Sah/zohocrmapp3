package com.markettingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markettingapp.entites.Lead;
import com.markettingapp.servises.LeadServices;
import com.markettingapp.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadServices leadService;
	
	@Autowired
	private EmailService emailService;
	
	
	
	@RequestMapping("/create")
	//http://localhost:8080/create
	public String ViewCreateLeadPage() {
		return "create_lead";
		
	}
	
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead")Lead lead, ModelMap model) {
		leadService.saveLeadInfo(lead);
		emailService.sendEmail(lead.getEmail(), "WELCOME TO PSA","TEST spring boot");
		model.addAttribute("msg", "record is saved.");
		return "create_lead";
	}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads"; 
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id")long id, ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads"; 
		
	}
	
	@RequestMapping("/update")
	public String getLeadInfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLeadInfo(Lead data, Model model) {
		Lead l = new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadService.saveLeadInfo(l);
		
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads"; 
		
		
	}
}
