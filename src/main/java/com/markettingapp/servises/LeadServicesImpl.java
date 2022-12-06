package com.markettingapp.servises;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markettingapp.entites.Lead;
import com.markettingapp.repostory.LeadRepostory;


@Service
public class LeadServicesImpl implements LeadServices {
	
	@Autowired
	private LeadRepostory leadRepo;
	
	@Override
	public void saveLeadInfo(Lead lead) {
			leadRepo.save(lead);

	}

	@Override
	public List<Lead> getLeads() {
		// TODO Auto-generated method stub
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
		// TODO Auto-generated method stub
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getOneLead(long id) {
		// TODO Auto-generated method stub
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
