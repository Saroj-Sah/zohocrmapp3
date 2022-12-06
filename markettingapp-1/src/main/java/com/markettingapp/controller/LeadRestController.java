package com.markettingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markettingapp.entites.Lead;
import com.markettingapp.repostory.LeadRepostory;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepostory leadRepo;
	
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		 leadRepo.save(lead);
		
	}
	@PutMapping
	public void UpdateOneLead(@RequestBody Lead lead) {
		 leadRepo.save(lead);
		
	}
	//http://localhost:8080/api/leads/delete/1
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/leads/leadinfo/1
	@RequestMapping("/leadinfo/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
	}

}
