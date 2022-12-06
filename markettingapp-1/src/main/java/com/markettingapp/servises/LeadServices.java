package com.markettingapp.servises;

import java.util.List;

import com.markettingapp.entites.Lead;

public interface LeadServices {
	public void saveLeadInfo(Lead lead);

	public List<Lead> getLeads();

	public void deleteLead(long id);

	public Lead getOneLead(long id);

}
