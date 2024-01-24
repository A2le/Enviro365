package com.enviro.assessment.grad001.athulentintili.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.athulentintili.model.Investor;

@Repository
public interface InvestorRepo extends JpaRepository<Investor,Long>{
    
}
