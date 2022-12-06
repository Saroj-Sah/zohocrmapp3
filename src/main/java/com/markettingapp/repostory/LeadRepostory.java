package com.markettingapp.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markettingapp.entites.Lead;

public interface LeadRepostory extends JpaRepository<Lead, Long> {

}
